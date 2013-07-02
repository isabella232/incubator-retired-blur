package org.apache.blur.analysis;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.blur.analysis.type.DoubleFieldTypeDefinition;
import org.apache.blur.analysis.type.FloatFieldTypeDefinition;
import org.apache.blur.analysis.type.IntFieldTypeDefinition;
import org.apache.blur.analysis.type.LongFieldTypeDefinition;
import org.apache.blur.analysis.type.NumericFieldTypeDefinition;
import org.apache.blur.analysis.type.StoredFieldTypeDefinition;
import org.apache.blur.analysis.type.StringFieldTypeDefinition;
import org.apache.blur.analysis.type.TextFieldTypeDefinition;
import org.apache.blur.log.Log;
import org.apache.blur.log.LogFactory;
import org.apache.blur.thrift.generated.Column;
import org.apache.blur.thrift.generated.Record;
import org.apache.blur.utils.BlurConstants;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.AnalyzerWrapper;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.TextField;
import org.apache.lucene.search.Query;

public abstract class BaseFieldManager extends FieldManager {

  private static final Log LOG = LogFactory.getLog(BaseFieldManager.class);
  private static final Map<String, String> EMPTY_MAP = new HashMap<String, String>();;

  private Map<String, FieldTypeDefinition> _fieldNameToDefMap = new ConcurrentHashMap<String, FieldTypeDefinition>();
  private Map<String, Class<? extends FieldTypeDefinition>> _typeMap = new ConcurrentHashMap<String, Class<? extends FieldTypeDefinition>>();
  private Map<String, Set<String>> _columnToSubColumn = new ConcurrentHashMap<String, Set<String>>();
  private Analyzer _baseAnalyzerForQuery;

  public static FieldType ID_TYPE;
  static {
    ID_TYPE = new FieldType();
    ID_TYPE.setIndexed(true);
    ID_TYPE.setTokenized(false);
    ID_TYPE.setOmitNorms(true);
    ID_TYPE.setStored(true);
    ID_TYPE.freeze();
  }
  private static final FieldType SUPER_FIELD_TYPE;
  static {
    SUPER_FIELD_TYPE = new FieldType(TextField.TYPE_NOT_STORED);
    SUPER_FIELD_TYPE.setOmitNorms(true);
  }

  public BaseFieldManager(final Analyzer defaultAnalyzerForQuerying) {
    _typeMap.put(TextFieldTypeDefinition.NAME, TextFieldTypeDefinition.class);
    _typeMap.put(StringFieldTypeDefinition.NAME, StringFieldTypeDefinition.class);
    _typeMap.put(StoredFieldTypeDefinition.NAME, StoredFieldTypeDefinition.class);
    _typeMap.put(IntFieldTypeDefinition.NAME, IntFieldTypeDefinition.class);
    _typeMap.put(LongFieldTypeDefinition.NAME, LongFieldTypeDefinition.class);
    _typeMap.put(DoubleFieldTypeDefinition.NAME, DoubleFieldTypeDefinition.class);
    _typeMap.put(FloatFieldTypeDefinition.NAME, FloatFieldTypeDefinition.class);

    _baseAnalyzerForQuery = new AnalyzerWrapper() {
      @Override
      protected Analyzer getWrappedAnalyzer(String fieldName) {
        FieldTypeDefinition fieldTypeDefinition = getFieldTypeDefinition(fieldName);
        if (fieldTypeDefinition == null) {
          return defaultAnalyzerForQuerying;
        }
        return fieldTypeDefinition.getAnalyzerForQuery();
      }

      @Override
      protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {
        return components;
      }
    };
  }

  @Override
  public List<Field> getFields(String rowId, Record record) {
    List<Field> fields = new ArrayList<Field>();
    String family = record.getFamily();
    List<Column> columns = record.getColumns();
    addDefaultFields(fields, rowId, record);
    for (Column column : columns) {
      String name = column.getName();
      String value = column.getValue();
      if (value == null || name == null) {
        continue;
      }
      getAndAddFields(fields, family, column, getFieldTypeDefinition(family, column));
      Collection<String> subColumns = getSubColumns(family, column);
      if (subColumns != null) {
        for (String subName : subColumns) {
          getAndAddFields(fields, family, column, subName, getFieldTypeDefinition(family, column, subName));
        }
      }
    }
    return fields;
  }

  private void getAndAddFields(List<Field> fields, String family, Column column, String subName,
      FieldTypeDefinition fieldTypeDefinition) {
    for (Field field : fieldTypeDefinition.getFieldsForSubColumn(family, column, subName)) {
      fields.add(field);
    }
  }

  private void addDefaultFields(List<Field> fields, String rowId, Record record) {
    String family = record.getFamily();
    String recordId = record.getRecordId();

    validateNotNull(rowId, "rowId");
    validateNotNull(family, "family");
    validateNotNull(recordId, "recordId");

    fields.add(new Field(BlurConstants.FAMILY, family, ID_TYPE));
    fields.add(new Field(BlurConstants.ROW_ID, rowId, ID_TYPE));
    fields.add(new Field(BlurConstants.RECORD_ID, recordId, ID_TYPE));
  }

  private void validateNotNull(String value, String fieldName) {
    if (value != null) {
      return;
    }
    throw new IllegalArgumentException("Field [" + fieldName + "] cannot be null.");
  }

  private void getAndAddFields(List<Field> fields, String family, Column column, FieldTypeDefinition fieldTypeDefinition) {
    for (Field field : fieldTypeDefinition.getFieldsForColumn(family, column)) {
      fields.add(field);
    }
    if (fieldTypeDefinition.isFieldLessIndexing()) {
      addFieldLessIndex(fields, column.getValue());
    }
  }

  private void addFieldLessIndex(List<Field> fields, String value) {
    fields.add(new Field(BlurConstants.SUPER, value, SUPER_FIELD_TYPE));
  }

  private FieldTypeDefinition getFieldTypeDefinition(String family, Column column, String subName) {
    return _fieldNameToDefMap.get(getSubColumnName(family, column, subName));
  }

  private String getSubColumnName(String family, Column column, String subName) {
    return getColumnName(family, column) + "." + subName;
  }

  private String getColumnName(String family, Column column) {
    return getColumnName(family, column.getName());
  }

  private String getColumnName(String family, String columnName) {
    return family + "." + columnName;
  }

  private Collection<String> getSubColumns(String family, Column column) {
    return _columnToSubColumn.get(getColumnName(family, column));
  }

  private FieldTypeDefinition getFieldTypeDefinition(String family, Column column) {
    return _fieldNameToDefMap.get(getColumnName(family, column));
  }

  @Override
  public void addColumnDefinition(String family, String columnName, String subColumnName, boolean fieldLessIndexing,
      String fieldType, Map<String, String> props) {
    String baseFieldName = family + "." + columnName;
    String fieldName;
    if (subColumnName != null) {
      if (!_fieldNameToDefMap.containsKey(baseFieldName)) {
        throw new IllegalArgumentException("Base column of [" + baseFieldName
            + "] not found, please add base before adding sub column.");
      }
      if (fieldLessIndexing) {
        throw new IllegalArgumentException("Subcolumn of [" + subColumnName + "] from base of [" + baseFieldName
            + "] cannot be added with fieldLessIndexing set to true.");
      }
      fieldName = baseFieldName + "." + subColumnName;
    } else {
      fieldName = baseFieldName;
    }
    tryToStore(fieldName, fieldLessIndexing, fieldType, props);
    Class<? extends FieldTypeDefinition> clazz = _typeMap.get(fieldType);
    if (clazz == null) {
      throw new IllegalArgumentException("FieldType of [" + fieldType + "] was not found.");
    }
    FieldTypeDefinition fieldTypeDefinition;
    try {
      fieldTypeDefinition = clazz.newInstance();
    } catch (InstantiationException e) {
      LOG.error("Unknown error trying to create a type of [{0}] from class [{1}]", e, fieldType, clazz);
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      LOG.error("Unknown error trying to create a type of [{0}] from class [{1}]", e, fieldType, clazz);
      throw new RuntimeException(e);
    }
    if (props == null) {
      fieldTypeDefinition.configure(EMPTY_MAP);
    } else {
      fieldTypeDefinition.configure(props);
    }
    fieldTypeDefinition.setFieldLessIndexing(fieldLessIndexing);
    _fieldNameToDefMap.put(fieldName, fieldTypeDefinition);
    if (subColumnName != null) {
      Set<String> subColumnNames = _columnToSubColumn.put(baseFieldName, getConcurrentSet());
      subColumnNames.add(subColumnName);
    }
  }

  protected abstract void tryToStore(String fieldName, boolean fieldLessIndexing, String fieldType,
      Map<String, String> props);

  private Set<String> getConcurrentSet() {
    return Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());
  }

  @Override
  public boolean isValidColumnDefinition(String family, String columnName) {
    String fieldName = getColumnName(family, columnName);
    return _fieldNameToDefMap.containsKey(fieldName);
  }

  @Override
  public Analyzer getAnalyzerForIndex(String fieldName) {
    FieldTypeDefinition fieldTypeDefinition = _fieldNameToDefMap.get(fieldName);
    if (fieldTypeDefinition == null) {
      throw new AnalyzerNotFoundException(fieldName);
    }
    return fieldTypeDefinition.getAnalyzerForIndex();
  }

  @Override
  public Analyzer getAnalyzerForQuery(String fieldName) {
    FieldTypeDefinition fieldTypeDefinition = _fieldNameToDefMap.get(fieldName);
    if (fieldTypeDefinition == null) {
      throw new AnalyzerNotFoundException(fieldName);
    }
    return fieldTypeDefinition.getAnalyzerForQuery();
  }

  public void addColumnDefinitionInt(String family, String columnName) {
    addColumnDefinition(family, columnName, null, false, IntFieldTypeDefinition.NAME, null);
  }

  public void addColumnDefinitionLong(String family, String columnName) {
    addColumnDefinition(family, columnName, null, false, LongFieldTypeDefinition.NAME, null);
  }

  public void addColumnDefinitionFloat(String family, String columnName) {
    addColumnDefinition(family, columnName, null, false, FloatFieldTypeDefinition.NAME, null);
  }

  public void addColumnDefinitionDouble(String family, String columnName) {
    addColumnDefinition(family, columnName, null, false, DoubleFieldTypeDefinition.NAME, null);
  }

  public void addColumnDefinitionString(String family, String columnName) {
    addColumnDefinition(family, columnName, null, false, StringFieldTypeDefinition.NAME, null);
  }

  public void addColumnDefinitionText(String family, String columnName) {
    addColumnDefinition(family, columnName, null, false, TextFieldTypeDefinition.NAME, null);
  }

  public void addColumnDefinitionTextFieldLess(String family, String columnName) {
    addColumnDefinition(family, columnName, null, true, TextFieldTypeDefinition.NAME, null);
  }

  @Override
  public Analyzer getAnalyzerForQuery() {
    return _baseAnalyzerForQuery;
  }

  @Override
  public boolean checkSupportForFuzzyQuery(String field) {
    FieldTypeDefinition fieldTypeDefinition = getFieldTypeDefinition(field);
    return fieldTypeDefinition.checkSupportForFuzzyQuery();
  }

  @Override
  public boolean checkSupportForPrefixQuery(String field) {
    FieldTypeDefinition fieldTypeDefinition = getFieldTypeDefinition(field);
    return fieldTypeDefinition.checkSupportForPrefixQuery();
  }

  @Override
  public boolean checkSupportForWildcardQuery(String field) {
    FieldTypeDefinition fieldTypeDefinition = getFieldTypeDefinition(field);
    return fieldTypeDefinition.checkSupportForWildcardQuery();
  }

  @Override
  public Query getNewRangeQuery(String field, String part1, String part2, boolean startInclusive, boolean endInclusive) {
    FieldTypeDefinition fieldTypeDefinition = getFieldTypeDefinition(field);
    if (fieldTypeDefinition != null && fieldTypeDefinition.isNumeric()) {
      NumericFieldTypeDefinition numericFieldTypeDefinition = (NumericFieldTypeDefinition) fieldTypeDefinition;
      return numericFieldTypeDefinition.getNewRangeQuery(field, part1, part2, startInclusive, endInclusive);
    }
    return null;
  }

  @Override
  public Query getTermQueryIfNumeric(String field, String text) {
    FieldTypeDefinition fieldTypeDefinition = getFieldTypeDefinition(field);
    if (fieldTypeDefinition != null && fieldTypeDefinition.isNumeric()) {
      NumericFieldTypeDefinition numericFieldTypeDefinition = (NumericFieldTypeDefinition) fieldTypeDefinition;
      return numericFieldTypeDefinition.getNewRangeQuery(field, text, text, true, true);
    }
    return null;
  }

  @Override
  public FieldTypeDefinition getFieldTypeDefinition(String field) {
    return _fieldNameToDefMap.get(field);
  }
  
  @Override
  public boolean isFieldLessIndexed(String name) {
    return false;
  }

  @Override
  public Analyzer getAnalyzerForIndex() {
    return null;
  }

}

/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.nearinfinity.blur.thrift.generated;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RowMutation implements org.apache.thrift.TBase<RowMutation, RowMutation._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RowMutation");

  private static final org.apache.thrift.protocol.TField ROW_MUTATION_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("rowMutationType", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField ROW_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("rowId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField RECORD_MUTATIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("recordMutations", org.apache.thrift.protocol.TType.LIST, (short)3);

  /**
   * 
   * @see RowMutationType
   */
  public RowMutationType rowMutationType;
  public String rowId;
  public List<RecordMutation> recordMutations;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see RowMutationType
     */
    ROW_MUTATION_TYPE((short)1, "rowMutationType"),
    ROW_ID((short)2, "rowId"),
    RECORD_MUTATIONS((short)3, "recordMutations");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ROW_MUTATION_TYPE
          return ROW_MUTATION_TYPE;
        case 2: // ROW_ID
          return ROW_ID;
        case 3: // RECORD_MUTATIONS
          return RECORD_MUTATIONS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ROW_MUTATION_TYPE, new org.apache.thrift.meta_data.FieldMetaData("rowMutationType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, RowMutationType.class)));
    tmpMap.put(_Fields.ROW_ID, new org.apache.thrift.meta_data.FieldMetaData("rowId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.RECORD_MUTATIONS, new org.apache.thrift.meta_data.FieldMetaData("recordMutations", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RecordMutation.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RowMutation.class, metaDataMap);
  }

  public RowMutation() {
  }

  public RowMutation(
    RowMutationType rowMutationType,
    String rowId,
    List<RecordMutation> recordMutations)
  {
    this();
    this.rowMutationType = rowMutationType;
    this.rowId = rowId;
    this.recordMutations = recordMutations;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RowMutation(RowMutation other) {
    if (other.isSetRowMutationType()) {
      this.rowMutationType = other.rowMutationType;
    }
    if (other.isSetRowId()) {
      this.rowId = other.rowId;
    }
    if (other.isSetRecordMutations()) {
      List<RecordMutation> __this__recordMutations = new ArrayList<RecordMutation>();
      for (RecordMutation other_element : other.recordMutations) {
        __this__recordMutations.add(new RecordMutation(other_element));
      }
      this.recordMutations = __this__recordMutations;
    }
  }

  public RowMutation deepCopy() {
    return new RowMutation(this);
  }

  @Override
  public void clear() {
    this.rowMutationType = null;
    this.rowId = null;
    this.recordMutations = null;
  }

  /**
   * 
   * @see RowMutationType
   */
  public RowMutationType getRowMutationType() {
    return this.rowMutationType;
  }

  /**
   * 
   * @see RowMutationType
   */
  public RowMutation setRowMutationType(RowMutationType rowMutationType) {
    this.rowMutationType = rowMutationType;
    return this;
  }

  public void unsetRowMutationType() {
    this.rowMutationType = null;
  }

  /** Returns true if field rowMutationType is set (has been assigned a value) and false otherwise */
  public boolean isSetRowMutationType() {
    return this.rowMutationType != null;
  }

  public void setRowMutationTypeIsSet(boolean value) {
    if (!value) {
      this.rowMutationType = null;
    }
  }

  public String getRowId() {
    return this.rowId;
  }

  public RowMutation setRowId(String rowId) {
    this.rowId = rowId;
    return this;
  }

  public void unsetRowId() {
    this.rowId = null;
  }

  /** Returns true if field rowId is set (has been assigned a value) and false otherwise */
  public boolean isSetRowId() {
    return this.rowId != null;
  }

  public void setRowIdIsSet(boolean value) {
    if (!value) {
      this.rowId = null;
    }
  }

  public int getRecordMutationsSize() {
    return (this.recordMutations == null) ? 0 : this.recordMutations.size();
  }

  public java.util.Iterator<RecordMutation> getRecordMutationsIterator() {
    return (this.recordMutations == null) ? null : this.recordMutations.iterator();
  }

  public void addToRecordMutations(RecordMutation elem) {
    if (this.recordMutations == null) {
      this.recordMutations = new ArrayList<RecordMutation>();
    }
    this.recordMutations.add(elem);
  }

  public List<RecordMutation> getRecordMutations() {
    return this.recordMutations;
  }

  public RowMutation setRecordMutations(List<RecordMutation> recordMutations) {
    this.recordMutations = recordMutations;
    return this;
  }

  public void unsetRecordMutations() {
    this.recordMutations = null;
  }

  /** Returns true if field recordMutations is set (has been assigned a value) and false otherwise */
  public boolean isSetRecordMutations() {
    return this.recordMutations != null;
  }

  public void setRecordMutationsIsSet(boolean value) {
    if (!value) {
      this.recordMutations = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ROW_MUTATION_TYPE:
      if (value == null) {
        unsetRowMutationType();
      } else {
        setRowMutationType((RowMutationType)value);
      }
      break;

    case ROW_ID:
      if (value == null) {
        unsetRowId();
      } else {
        setRowId((String)value);
      }
      break;

    case RECORD_MUTATIONS:
      if (value == null) {
        unsetRecordMutations();
      } else {
        setRecordMutations((List<RecordMutation>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ROW_MUTATION_TYPE:
      return getRowMutationType();

    case ROW_ID:
      return getRowId();

    case RECORD_MUTATIONS:
      return getRecordMutations();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ROW_MUTATION_TYPE:
      return isSetRowMutationType();
    case ROW_ID:
      return isSetRowId();
    case RECORD_MUTATIONS:
      return isSetRecordMutations();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RowMutation)
      return this.equals((RowMutation)that);
    return false;
  }

  public boolean equals(RowMutation that) {
    if (that == null)
      return false;

    boolean this_present_rowMutationType = true && this.isSetRowMutationType();
    boolean that_present_rowMutationType = true && that.isSetRowMutationType();
    if (this_present_rowMutationType || that_present_rowMutationType) {
      if (!(this_present_rowMutationType && that_present_rowMutationType))
        return false;
      if (!this.rowMutationType.equals(that.rowMutationType))
        return false;
    }

    boolean this_present_rowId = true && this.isSetRowId();
    boolean that_present_rowId = true && that.isSetRowId();
    if (this_present_rowId || that_present_rowId) {
      if (!(this_present_rowId && that_present_rowId))
        return false;
      if (!this.rowId.equals(that.rowId))
        return false;
    }

    boolean this_present_recordMutations = true && this.isSetRecordMutations();
    boolean that_present_recordMutations = true && that.isSetRecordMutations();
    if (this_present_recordMutations || that_present_recordMutations) {
      if (!(this_present_recordMutations && that_present_recordMutations))
        return false;
      if (!this.recordMutations.equals(that.recordMutations))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(RowMutation other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    RowMutation typedOther = (RowMutation)other;

    lastComparison = Boolean.valueOf(isSetRowMutationType()).compareTo(typedOther.isSetRowMutationType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRowMutationType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rowMutationType, typedOther.rowMutationType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRowId()).compareTo(typedOther.isSetRowId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRowId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rowId, typedOther.rowId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRecordMutations()).compareTo(typedOther.isSetRecordMutations());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRecordMutations()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.recordMutations, typedOther.recordMutations);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // ROW_MUTATION_TYPE
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.rowMutationType = RowMutationType.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // ROW_ID
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.rowId = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // RECORD_MUTATIONS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list81 = iprot.readListBegin();
              this.recordMutations = new ArrayList<RecordMutation>(_list81.size);
              for (int _i82 = 0; _i82 < _list81.size; ++_i82)
              {
                RecordMutation _elem83;
                _elem83 = new RecordMutation();
                _elem83.read(iprot);
                this.recordMutations.add(_elem83);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.rowMutationType != null) {
      oprot.writeFieldBegin(ROW_MUTATION_TYPE_FIELD_DESC);
      oprot.writeI32(this.rowMutationType.getValue());
      oprot.writeFieldEnd();
    }
    if (this.rowId != null) {
      oprot.writeFieldBegin(ROW_ID_FIELD_DESC);
      oprot.writeString(this.rowId);
      oprot.writeFieldEnd();
    }
    if (this.recordMutations != null) {
      oprot.writeFieldBegin(RECORD_MUTATIONS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.recordMutations.size()));
        for (RecordMutation _iter84 : this.recordMutations)
        {
          _iter84.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("RowMutation(");
    boolean first = true;

    sb.append("rowMutationType:");
    if (this.rowMutationType == null) {
      sb.append("null");
    } else {
      sb.append(this.rowMutationType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("rowId:");
    if (this.rowId == null) {
      sb.append("null");
    } else {
      sb.append(this.rowId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("recordMutations:");
    if (this.recordMutations == null) {
      sb.append("null");
    } else {
      sb.append(this.recordMutations);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}


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

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

public class FacetResult implements TBase<FacetResult, FacetResult._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("FacetResult");

  private static final TField FACET_QUERY_FIELD_DESC = new TField("facetQuery", TType.STRUCT, (short)1);
  private static final TField COUNTS_FIELD_DESC = new TField("counts", TType.MAP, (short)2);

  public FacetQuery facetQuery;
  public Map<Facet,Long> counts;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    FACET_QUERY((short)1, "facetQuery"),
    COUNTS((short)2, "counts");

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
        case 1: // FACET_QUERY
          return FACET_QUERY;
        case 2: // COUNTS
          return COUNTS;
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

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FACET_QUERY, new FieldMetaData("facetQuery", TFieldRequirementType.DEFAULT, 
        new StructMetaData(TType.STRUCT, FacetQuery.class)));
    tmpMap.put(_Fields.COUNTS, new FieldMetaData("counts", TFieldRequirementType.DEFAULT, 
        new MapMetaData(TType.MAP, 
            new StructMetaData(TType.STRUCT, Facet.class), 
            new FieldValueMetaData(TType.I64))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(FacetResult.class, metaDataMap);
  }

  public FacetResult() {
  }

  public FacetResult(
    FacetQuery facetQuery,
    Map<Facet,Long> counts)
  {
    this();
    this.facetQuery = facetQuery;
    this.counts = counts;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FacetResult(FacetResult other) {
    if (other.isSetFacetQuery()) {
      this.facetQuery = new FacetQuery(other.facetQuery);
    }
    if (other.isSetCounts()) {
      Map<Facet,Long> __this__counts = new HashMap<Facet,Long>();
      for (Map.Entry<Facet, Long> other_element : other.counts.entrySet()) {

        Facet other_element_key = other_element.getKey();
        Long other_element_value = other_element.getValue();

        Facet __this__counts_copy_key = new Facet(other_element_key);

        Long __this__counts_copy_value = other_element_value;

        __this__counts.put(__this__counts_copy_key, __this__counts_copy_value);
      }
      this.counts = __this__counts;
    }
  }

  public FacetResult deepCopy() {
    return new FacetResult(this);
  }

  @Override
  public void clear() {
    this.facetQuery = null;
    this.counts = null;
  }

  public FacetQuery getFacetQuery() {
    return this.facetQuery;
  }

  public FacetResult setFacetQuery(FacetQuery facetQuery) {
    this.facetQuery = facetQuery;
    return this;
  }

  public void unsetFacetQuery() {
    this.facetQuery = null;
  }

  /** Returns true if field facetQuery is set (has been asigned a value) and false otherwise */
  public boolean isSetFacetQuery() {
    return this.facetQuery != null;
  }

  public void setFacetQueryIsSet(boolean value) {
    if (!value) {
      this.facetQuery = null;
    }
  }

  public int getCountsSize() {
    return (this.counts == null) ? 0 : this.counts.size();
  }

  public void putToCounts(Facet key, long val) {
    if (this.counts == null) {
      this.counts = new HashMap<Facet,Long>();
    }
    this.counts.put(key, val);
  }

  public Map<Facet,Long> getCounts() {
    return this.counts;
  }

  public FacetResult setCounts(Map<Facet,Long> counts) {
    this.counts = counts;
    return this;
  }

  public void unsetCounts() {
    this.counts = null;
  }

  /** Returns true if field counts is set (has been asigned a value) and false otherwise */
  public boolean isSetCounts() {
    return this.counts != null;
  }

  public void setCountsIsSet(boolean value) {
    if (!value) {
      this.counts = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FACET_QUERY:
      if (value == null) {
        unsetFacetQuery();
      } else {
        setFacetQuery((FacetQuery)value);
      }
      break;

    case COUNTS:
      if (value == null) {
        unsetCounts();
      } else {
        setCounts((Map<Facet,Long>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FACET_QUERY:
      return getFacetQuery();

    case COUNTS:
      return getCounts();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FACET_QUERY:
      return isSetFacetQuery();
    case COUNTS:
      return isSetCounts();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FacetResult)
      return this.equals((FacetResult)that);
    return false;
  }

  public boolean equals(FacetResult that) {
    if (that == null)
      return false;

    boolean this_present_facetQuery = true && this.isSetFacetQuery();
    boolean that_present_facetQuery = true && that.isSetFacetQuery();
    if (this_present_facetQuery || that_present_facetQuery) {
      if (!(this_present_facetQuery && that_present_facetQuery))
        return false;
      if (!this.facetQuery.equals(that.facetQuery))
        return false;
    }

    boolean this_present_counts = true && this.isSetCounts();
    boolean that_present_counts = true && that.isSetCounts();
    if (this_present_counts || that_present_counts) {
      if (!(this_present_counts && that_present_counts))
        return false;
      if (!this.counts.equals(that.counts))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(FacetResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    FacetResult typedOther = (FacetResult)other;

    lastComparison = Boolean.valueOf(isSetFacetQuery()).compareTo(typedOther.isSetFacetQuery());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFacetQuery()) {
      lastComparison = TBaseHelper.compareTo(this.facetQuery, typedOther.facetQuery);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCounts()).compareTo(typedOther.isSetCounts());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCounts()) {
      lastComparison = TBaseHelper.compareTo(this.counts, typedOther.counts);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // FACET_QUERY
          if (field.type == TType.STRUCT) {
            this.facetQuery = new FacetQuery();
            this.facetQuery.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // COUNTS
          if (field.type == TType.MAP) {
            {
              TMap _map59 = iprot.readMapBegin();
              this.counts = new HashMap<Facet,Long>(2*_map59.size);
              for (int _i60 = 0; _i60 < _map59.size; ++_i60)
              {
                Facet _key61;
                long _val62;
                _key61 = new Facet();
                _key61.read(iprot);
                _val62 = iprot.readI64();
                this.counts.put(_key61, _val62);
              }
              iprot.readMapEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.facetQuery != null) {
      oprot.writeFieldBegin(FACET_QUERY_FIELD_DESC);
      this.facetQuery.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.counts != null) {
      oprot.writeFieldBegin(COUNTS_FIELD_DESC);
      {
        oprot.writeMapBegin(new TMap(TType.STRUCT, TType.I64, this.counts.size()));
        for (Map.Entry<Facet, Long> _iter63 : this.counts.entrySet())
        {
          _iter63.getKey().write(oprot);
          oprot.writeI64(_iter63.getValue());
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("FacetResult(");
    boolean first = true;

    sb.append("facetQuery:");
    if (this.facetQuery == null) {
      sb.append("null");
    } else {
      sb.append(this.facetQuery);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("counts:");
    if (this.counts == null) {
      sb.append("null");
    } else {
      sb.append(this.counts);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}


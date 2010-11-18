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
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.protocol.*;

public class SearchQueryStatus implements TBase<SearchQueryStatus, SearchQueryStatus._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("SearchQueryStatus");

  private static final TField QUERY_FIELD_DESC = new TField("query", TType.STRUCT, (short)1);
  private static final TField REAL_TIME_FIELD_DESC = new TField("realTime", TType.I64, (short)2);
  private static final TField CPU_TIME_FIELD_DESC = new TField("cpuTime", TType.I64, (short)3);
  private static final TField COMPLETE_FIELD_DESC = new TField("complete", TType.DOUBLE, (short)4);

  public SearchQuery query;
  public long realTime;
  public long cpuTime;
  public double complete;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    QUERY((short)1, "query"),
    REAL_TIME((short)2, "realTime"),
    CPU_TIME((short)3, "cpuTime"),
    COMPLETE((short)4, "complete");

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
        case 1: // QUERY
          return QUERY;
        case 2: // REAL_TIME
          return REAL_TIME;
        case 3: // CPU_TIME
          return CPU_TIME;
        case 4: // COMPLETE
          return COMPLETE;
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
  private static final int __REALTIME_ISSET_ID = 0;
  private static final int __CPUTIME_ISSET_ID = 1;
  private static final int __COMPLETE_ISSET_ID = 2;
  private BitSet __isset_bit_vector = new BitSet(3);

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.QUERY, new FieldMetaData("query", TFieldRequirementType.DEFAULT, 
        new StructMetaData(TType.STRUCT, SearchQuery.class)));
    tmpMap.put(_Fields.REAL_TIME, new FieldMetaData("realTime", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.CPU_TIME, new FieldMetaData("cpuTime", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.COMPLETE, new FieldMetaData("complete", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.DOUBLE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(SearchQueryStatus.class, metaDataMap);
  }

  public SearchQueryStatus() {
  }

  public SearchQueryStatus(
    SearchQuery query,
    long realTime,
    long cpuTime,
    double complete)
  {
    this();
    this.query = query;
    this.realTime = realTime;
    setRealTimeIsSet(true);
    this.cpuTime = cpuTime;
    setCpuTimeIsSet(true);
    this.complete = complete;
    setCompleteIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SearchQueryStatus(SearchQueryStatus other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetQuery()) {
      this.query = new SearchQuery(other.query);
    }
    this.realTime = other.realTime;
    this.cpuTime = other.cpuTime;
    this.complete = other.complete;
  }

  public SearchQueryStatus deepCopy() {
    return new SearchQueryStatus(this);
  }

  @Deprecated
  public SearchQueryStatus clone() {
    return new SearchQueryStatus(this);
  }

  public SearchQuery getQuery() {
    return this.query;
  }

  public SearchQueryStatus setQuery(SearchQuery query) {
    this.query = query;
    return this;
  }

  public void unsetQuery() {
    this.query = null;
  }

  /** Returns true if field query is set (has been asigned a value) and false otherwise */
  public boolean isSetQuery() {
    return this.query != null;
  }

  public void setQueryIsSet(boolean value) {
    if (!value) {
      this.query = null;
    }
  }

  public long getRealTime() {
    return this.realTime;
  }

  public SearchQueryStatus setRealTime(long realTime) {
    this.realTime = realTime;
    setRealTimeIsSet(true);
    return this;
  }

  public void unsetRealTime() {
    __isset_bit_vector.clear(__REALTIME_ISSET_ID);
  }

  /** Returns true if field realTime is set (has been asigned a value) and false otherwise */
  public boolean isSetRealTime() {
    return __isset_bit_vector.get(__REALTIME_ISSET_ID);
  }

  public void setRealTimeIsSet(boolean value) {
    __isset_bit_vector.set(__REALTIME_ISSET_ID, value);
  }

  public long getCpuTime() {
    return this.cpuTime;
  }

  public SearchQueryStatus setCpuTime(long cpuTime) {
    this.cpuTime = cpuTime;
    setCpuTimeIsSet(true);
    return this;
  }

  public void unsetCpuTime() {
    __isset_bit_vector.clear(__CPUTIME_ISSET_ID);
  }

  /** Returns true if field cpuTime is set (has been asigned a value) and false otherwise */
  public boolean isSetCpuTime() {
    return __isset_bit_vector.get(__CPUTIME_ISSET_ID);
  }

  public void setCpuTimeIsSet(boolean value) {
    __isset_bit_vector.set(__CPUTIME_ISSET_ID, value);
  }

  public double getComplete() {
    return this.complete;
  }

  public SearchQueryStatus setComplete(double complete) {
    this.complete = complete;
    setCompleteIsSet(true);
    return this;
  }

  public void unsetComplete() {
    __isset_bit_vector.clear(__COMPLETE_ISSET_ID);
  }

  /** Returns true if field complete is set (has been asigned a value) and false otherwise */
  public boolean isSetComplete() {
    return __isset_bit_vector.get(__COMPLETE_ISSET_ID);
  }

  public void setCompleteIsSet(boolean value) {
    __isset_bit_vector.set(__COMPLETE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case QUERY:
      if (value == null) {
        unsetQuery();
      } else {
        setQuery((SearchQuery)value);
      }
      break;

    case REAL_TIME:
      if (value == null) {
        unsetRealTime();
      } else {
        setRealTime((Long)value);
      }
      break;

    case CPU_TIME:
      if (value == null) {
        unsetCpuTime();
      } else {
        setCpuTime((Long)value);
      }
      break;

    case COMPLETE:
      if (value == null) {
        unsetComplete();
      } else {
        setComplete((Double)value);
      }
      break;

    }
  }

  public void setFieldValue(int fieldID, Object value) {
    setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case QUERY:
      return getQuery();

    case REAL_TIME:
      return new Long(getRealTime());

    case CPU_TIME:
      return new Long(getCpuTime());

    case COMPLETE:
      return new Double(getComplete());

    }
    throw new IllegalStateException();
  }

  public Object getFieldValue(int fieldId) {
    return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    switch (field) {
    case QUERY:
      return isSetQuery();
    case REAL_TIME:
      return isSetRealTime();
    case CPU_TIME:
      return isSetCpuTime();
    case COMPLETE:
      return isSetComplete();
    }
    throw new IllegalStateException();
  }

  public boolean isSet(int fieldID) {
    return isSet(_Fields.findByThriftIdOrThrow(fieldID));
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SearchQueryStatus)
      return this.equals((SearchQueryStatus)that);
    return false;
  }

  public boolean equals(SearchQueryStatus that) {
    if (that == null)
      return false;

    boolean this_present_query = true && this.isSetQuery();
    boolean that_present_query = true && that.isSetQuery();
    if (this_present_query || that_present_query) {
      if (!(this_present_query && that_present_query))
        return false;
      if (!this.query.equals(that.query))
        return false;
    }

    boolean this_present_realTime = true;
    boolean that_present_realTime = true;
    if (this_present_realTime || that_present_realTime) {
      if (!(this_present_realTime && that_present_realTime))
        return false;
      if (this.realTime != that.realTime)
        return false;
    }

    boolean this_present_cpuTime = true;
    boolean that_present_cpuTime = true;
    if (this_present_cpuTime || that_present_cpuTime) {
      if (!(this_present_cpuTime && that_present_cpuTime))
        return false;
      if (this.cpuTime != that.cpuTime)
        return false;
    }

    boolean this_present_complete = true;
    boolean that_present_complete = true;
    if (this_present_complete || that_present_complete) {
      if (!(this_present_complete && that_present_complete))
        return false;
      if (this.complete != that.complete)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(SearchQueryStatus other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    SearchQueryStatus typedOther = (SearchQueryStatus)other;

    lastComparison = Boolean.valueOf(isSetQuery()).compareTo(typedOther.isSetQuery());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuery()) {      lastComparison = TBaseHelper.compareTo(this.query, typedOther.query);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRealTime()).compareTo(typedOther.isSetRealTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRealTime()) {      lastComparison = TBaseHelper.compareTo(this.realTime, typedOther.realTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCpuTime()).compareTo(typedOther.isSetCpuTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCpuTime()) {      lastComparison = TBaseHelper.compareTo(this.cpuTime, typedOther.cpuTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetComplete()).compareTo(typedOther.isSetComplete());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetComplete()) {      lastComparison = TBaseHelper.compareTo(this.complete, typedOther.complete);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
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
        case 1: // QUERY
          if (field.type == TType.STRUCT) {
            this.query = new SearchQuery();
            this.query.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // REAL_TIME
          if (field.type == TType.I64) {
            this.realTime = iprot.readI64();
            setRealTimeIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // CPU_TIME
          if (field.type == TType.I64) {
            this.cpuTime = iprot.readI64();
            setCpuTimeIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // COMPLETE
          if (field.type == TType.DOUBLE) {
            this.complete = iprot.readDouble();
            setCompleteIsSet(true);
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
    if (this.query != null) {
      oprot.writeFieldBegin(QUERY_FIELD_DESC);
      this.query.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(REAL_TIME_FIELD_DESC);
    oprot.writeI64(this.realTime);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(CPU_TIME_FIELD_DESC);
    oprot.writeI64(this.cpuTime);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(COMPLETE_FIELD_DESC);
    oprot.writeDouble(this.complete);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("SearchQueryStatus(");
    boolean first = true;

    sb.append("query:");
    if (this.query == null) {
      sb.append("null");
    } else {
      sb.append(this.query);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("realTime:");
    sb.append(this.realTime);
    first = false;
    if (!first) sb.append(", ");
    sb.append("cpuTime:");
    sb.append(this.cpuTime);
    first = false;
    if (!first) sb.append(", ");
    sb.append("complete:");
    sb.append(this.complete);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}


/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.fuyou.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;

import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;

public class BeanExample implements org.apache.thrift.TBase<BeanExample, BeanExample._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BeanExample");

  private static final org.apache.thrift.protocol.TField BOOLEAN_PRIMIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("booleanPrimive", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField BYTE_PRIMIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("bytePrimive", org.apache.thrift.protocol.TType.BYTE, (short)2);
  private static final org.apache.thrift.protocol.TField SHORT_PRIMIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("shortPrimive", org.apache.thrift.protocol.TType.I16, (short)3);
  private static final org.apache.thrift.protocol.TField INT_PRIMIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("intPrimive", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField LONG_PRIMIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("longPrimive", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField DOUBLE_PRIMIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("doublePrimive", org.apache.thrift.protocol.TType.DOUBLE, (short)6);
  private static final org.apache.thrift.protocol.TField STRING_OBJECT_FIELD_DESC = new org.apache.thrift.protocol.TField("stringObject", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField BYTE_ARRAY_FIELD_DESC = new org.apache.thrift.protocol.TField("byteArray", org.apache.thrift.protocol.TType.STRING, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BeanExampleStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BeanExampleTupleSchemeFactory());
  }

  public boolean booleanPrimive; // required
  public byte bytePrimive; // required
  public short shortPrimive; // required
  public int intPrimive; // required
  public long longPrimive; // required
  public double doublePrimive; // required
  public String stringObject; // required
  public ByteBuffer byteArray; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BOOLEAN_PRIMIVE((short)1, "booleanPrimive"),
    BYTE_PRIMIVE((short)2, "bytePrimive"),
    SHORT_PRIMIVE((short)3, "shortPrimive"),
    INT_PRIMIVE((short)4, "intPrimive"),
    LONG_PRIMIVE((short)5, "longPrimive"),
    DOUBLE_PRIMIVE((short)6, "doublePrimive"),
    STRING_OBJECT((short)7, "stringObject"),
    BYTE_ARRAY((short)8, "byteArray");

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
        case 1: // BOOLEAN_PRIMIVE
          return BOOLEAN_PRIMIVE;
        case 2: // BYTE_PRIMIVE
          return BYTE_PRIMIVE;
        case 3: // SHORT_PRIMIVE
          return SHORT_PRIMIVE;
        case 4: // INT_PRIMIVE
          return INT_PRIMIVE;
        case 5: // LONG_PRIMIVE
          return LONG_PRIMIVE;
        case 6: // DOUBLE_PRIMIVE
          return DOUBLE_PRIMIVE;
        case 7: // STRING_OBJECT
          return STRING_OBJECT;
        case 8: // BYTE_ARRAY
          return BYTE_ARRAY;
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
  private static final int __BOOLEANPRIMIVE_ISSET_ID = 0;
  private static final int __BYTEPRIMIVE_ISSET_ID = 1;
  private static final int __SHORTPRIMIVE_ISSET_ID = 2;
  private static final int __INTPRIMIVE_ISSET_ID = 3;
  private static final int __LONGPRIMIVE_ISSET_ID = 4;
  private static final int __DOUBLEPRIMIVE_ISSET_ID = 5;
  private BitSet __isset_bit_vector = new BitSet(6);
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BOOLEAN_PRIMIVE, new org.apache.thrift.meta_data.FieldMetaData("booleanPrimive", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.BYTE_PRIMIVE, new org.apache.thrift.meta_data.FieldMetaData("bytePrimive", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    tmpMap.put(_Fields.SHORT_PRIMIVE, new org.apache.thrift.meta_data.FieldMetaData("shortPrimive", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.INT_PRIMIVE, new org.apache.thrift.meta_data.FieldMetaData("intPrimive", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LONG_PRIMIVE, new org.apache.thrift.meta_data.FieldMetaData("longPrimive", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.DOUBLE_PRIMIVE, new org.apache.thrift.meta_data.FieldMetaData("doublePrimive", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.STRING_OBJECT, new org.apache.thrift.meta_data.FieldMetaData("stringObject", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BYTE_ARRAY, new org.apache.thrift.meta_data.FieldMetaData("byteArray", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BeanExample.class, metaDataMap);
  }

  public BeanExample() {
  }

  public BeanExample(
    boolean booleanPrimive,
    byte bytePrimive,
    short shortPrimive,
    int intPrimive,
    long longPrimive,
    double doublePrimive,
    String stringObject,
    ByteBuffer byteArray)
  {
    this();
    this.booleanPrimive = booleanPrimive;
    setBooleanPrimiveIsSet(true);
    this.bytePrimive = bytePrimive;
    setBytePrimiveIsSet(true);
    this.shortPrimive = shortPrimive;
    setShortPrimiveIsSet(true);
    this.intPrimive = intPrimive;
    setIntPrimiveIsSet(true);
    this.longPrimive = longPrimive;
    setLongPrimiveIsSet(true);
    this.doublePrimive = doublePrimive;
    setDoublePrimiveIsSet(true);
    this.stringObject = stringObject;
    this.byteArray = byteArray;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BeanExample(BeanExample other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.booleanPrimive = other.booleanPrimive;
    this.bytePrimive = other.bytePrimive;
    this.shortPrimive = other.shortPrimive;
    this.intPrimive = other.intPrimive;
    this.longPrimive = other.longPrimive;
    this.doublePrimive = other.doublePrimive;
    if (other.isSetStringObject()) {
      this.stringObject = other.stringObject;
    }
    if (other.isSetByteArray()) {
      this.byteArray = org.apache.thrift.TBaseHelper.copyBinary(other.byteArray);
;
    }
  }

  public BeanExample deepCopy() {
    return new BeanExample(this);
  }

  @Override
  public void clear() {
    setBooleanPrimiveIsSet(false);
    this.booleanPrimive = false;
    setBytePrimiveIsSet(false);
    this.bytePrimive = 0;
    setShortPrimiveIsSet(false);
    this.shortPrimive = 0;
    setIntPrimiveIsSet(false);
    this.intPrimive = 0;
    setLongPrimiveIsSet(false);
    this.longPrimive = 0;
    setDoublePrimiveIsSet(false);
    this.doublePrimive = 0.0;
    this.stringObject = null;
    this.byteArray = null;
  }

  public boolean isBooleanPrimive() {
    return this.booleanPrimive;
  }

  public BeanExample setBooleanPrimive(boolean booleanPrimive) {
    this.booleanPrimive = booleanPrimive;
    setBooleanPrimiveIsSet(true);
    return this;
  }

  public void unsetBooleanPrimive() {
    __isset_bit_vector.clear(__BOOLEANPRIMIVE_ISSET_ID);
  }

  /** Returns true if field booleanPrimive is set (has been assigned a value) and false otherwise */
  public boolean isSetBooleanPrimive() {
    return __isset_bit_vector.get(__BOOLEANPRIMIVE_ISSET_ID);
  }

  public void setBooleanPrimiveIsSet(boolean value) {
    __isset_bit_vector.set(__BOOLEANPRIMIVE_ISSET_ID, value);
  }

  public byte getBytePrimive() {
    return this.bytePrimive;
  }

  public BeanExample setBytePrimive(byte bytePrimive) {
    this.bytePrimive = bytePrimive;
    setBytePrimiveIsSet(true);
    return this;
  }

  public void unsetBytePrimive() {
    __isset_bit_vector.clear(__BYTEPRIMIVE_ISSET_ID);
  }

  /** Returns true if field bytePrimive is set (has been assigned a value) and false otherwise */
  public boolean isSetBytePrimive() {
    return __isset_bit_vector.get(__BYTEPRIMIVE_ISSET_ID);
  }

  public void setBytePrimiveIsSet(boolean value) {
    __isset_bit_vector.set(__BYTEPRIMIVE_ISSET_ID, value);
  }

  public short getShortPrimive() {
    return this.shortPrimive;
  }

  public BeanExample setShortPrimive(short shortPrimive) {
    this.shortPrimive = shortPrimive;
    setShortPrimiveIsSet(true);
    return this;
  }

  public void unsetShortPrimive() {
    __isset_bit_vector.clear(__SHORTPRIMIVE_ISSET_ID);
  }

  /** Returns true if field shortPrimive is set (has been assigned a value) and false otherwise */
  public boolean isSetShortPrimive() {
    return __isset_bit_vector.get(__SHORTPRIMIVE_ISSET_ID);
  }

  public void setShortPrimiveIsSet(boolean value) {
    __isset_bit_vector.set(__SHORTPRIMIVE_ISSET_ID, value);
  }

  public int getIntPrimive() {
    return this.intPrimive;
  }

  public BeanExample setIntPrimive(int intPrimive) {
    this.intPrimive = intPrimive;
    setIntPrimiveIsSet(true);
    return this;
  }

  public void unsetIntPrimive() {
    __isset_bit_vector.clear(__INTPRIMIVE_ISSET_ID);
  }

  /** Returns true if field intPrimive is set (has been assigned a value) and false otherwise */
  public boolean isSetIntPrimive() {
    return __isset_bit_vector.get(__INTPRIMIVE_ISSET_ID);
  }

  public void setIntPrimiveIsSet(boolean value) {
    __isset_bit_vector.set(__INTPRIMIVE_ISSET_ID, value);
  }

  public long getLongPrimive() {
    return this.longPrimive;
  }

  public BeanExample setLongPrimive(long longPrimive) {
    this.longPrimive = longPrimive;
    setLongPrimiveIsSet(true);
    return this;
  }

  public void unsetLongPrimive() {
    __isset_bit_vector.clear(__LONGPRIMIVE_ISSET_ID);
  }

  /** Returns true if field longPrimive is set (has been assigned a value) and false otherwise */
  public boolean isSetLongPrimive() {
    return __isset_bit_vector.get(__LONGPRIMIVE_ISSET_ID);
  }

  public void setLongPrimiveIsSet(boolean value) {
    __isset_bit_vector.set(__LONGPRIMIVE_ISSET_ID, value);
  }

  public double getDoublePrimive() {
    return this.doublePrimive;
  }

  public BeanExample setDoublePrimive(double doublePrimive) {
    this.doublePrimive = doublePrimive;
    setDoublePrimiveIsSet(true);
    return this;
  }

  public void unsetDoublePrimive() {
    __isset_bit_vector.clear(__DOUBLEPRIMIVE_ISSET_ID);
  }

  /** Returns true if field doublePrimive is set (has been assigned a value) and false otherwise */
  public boolean isSetDoublePrimive() {
    return __isset_bit_vector.get(__DOUBLEPRIMIVE_ISSET_ID);
  }

  public void setDoublePrimiveIsSet(boolean value) {
    __isset_bit_vector.set(__DOUBLEPRIMIVE_ISSET_ID, value);
  }

  public String getStringObject() {
    return this.stringObject;
  }

  public BeanExample setStringObject(String stringObject) {
    this.stringObject = stringObject;
    return this;
  }

  public void unsetStringObject() {
    this.stringObject = null;
  }

  /** Returns true if field stringObject is set (has been assigned a value) and false otherwise */
  public boolean isSetStringObject() {
    return this.stringObject != null;
  }

  public void setStringObjectIsSet(boolean value) {
    if (!value) {
      this.stringObject = null;
    }
  }

  public byte[] getByteArray() {
    setByteArray(org.apache.thrift.TBaseHelper.rightSize(byteArray));
    return byteArray == null ? null : byteArray.array();
  }

  public ByteBuffer bufferForByteArray() {
    return byteArray;
  }

  public BeanExample setByteArray(byte[] byteArray) {
    setByteArray(byteArray == null ? (ByteBuffer)null : ByteBuffer.wrap(byteArray));
    return this;
  }

  public BeanExample setByteArray(ByteBuffer byteArray) {
    this.byteArray = byteArray;
    return this;
  }

  public void unsetByteArray() {
    this.byteArray = null;
  }

  /** Returns true if field byteArray is set (has been assigned a value) and false otherwise */
  public boolean isSetByteArray() {
    return this.byteArray != null;
  }

  public void setByteArrayIsSet(boolean value) {
    if (!value) {
      this.byteArray = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case BOOLEAN_PRIMIVE:
      if (value == null) {
        unsetBooleanPrimive();
      } else {
        setBooleanPrimive((Boolean)value);
      }
      break;

    case BYTE_PRIMIVE:
      if (value == null) {
        unsetBytePrimive();
      } else {
        setBytePrimive((Byte)value);
      }
      break;

    case SHORT_PRIMIVE:
      if (value == null) {
        unsetShortPrimive();
      } else {
        setShortPrimive((Short)value);
      }
      break;

    case INT_PRIMIVE:
      if (value == null) {
        unsetIntPrimive();
      } else {
        setIntPrimive((Integer)value);
      }
      break;

    case LONG_PRIMIVE:
      if (value == null) {
        unsetLongPrimive();
      } else {
        setLongPrimive((Long)value);
      }
      break;

    case DOUBLE_PRIMIVE:
      if (value == null) {
        unsetDoublePrimive();
      } else {
        setDoublePrimive((Double)value);
      }
      break;

    case STRING_OBJECT:
      if (value == null) {
        unsetStringObject();
      } else {
        setStringObject((String)value);
      }
      break;

    case BYTE_ARRAY:
      if (value == null) {
        unsetByteArray();
      } else {
        setByteArray((ByteBuffer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case BOOLEAN_PRIMIVE:
      return Boolean.valueOf(isBooleanPrimive());

    case BYTE_PRIMIVE:
      return Byte.valueOf(getBytePrimive());

    case SHORT_PRIMIVE:
      return Short.valueOf(getShortPrimive());

    case INT_PRIMIVE:
      return Integer.valueOf(getIntPrimive());

    case LONG_PRIMIVE:
      return Long.valueOf(getLongPrimive());

    case DOUBLE_PRIMIVE:
      return Double.valueOf(getDoublePrimive());

    case STRING_OBJECT:
      return getStringObject();

    case BYTE_ARRAY:
      return getByteArray();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case BOOLEAN_PRIMIVE:
      return isSetBooleanPrimive();
    case BYTE_PRIMIVE:
      return isSetBytePrimive();
    case SHORT_PRIMIVE:
      return isSetShortPrimive();
    case INT_PRIMIVE:
      return isSetIntPrimive();
    case LONG_PRIMIVE:
      return isSetLongPrimive();
    case DOUBLE_PRIMIVE:
      return isSetDoublePrimive();
    case STRING_OBJECT:
      return isSetStringObject();
    case BYTE_ARRAY:
      return isSetByteArray();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BeanExample)
      return this.equals((BeanExample)that);
    return false;
  }

  public boolean equals(BeanExample that) {
    if (that == null)
      return false;

    boolean this_present_booleanPrimive = true;
    boolean that_present_booleanPrimive = true;
    if (this_present_booleanPrimive || that_present_booleanPrimive) {
      if (!(this_present_booleanPrimive && that_present_booleanPrimive))
        return false;
      if (this.booleanPrimive != that.booleanPrimive)
        return false;
    }

    boolean this_present_bytePrimive = true;
    boolean that_present_bytePrimive = true;
    if (this_present_bytePrimive || that_present_bytePrimive) {
      if (!(this_present_bytePrimive && that_present_bytePrimive))
        return false;
      if (this.bytePrimive != that.bytePrimive)
        return false;
    }

    boolean this_present_shortPrimive = true;
    boolean that_present_shortPrimive = true;
    if (this_present_shortPrimive || that_present_shortPrimive) {
      if (!(this_present_shortPrimive && that_present_shortPrimive))
        return false;
      if (this.shortPrimive != that.shortPrimive)
        return false;
    }

    boolean this_present_intPrimive = true;
    boolean that_present_intPrimive = true;
    if (this_present_intPrimive || that_present_intPrimive) {
      if (!(this_present_intPrimive && that_present_intPrimive))
        return false;
      if (this.intPrimive != that.intPrimive)
        return false;
    }

    boolean this_present_longPrimive = true;
    boolean that_present_longPrimive = true;
    if (this_present_longPrimive || that_present_longPrimive) {
      if (!(this_present_longPrimive && that_present_longPrimive))
        return false;
      if (this.longPrimive != that.longPrimive)
        return false;
    }

    boolean this_present_doublePrimive = true;
    boolean that_present_doublePrimive = true;
    if (this_present_doublePrimive || that_present_doublePrimive) {
      if (!(this_present_doublePrimive && that_present_doublePrimive))
        return false;
      if (this.doublePrimive != that.doublePrimive)
        return false;
    }

    boolean this_present_stringObject = true && this.isSetStringObject();
    boolean that_present_stringObject = true && that.isSetStringObject();
    if (this_present_stringObject || that_present_stringObject) {
      if (!(this_present_stringObject && that_present_stringObject))
        return false;
      if (!this.stringObject.equals(that.stringObject))
        return false;
    }

    boolean this_present_byteArray = true && this.isSetByteArray();
    boolean that_present_byteArray = true && that.isSetByteArray();
    if (this_present_byteArray || that_present_byteArray) {
      if (!(this_present_byteArray && that_present_byteArray))
        return false;
      if (!this.byteArray.equals(that.byteArray))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(BeanExample other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    BeanExample typedOther = (BeanExample)other;

    lastComparison = Boolean.valueOf(isSetBooleanPrimive()).compareTo(typedOther.isSetBooleanPrimive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBooleanPrimive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.booleanPrimive, typedOther.booleanPrimive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBytePrimive()).compareTo(typedOther.isSetBytePrimive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBytePrimive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bytePrimive, typedOther.bytePrimive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetShortPrimive()).compareTo(typedOther.isSetShortPrimive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetShortPrimive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.shortPrimive, typedOther.shortPrimive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIntPrimive()).compareTo(typedOther.isSetIntPrimive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIntPrimive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.intPrimive, typedOther.intPrimive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLongPrimive()).compareTo(typedOther.isSetLongPrimive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLongPrimive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.longPrimive, typedOther.longPrimive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDoublePrimive()).compareTo(typedOther.isSetDoublePrimive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDoublePrimive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.doublePrimive, typedOther.doublePrimive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStringObject()).compareTo(typedOther.isSetStringObject());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStringObject()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.stringObject, typedOther.stringObject);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetByteArray()).compareTo(typedOther.isSetByteArray());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetByteArray()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.byteArray, typedOther.byteArray);
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
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BeanExample(");
    boolean first = true;

    sb.append("booleanPrimive:");
    sb.append(this.booleanPrimive);
    first = false;
    if (!first) sb.append(", ");
    sb.append("bytePrimive:");
    sb.append(this.bytePrimive);
    first = false;
    if (!first) sb.append(", ");
    sb.append("shortPrimive:");
    sb.append(this.shortPrimive);
    first = false;
    if (!first) sb.append(", ");
    sb.append("intPrimive:");
    sb.append(this.intPrimive);
    first = false;
    if (!first) sb.append(", ");
    sb.append("longPrimive:");
    sb.append(this.longPrimive);
    first = false;
    if (!first) sb.append(", ");
    sb.append("doublePrimive:");
    sb.append(this.doublePrimive);
    first = false;
    if (!first) sb.append(", ");
    sb.append("stringObject:");
    if (this.stringObject == null) {
      sb.append("null");
    } else {
      sb.append(this.stringObject);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("byteArray:");
    if (this.byteArray == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.byteArray, sb);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BeanExampleStandardSchemeFactory implements SchemeFactory {
    public BeanExampleStandardScheme getScheme() {
      return new BeanExampleStandardScheme();
    }
  }

  private static class BeanExampleStandardScheme extends StandardScheme<BeanExample> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BeanExample struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BOOLEAN_PRIMIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.booleanPrimive = iprot.readBool();
              struct.setBooleanPrimiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BYTE_PRIMIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.bytePrimive = iprot.readByte();
              struct.setBytePrimiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SHORT_PRIMIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.shortPrimive = iprot.readI16();
              struct.setShortPrimiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // INT_PRIMIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.intPrimive = iprot.readI32();
              struct.setIntPrimiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // LONG_PRIMIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.longPrimive = iprot.readI64();
              struct.setLongPrimiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // DOUBLE_PRIMIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.doublePrimive = iprot.readDouble();
              struct.setDoublePrimiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // STRING_OBJECT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.stringObject = iprot.readString();
              struct.setStringObjectIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // BYTE_ARRAY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.byteArray = iprot.readBinary();
              struct.setByteArrayIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BeanExample struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(BOOLEAN_PRIMIVE_FIELD_DESC);
      oprot.writeBool(struct.booleanPrimive);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(BYTE_PRIMIVE_FIELD_DESC);
      oprot.writeByte(struct.bytePrimive);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(SHORT_PRIMIVE_FIELD_DESC);
      oprot.writeI16(struct.shortPrimive);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(INT_PRIMIVE_FIELD_DESC);
      oprot.writeI32(struct.intPrimive);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(LONG_PRIMIVE_FIELD_DESC);
      oprot.writeI64(struct.longPrimive);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(DOUBLE_PRIMIVE_FIELD_DESC);
      oprot.writeDouble(struct.doublePrimive);
      oprot.writeFieldEnd();
      if (struct.stringObject != null) {
        oprot.writeFieldBegin(STRING_OBJECT_FIELD_DESC);
        oprot.writeString(struct.stringObject);
        oprot.writeFieldEnd();
      }
      if (struct.byteArray != null) {
        oprot.writeFieldBegin(BYTE_ARRAY_FIELD_DESC);
        oprot.writeBinary(struct.byteArray);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BeanExampleTupleSchemeFactory implements SchemeFactory {
    public BeanExampleTupleScheme getScheme() {
      return new BeanExampleTupleScheme();
    }
  }

  private static class BeanExampleTupleScheme extends TupleScheme<BeanExample> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BeanExample struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetBooleanPrimive()) {
        optionals.set(0);
      }
      if (struct.isSetBytePrimive()) {
        optionals.set(1);
      }
      if (struct.isSetShortPrimive()) {
        optionals.set(2);
      }
      if (struct.isSetIntPrimive()) {
        optionals.set(3);
      }
      if (struct.isSetLongPrimive()) {
        optionals.set(4);
      }
      if (struct.isSetDoublePrimive()) {
        optionals.set(5);
      }
      if (struct.isSetStringObject()) {
        optionals.set(6);
      }
      if (struct.isSetByteArray()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetBooleanPrimive()) {
        oprot.writeBool(struct.booleanPrimive);
      }
      if (struct.isSetBytePrimive()) {
        oprot.writeByte(struct.bytePrimive);
      }
      if (struct.isSetShortPrimive()) {
        oprot.writeI16(struct.shortPrimive);
      }
      if (struct.isSetIntPrimive()) {
        oprot.writeI32(struct.intPrimive);
      }
      if (struct.isSetLongPrimive()) {
        oprot.writeI64(struct.longPrimive);
      }
      if (struct.isSetDoublePrimive()) {
        oprot.writeDouble(struct.doublePrimive);
      }
      if (struct.isSetStringObject()) {
        oprot.writeString(struct.stringObject);
      }
      if (struct.isSetByteArray()) {
        oprot.writeBinary(struct.byteArray);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BeanExample struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.booleanPrimive = iprot.readBool();
        struct.setBooleanPrimiveIsSet(true);
      }
      if (incoming.get(1)) {
        struct.bytePrimive = iprot.readByte();
        struct.setBytePrimiveIsSet(true);
      }
      if (incoming.get(2)) {
        struct.shortPrimive = iprot.readI16();
        struct.setShortPrimiveIsSet(true);
      }
      if (incoming.get(3)) {
        struct.intPrimive = iprot.readI32();
        struct.setIntPrimiveIsSet(true);
      }
      if (incoming.get(4)) {
        struct.longPrimive = iprot.readI64();
        struct.setLongPrimiveIsSet(true);
      }
      if (incoming.get(5)) {
        struct.doublePrimive = iprot.readDouble();
        struct.setDoublePrimiveIsSet(true);
      }
      if (incoming.get(6)) {
        struct.stringObject = iprot.readString();
        struct.setStringObjectIsSet(true);
      }
      if (incoming.get(7)) {
        struct.byteArray = iprot.readBinary();
        struct.setByteArrayIsSet(true);
      }
    }
  }

}


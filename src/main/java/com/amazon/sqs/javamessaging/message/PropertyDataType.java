package com.amazon.sqs.javamessaging.message;

import javax.jms.JMSException;

public enum PropertyDataType {
  OBJECT("Object"),

  STRING("String"),

  INT("Number.int"),

  BOOLEAN("Number.Boolean"),

  BYTE("Number.byte"),

  DOUBLE("Number.double"),

  FLOAT("Number.float"),

  LONG("Number.long"),

  SHORT("Number.short");

  private PropertyDataType(String dataType) {
    this.dataType = dataType;
  }

  private String dataType;

  public String getDataType() {
    return dataType;
  }


  public static PropertyDataType getByDataType(String dataType) {

    for (PropertyDataType propertyDataType : values()) {
      if (propertyDataType.dataType.equalsIgnoreCase(dataType)) {
        return propertyDataType;
      }
    }
    return PropertyDataType.OBJECT;
  }

  public static PropertyDataType getByObject(Object value) throws JMSException {
    if (value instanceof String) {
      return PropertyDataType.STRING;
    } else if (value instanceof Integer) {
      return PropertyDataType.INT;
    } else if (value instanceof Long) {
      return PropertyDataType.LONG;
    } else if (value instanceof Boolean) {
      return PropertyDataType.BOOLEAN;
    } else if (value instanceof Byte) {
      return PropertyDataType.BYTE;
    } else if (value instanceof Double) {
      return PropertyDataType.DOUBLE;
    } else if (value instanceof Float) {
      return PropertyDataType.FLOAT;
    } else if (value instanceof Short) {
      return PropertyDataType.SHORT;
    } else {
      return PropertyDataType.OBJECT;
    }
  }

}

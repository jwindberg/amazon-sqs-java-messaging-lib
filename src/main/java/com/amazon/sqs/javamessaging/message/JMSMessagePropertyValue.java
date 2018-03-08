package com.amazon.sqs.javamessaging.message;



import javax.jms.JMSException;


/**
 * This class is used fulfill object value, corresponding SQS message attribute type and message
 * attribute string value.
 */
public class JMSMessagePropertyValue {

  private static final String INT_FALSE = "0";

  private static final String INT_TRUE = "1";

  private String value;

  private final PropertyDataType type;


  public JMSMessagePropertyValue(String stringValue, PropertyDataType type) throws JMSException {
    this.type = type;
    this.value = stringValue;
  }

  public JMSMessagePropertyValue(Object value) throws JMSException {
    this.type = PropertyDataType.getByObject(value);
    if (PropertyDataType.BOOLEAN == type) {
      if ((Boolean) value) {
        this.value = INT_TRUE;
      } else {
        this.value = INT_FALSE;
      }
    } else {
      this.value = value.toString();
    }
  }

  public JMSMessagePropertyValue(Object value, PropertyDataType type) throws JMSException {
    this.type = type;
    if (PropertyDataType.BOOLEAN == type) {
      if ((Boolean) value) {
        this.value = INT_TRUE;
      } else {
        this.value = INT_FALSE;
      }
    } else {
      this.value = value.toString();
    }
  }

  public PropertyDataType getType() {
    return type;
  }

  public String getStringValue() {
    return value;
  }


  public Object getValue() {
    switch (type) {
      case OBJECT:
        return value;
      case STRING:
        return value;
      case INT:
        return Integer.valueOf(value);
      case BOOLEAN:
        return INT_TRUE.equalsIgnoreCase(value) ? Boolean.TRUE : Boolean.FALSE;
      case BYTE:
        return Byte.valueOf(value);
      case DOUBLE:
        return Double.valueOf(value);
      case FLOAT:
        return Float.valueOf(value);
      case LONG:
        return Long.valueOf(value);
      case SHORT:
        return Short.valueOf(value);
      default:
        return value;
    }
  }

  public <T> T getValue(Class<T> type) {
    return (T) getValue();
  }


}

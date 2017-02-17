/**
 * WSTransformerPluginV2GetConfiguration.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.talend.mdm.webservice;

public class WSTransformerPluginV2GetConfiguration  implements java.io.Serializable {
    private java.lang.String jndiName;

    private java.lang.String optionalParameter;

    public WSTransformerPluginV2GetConfiguration() {
    }

    public WSTransformerPluginV2GetConfiguration(
           java.lang.String jndiName,
           java.lang.String optionalParameter) {
           this.jndiName = jndiName;
           this.optionalParameter = optionalParameter;
    }


    /**
     * Gets the jndiName value for this WSTransformerPluginV2GetConfiguration.
     * 
     * @return jndiName
     */
    public java.lang.String getJndiName() {
        return jndiName;
    }


    /**
     * Sets the jndiName value for this WSTransformerPluginV2GetConfiguration.
     * 
     * @param jndiName
     */
    public void setJndiName(java.lang.String jndiName) {
        this.jndiName = jndiName;
    }


    /**
     * Gets the optionalParameter value for this WSTransformerPluginV2GetConfiguration.
     * 
     * @return optionalParameter
     */
    public java.lang.String getOptionalParameter() {
        return optionalParameter;
    }


    /**
     * Sets the optionalParameter value for this WSTransformerPluginV2GetConfiguration.
     * 
     * @param optionalParameter
     */
    public void setOptionalParameter(java.lang.String optionalParameter) {
        this.optionalParameter = optionalParameter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSTransformerPluginV2GetConfiguration)) return false;
        WSTransformerPluginV2GetConfiguration other = (WSTransformerPluginV2GetConfiguration) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.jndiName==null && other.getJndiName()==null) || 
             (this.jndiName!=null &&
              this.jndiName.equals(other.getJndiName()))) &&
            ((this.optionalParameter==null && other.getOptionalParameter()==null) || 
             (this.optionalParameter!=null &&
              this.optionalParameter.equals(other.getOptionalParameter())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getJndiName() != null) {
            _hashCode += getJndiName().hashCode();
        }
        if (getOptionalParameter() != null) {
            _hashCode += getOptionalParameter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSTransformerPluginV2GetConfiguration.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSTransformerPluginV2GetConfiguration"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jndiName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jndiName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("optionalParameter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "optionalParameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

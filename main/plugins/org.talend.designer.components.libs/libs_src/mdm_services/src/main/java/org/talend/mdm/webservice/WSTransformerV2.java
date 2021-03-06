/**
 * WSTransformerV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.talend.mdm.webservice;

public class WSTransformerV2  implements java.io.Serializable {
    private java.lang.String name;

    private java.lang.String description;

    private org.talend.mdm.webservice.WSTransformerProcessStep[] processSteps;

    public WSTransformerV2() {
    }

    public WSTransformerV2(
           java.lang.String name,
           java.lang.String description,
           org.talend.mdm.webservice.WSTransformerProcessStep[] processSteps) {
           this.name = name;
           this.description = description;
           this.processSteps = processSteps;
    }


    /**
     * Gets the name value for this WSTransformerV2.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this WSTransformerV2.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the description value for this WSTransformerV2.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this WSTransformerV2.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the processSteps value for this WSTransformerV2.
     * 
     * @return processSteps
     */
    public org.talend.mdm.webservice.WSTransformerProcessStep[] getProcessSteps() {
        return processSteps;
    }


    /**
     * Sets the processSteps value for this WSTransformerV2.
     * 
     * @param processSteps
     */
    public void setProcessSteps(org.talend.mdm.webservice.WSTransformerProcessStep[] processSteps) {
        this.processSteps = processSteps;
    }

    public org.talend.mdm.webservice.WSTransformerProcessStep getProcessSteps(int i) {
        return this.processSteps[i];
    }

    public void setProcessSteps(int i, org.talend.mdm.webservice.WSTransformerProcessStep _value) {
        this.processSteps[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSTransformerV2)) return false;
        WSTransformerV2 other = (WSTransformerV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.processSteps==null && other.getProcessSteps()==null) || 
             (this.processSteps!=null &&
              java.util.Arrays.equals(this.processSteps, other.getProcessSteps())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getProcessSteps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProcessSteps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProcessSteps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSTransformerV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSTransformerV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processSteps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processSteps"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSTransformerProcessStep"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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

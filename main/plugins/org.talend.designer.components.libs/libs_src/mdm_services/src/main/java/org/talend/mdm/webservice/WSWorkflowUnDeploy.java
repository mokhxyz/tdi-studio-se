/**
 * WSWorkflowUnDeploy.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.talend.mdm.webservice;

public class WSWorkflowUnDeploy  implements java.io.Serializable {
    private org.talend.mdm.webservice.WSWorkflowProcessDefinitionUUID uuid;

    public WSWorkflowUnDeploy() {
    }

    public WSWorkflowUnDeploy(
           org.talend.mdm.webservice.WSWorkflowProcessDefinitionUUID uuid) {
           this.uuid = uuid;
    }


    /**
     * Gets the uuid value for this WSWorkflowUnDeploy.
     * 
     * @return uuid
     */
    public org.talend.mdm.webservice.WSWorkflowProcessDefinitionUUID getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid value for this WSWorkflowUnDeploy.
     * 
     * @param uuid
     */
    public void setUuid(org.talend.mdm.webservice.WSWorkflowProcessDefinitionUUID uuid) {
        this.uuid = uuid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSWorkflowUnDeploy)) return false;
        WSWorkflowUnDeploy other = (WSWorkflowUnDeploy) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.uuid==null && other.getUuid()==null) || 
             (this.uuid!=null &&
              this.uuid.equals(other.getUuid())));
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
        if (getUuid() != null) {
            _hashCode += getUuid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSWorkflowUnDeploy.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSWorkflowUnDeploy"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uuid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uuid"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSWorkflowProcessDefinitionUUID"));
        elemField.setNillable(false);
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

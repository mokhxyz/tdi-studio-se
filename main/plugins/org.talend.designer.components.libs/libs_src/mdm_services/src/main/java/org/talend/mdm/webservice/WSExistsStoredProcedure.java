/**
 * WSExistsStoredProcedure.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.talend.mdm.webservice;

public class WSExistsStoredProcedure  implements java.io.Serializable {
    private org.talend.mdm.webservice.WSStoredProcedurePK wsStoredProcedurePK;

    public WSExistsStoredProcedure() {
    }

    public WSExistsStoredProcedure(
           org.talend.mdm.webservice.WSStoredProcedurePK wsStoredProcedurePK) {
           this.wsStoredProcedurePK = wsStoredProcedurePK;
    }


    /**
     * Gets the wsStoredProcedurePK value for this WSExistsStoredProcedure.
     * 
     * @return wsStoredProcedurePK
     */
    public org.talend.mdm.webservice.WSStoredProcedurePK getWsStoredProcedurePK() {
        return wsStoredProcedurePK;
    }


    /**
     * Sets the wsStoredProcedurePK value for this WSExistsStoredProcedure.
     * 
     * @param wsStoredProcedurePK
     */
    public void setWsStoredProcedurePK(org.talend.mdm.webservice.WSStoredProcedurePK wsStoredProcedurePK) {
        this.wsStoredProcedurePK = wsStoredProcedurePK;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSExistsStoredProcedure)) return false;
        WSExistsStoredProcedure other = (WSExistsStoredProcedure) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.wsStoredProcedurePK==null && other.getWsStoredProcedurePK()==null) || 
             (this.wsStoredProcedurePK!=null &&
              this.wsStoredProcedurePK.equals(other.getWsStoredProcedurePK())));
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
        if (getWsStoredProcedurePK() != null) {
            _hashCode += getWsStoredProcedurePK().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSExistsStoredProcedure.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSExistsStoredProcedure"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wsStoredProcedurePK");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wsStoredProcedurePK"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSStoredProcedurePK"));
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

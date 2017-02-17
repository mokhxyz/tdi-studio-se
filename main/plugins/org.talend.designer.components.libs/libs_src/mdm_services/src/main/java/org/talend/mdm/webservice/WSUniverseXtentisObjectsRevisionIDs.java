/**
 * WSUniverseXtentisObjectsRevisionIDs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.talend.mdm.webservice;

public class WSUniverseXtentisObjectsRevisionIDs  implements java.io.Serializable {
    private java.lang.String xtentisObjectName;

    private java.lang.String revisionID;

    public WSUniverseXtentisObjectsRevisionIDs() {
    }

    public WSUniverseXtentisObjectsRevisionIDs(
           java.lang.String xtentisObjectName,
           java.lang.String revisionID) {
           this.xtentisObjectName = xtentisObjectName;
           this.revisionID = revisionID;
    }


    /**
     * Gets the xtentisObjectName value for this WSUniverseXtentisObjectsRevisionIDs.
     * 
     * @return xtentisObjectName
     */
    public java.lang.String getXtentisObjectName() {
        return xtentisObjectName;
    }


    /**
     * Sets the xtentisObjectName value for this WSUniverseXtentisObjectsRevisionIDs.
     * 
     * @param xtentisObjectName
     */
    public void setXtentisObjectName(java.lang.String xtentisObjectName) {
        this.xtentisObjectName = xtentisObjectName;
    }


    /**
     * Gets the revisionID value for this WSUniverseXtentisObjectsRevisionIDs.
     * 
     * @return revisionID
     */
    public java.lang.String getRevisionID() {
        return revisionID;
    }


    /**
     * Sets the revisionID value for this WSUniverseXtentisObjectsRevisionIDs.
     * 
     * @param revisionID
     */
    public void setRevisionID(java.lang.String revisionID) {
        this.revisionID = revisionID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSUniverseXtentisObjectsRevisionIDs)) return false;
        WSUniverseXtentisObjectsRevisionIDs other = (WSUniverseXtentisObjectsRevisionIDs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.xtentisObjectName==null && other.getXtentisObjectName()==null) || 
             (this.xtentisObjectName!=null &&
              this.xtentisObjectName.equals(other.getXtentisObjectName()))) &&
            ((this.revisionID==null && other.getRevisionID()==null) || 
             (this.revisionID!=null &&
              this.revisionID.equals(other.getRevisionID())));
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
        if (getXtentisObjectName() != null) {
            _hashCode += getXtentisObjectName().hashCode();
        }
        if (getRevisionID() != null) {
            _hashCode += getRevisionID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSUniverseXtentisObjectsRevisionIDs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", ">WSUniverse>xtentisObjectsRevisionIDs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xtentisObjectName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xtentisObjectName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisionID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisionID"));
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

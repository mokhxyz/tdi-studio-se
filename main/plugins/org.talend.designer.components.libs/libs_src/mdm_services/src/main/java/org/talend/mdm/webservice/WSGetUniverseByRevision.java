/**
 * WSGetUniverseByRevision.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.talend.mdm.webservice;

public class WSGetUniverseByRevision  implements java.io.Serializable {
    private java.lang.String namepattern;

    private java.lang.String revision;

    private org.talend.mdm.webservice.WSGetUniverseByRevisionType type;

    public WSGetUniverseByRevision() {
    }

    public WSGetUniverseByRevision(
           java.lang.String namepattern,
           java.lang.String revision,
           org.talend.mdm.webservice.WSGetUniverseByRevisionType type) {
           this.namepattern = namepattern;
           this.revision = revision;
           this.type = type;
    }


    /**
     * Gets the namepattern value for this WSGetUniverseByRevision.
     * 
     * @return namepattern
     */
    public java.lang.String getNamepattern() {
        return namepattern;
    }


    /**
     * Sets the namepattern value for this WSGetUniverseByRevision.
     * 
     * @param namepattern
     */
    public void setNamepattern(java.lang.String namepattern) {
        this.namepattern = namepattern;
    }


    /**
     * Gets the revision value for this WSGetUniverseByRevision.
     * 
     * @return revision
     */
    public java.lang.String getRevision() {
        return revision;
    }


    /**
     * Sets the revision value for this WSGetUniverseByRevision.
     * 
     * @param revision
     */
    public void setRevision(java.lang.String revision) {
        this.revision = revision;
    }


    /**
     * Gets the type value for this WSGetUniverseByRevision.
     * 
     * @return type
     */
    public org.talend.mdm.webservice.WSGetUniverseByRevisionType getType() {
        return type;
    }


    /**
     * Sets the type value for this WSGetUniverseByRevision.
     * 
     * @param type
     */
    public void setType(org.talend.mdm.webservice.WSGetUniverseByRevisionType type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSGetUniverseByRevision)) return false;
        WSGetUniverseByRevision other = (WSGetUniverseByRevision) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.namepattern==null && other.getNamepattern()==null) || 
             (this.namepattern!=null &&
              this.namepattern.equals(other.getNamepattern()))) &&
            ((this.revision==null && other.getRevision()==null) || 
             (this.revision!=null &&
              this.revision.equals(other.getRevision()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
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
        if (getNamepattern() != null) {
            _hashCode += getNamepattern().hashCode();
        }
        if (getRevision() != null) {
            _hashCode += getRevision().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSGetUniverseByRevision.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSGetUniverseByRevision"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("namepattern");
        elemField.setXmlName(new javax.xml.namespace.QName("", "namepattern"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revision");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revision"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSGetUniverseByRevisionType"));
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

/**
 * WSVersioningGetObjectsVersions.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.talend.mdm.webservice;


/**
 * Get tagging versions for one or more Xtentis Object instances -
 * do not pass any name to get tagging versions of the object
 */
public class WSVersioningGetObjectsVersions  implements java.io.Serializable {
    private java.lang.String versioningSystemName;

    private java.lang.String type;

    private java.lang.String[] names;

    public WSVersioningGetObjectsVersions() {
    }

    public WSVersioningGetObjectsVersions(
           java.lang.String versioningSystemName,
           java.lang.String type,
           java.lang.String[] names) {
           this.versioningSystemName = versioningSystemName;
           this.type = type;
           this.names = names;
    }


    /**
     * Gets the versioningSystemName value for this WSVersioningGetObjectsVersions.
     * 
     * @return versioningSystemName
     */
    public java.lang.String getVersioningSystemName() {
        return versioningSystemName;
    }


    /**
     * Sets the versioningSystemName value for this WSVersioningGetObjectsVersions.
     * 
     * @param versioningSystemName
     */
    public void setVersioningSystemName(java.lang.String versioningSystemName) {
        this.versioningSystemName = versioningSystemName;
    }


    /**
     * Gets the type value for this WSVersioningGetObjectsVersions.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this WSVersioningGetObjectsVersions.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the names value for this WSVersioningGetObjectsVersions.
     * 
     * @return names
     */
    public java.lang.String[] getNames() {
        return names;
    }


    /**
     * Sets the names value for this WSVersioningGetObjectsVersions.
     * 
     * @param names
     */
    public void setNames(java.lang.String[] names) {
        this.names = names;
    }

    public java.lang.String getNames(int i) {
        return this.names[i];
    }

    public void setNames(int i, java.lang.String _value) {
        this.names[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSVersioningGetObjectsVersions)) return false;
        WSVersioningGetObjectsVersions other = (WSVersioningGetObjectsVersions) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.versioningSystemName==null && other.getVersioningSystemName()==null) || 
             (this.versioningSystemName!=null &&
              this.versioningSystemName.equals(other.getVersioningSystemName()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.names==null && other.getNames()==null) || 
             (this.names!=null &&
              java.util.Arrays.equals(this.names, other.getNames())));
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
        if (getVersioningSystemName() != null) {
            _hashCode += getVersioningSystemName().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getNames() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNames());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNames(), i);
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
        new org.apache.axis.description.TypeDesc(WSVersioningGetObjectsVersions.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSVersioningGetObjectsVersions"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versioningSystemName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "versioningSystemName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("names");
        elemField.setXmlName(new javax.xml.namespace.QName("", "names"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

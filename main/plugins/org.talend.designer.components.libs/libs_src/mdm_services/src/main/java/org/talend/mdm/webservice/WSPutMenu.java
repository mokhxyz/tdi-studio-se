/**
 * WSPutMenu.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.talend.mdm.webservice;

public class WSPutMenu  implements java.io.Serializable {
    private org.talend.mdm.webservice.WSMenu wsMenu;

    public WSPutMenu() {
    }

    public WSPutMenu(
           org.talend.mdm.webservice.WSMenu wsMenu) {
           this.wsMenu = wsMenu;
    }


    /**
     * Gets the wsMenu value for this WSPutMenu.
     * 
     * @return wsMenu
     */
    public org.talend.mdm.webservice.WSMenu getWsMenu() {
        return wsMenu;
    }


    /**
     * Sets the wsMenu value for this WSPutMenu.
     * 
     * @param wsMenu
     */
    public void setWsMenu(org.talend.mdm.webservice.WSMenu wsMenu) {
        this.wsMenu = wsMenu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSPutMenu)) return false;
        WSPutMenu other = (WSPutMenu) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.wsMenu==null && other.getWsMenu()==null) || 
             (this.wsMenu!=null &&
              this.wsMenu.equals(other.getWsMenu())));
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
        if (getWsMenu() != null) {
            _hashCode += getWsMenu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSPutMenu.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSPutMenu"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wsMenu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wsMenu"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn-com-amalto-xtentis-webservice", "WSMenu"));
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

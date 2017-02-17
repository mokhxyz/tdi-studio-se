/*
 * XML Type:  ArrayOfOwnershipTypes
 * Namespace: http://schemas.microsoft.com/xrm/2011/Metadata
 * Java type: com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.xrm._2011.metadata;


/**
 * An XML ArrayOfOwnershipTypes(@http://schemas.microsoft.com/xrm/2011/Metadata).
 *
 * This is a complex type.
 */
public interface ArrayOfOwnershipTypes extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ArrayOfOwnershipTypes.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7EBB4BC9E00A8FB74293D27D6A5BA466").resolveHandle("arrayofownershiptypesd037type");
    
    /**
     * Gets array of all "OwnershipTypes" elements
     */
    java.util.List[] getOwnershipTypesArray();
    
    /**
     * Gets ith "OwnershipTypes" element
     */
    java.util.List getOwnershipTypesArray(int i);
    
    /**
     * Gets (as xml) array of all "OwnershipTypes" elements
     */
    com.microsoft.schemas.xrm._2011.metadata.OwnershipTypes[] xgetOwnershipTypesArray();
    
    /**
     * Gets (as xml) ith "OwnershipTypes" element
     */
    com.microsoft.schemas.xrm._2011.metadata.OwnershipTypes xgetOwnershipTypesArray(int i);
    
    /**
     * Returns number of "OwnershipTypes" element
     */
    int sizeOfOwnershipTypesArray();
    
    /**
     * Sets array of all "OwnershipTypes" element
     */
    void setOwnershipTypesArray(java.util.List[] ownershipTypesArray);
    
    /**
     * Sets ith "OwnershipTypes" element
     */
    void setOwnershipTypesArray(int i, java.util.List ownershipTypes);
    
    /**
     * Sets (as xml) array of all "OwnershipTypes" element
     */
    void xsetOwnershipTypesArray(com.microsoft.schemas.xrm._2011.metadata.OwnershipTypes[] ownershipTypesArray);
    
    /**
     * Sets (as xml) ith "OwnershipTypes" element
     */
    void xsetOwnershipTypesArray(int i, com.microsoft.schemas.xrm._2011.metadata.OwnershipTypes ownershipTypes);
    
    /**
     * Inserts the value as the ith "OwnershipTypes" element
     */
    void insertOwnershipTypes(int i, java.util.List ownershipTypes);
    
    /**
     * Appends the value as the last "OwnershipTypes" element
     */
    void addOwnershipTypes(java.util.List ownershipTypes);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "OwnershipTypes" element
     */
    com.microsoft.schemas.xrm._2011.metadata.OwnershipTypes insertNewOwnershipTypes(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "OwnershipTypes" element
     */
    com.microsoft.schemas.xrm._2011.metadata.OwnershipTypes addNewOwnershipTypes();
    
    /**
     * Removes the ith "OwnershipTypes" element
     */
    void removeOwnershipTypes(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes newInstance() {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfOwnershipTypes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

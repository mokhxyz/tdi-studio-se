/*
 * XML Type:  LocalizedLabel
 * Namespace: http://schemas.microsoft.com/xrm/2011/Contracts
 * Java type: com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.xrm._2011.contracts;


/**
 * An XML LocalizedLabel(@http://schemas.microsoft.com/xrm/2011/Contracts).
 *
 * This is a complex type.
 */
public interface LocalizedLabel extends com.microsoft.schemas.xrm._2011.metadata.MetadataBase
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LocalizedLabel.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7EBB4BC9E00A8FB74293D27D6A5BA466").resolveHandle("localizedlabelbd0atype");
    
    /**
     * Gets the "IsManaged" element
     */
    boolean getIsManaged();
    
    /**
     * Gets (as xml) the "IsManaged" element
     */
    org.apache.xmlbeans.XmlBoolean xgetIsManaged();
    
    /**
     * Tests for nil "IsManaged" element
     */
    boolean isNilIsManaged();
    
    /**
     * True if has "IsManaged" element
     */
    boolean isSetIsManaged();
    
    /**
     * Sets the "IsManaged" element
     */
    void setIsManaged(boolean isManaged);
    
    /**
     * Sets (as xml) the "IsManaged" element
     */
    void xsetIsManaged(org.apache.xmlbeans.XmlBoolean isManaged);
    
    /**
     * Nils the "IsManaged" element
     */
    void setNilIsManaged();
    
    /**
     * Unsets the "IsManaged" element
     */
    void unsetIsManaged();
    
    /**
     * Gets the "Label" element
     */
    java.lang.String getLabel();
    
    /**
     * Gets (as xml) the "Label" element
     */
    org.apache.xmlbeans.XmlString xgetLabel();
    
    /**
     * Tests for nil "Label" element
     */
    boolean isNilLabel();
    
    /**
     * True if has "Label" element
     */
    boolean isSetLabel();
    
    /**
     * Sets the "Label" element
     */
    void setLabel(java.lang.String label);
    
    /**
     * Sets (as xml) the "Label" element
     */
    void xsetLabel(org.apache.xmlbeans.XmlString label);
    
    /**
     * Nils the "Label" element
     */
    void setNilLabel();
    
    /**
     * Unsets the "Label" element
     */
    void unsetLabel();
    
    /**
     * Gets the "LanguageCode" element
     */
    int getLanguageCode();
    
    /**
     * Gets (as xml) the "LanguageCode" element
     */
    org.apache.xmlbeans.XmlInt xgetLanguageCode();
    
    /**
     * True if has "LanguageCode" element
     */
    boolean isSetLanguageCode();
    
    /**
     * Sets the "LanguageCode" element
     */
    void setLanguageCode(int languageCode);
    
    /**
     * Sets (as xml) the "LanguageCode" element
     */
    void xsetLanguageCode(org.apache.xmlbeans.XmlInt languageCode);
    
    /**
     * Unsets the "LanguageCode" element
     */
    void unsetLanguageCode();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel newInstance() {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.microsoft.schemas.xrm._2011.contracts.LocalizedLabel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

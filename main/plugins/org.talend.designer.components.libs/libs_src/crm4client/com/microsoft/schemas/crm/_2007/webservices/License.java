/*
 * XML Type:  license
 * Namespace: http://schemas.microsoft.com/crm/2007/WebServices
 * Java type: com.microsoft.schemas.crm._2007.webservices.License
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.crm._2007.webservices;


/**
 * An XML license(@http://schemas.microsoft.com/crm/2007/WebServices).
 *
 * This is a complex type.
 */
public interface License extends com.microsoft.schemas.crm._2006.webservices.BusinessEntity
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(License.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE3DFDC56E75679F2AF264CA469AD5996").resolveHandle("license85cdtype");
    
    /**
     * Gets the "installedon" element
     */
    com.microsoft.schemas.crm._2006.webservices.CrmDateTime getInstalledon();
    
    /**
     * True if has "installedon" element
     */
    boolean isSetInstalledon();
    
    /**
     * Sets the "installedon" element
     */
    void setInstalledon(com.microsoft.schemas.crm._2006.webservices.CrmDateTime installedon);
    
    /**
     * Appends and returns a new empty "installedon" element
     */
    com.microsoft.schemas.crm._2006.webservices.CrmDateTime addNewInstalledon();
    
    /**
     * Unsets the "installedon" element
     */
    void unsetInstalledon();
    
    /**
     * Gets the "licenseid" element
     */
    com.microsoft.schemas.crm._2006.webservices.Key getLicenseid();
    
    /**
     * True if has "licenseid" element
     */
    boolean isSetLicenseid();
    
    /**
     * Sets the "licenseid" element
     */
    void setLicenseid(com.microsoft.schemas.crm._2006.webservices.Key licenseid);
    
    /**
     * Appends and returns a new empty "licenseid" element
     */
    com.microsoft.schemas.crm._2006.webservices.Key addNewLicenseid();
    
    /**
     * Unsets the "licenseid" element
     */
    void unsetLicenseid();
    
    /**
     * Gets the "licensekey" element
     */
    java.lang.String getLicensekey();
    
    /**
     * Gets (as xml) the "licensekey" element
     */
    org.apache.xmlbeans.XmlString xgetLicensekey();
    
    /**
     * True if has "licensekey" element
     */
    boolean isSetLicensekey();
    
    /**
     * Sets the "licensekey" element
     */
    void setLicensekey(java.lang.String licensekey);
    
    /**
     * Sets (as xml) the "licensekey" element
     */
    void xsetLicensekey(org.apache.xmlbeans.XmlString licensekey);
    
    /**
     * Unsets the "licensekey" element
     */
    void unsetLicensekey();
    
    /**
     * Gets the "licensetype" element
     */
    com.microsoft.schemas.crm._2006.webservices.UniqueIdentifier getLicensetype();
    
    /**
     * True if has "licensetype" element
     */
    boolean isSetLicensetype();
    
    /**
     * Sets the "licensetype" element
     */
    void setLicensetype(com.microsoft.schemas.crm._2006.webservices.UniqueIdentifier licensetype);
    
    /**
     * Appends and returns a new empty "licensetype" element
     */
    com.microsoft.schemas.crm._2006.webservices.UniqueIdentifier addNewLicensetype();
    
    /**
     * Unsets the "licensetype" element
     */
    void unsetLicensetype();
    
    /**
     * Gets the "organizationid" element
     */
    com.microsoft.schemas.crm._2006.webservices.Lookup getOrganizationid();
    
    /**
     * True if has "organizationid" element
     */
    boolean isSetOrganizationid();
    
    /**
     * Sets the "organizationid" element
     */
    void setOrganizationid(com.microsoft.schemas.crm._2006.webservices.Lookup organizationid);
    
    /**
     * Appends and returns a new empty "organizationid" element
     */
    com.microsoft.schemas.crm._2006.webservices.Lookup addNewOrganizationid();
    
    /**
     * Unsets the "organizationid" element
     */
    void unsetOrganizationid();
    
    /**
     * Gets the "timezoneruleversionnumber" element
     */
    com.microsoft.schemas.crm._2006.webservices.CrmNumber getTimezoneruleversionnumber();
    
    /**
     * True if has "timezoneruleversionnumber" element
     */
    boolean isSetTimezoneruleversionnumber();
    
    /**
     * Sets the "timezoneruleversionnumber" element
     */
    void setTimezoneruleversionnumber(com.microsoft.schemas.crm._2006.webservices.CrmNumber timezoneruleversionnumber);
    
    /**
     * Appends and returns a new empty "timezoneruleversionnumber" element
     */
    com.microsoft.schemas.crm._2006.webservices.CrmNumber addNewTimezoneruleversionnumber();
    
    /**
     * Unsets the "timezoneruleversionnumber" element
     */
    void unsetTimezoneruleversionnumber();
    
    /**
     * Gets the "utcconversiontimezonecode" element
     */
    com.microsoft.schemas.crm._2006.webservices.CrmNumber getUtcconversiontimezonecode();
    
    /**
     * True if has "utcconversiontimezonecode" element
     */
    boolean isSetUtcconversiontimezonecode();
    
    /**
     * Sets the "utcconversiontimezonecode" element
     */
    void setUtcconversiontimezonecode(com.microsoft.schemas.crm._2006.webservices.CrmNumber utcconversiontimezonecode);
    
    /**
     * Appends and returns a new empty "utcconversiontimezonecode" element
     */
    com.microsoft.schemas.crm._2006.webservices.CrmNumber addNewUtcconversiontimezonecode();
    
    /**
     * Unsets the "utcconversiontimezonecode" element
     */
    void unsetUtcconversiontimezonecode();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.microsoft.schemas.crm._2007.webservices.License newInstance() {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.microsoft.schemas.crm._2007.webservices.License parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.microsoft.schemas.crm._2007.webservices.License parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.microsoft.schemas.crm._2007.webservices.License parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.microsoft.schemas.crm._2007.webservices.License parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.microsoft.schemas.crm._2007.webservices.License parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.microsoft.schemas.crm._2007.webservices.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

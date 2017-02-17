/**
 * CaseType.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2 Built on : Apr 17, 2012 (05:34:40 IST)
 */

package com.salesforce.soap.partner;

/**
 * CaseType bean class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class CaseType implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("urn:partner.soap.sforce.com",
            "CaseType", "ns1");

    /**
     * field for CaseType
     */

    protected java.lang.String localCaseType;

    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor

    protected CaseType(java.lang.String value, boolean isRegisterValue) {
        localCaseType = value;
        if (isRegisterValue) {

            _table_.put(localCaseType, this);

        }

    }

    public static final java.lang.String _Nominative = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Nominative");

    public static final java.lang.String _Accusative = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Accusative");

    public static final java.lang.String _Genitive = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Genitive");

    public static final java.lang.String _Dative = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Dative");

    public static final java.lang.String _Inessive = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Inessive");

    public static final java.lang.String _Elative = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Elative");

    public static final java.lang.String _Illative = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Illative");

    public static final java.lang.String _Adessive = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Adessive");

    public static final java.lang.String _Ablative = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Ablative");

    public static final java.lang.String _Allative = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Allative");

    public static final java.lang.String _Essive = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Essive");

    public static final java.lang.String _Translative = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Translative");

    public static final java.lang.String _Partitive = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Partitive");

    public static final java.lang.String _Objective = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Objective");

    public static final java.lang.String _Subjective = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Subjective");

    public static final java.lang.String _Instrumental = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Instrumental");

    public static final java.lang.String _Prepositional = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Prepositional");

    public static final java.lang.String _Locative = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Locative");

    public static final java.lang.String _Vocative = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Vocative");

    public static final java.lang.String _Sublative = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Sublative");

    public static final java.lang.String _Superessive = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Superessive");

    public static final java.lang.String _Delative = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Delative");

    public static final java.lang.String _Causalfinal = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Causalfinal");

    public static final java.lang.String _Essiveformal = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Essiveformal");

    public static final java.lang.String _Termanative = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Termanative");

    public static final java.lang.String _Distributive = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Distributive");

    public static final java.lang.String _Ergative = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Ergative");

    public static final java.lang.String _Adverbial = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Adverbial");

    public static final java.lang.String _Abessive = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Abessive");

    public static final java.lang.String _Comitative = org.apache.axis2.databinding.utils.ConverterUtil
            .convertToString("Comitative");

    public static final CaseType Nominative = new CaseType(_Nominative, true);

    public static final CaseType Accusative = new CaseType(_Accusative, true);

    public static final CaseType Genitive = new CaseType(_Genitive, true);

    public static final CaseType Dative = new CaseType(_Dative, true);

    public static final CaseType Inessive = new CaseType(_Inessive, true);

    public static final CaseType Elative = new CaseType(_Elative, true);

    public static final CaseType Illative = new CaseType(_Illative, true);

    public static final CaseType Adessive = new CaseType(_Adessive, true);

    public static final CaseType Ablative = new CaseType(_Ablative, true);

    public static final CaseType Allative = new CaseType(_Allative, true);

    public static final CaseType Essive = new CaseType(_Essive, true);

    public static final CaseType Translative = new CaseType(_Translative, true);

    public static final CaseType Partitive = new CaseType(_Partitive, true);

    public static final CaseType Objective = new CaseType(_Objective, true);

    public static final CaseType Subjective = new CaseType(_Subjective, true);

    public static final CaseType Instrumental = new CaseType(_Instrumental, true);

    public static final CaseType Prepositional = new CaseType(_Prepositional, true);

    public static final CaseType Locative = new CaseType(_Locative, true);

    public static final CaseType Vocative = new CaseType(_Vocative, true);

    public static final CaseType Sublative = new CaseType(_Sublative, true);

    public static final CaseType Superessive = new CaseType(_Superessive, true);

    public static final CaseType Delative = new CaseType(_Delative, true);

    public static final CaseType Causalfinal = new CaseType(_Causalfinal, true);

    public static final CaseType Essiveformal = new CaseType(_Essiveformal, true);

    public static final CaseType Termanative = new CaseType(_Termanative, true);

    public static final CaseType Distributive = new CaseType(_Distributive, true);

    public static final CaseType Ergative = new CaseType(_Ergative, true);

    public static final CaseType Adverbial = new CaseType(_Adverbial, true);

    public static final CaseType Abessive = new CaseType(_Abessive, true);

    public static final CaseType Comitative = new CaseType(_Comitative, true);

    public java.lang.String getValue() {
        return localCaseType;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj == this);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public java.lang.String toString() {

        return localCaseType.toString();

    }

    /**
     *
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

        org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
        return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
        serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
            boolean serializeType) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

        // We can safely assume an element has only one type associated with it

        java.lang.String namespace = parentQName.getNamespaceURI();
        java.lang.String _localName = parentQName.getLocalPart();

        writeStartElement(null, namespace, _localName, xmlWriter);

        // add the type details if this is used in a simple type
        if (serializeType) {
            java.lang.String namespacePrefix = registerPrefix(xmlWriter, "urn:partner.soap.sforce.com");
            if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":CaseType",
                        xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "CaseType", xmlWriter);
            }
        }

        if (localCaseType == null) {

            throw new org.apache.axis2.databinding.ADBException("CaseType cannot be null !!");

        } else {

            xmlWriter.writeCharacters(localCaseType);

        }

        xmlWriter.writeEndElement();

    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
        if (namespace.equals("urn:partner.soap.sforce.com")) {
            return "ns1";
        }
        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
            javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
        if (writerPrefix != null) {
            xmlWriter.writeStartElement(namespace, localPart);
        } else {
            if (namespace.length() == 0) {
                prefix = "";
            } else if (prefix == null) {
                prefix = generatePrefix(namespace);
            }

            xmlWriter.writeStartElement(prefix, localPart, namespace);
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
            java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        if (xmlWriter.getPrefix(namespace) == null) {
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
        xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

        java.lang.String attributeNamespace = qname.getNamespaceURI();
        java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
        if (attributePrefix == null) {
            attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
        }
        java.lang.String attributeValue;
        if (attributePrefix.trim().length() > 0) {
            attributeValue = attributePrefix + ":" + qname.getLocalPart();
        } else {
            attributeValue = qname.getLocalPart();
        }

        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attributeValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attributeValue);
        }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
        java.lang.String namespaceURI = qname.getNamespaceURI();
        if (namespaceURI != null) {
            java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
            if (prefix == null) {
                prefix = generatePrefix(namespaceURI);
                xmlWriter.writeNamespace(prefix, namespaceURI);
                xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
                xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            } else {
                // i.e this is the default namespace
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {

        if (qnames != null) {
            // we have to store this data until last moment since it is not possible to write any
            // namespace data after writing the charactor data
            java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
            java.lang.String namespaceURI = null;
            java.lang.String prefix = null;

            for (int i = 0; i < qnames.length; i++) {
                if (i > 0) {
                    stringToWrite.append(" ");
                }
                namespaceURI = qnames[i].getNamespaceURI();
                if (namespaceURI != null) {
                    prefix = xmlWriter.getPrefix(namespaceURI);
                    if ((prefix == null) || (prefix.length() == 0)) {
                        prefix = generatePrefix(namespaceURI);
                        xmlWriter.writeNamespace(prefix, namespaceURI);
                        xmlWriter.setPrefix(prefix, namespaceURI);
                    }

                    if (prefix.trim().length() > 0) {
                        stringToWrite.append(prefix).append(":")
                                .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                } else {
                    stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                }
            }
            xmlWriter.writeCharacters(stringToWrite.toString());
        }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
            throws javax.xml.stream.XMLStreamException {
        java.lang.String prefix = xmlWriter.getPrefix(namespace);
        if (prefix == null) {
            prefix = generatePrefix(namespace);
            javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
            while (true) {
                java.lang.String uri = nsContext.getNamespaceURI(prefix);
                if (uri == null || uri.length() == 0) {
                    break;
                }
                prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
            }
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
        return prefix;
    }

    /**
     * databinding method to get an XML representation of this object
     *
     */
    public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
            throws org.apache.axis2.databinding.ADBException {

        // We can safely assume an element has only one type associated with it
        return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME, new java.lang.Object[] {
                org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCaseType) }, null);

    }

    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {

        public static CaseType fromValue(java.lang.String value) throws java.lang.IllegalArgumentException {
            CaseType enumeration = (CaseType)

            _table_.get(value);

            if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                throw new java.lang.IllegalArgumentException();
            }
            return enumeration;
        }

        public static CaseType fromString(java.lang.String value, java.lang.String namespaceURI)
                throws java.lang.IllegalArgumentException {
            try {

                return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

            } catch (java.lang.Exception e) {
                throw new java.lang.IllegalArgumentException();
            }
        }

        public static CaseType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader, java.lang.String content) {
            if (content.indexOf(":") > -1) {
                java.lang.String prefix = content.substring(0, content.indexOf(":"));
                java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                return CaseType.Factory.fromString(content, namespaceUri);
            } else {
                return CaseType.Factory.fromString(content, "");
            }
        }

        /**
         * static method to create the object Precondition: If this object is an element, the current or next start element starts this
         * object and any intervening reader events are ignorable If this object is not an element, it is a complex type and the reader is
         * at the event just after the outer start element Postcondition: If this object is an element, the reader is positioned at its end
         * element If this object is a complex type, the reader is positioned at the end element of its outer element
         */
        public static CaseType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            CaseType object = null;
            // initialize a hash map to keep values
            java.util.Map attributeMap = new java.util.HashMap();
            java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix = "";
            java.lang.String namespaceuri = "";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                while (!reader.isEndElement()) {
                    if (reader.isStartElement() || reader.hasText()) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "CaseType" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        if (content.indexOf(":") > 0) {
                            // this seems to be a Qname so find the namespace and send
                            prefix = content.substring(0, content.indexOf(":"));
                            namespaceuri = reader.getNamespaceURI(prefix);
                            object = CaseType.Factory.fromString(content, namespaceuri);
                        } else {
                            // this seems to be not a qname send and empty namespace incase of it is
                            // check is done in fromString method
                            object = CaseType.Factory.fromString(content, "");
                        }

                    } else {
                        reader.next();
                    }
                }  // end of while loop

            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

    }// end of factory class

}

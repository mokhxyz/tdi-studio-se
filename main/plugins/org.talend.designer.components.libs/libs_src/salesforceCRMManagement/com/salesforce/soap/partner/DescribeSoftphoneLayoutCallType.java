/**
 * DescribeSoftphoneLayoutCallType.java
 * 
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2 Built on : Apr 17, 2012 (05:34:40 IST)
 */

package com.salesforce.soap.partner;

/**
 * DescribeSoftphoneLayoutCallType bean class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class DescribeSoftphoneLayoutCallType implements org.apache.axis2.databinding.ADBBean {

    /*
     * This type was generated from the piece of schema that had name = DescribeSoftphoneLayoutCallType Namespace URI =
     * urn:partner.soap.sforce.com Namespace Prefix = ns1
     */

    /**
     * field for InfoFields This was an Array!
     */

    protected com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField[] localInfoFields;

    /**
     * Auto generated getter method
     * 
     * @return com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField[]
     */
    public com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField[] getInfoFields() {
        return localInfoFields;
    }

    /**
     * validate the array for InfoFields
     */
    protected void validateInfoFields(com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField[] param) {

        if ((param != null) && (param.length < 1)) {
            throw new java.lang.RuntimeException();
        }

    }

    /**
     * Auto generated setter method
     * 
     * @param param InfoFields
     */
    public void setInfoFields(com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField[] param) {

        validateInfoFields(param);

        this.localInfoFields = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * 
     * @param param com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField
     */
    public void addInfoFields(com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField param) {
        if (localInfoFields == null) {
            localInfoFields = new com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField[] {};
        }

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localInfoFields);
        list.add(param);
        this.localInfoFields = (com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField[]) list
                .toArray(new com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField[list.size()]);

    }

    /**
     * field for Name
     */

    protected java.lang.String localName;

    /**
     * Auto generated getter method
     * 
     * @return java.lang.String
     */
    public java.lang.String getName() {
        return localName;
    }

    /**
     * Auto generated setter method
     * 
     * @param param Name
     */
    public void setName(java.lang.String param) {

        this.localName = param;

    }

    /**
     * field for ScreenPopOptions This was an Array!
     */

    protected com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption[] localScreenPopOptions;

    /*
     * This tracker boolean wil be used to detect whether the user called the set method for this attribute. It will be
     * used to determine whether to include this field in the serialized XML
     */
    protected boolean localScreenPopOptionsTracker = false;

    public boolean isScreenPopOptionsSpecified() {
        return localScreenPopOptionsTracker;
    }

    /**
     * Auto generated getter method
     * 
     * @return com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption[]
     */
    public com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption[] getScreenPopOptions() {
        return localScreenPopOptions;
    }

    /**
     * validate the array for ScreenPopOptions
     */
    protected void validateScreenPopOptions(com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption[] param) {

    }

    /**
     * Auto generated setter method
     * 
     * @param param ScreenPopOptions
     */
    public void setScreenPopOptions(com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption[] param) {

        validateScreenPopOptions(param);

        localScreenPopOptionsTracker = param != null;

        this.localScreenPopOptions = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * 
     * @param param com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption
     */
    public void addScreenPopOptions(com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption param) {
        if (localScreenPopOptions == null) {
            localScreenPopOptions = new com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption[] {};
        }

        // update the setting tracker
        localScreenPopOptionsTracker = true;

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localScreenPopOptions);
        list.add(param);
        this.localScreenPopOptions = (com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption[]) list
                .toArray(new com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption[list.size()]);

    }

    /**
     * field for ScreenPopsOpenWithin
     */

    protected java.lang.String localScreenPopsOpenWithin;

    /*
     * This tracker boolean wil be used to detect whether the user called the set method for this attribute. It will be
     * used to determine whether to include this field in the serialized XML
     */
    protected boolean localScreenPopsOpenWithinTracker = false;

    public boolean isScreenPopsOpenWithinSpecified() {
        return localScreenPopsOpenWithinTracker;
    }

    /**
     * Auto generated getter method
     * 
     * @return java.lang.String
     */
    public java.lang.String getScreenPopsOpenWithin() {
        return localScreenPopsOpenWithin;
    }

    /**
     * Auto generated setter method
     * 
     * @param param ScreenPopsOpenWithin
     */
    public void setScreenPopsOpenWithin(java.lang.String param) {
        localScreenPopsOpenWithinTracker = param != null;

        this.localScreenPopsOpenWithin = param;

    }

    /**
     * field for Sections This was an Array!
     */

    protected com.salesforce.soap.partner.DescribeSoftphoneLayoutSection[] localSections;

    /*
     * This tracker boolean wil be used to detect whether the user called the set method for this attribute. It will be
     * used to determine whether to include this field in the serialized XML
     */
    protected boolean localSectionsTracker = false;

    public boolean isSectionsSpecified() {
        return localSectionsTracker;
    }

    /**
     * Auto generated getter method
     * 
     * @return com.salesforce.soap.partner.DescribeSoftphoneLayoutSection[]
     */
    public com.salesforce.soap.partner.DescribeSoftphoneLayoutSection[] getSections() {
        return localSections;
    }

    /**
     * validate the array for Sections
     */
    protected void validateSections(com.salesforce.soap.partner.DescribeSoftphoneLayoutSection[] param) {

    }

    /**
     * Auto generated setter method
     * 
     * @param param Sections
     */
    public void setSections(com.salesforce.soap.partner.DescribeSoftphoneLayoutSection[] param) {

        validateSections(param);

        localSectionsTracker = param != null;

        this.localSections = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * 
     * @param param com.salesforce.soap.partner.DescribeSoftphoneLayoutSection
     */
    public void addSections(com.salesforce.soap.partner.DescribeSoftphoneLayoutSection param) {
        if (localSections == null) {
            localSections = new com.salesforce.soap.partner.DescribeSoftphoneLayoutSection[] {};
        }

        // update the setting tracker
        localSectionsTracker = true;

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localSections);
        list.add(param);
        this.localSections = (com.salesforce.soap.partner.DescribeSoftphoneLayoutSection[]) list
                .toArray(new com.salesforce.soap.partner.DescribeSoftphoneLayoutSection[list.size()]);

    }

    /**
     * 
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

        org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
        return factory.createOMElement(dataSource, parentQName);

    }

    public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
        serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
            boolean serializeType) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

        java.lang.String prefix = null;
        java.lang.String namespace = null;

        prefix = parentQName.getPrefix();
        namespace = parentQName.getNamespaceURI();
        writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

        if (serializeType) {

            java.lang.String namespacePrefix = registerPrefix(xmlWriter, "urn:partner.soap.sforce.com");
            if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
                        + ":DescribeSoftphoneLayoutCallType", xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "DescribeSoftphoneLayoutCallType",
                        xmlWriter);
            }

        }

        if (localInfoFields != null) {
            for (int i = 0; i < localInfoFields.length; i++) {
                if (localInfoFields[i] != null) {
                    localInfoFields[i].serialize(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "infoFields"),
                            xmlWriter);
                } else {

                    throw new org.apache.axis2.databinding.ADBException("infoFields cannot be null!!");

                }

            }
        } else {

            throw new org.apache.axis2.databinding.ADBException("infoFields cannot be null!!");

        }

        namespace = "urn:partner.soap.sforce.com";
        writeStartElement(null, namespace, "name", xmlWriter);

        if (localName == null) {
            // write the nil attribute

            throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");

        } else {

            xmlWriter.writeCharacters(localName);

        }

        xmlWriter.writeEndElement();
        if (localScreenPopOptionsTracker) {
            if (localScreenPopOptions != null) {
                for (int i = 0; i < localScreenPopOptions.length; i++) {
                    if (localScreenPopOptions[i] != null) {
                        localScreenPopOptions[i].serialize(new javax.xml.namespace.QName("urn:partner.soap.sforce.com",
                                "screenPopOptions"), xmlWriter);
                    } else {

                        // we don't have to do any thing since minOccures is zero

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException("screenPopOptions cannot be null!!");

            }
        }
        if (localScreenPopsOpenWithinTracker) {
            namespace = "urn:partner.soap.sforce.com";
            writeStartElement(null, namespace, "screenPopsOpenWithin", xmlWriter);

            if (localScreenPopsOpenWithin == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("screenPopsOpenWithin cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localScreenPopsOpenWithin);

            }

            xmlWriter.writeEndElement();
        }
        if (localSectionsTracker) {
            if (localSections != null) {
                for (int i = 0; i < localSections.length; i++) {
                    if (localSections[i] != null) {
                        localSections[i].serialize(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "sections"),
                                xmlWriter);
                    } else {

                        // we don't have to do any thing since minOccures is zero

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException("sections cannot be null!!");

            }
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

        java.util.ArrayList elementList = new java.util.ArrayList();
        java.util.ArrayList attribList = new java.util.ArrayList();

        if (localInfoFields != null) {
            for (int i = 0; i < localInfoFields.length; i++) {

                if (localInfoFields[i] != null) {
                    elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "infoFields"));
                    elementList.add(localInfoFields[i]);
                } else {

                    throw new org.apache.axis2.databinding.ADBException("infoFields cannot be null !!");

                }

            }
        } else {

            throw new org.apache.axis2.databinding.ADBException("infoFields cannot be null!!");

        }

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "name"));

        if (localName != null) {
            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
        } else {
            throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");
        }
        if (localScreenPopOptionsTracker) {
            if (localScreenPopOptions != null) {
                for (int i = 0; i < localScreenPopOptions.length; i++) {

                    if (localScreenPopOptions[i] != null) {
                        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "screenPopOptions"));
                        elementList.add(localScreenPopOptions[i]);
                    } else {

                        // nothing to do

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException("screenPopOptions cannot be null!!");

            }

        }
        if (localScreenPopsOpenWithinTracker) {
            elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "screenPopsOpenWithin"));

            if (localScreenPopsOpenWithin != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localScreenPopsOpenWithin));
            } else {
                throw new org.apache.axis2.databinding.ADBException("screenPopsOpenWithin cannot be null!!");
            }
        }
        if (localSectionsTracker) {
            if (localSections != null) {
                for (int i = 0; i < localSections.length; i++) {

                    if (localSections[i] != null) {
                        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "sections"));
                        elementList.add(localSections[i]);
                    } else {

                        // nothing to do

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException("sections cannot be null!!");

            }

        }

        return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                attribList.toArray());

    }

    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {

        /**
         * static method to create the object Precondition: If this object is an element, the current or next start
         * element starts this object and any intervening reader events are ignorable If this object is not an element,
         * it is a complex type and the reader is at the event just after the outer start element Postcondition: If this
         * object is an element, the reader is positioned at its end element If this object is a complex type, the
         * reader is positioned at the end element of its outer element
         */
        public static DescribeSoftphoneLayoutCallType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            DescribeSoftphoneLayoutCallType object = new DescribeSoftphoneLayoutCallType();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix = "";
            java.lang.String namespaceuri = "";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                    java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                    if (fullTypeName != null) {
                        java.lang.String nsPrefix = null;
                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                        }
                        nsPrefix = nsPrefix == null ? "" : nsPrefix;

                        java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                        if (!"DescribeSoftphoneLayoutCallType".equals(type)) {
                            // find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (DescribeSoftphoneLayoutCallType) com.salesforce.soap.partner.sobject.ExtensionMapper
                                    .getTypeObject(nsUri, type, reader);
                        }

                    }

                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                java.util.ArrayList list1 = new java.util.ArrayList();

                java.util.ArrayList list3 = new java.util.ArrayList();

                java.util.ArrayList list5 = new java.util.ArrayList();

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "infoFields").equals(reader.getName())) {

                    // Process the array and step past its final element's end.
                    list1.add(com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField.Factory.parse(reader));

                    // loop until we find a start element that is not part of this array
                    boolean loopDone1 = false;
                    while (!loopDone1) {
                        // We should be at the end element, but make sure
                        while (!reader.isEndElement())
                            reader.next();
                        // Step out of this element
                        reader.next();
                        // Step to next element event.
                        while (!reader.isStartElement() && !reader.isEndElement())
                            reader.next();
                        if (reader.isEndElement()) {
                            // two continuous end elements means we are exiting the xml structure
                            loopDone1 = true;
                        } else {
                            if (new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "infoFields").equals(reader
                                    .getName())) {
                                list1.add(com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField.Factory.parse(reader));

                            } else {
                                loopDone1 = true;
                            }
                        }
                    }
                    // call the converter utility to convert and set the array

                    object.setInfoFields((com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField[]) org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToArray(com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField.class, list1));

                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "name").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "name" + "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    reader.next();

                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "screenPopOptions").equals(reader
                                .getName())) {

                    // Process the array and step past its final element's end.
                    list3.add(com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption.Factory.parse(reader));

                    // loop until we find a start element that is not part of this array
                    boolean loopDone3 = false;
                    while (!loopDone3) {
                        // We should be at the end element, but make sure
                        while (!reader.isEndElement())
                            reader.next();
                        // Step out of this element
                        reader.next();
                        // Step to next element event.
                        while (!reader.isStartElement() && !reader.isEndElement())
                            reader.next();
                        if (reader.isEndElement()) {
                            // two continuous end elements means we are exiting the xml structure
                            loopDone3 = true;
                        } else {
                            if (new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "screenPopOptions").equals(reader
                                    .getName())) {
                                list3.add(com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption.Factory.parse(reader));

                            } else {
                                loopDone3 = true;
                            }
                        }
                    }
                    // call the converter utility to convert and set the array

                    object.setScreenPopOptions((com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption[]) org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToArray(com.salesforce.soap.partner.DescribeSoftphoneScreenPopOption.class, list3));

                } // End of if for expected property start element

                else {

                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "screenPopsOpenWithin").equals(reader
                                .getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "screenPopsOpenWithin"
                                + "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setScreenPopsOpenWithin(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    reader.next();

                } // End of if for expected property start element

                else {

                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "sections").equals(reader.getName())) {

                    // Process the array and step past its final element's end.
                    list5.add(com.salesforce.soap.partner.DescribeSoftphoneLayoutSection.Factory.parse(reader));

                    // loop until we find a start element that is not part of this array
                    boolean loopDone5 = false;
                    while (!loopDone5) {
                        // We should be at the end element, but make sure
                        while (!reader.isEndElement())
                            reader.next();
                        // Step out of this element
                        reader.next();
                        // Step to next element event.
                        while (!reader.isStartElement() && !reader.isEndElement())
                            reader.next();
                        if (reader.isEndElement()) {
                            // two continuous end elements means we are exiting the xml structure
                            loopDone5 = true;
                        } else {
                            if (new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "sections").equals(reader.getName())) {
                                list5.add(com.salesforce.soap.partner.DescribeSoftphoneLayoutSection.Factory.parse(reader));

                            } else {
                                loopDone5 = true;
                            }
                        }
                    }
                    // call the converter utility to convert and set the array

                    object.setSections((com.salesforce.soap.partner.DescribeSoftphoneLayoutSection[]) org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToArray(com.salesforce.soap.partner.DescribeSoftphoneLayoutSection.class, list5));

                } // End of if for expected property start element

                else {

                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement())
                    // A start element we are not expecting indicates a trailing invalid property
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

    }// end of factory class

}

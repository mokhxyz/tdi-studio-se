/**
 * DescribeSoftphoneLayoutSection.java
 * 
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2 Built on : Apr 17, 2012 (05:34:40 IST)
 */

package com.salesforce.soap.partner;

/**
 * DescribeSoftphoneLayoutSection bean class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class DescribeSoftphoneLayoutSection implements org.apache.axis2.databinding.ADBBean {

    /*
     * This type was generated from the piece of schema that had name = DescribeSoftphoneLayoutSection Namespace URI =
     * urn:partner.soap.sforce.com Namespace Prefix = ns1
     */

    /**
     * field for EntityApiName
     */

    protected java.lang.String localEntityApiName;

    /**
     * Auto generated getter method
     * 
     * @return java.lang.String
     */
    public java.lang.String getEntityApiName() {
        return localEntityApiName;
    }

    /**
     * Auto generated setter method
     * 
     * @param param EntityApiName
     */
    public void setEntityApiName(java.lang.String param) {

        this.localEntityApiName = param;

    }

    /**
     * field for Items This was an Array!
     */

    protected com.salesforce.soap.partner.DescribeSoftphoneLayoutItem[] localItems;

    /**
     * Auto generated getter method
     * 
     * @return com.salesforce.soap.partner.DescribeSoftphoneLayoutItem[]
     */
    public com.salesforce.soap.partner.DescribeSoftphoneLayoutItem[] getItems() {
        return localItems;
    }

    /**
     * validate the array for Items
     */
    protected void validateItems(com.salesforce.soap.partner.DescribeSoftphoneLayoutItem[] param) {

        if ((param != null) && (param.length < 1)) {
            throw new java.lang.RuntimeException();
        }

    }

    /**
     * Auto generated setter method
     * 
     * @param param Items
     */
    public void setItems(com.salesforce.soap.partner.DescribeSoftphoneLayoutItem[] param) {

        validateItems(param);

        this.localItems = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * 
     * @param param com.salesforce.soap.partner.DescribeSoftphoneLayoutItem
     */
    public void addItems(com.salesforce.soap.partner.DescribeSoftphoneLayoutItem param) {
        if (localItems == null) {
            localItems = new com.salesforce.soap.partner.DescribeSoftphoneLayoutItem[] {};
        }

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localItems);
        list.add(param);
        this.localItems = (com.salesforce.soap.partner.DescribeSoftphoneLayoutItem[]) list
                .toArray(new com.salesforce.soap.partner.DescribeSoftphoneLayoutItem[list.size()]);

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
                        + ":DescribeSoftphoneLayoutSection", xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "DescribeSoftphoneLayoutSection",
                        xmlWriter);
            }

        }

        namespace = "urn:partner.soap.sforce.com";
        writeStartElement(null, namespace, "entityApiName", xmlWriter);

        if (localEntityApiName == null) {
            // write the nil attribute

            throw new org.apache.axis2.databinding.ADBException("entityApiName cannot be null!!");

        } else {

            xmlWriter.writeCharacters(localEntityApiName);

        }

        xmlWriter.writeEndElement();

        if (localItems != null) {
            for (int i = 0; i < localItems.length; i++) {
                if (localItems[i] != null) {
                    localItems[i].serialize(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "items"), xmlWriter);
                } else {

                    throw new org.apache.axis2.databinding.ADBException("items cannot be null!!");

                }

            }
        } else {

            throw new org.apache.axis2.databinding.ADBException("items cannot be null!!");

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

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "entityApiName"));

        if (localEntityApiName != null) {
            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEntityApiName));
        } else {
            throw new org.apache.axis2.databinding.ADBException("entityApiName cannot be null!!");
        }

        if (localItems != null) {
            for (int i = 0; i < localItems.length; i++) {

                if (localItems[i] != null) {
                    elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "items"));
                    elementList.add(localItems[i]);
                } else {

                    throw new org.apache.axis2.databinding.ADBException("items cannot be null !!");

                }

            }
        } else {

            throw new org.apache.axis2.databinding.ADBException("items cannot be null!!");

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
        public static DescribeSoftphoneLayoutSection parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            DescribeSoftphoneLayoutSection object = new DescribeSoftphoneLayoutSection();

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

                        if (!"DescribeSoftphoneLayoutSection".equals(type)) {
                            // find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (DescribeSoftphoneLayoutSection) com.salesforce.soap.partner.sobject.ExtensionMapper
                                    .getTypeObject(nsUri, type, reader);
                        }

                    }

                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                java.util.ArrayList list2 = new java.util.ArrayList();

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "entityApiName").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "entityApiName"
                                + "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setEntityApiName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    reader.next();

                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "items").equals(reader.getName())) {

                    // Process the array and step past its final element's end.
                    list2.add(com.salesforce.soap.partner.DescribeSoftphoneLayoutItem.Factory.parse(reader));

                    // loop until we find a start element that is not part of this array
                    boolean loopDone2 = false;
                    while (!loopDone2) {
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
                            loopDone2 = true;
                        } else {
                            if (new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "items").equals(reader.getName())) {
                                list2.add(com.salesforce.soap.partner.DescribeSoftphoneLayoutItem.Factory.parse(reader));

                            } else {
                                loopDone2 = true;
                            }
                        }
                    }
                    // call the converter utility to convert and set the array

                    object.setItems((com.salesforce.soap.partner.DescribeSoftphoneLayoutItem[]) org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToArray(com.salesforce.soap.partner.DescribeSoftphoneLayoutItem.class, list2));

                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
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

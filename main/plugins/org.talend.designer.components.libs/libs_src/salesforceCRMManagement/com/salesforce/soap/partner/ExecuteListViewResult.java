/**
 * ExecuteListViewResult.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2 Built on : Apr 17, 2012 (05:34:40 IST)
 */

package com.salesforce.soap.partner;

/**
 * ExecuteListViewResult bean class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class ExecuteListViewResult implements org.apache.axis2.databinding.ADBBean {
    /*
     * This type was generated from the piece of schema that had name = ExecuteListViewResult Namespace URI = urn:partner.soap.sforce.com
     * Namespace Prefix = ns1
     */

    /**
     * field for Columns This was an Array!
     */

    protected com.salesforce.soap.partner.ListViewColumn[] localColumns;

    /**
     * Auto generated getter method
     * 
     * @return com.salesforce.soap.partner.ListViewColumn[]
     */
    public com.salesforce.soap.partner.ListViewColumn[] getColumns() {
        return localColumns;
    }

    /**
     * validate the array for Columns
     */
    protected void validateColumns(com.salesforce.soap.partner.ListViewColumn[] param) {

        if ((param != null) && (param.length < 1)) {
            throw new java.lang.RuntimeException();
        }

    }

    /**
     * Auto generated setter method
     * 
     * @param param Columns
     */
    public void setColumns(com.salesforce.soap.partner.ListViewColumn[] param) {

        validateColumns(param);

        this.localColumns = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * 
     * @param param com.salesforce.soap.partner.ListViewColumn
     */
    public void addColumns(com.salesforce.soap.partner.ListViewColumn param) {
        if (localColumns == null) {
            localColumns = new com.salesforce.soap.partner.ListViewColumn[] {};
        }

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localColumns);
        list.add(param);
        this.localColumns = (com.salesforce.soap.partner.ListViewColumn[]) list
                .toArray(new com.salesforce.soap.partner.ListViewColumn[list.size()]);

    }

    /**
     * field for DeveloperName
     */

    protected java.lang.String localDeveloperName;

    /**
     * Auto generated getter method
     * 
     * @return java.lang.String
     */
    public java.lang.String getDeveloperName() {
        return localDeveloperName;
    }

    /**
     * Auto generated setter method
     * 
     * @param param DeveloperName
     */
    public void setDeveloperName(java.lang.String param) {

        this.localDeveloperName = param;

    }

    /**
     * field for Done
     */

    protected boolean localDone;

    /**
     * Auto generated getter method
     * 
     * @return boolean
     */
    public boolean getDone() {
        return localDone;
    }

    /**
     * Auto generated setter method
     * 
     * @param param Done
     */
    public void setDone(boolean param) {

        this.localDone = param;

    }

    /**
     * field for Id
     */

    protected com.salesforce.soap.partner.ID localId;

    /**
     * Auto generated getter method
     * 
     * @return com.salesforce.soap.partner.ID
     */
    public com.salesforce.soap.partner.ID getId() {
        return localId;
    }

    /**
     * Auto generated setter method
     * 
     * @param param Id
     */
    public void setId(com.salesforce.soap.partner.ID param) {

        this.localId = param;

    }

    /**
     * field for Label
     */

    protected java.lang.String localLabel;

    /**
     * Auto generated getter method
     * 
     * @return java.lang.String
     */
    public java.lang.String getLabel() {
        return localLabel;
    }

    /**
     * Auto generated setter method
     * 
     * @param param Label
     */
    public void setLabel(java.lang.String param) {

        this.localLabel = param;

    }

    /**
     * field for Records This was an Array!
     */

    protected com.salesforce.soap.partner.ListViewRecord[] localRecords;

    /**
     * Auto generated getter method
     * 
     * @return com.salesforce.soap.partner.ListViewRecord[]
     */
    public com.salesforce.soap.partner.ListViewRecord[] getRecords() {
        return localRecords;
    }

    /**
     * validate the array for Records
     */
    protected void validateRecords(com.salesforce.soap.partner.ListViewRecord[] param) {

        if ((param != null) && (param.length < 1)) {
            throw new java.lang.RuntimeException();
        }

    }

    /**
     * Auto generated setter method
     * 
     * @param param Records
     */
    public void setRecords(com.salesforce.soap.partner.ListViewRecord[] param) {

        validateRecords(param);

        this.localRecords = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * 
     * @param param com.salesforce.soap.partner.ListViewRecord
     */
    public void addRecords(com.salesforce.soap.partner.ListViewRecord param) {
        if (localRecords == null) {
            localRecords = new com.salesforce.soap.partner.ListViewRecord[] {};
        }

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localRecords);
        list.add(param);
        this.localRecords = (com.salesforce.soap.partner.ListViewRecord[]) list
                .toArray(new com.salesforce.soap.partner.ListViewRecord[list.size()]);

    }

    /**
     * field for Size
     */

    protected int localSize;

    /**
     * Auto generated getter method
     * 
     * @return int
     */
    public int getSize() {
        return localSize;
    }

    /**
     * Auto generated setter method
     * 
     * @param param Size
     */
    public void setSize(int param) {

        this.localSize = param;

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
                        + ":ExecuteListViewResult", xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "ExecuteListViewResult", xmlWriter);
            }

        }

        if (localColumns != null) {
            for (int i = 0; i < localColumns.length; i++) {
                if (localColumns[i] != null) {
                    localColumns[i].serialize(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "columns"), xmlWriter);
                } else {

                    throw new org.apache.axis2.databinding.ADBException("columns cannot be null!!");

                }

            }
        } else {

            throw new org.apache.axis2.databinding.ADBException("columns cannot be null!!");

        }

        namespace = "urn:partner.soap.sforce.com";
        writeStartElement(null, namespace, "developerName", xmlWriter);

        if (localDeveloperName == null) {
            // write the nil attribute

            throw new org.apache.axis2.databinding.ADBException("developerName cannot be null!!");

        } else {

            xmlWriter.writeCharacters(localDeveloperName);

        }

        xmlWriter.writeEndElement();

        namespace = "urn:partner.soap.sforce.com";
        writeStartElement(null, namespace, "done", xmlWriter);

        if (false) {

            throw new org.apache.axis2.databinding.ADBException("done cannot be null!!");

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDone));
        }

        xmlWriter.writeEndElement();

        if (localId == null) {
            throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");
        }
        localId.serialize(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "id"), xmlWriter);

        namespace = "urn:partner.soap.sforce.com";
        writeStartElement(null, namespace, "label", xmlWriter);

        if (localLabel == null) {
            // write the nil attribute

            throw new org.apache.axis2.databinding.ADBException("label cannot be null!!");

        } else {

            xmlWriter.writeCharacters(localLabel);

        }

        xmlWriter.writeEndElement();

        if (localRecords != null) {
            for (int i = 0; i < localRecords.length; i++) {
                if (localRecords[i] != null) {
                    localRecords[i].serialize(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "records"), xmlWriter);
                } else {

                    throw new org.apache.axis2.databinding.ADBException("records cannot be null!!");

                }

            }
        } else {

            throw new org.apache.axis2.databinding.ADBException("records cannot be null!!");

        }

        namespace = "urn:partner.soap.sforce.com";
        writeStartElement(null, namespace, "size", xmlWriter);

        if (localSize == java.lang.Integer.MIN_VALUE) {

            throw new org.apache.axis2.databinding.ADBException("size cannot be null!!");

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSize));
        }

        xmlWriter.writeEndElement();

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

        if (localColumns != null) {
            for (int i = 0; i < localColumns.length; i++) {

                if (localColumns[i] != null) {
                    elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "columns"));
                    elementList.add(localColumns[i]);
                } else {

                    throw new org.apache.axis2.databinding.ADBException("columns cannot be null !!");

                }

            }
        } else {

            throw new org.apache.axis2.databinding.ADBException("columns cannot be null!!");

        }

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "developerName"));

        if (localDeveloperName != null) {
            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDeveloperName));
        } else {
            throw new org.apache.axis2.databinding.ADBException("developerName cannot be null!!");
        }

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "done"));

        elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDone));

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "id"));

        if (localId == null) {
            throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");
        }
        elementList.add(localId);

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "label"));

        if (localLabel != null) {
            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLabel));
        } else {
            throw new org.apache.axis2.databinding.ADBException("label cannot be null!!");
        }

        if (localRecords != null) {
            for (int i = 0; i < localRecords.length; i++) {

                if (localRecords[i] != null) {
                    elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "records"));
                    elementList.add(localRecords[i]);
                } else {

                    throw new org.apache.axis2.databinding.ADBException("records cannot be null !!");

                }

            }
        } else {

            throw new org.apache.axis2.databinding.ADBException("records cannot be null!!");

        }

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "size"));

        elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSize));

        return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
                attribList.toArray());

    }

    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {

        /**
         * static method to create the object Precondition: If this object is an element, the current or next start element starts this
         * object and any intervening reader events are ignorable If this object is not an element, it is a complex type and the reader is
         * at the event just after the outer start element Postcondition: If this object is an element, the reader is positioned at its end
         * element If this object is a complex type, the reader is positioned at the end element of its outer element
         */
        public static ExecuteListViewResult parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            ExecuteListViewResult object = new ExecuteListViewResult();

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

                        if (!"ExecuteListViewResult".equals(type)) {
                            // find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (ExecuteListViewResult) com.salesforce.soap.partner.sobject.ExtensionMapper.getTypeObject(
                                    nsUri, type, reader);
                        }

                    }

                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                java.util.ArrayList list1 = new java.util.ArrayList();

                java.util.ArrayList list6 = new java.util.ArrayList();

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "columns").equals(reader.getName())) {

                    // Process the array and step past its final element's end.
                    list1.add(com.salesforce.soap.partner.ListViewColumn.Factory.parse(reader));

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
                            if (new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "columns").equals(reader.getName())) {
                                list1.add(com.salesforce.soap.partner.ListViewColumn.Factory.parse(reader));

                            } else {
                                loopDone1 = true;
                            }
                        }
                    }
                    // call the converter utility to convert and set the array

                    object.setColumns((com.salesforce.soap.partner.ListViewColumn[]) org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToArray(com.salesforce.soap.partner.ListViewColumn.class, list1));

                }  // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "developerName").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "developerName"
                                + "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setDeveloperName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    reader.next();

                }  // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "done").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "done" + "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setDone(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));

                    reader.next();

                }  // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "id").equals(reader.getName())) {

                    object.setId(com.salesforce.soap.partner.ID.Factory.parse(reader));

                    reader.next();

                }  // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "label").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "label" + "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setLabel(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    reader.next();

                }  // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "records").equals(reader.getName())) {

                    // Process the array and step past its final element's end.
                    list6.add(com.salesforce.soap.partner.ListViewRecord.Factory.parse(reader));

                    // loop until we find a start element that is not part of this array
                    boolean loopDone6 = false;
                    while (!loopDone6) {
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
                            loopDone6 = true;
                        } else {
                            if (new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "records").equals(reader.getName())) {
                                list6.add(com.salesforce.soap.partner.ListViewRecord.Factory.parse(reader));

                            } else {
                                loopDone6 = true;
                            }
                        }
                    }
                    // call the converter utility to convert and set the array

                    object.setRecords((com.salesforce.soap.partner.ListViewRecord[]) org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToArray(com.salesforce.soap.partner.ListViewRecord.class, list6));

                }  // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "size").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "size" + "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setSize(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                }  // End of if for expected property start element

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

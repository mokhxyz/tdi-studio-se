/**
 * RelatedList.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2 Built on : Apr 17, 2012 (05:34:40 IST)
 */

package com.salesforce.soap.partner;

/**
 * RelatedList bean class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class RelatedList implements org.apache.axis2.databinding.ADBBean {
    /*
     * This type was generated from the piece of schema that had name = RelatedList Namespace URI = urn:partner.soap.sforce.com Namespace
     * Prefix = ns1
     */

    /**
     * field for AccessLevelRequiredForCreate
     */

    protected com.salesforce.soap.partner.ShareAccessLevel localAccessLevelRequiredForCreate;

    /**
     * Auto generated getter method
     * 
     * @return com.salesforce.soap.partner.ShareAccessLevel
     */
    public com.salesforce.soap.partner.ShareAccessLevel getAccessLevelRequiredForCreate() {
        return localAccessLevelRequiredForCreate;
    }

    /**
     * Auto generated setter method
     * 
     * @param param AccessLevelRequiredForCreate
     */
    public void setAccessLevelRequiredForCreate(com.salesforce.soap.partner.ShareAccessLevel param) {

        this.localAccessLevelRequiredForCreate = param;

    }

    /**
     * field for Buttons This was an Array!
     */

    protected com.salesforce.soap.partner.DescribeLayoutButton[] localButtons;

    /*
     * This tracker boolean wil be used to detect whether the user called the set method for this attribute. It will be used to determine
     * whether to include this field in the serialized XML
     */
    protected boolean localButtonsTracker = false;

    public boolean isButtonsSpecified() {
        return localButtonsTracker;
    }

    /**
     * Auto generated getter method
     * 
     * @return com.salesforce.soap.partner.DescribeLayoutButton[]
     */
    public com.salesforce.soap.partner.DescribeLayoutButton[] getButtons() {
        return localButtons;
    }

    /**
     * validate the array for Buttons
     */
    protected void validateButtons(com.salesforce.soap.partner.DescribeLayoutButton[] param) {

    }

    /**
     * Auto generated setter method
     * 
     * @param param Buttons
     */
    public void setButtons(com.salesforce.soap.partner.DescribeLayoutButton[] param) {

        validateButtons(param);

        localButtonsTracker = true;

        this.localButtons = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * 
     * @param param com.salesforce.soap.partner.DescribeLayoutButton
     */
    public void addButtons(com.salesforce.soap.partner.DescribeLayoutButton param) {
        if (localButtons == null) {
            localButtons = new com.salesforce.soap.partner.DescribeLayoutButton[] {};
        }

        // update the setting tracker
        localButtonsTracker = true;

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localButtons);
        list.add(param);
        this.localButtons = (com.salesforce.soap.partner.DescribeLayoutButton[]) list
                .toArray(new com.salesforce.soap.partner.DescribeLayoutButton[list.size()]);

    }

    /**
     * field for Columns This was an Array!
     */

    protected com.salesforce.soap.partner.RelatedListColumn[] localColumns;

    /**
     * Auto generated getter method
     * 
     * @return com.salesforce.soap.partner.RelatedListColumn[]
     */
    public com.salesforce.soap.partner.RelatedListColumn[] getColumns() {
        return localColumns;
    }

    /**
     * validate the array for Columns
     */
    protected void validateColumns(com.salesforce.soap.partner.RelatedListColumn[] param) {

        if ((param != null) && (param.length < 1)) {
            throw new java.lang.RuntimeException();
        }

    }

    /**
     * Auto generated setter method
     * 
     * @param param Columns
     */
    public void setColumns(com.salesforce.soap.partner.RelatedListColumn[] param) {

        validateColumns(param);

        this.localColumns = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * 
     * @param param com.salesforce.soap.partner.RelatedListColumn
     */
    public void addColumns(com.salesforce.soap.partner.RelatedListColumn param) {
        if (localColumns == null) {
            localColumns = new com.salesforce.soap.partner.RelatedListColumn[] {};
        }

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localColumns);
        list.add(param);
        this.localColumns = (com.salesforce.soap.partner.RelatedListColumn[]) list
                .toArray(new com.salesforce.soap.partner.RelatedListColumn[list.size()]);

    }

    /**
     * field for Custom
     */

    protected boolean localCustom;

    /**
     * Auto generated getter method
     * 
     * @return boolean
     */
    public boolean getCustom() {
        return localCustom;
    }

    /**
     * Auto generated setter method
     * 
     * @param param Custom
     */
    public void setCustom(boolean param) {

        this.localCustom = param;

    }

    /**
     * field for Field
     */

    protected java.lang.String localField;

    /**
     * Auto generated getter method
     * 
     * @return java.lang.String
     */
    public java.lang.String getField() {
        return localField;
    }

    /**
     * Auto generated setter method
     * 
     * @param param Field
     */
    public void setField(java.lang.String param) {

        this.localField = param;

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
     * field for LimitRows
     */

    protected int localLimitRows;

    /**
     * Auto generated getter method
     * 
     * @return int
     */
    public int getLimitRows() {
        return localLimitRows;
    }

    /**
     * Auto generated setter method
     * 
     * @param param LimitRows
     */
    public void setLimitRows(int param) {

        this.localLimitRows = param;

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
     * field for Sobject
     */

    protected java.lang.String localSobject;

    /**
     * Auto generated getter method
     * 
     * @return java.lang.String
     */
    public java.lang.String getSobject() {
        return localSobject;
    }

    /**
     * Auto generated setter method
     * 
     * @param param Sobject
     */
    public void setSobject(java.lang.String param) {

        this.localSobject = param;

    }

    /**
     * field for Sort This was an Array!
     */

    protected com.salesforce.soap.partner.RelatedListSort[] localSort;

    /*
     * This tracker boolean wil be used to detect whether the user called the set method for this attribute. It will be used to determine
     * whether to include this field in the serialized XML
     */
    protected boolean localSortTracker = false;

    public boolean isSortSpecified() {
        return localSortTracker;
    }

    /**
     * Auto generated getter method
     * 
     * @return com.salesforce.soap.partner.RelatedListSort[]
     */
    public com.salesforce.soap.partner.RelatedListSort[] getSort() {
        return localSort;
    }

    /**
     * validate the array for Sort
     */
    protected void validateSort(com.salesforce.soap.partner.RelatedListSort[] param) {

    }

    /**
     * Auto generated setter method
     * 
     * @param param Sort
     */
    public void setSort(com.salesforce.soap.partner.RelatedListSort[] param) {

        validateSort(param);

        localSortTracker = param != null;

        this.localSort = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * 
     * @param param com.salesforce.soap.partner.RelatedListSort
     */
    public void addSort(com.salesforce.soap.partner.RelatedListSort param) {
        if (localSort == null) {
            localSort = new com.salesforce.soap.partner.RelatedListSort[] {};
        }

        // update the setting tracker
        localSortTracker = true;

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localSort);
        list.add(param);
        this.localSort = (com.salesforce.soap.partner.RelatedListSort[]) list
                .toArray(new com.salesforce.soap.partner.RelatedListSort[list.size()]);

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
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":RelatedList",
                        xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "RelatedList", xmlWriter);
            }

        }

        if (localAccessLevelRequiredForCreate == null) {

            writeStartElement(null, "urn:partner.soap.sforce.com", "accessLevelRequiredForCreate", xmlWriter);

            // write the nil attribute
            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
            xmlWriter.writeEndElement();
        } else {
            localAccessLevelRequiredForCreate.serialize(new javax.xml.namespace.QName("urn:partner.soap.sforce.com",
                    "accessLevelRequiredForCreate"), xmlWriter);
        }
        if (localButtonsTracker) {
            if (localButtons != null) {
                for (int i = 0; i < localButtons.length; i++) {
                    if (localButtons[i] != null) {
                        localButtons[i].serialize(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "buttons"),
                                xmlWriter);
                    } else {

                        writeStartElement(null, "urn:partner.soap.sforce.com", "buttons", xmlWriter);

                        // write the nil attribute
                        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                        xmlWriter.writeEndElement();

                    }

                }
            } else {

                writeStartElement(null, "urn:partner.soap.sforce.com", "buttons", xmlWriter);

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                xmlWriter.writeEndElement();

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
        writeStartElement(null, namespace, "custom", xmlWriter);

        if (false) {

            throw new org.apache.axis2.databinding.ADBException("custom cannot be null!!");

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCustom));
        }

        xmlWriter.writeEndElement();

        namespace = "urn:partner.soap.sforce.com";
        writeStartElement(null, namespace, "field", xmlWriter);

        if (localField == null) {
            // write the nil attribute

            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

        } else {

            xmlWriter.writeCharacters(localField);

        }

        xmlWriter.writeEndElement();

        namespace = "urn:partner.soap.sforce.com";
        writeStartElement(null, namespace, "label", xmlWriter);

        if (localLabel == null) {
            // write the nil attribute

            throw new org.apache.axis2.databinding.ADBException("label cannot be null!!");

        } else {

            xmlWriter.writeCharacters(localLabel);

        }

        xmlWriter.writeEndElement();

        namespace = "urn:partner.soap.sforce.com";
        writeStartElement(null, namespace, "limitRows", xmlWriter);

        if (localLimitRows == java.lang.Integer.MIN_VALUE) {

            throw new org.apache.axis2.databinding.ADBException("limitRows cannot be null!!");

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLimitRows));
        }

        xmlWriter.writeEndElement();

        namespace = "urn:partner.soap.sforce.com";
        writeStartElement(null, namespace, "name", xmlWriter);

        if (localName == null) {
            // write the nil attribute

            throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");

        } else {

            xmlWriter.writeCharacters(localName);

        }

        xmlWriter.writeEndElement();

        namespace = "urn:partner.soap.sforce.com";
        writeStartElement(null, namespace, "sobject", xmlWriter);

        if (localSobject == null) {
            // write the nil attribute

            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

        } else {

            xmlWriter.writeCharacters(localSobject);

        }

        xmlWriter.writeEndElement();
        if (localSortTracker) {
            if (localSort != null) {
                for (int i = 0; i < localSort.length; i++) {
                    if (localSort[i] != null) {
                        localSort[i].serialize(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "sort"), xmlWriter);
                    } else {

                        // we don't have to do any thing since minOccures is zero

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException("sort cannot be null!!");

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

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "accessLevelRequiredForCreate"));

        elementList.add(localAccessLevelRequiredForCreate == null ? null : localAccessLevelRequiredForCreate);
        if (localButtonsTracker) {
            if (localButtons != null) {
                for (int i = 0; i < localButtons.length; i++) {

                    if (localButtons[i] != null) {
                        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "buttons"));
                        elementList.add(localButtons[i]);
                    } else {

                        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "buttons"));
                        elementList.add(null);

                    }

                }
            } else {

                elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "buttons"));
                elementList.add(localButtons);

            }

        }
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

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "custom"));

        elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCustom));

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "field"));

        elementList.add(localField == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField));

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "label"));

        if (localLabel != null) {
            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLabel));
        } else {
            throw new org.apache.axis2.databinding.ADBException("label cannot be null!!");
        }

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "limitRows"));

        elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLimitRows));

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "name"));

        if (localName != null) {
            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
        } else {
            throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");
        }

        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "sobject"));

        elementList.add(localSobject == null ? null : org.apache.axis2.databinding.utils.ConverterUtil
                .convertToString(localSobject));
        if (localSortTracker) {
            if (localSort != null) {
                for (int i = 0; i < localSort.length; i++) {

                    if (localSort[i] != null) {
                        elementList.add(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "sort"));
                        elementList.add(localSort[i]);
                    } else {

                        // nothing to do

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException("sort cannot be null!!");

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
         * static method to create the object Precondition: If this object is an element, the current or next start element starts this
         * object and any intervening reader events are ignorable If this object is not an element, it is a complex type and the reader is
         * at the event just after the outer start element Postcondition: If this object is an element, the reader is positioned at its end
         * element If this object is a complex type, the reader is positioned at the end element of its outer element
         */
        public static RelatedList parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            RelatedList object = new RelatedList();

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

                        if (!"RelatedList".equals(type)) {
                            // find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (RelatedList) com.salesforce.soap.partner.sobject.ExtensionMapper.getTypeObject(nsUri, type,
                                    reader);
                        }

                    }

                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                java.util.ArrayList list2 = new java.util.ArrayList();

                java.util.ArrayList list3 = new java.util.ArrayList();

                java.util.ArrayList list10 = new java.util.ArrayList();

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "accessLevelRequiredForCreate")
                                .equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        object.setAccessLevelRequiredForCreate(null);
                        reader.next();

                        reader.next();

                    } else {

                        object.setAccessLevelRequiredForCreate(com.salesforce.soap.partner.ShareAccessLevel.Factory.parse(reader));

                        reader.next();
                    }
                }  // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "buttons").equals(reader.getName())) {

                    // Process the array and step past its final element's end.

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        list2.add(null);
                        reader.next();
                    } else {
                        list2.add(com.salesforce.soap.partner.DescribeLayoutButton.Factory.parse(reader));
                    }
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
                            if (new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "buttons").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    list2.add(null);
                                    reader.next();
                                } else {
                                    list2.add(com.salesforce.soap.partner.DescribeLayoutButton.Factory.parse(reader));
                                }
                            } else {
                                loopDone2 = true;
                            }
                        }
                    }
                    // call the converter utility to convert and set the array

                    object.setButtons((com.salesforce.soap.partner.DescribeLayoutButton[]) org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToArray(com.salesforce.soap.partner.DescribeLayoutButton.class, list2));

                }  // End of if for expected property start element

                else {

                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "columns").equals(reader.getName())) {

                    // Process the array and step past its final element's end.
                    list3.add(com.salesforce.soap.partner.RelatedListColumn.Factory.parse(reader));

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
                            if (new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "columns").equals(reader.getName())) {
                                list3.add(com.salesforce.soap.partner.RelatedListColumn.Factory.parse(reader));

                            } else {
                                loopDone3 = true;
                            }
                        }
                    }
                    // call the converter utility to convert and set the array

                    object.setColumns((com.salesforce.soap.partner.RelatedListColumn[]) org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToArray(com.salesforce.soap.partner.RelatedListColumn.class, list3));

                }  // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "custom").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "custom" + "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setCustom(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));

                    reader.next();

                }  // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "field").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                        java.lang.String content = reader.getElementText();

                        object.setField(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {

                        reader.getElementText(); // throw away text nodes if any.
                    }

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
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "limitRows").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "limitRows" + "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setLimitRows(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                }  // End of if for expected property start element

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

                }  // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "sobject").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                        java.lang.String content = reader.getElementText();

                        object.setSobject(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {

                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "sort").equals(reader.getName())) {

                    // Process the array and step past its final element's end.
                    list10.add(com.salesforce.soap.partner.RelatedListSort.Factory.parse(reader));

                    // loop until we find a start element that is not part of this array
                    boolean loopDone10 = false;
                    while (!loopDone10) {
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
                            loopDone10 = true;
                        } else {
                            if (new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "sort").equals(reader.getName())) {
                                list10.add(com.salesforce.soap.partner.RelatedListSort.Factory.parse(reader));

                            } else {
                                loopDone10 = true;
                            }
                        }
                    }
                    // call the converter utility to convert and set the array

                    object.setSort((com.salesforce.soap.partner.RelatedListSort[]) org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToArray(com.salesforce.soap.partner.RelatedListSort.class, list10));

                }  // End of if for expected property start element

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

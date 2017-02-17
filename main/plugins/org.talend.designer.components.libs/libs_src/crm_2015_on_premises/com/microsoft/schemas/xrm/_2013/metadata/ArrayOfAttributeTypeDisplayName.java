
package com.microsoft.schemas.xrm._2013.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAttributeTypeDisplayName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAttributeTypeDisplayName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AttributeTypeDisplayName" type="{http://schemas.microsoft.com/xrm/2013/Metadata}AttributeTypeDisplayName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAttributeTypeDisplayName", propOrder = {
    "attributeTypeDisplayNames"
})
public class ArrayOfAttributeTypeDisplayName
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "AttributeTypeDisplayName", nillable = true)
    protected List<AttributeTypeDisplayName> attributeTypeDisplayNames;

    /**
     * Gets the value of the attributeTypeDisplayNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeTypeDisplayNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeTypeDisplayNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributeTypeDisplayName }
     * 
     * 
     */
    public List<AttributeTypeDisplayName> getAttributeTypeDisplayNames() {
        if (attributeTypeDisplayNames == null) {
            attributeTypeDisplayNames = new ArrayList<AttributeTypeDisplayName>();
        }
        return this.attributeTypeDisplayNames;
    }

}

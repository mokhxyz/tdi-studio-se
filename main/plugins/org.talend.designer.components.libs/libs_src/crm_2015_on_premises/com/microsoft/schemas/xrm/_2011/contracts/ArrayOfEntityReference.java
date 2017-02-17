
package com.microsoft.schemas.xrm._2011.contracts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfEntityReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfEntityReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EntityReference" type="{http://schemas.microsoft.com/xrm/2011/Contracts}EntityReference" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfEntityReference", propOrder = {
    "entityReferences"
})
public class ArrayOfEntityReference
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "EntityReference", nillable = true)
    protected List<EntityReference> entityReferences;

    /**
     * Gets the value of the entityReferences property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entityReferences property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntityReferences().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityReference }
     * 
     * 
     */
    public List<EntityReference> getEntityReferences() {
        if (entityReferences == null) {
            entityReferences = new ArrayList<EntityReference>();
        }
        return this.entityReferences;
    }

}

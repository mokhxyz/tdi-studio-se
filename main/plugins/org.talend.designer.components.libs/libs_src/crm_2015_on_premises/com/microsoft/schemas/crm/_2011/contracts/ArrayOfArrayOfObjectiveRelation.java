
package com.microsoft.schemas.crm._2011.contracts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfArrayOfObjectiveRelation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfArrayOfObjectiveRelation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ArrayOfObjectiveRelation" type="{http://schemas.microsoft.com/crm/2011/Contracts}ArrayOfObjectiveRelation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfArrayOfObjectiveRelation", propOrder = {
    "arrayOfObjectiveRelations"
})
public class ArrayOfArrayOfObjectiveRelation
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ArrayOfObjectiveRelation", nillable = true)
    protected List<ArrayOfObjectiveRelation> arrayOfObjectiveRelations;

    /**
     * Gets the value of the arrayOfObjectiveRelations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrayOfObjectiveRelations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrayOfObjectiveRelations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfObjectiveRelation }
     * 
     * 
     */
    public List<ArrayOfObjectiveRelation> getArrayOfObjectiveRelations() {
        if (arrayOfObjectiveRelations == null) {
            arrayOfObjectiveRelations = new ArrayList<ArrayOfObjectiveRelation>();
        }
        return this.arrayOfObjectiveRelations;
    }

}


package com.microsoft.schemas.xrm._2011.metadata.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for DeletedMetadataFilters simple type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;simpleType name="DeletedMetadataFilters">
 *   &lt;list>
 *     &lt;simpleType>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *         &lt;enumeration value="Entity"/>
 *         &lt;enumeration value="Attribute"/>
 *         &lt;enumeration value="Relationship"/>
 *         &lt;enumeration value="Label"/>
 *         &lt;enumeration value="OptionSet"/>
 *       &lt;/restriction>
 *     &lt;/simpleType>
 *   &lt;/list>
 * &lt;/simpleType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeletedMetadataFilters", propOrder = {
    "values"
})
public class DeletedMetadataFilters
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlValue
    protected List<String> values;

    /**
     * Gets the value of the values property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the values property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getValues() {
        if (values == null) {
            values = new ArrayList<String>();
        }
        return this.values;
    }

}

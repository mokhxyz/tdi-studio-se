
package org.talend.mdm.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for executeTransformerV2AsJobResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="executeTransformerV2AsJobResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.talend.com/mdm}WSBackgroundJobPK" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeTransformerV2AsJobResponse", propOrder = {
    "_return"
})
public class ExecuteTransformerV2AsJobResponse {

    @XmlElement(name = "return")
    protected WSBackgroundJobPK _return;

    /**
     * Default no-arg constructor
     * 
     */
    public ExecuteTransformerV2AsJobResponse() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public ExecuteTransformerV2AsJobResponse(final WSBackgroundJobPK _return) {
        this._return = _return;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WSBackgroundJobPK }
     *     
     */
    public WSBackgroundJobPK getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSBackgroundJobPK }
     *     
     */
    public void setReturn(WSBackgroundJobPK value) {
        this._return = value;
    }

}

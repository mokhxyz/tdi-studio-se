
package org.talend.mdm.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WSGetMenu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WSGetMenu"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="wsMenuPK" type="{http://www.talend.com/mdm}WSMenuPK" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSGetMenu", propOrder = {
    "wsMenuPK"
})
public class WSGetMenu {

    protected WSMenuPK wsMenuPK;

    /**
     * Default no-arg constructor
     * 
     */
    public WSGetMenu() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public WSGetMenu(final WSMenuPK wsMenuPK) {
        this.wsMenuPK = wsMenuPK;
    }

    /**
     * Gets the value of the wsMenuPK property.
     * 
     * @return
     *     possible object is
     *     {@link WSMenuPK }
     *     
     */
    public WSMenuPK getWsMenuPK() {
        return wsMenuPK;
    }

    /**
     * Sets the value of the wsMenuPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSMenuPK }
     *     
     */
    public void setWsMenuPK(WSMenuPK value) {
        this.wsMenuPK = value;
    }

}

/*
 * XML Type:  CrmFloatProperty
 * Namespace: http://schemas.microsoft.com/crm/2006/WebServices
 * Java type: com.microsoft.schemas.crm._2006.webservices.CrmFloatProperty
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.crm._2006.webservices.impl;
/**
 * An XML CrmFloatProperty(@http://schemas.microsoft.com/crm/2006/WebServices).
 *
 * This is a complex type.
 */
public class CrmFloatPropertyImpl extends com.microsoft.schemas.crm._2006.webservices.impl.PropertyImpl implements com.microsoft.schemas.crm._2006.webservices.CrmFloatProperty
{
    
    public CrmFloatPropertyImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VALUE$0 = 
        new javax.xml.namespace.QName("http://schemas.microsoft.com/crm/2006/WebServices", "Value");
    
    
    /**
     * Gets the "Value" element
     */
    public com.microsoft.schemas.crm._2006.webservices.CrmFloat getValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2006.webservices.CrmFloat target = null;
            target = (com.microsoft.schemas.crm._2006.webservices.CrmFloat)get_store().find_element_user(VALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Value" element
     */
    public boolean isSetValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(VALUE$0) != 0;
        }
    }
    
    /**
     * Sets the "Value" element
     */
    public void setValue(com.microsoft.schemas.crm._2006.webservices.CrmFloat value)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2006.webservices.CrmFloat target = null;
            target = (com.microsoft.schemas.crm._2006.webservices.CrmFloat)get_store().find_element_user(VALUE$0, 0);
            if (target == null)
            {
                target = (com.microsoft.schemas.crm._2006.webservices.CrmFloat)get_store().add_element_user(VALUE$0);
            }
            target.set(value);
        }
    }
    
    /**
     * Appends and returns a new empty "Value" element
     */
    public com.microsoft.schemas.crm._2006.webservices.CrmFloat addNewValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2006.webservices.CrmFloat target = null;
            target = (com.microsoft.schemas.crm._2006.webservices.CrmFloat)get_store().add_element_user(VALUE$0);
            return target;
        }
    }
    
    /**
     * Unsets the "Value" element
     */
    public void unsetValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(VALUE$0, 0);
        }
    }
}

/*
 * XML Type:  UtcTimeFromLocalTimeRequest
 * Namespace: http://schemas.microsoft.com/crm/2007/WebServices
 * Java type: com.microsoft.schemas.crm._2007.webservices.UtcTimeFromLocalTimeRequest
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.crm._2007.webservices.impl;
/**
 * An XML UtcTimeFromLocalTimeRequest(@http://schemas.microsoft.com/crm/2007/WebServices).
 *
 * This is a complex type.
 */
public class UtcTimeFromLocalTimeRequestImpl extends com.microsoft.schemas.crm._2007.webservices.impl.RequestImpl implements com.microsoft.schemas.crm._2007.webservices.UtcTimeFromLocalTimeRequest
{
    
    public UtcTimeFromLocalTimeRequestImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TIMEZONECODE$0 = 
        new javax.xml.namespace.QName("http://schemas.microsoft.com/crm/2007/WebServices", "TimeZoneCode");
    private static final javax.xml.namespace.QName LOCALTIME$2 = 
        new javax.xml.namespace.QName("http://schemas.microsoft.com/crm/2007/WebServices", "LocalTime");
    
    
    /**
     * Gets the "TimeZoneCode" element
     */
    public int getTimeZoneCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIMEZONECODE$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "TimeZoneCode" element
     */
    public org.apache.xmlbeans.XmlInt xgetTimeZoneCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(TIMEZONECODE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "TimeZoneCode" element
     */
    public void setTimeZoneCode(int timeZoneCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIMEZONECODE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TIMEZONECODE$0);
            }
            target.setIntValue(timeZoneCode);
        }
    }
    
    /**
     * Sets (as xml) the "TimeZoneCode" element
     */
    public void xsetTimeZoneCode(org.apache.xmlbeans.XmlInt timeZoneCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(TIMEZONECODE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInt)get_store().add_element_user(TIMEZONECODE$0);
            }
            target.set(timeZoneCode);
        }
    }
    
    /**
     * Gets the "LocalTime" element
     */
    public com.microsoft.schemas.crm._2006.webservices.CrmDateTime getLocalTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2006.webservices.CrmDateTime target = null;
            target = (com.microsoft.schemas.crm._2006.webservices.CrmDateTime)get_store().find_element_user(LOCALTIME$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "LocalTime" element
     */
    public void setLocalTime(com.microsoft.schemas.crm._2006.webservices.CrmDateTime localTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2006.webservices.CrmDateTime target = null;
            target = (com.microsoft.schemas.crm._2006.webservices.CrmDateTime)get_store().find_element_user(LOCALTIME$2, 0);
            if (target == null)
            {
                target = (com.microsoft.schemas.crm._2006.webservices.CrmDateTime)get_store().add_element_user(LOCALTIME$2);
            }
            target.set(localTime);
        }
    }
    
    /**
     * Appends and returns a new empty "LocalTime" element
     */
    public com.microsoft.schemas.crm._2006.webservices.CrmDateTime addNewLocalTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2006.webservices.CrmDateTime target = null;
            target = (com.microsoft.schemas.crm._2006.webservices.CrmDateTime)get_store().add_element_user(LOCALTIME$2);
            return target;
        }
    }
}

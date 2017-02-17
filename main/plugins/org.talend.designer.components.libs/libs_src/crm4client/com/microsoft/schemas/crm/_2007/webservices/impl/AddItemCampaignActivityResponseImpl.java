/*
 * XML Type:  AddItemCampaignActivityResponse
 * Namespace: http://schemas.microsoft.com/crm/2007/WebServices
 * Java type: com.microsoft.schemas.crm._2007.webservices.AddItemCampaignActivityResponse
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.crm._2007.webservices.impl;
/**
 * An XML AddItemCampaignActivityResponse(@http://schemas.microsoft.com/crm/2007/WebServices).
 *
 * This is a complex type.
 */
public class AddItemCampaignActivityResponseImpl extends com.microsoft.schemas.crm._2007.webservices.impl.ResponseImpl implements com.microsoft.schemas.crm._2007.webservices.AddItemCampaignActivityResponse
{
    
    public AddItemCampaignActivityResponseImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CAMPAIGNACTIVITYITEMID$0 = 
        new javax.xml.namespace.QName("http://schemas.microsoft.com/crm/2007/WebServices", "CampaignActivityItemId");
    
    
    /**
     * Gets the "CampaignActivityItemId" element
     */
    public java.lang.String getCampaignActivityItemId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CAMPAIGNACTIVITYITEMID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CampaignActivityItemId" element
     */
    public com.microsoft.wsdl.types.Guid xgetCampaignActivityItemId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.wsdl.types.Guid target = null;
            target = (com.microsoft.wsdl.types.Guid)get_store().find_element_user(CAMPAIGNACTIVITYITEMID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CampaignActivityItemId" element
     */
    public void setCampaignActivityItemId(java.lang.String campaignActivityItemId)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CAMPAIGNACTIVITYITEMID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CAMPAIGNACTIVITYITEMID$0);
            }
            target.setStringValue(campaignActivityItemId);
        }
    }
    
    /**
     * Sets (as xml) the "CampaignActivityItemId" element
     */
    public void xsetCampaignActivityItemId(com.microsoft.wsdl.types.Guid campaignActivityItemId)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.wsdl.types.Guid target = null;
            target = (com.microsoft.wsdl.types.Guid)get_store().find_element_user(CAMPAIGNACTIVITYITEMID$0, 0);
            if (target == null)
            {
                target = (com.microsoft.wsdl.types.Guid)get_store().add_element_user(CAMPAIGNACTIVITYITEMID$0);
            }
            target.set(campaignActivityItemId);
        }
    }
}

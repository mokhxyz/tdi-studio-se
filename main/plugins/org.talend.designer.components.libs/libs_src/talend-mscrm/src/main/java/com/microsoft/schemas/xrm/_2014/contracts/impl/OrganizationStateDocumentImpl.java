/*
 * An XML document type.
 * Localname: OrganizationState
 * Namespace: http://schemas.microsoft.com/xrm/2014/Contracts
 * Java type: com.microsoft.schemas.xrm._2014.contracts.OrganizationStateDocument
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.xrm._2014.contracts.impl;
/**
 * A document containing one OrganizationState(@http://schemas.microsoft.com/xrm/2014/Contracts) element.
 *
 * This is a complex type.
 */
public class OrganizationStateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.microsoft.schemas.xrm._2014.contracts.OrganizationStateDocument
{
    private static final long serialVersionUID = 1L;
    
    public OrganizationStateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ORGANIZATIONSTATE$0 = 
        new javax.xml.namespace.QName("http://schemas.microsoft.com/xrm/2014/Contracts", "OrganizationState");
    
    
    /**
     * Gets the "OrganizationState" element
     */
    public com.microsoft.schemas.xrm._2014.contracts.OrganizationState.Enum getOrganizationState()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORGANIZATIONSTATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return (com.microsoft.schemas.xrm._2014.contracts.OrganizationState.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "OrganizationState" element
     */
    public com.microsoft.schemas.xrm._2014.contracts.OrganizationState xgetOrganizationState()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2014.contracts.OrganizationState target = null;
            target = (com.microsoft.schemas.xrm._2014.contracts.OrganizationState)get_store().find_element_user(ORGANIZATIONSTATE$0, 0);
            return target;
        }
    }
    
    /**
     * Tests for nil "OrganizationState" element
     */
    public boolean isNilOrganizationState()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2014.contracts.OrganizationState target = null;
            target = (com.microsoft.schemas.xrm._2014.contracts.OrganizationState)get_store().find_element_user(ORGANIZATIONSTATE$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * Sets the "OrganizationState" element
     */
    public void setOrganizationState(com.microsoft.schemas.xrm._2014.contracts.OrganizationState.Enum organizationState)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORGANIZATIONSTATE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ORGANIZATIONSTATE$0);
            }
            target.setEnumValue(organizationState);
        }
    }
    
    /**
     * Sets (as xml) the "OrganizationState" element
     */
    public void xsetOrganizationState(com.microsoft.schemas.xrm._2014.contracts.OrganizationState organizationState)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2014.contracts.OrganizationState target = null;
            target = (com.microsoft.schemas.xrm._2014.contracts.OrganizationState)get_store().find_element_user(ORGANIZATIONSTATE$0, 0);
            if (target == null)
            {
                target = (com.microsoft.schemas.xrm._2014.contracts.OrganizationState)get_store().add_element_user(ORGANIZATIONSTATE$0);
            }
            target.set(organizationState);
        }
    }
    
    /**
     * Nils the "OrganizationState" element
     */
    public void setNilOrganizationState()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2014.contracts.OrganizationState target = null;
            target = (com.microsoft.schemas.xrm._2014.contracts.OrganizationState)get_store().find_element_user(ORGANIZATIONSTATE$0, 0);
            if (target == null)
            {
                target = (com.microsoft.schemas.xrm._2014.contracts.OrganizationState)get_store().add_element_user(ORGANIZATIONSTATE$0);
            }
            target.setNil();
        }
    }
}

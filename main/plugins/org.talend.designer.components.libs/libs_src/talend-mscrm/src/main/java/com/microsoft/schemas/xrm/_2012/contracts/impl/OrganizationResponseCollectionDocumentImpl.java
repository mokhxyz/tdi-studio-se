/*
 * An XML document type.
 * Localname: OrganizationResponseCollection
 * Namespace: http://schemas.microsoft.com/xrm/2012/Contracts
 * Java type: com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollectionDocument
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.xrm._2012.contracts.impl;
/**
 * A document containing one OrganizationResponseCollection(@http://schemas.microsoft.com/xrm/2012/Contracts) element.
 *
 * This is a complex type.
 */
public class OrganizationResponseCollectionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollectionDocument
{
    private static final long serialVersionUID = 1L;
    
    public OrganizationResponseCollectionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ORGANIZATIONRESPONSECOLLECTION$0 = 
        new javax.xml.namespace.QName("http://schemas.microsoft.com/xrm/2012/Contracts", "OrganizationResponseCollection");
    
    
    /**
     * Gets the "OrganizationResponseCollection" element
     */
    public com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollection getOrganizationResponseCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollection target = null;
            target = (com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollection)get_store().find_element_user(ORGANIZATIONRESPONSECOLLECTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Tests for nil "OrganizationResponseCollection" element
     */
    public boolean isNilOrganizationResponseCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollection target = null;
            target = (com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollection)get_store().find_element_user(ORGANIZATIONRESPONSECOLLECTION$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * Sets the "OrganizationResponseCollection" element
     */
    public void setOrganizationResponseCollection(com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollection organizationResponseCollection)
    {
        generatedSetterHelperImpl(organizationResponseCollection, ORGANIZATIONRESPONSECOLLECTION$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "OrganizationResponseCollection" element
     */
    public com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollection addNewOrganizationResponseCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollection target = null;
            target = (com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollection)get_store().add_element_user(ORGANIZATIONRESPONSECOLLECTION$0);
            return target;
        }
    }
    
    /**
     * Nils the "OrganizationResponseCollection" element
     */
    public void setNilOrganizationResponseCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollection target = null;
            target = (com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollection)get_store().find_element_user(ORGANIZATIONRESPONSECOLLECTION$0, 0);
            if (target == null)
            {
                target = (com.microsoft.schemas.xrm._2012.contracts.OrganizationResponseCollection)get_store().add_element_user(ORGANIZATIONRESPONSECOLLECTION$0);
            }
            target.setNil();
        }
    }
}

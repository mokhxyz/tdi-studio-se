/*
 * An XML document type.
 * Localname: OrganizationDetail
 * Namespace: http://schemas.microsoft.com/xrm/2011/Contracts/Discovery
 * Java type: com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetailDocument
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.xrm._2011.contracts.discovery.impl;
/**
 * A document containing one OrganizationDetail(@http://schemas.microsoft.com/xrm/2011/Contracts/Discovery) element.
 *
 * This is a complex type.
 */
public class OrganizationDetailDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetailDocument
{
    private static final long serialVersionUID = 1L;
    
    public OrganizationDetailDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ORGANIZATIONDETAIL$0 = 
        new javax.xml.namespace.QName("http://schemas.microsoft.com/xrm/2011/Contracts/Discovery", "OrganizationDetail");
    
    
    /**
     * Gets the "OrganizationDetail" element
     */
    public com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetail getOrganizationDetail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetail target = null;
            target = (com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetail)get_store().find_element_user(ORGANIZATIONDETAIL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Tests for nil "OrganizationDetail" element
     */
    public boolean isNilOrganizationDetail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetail target = null;
            target = (com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetail)get_store().find_element_user(ORGANIZATIONDETAIL$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * Sets the "OrganizationDetail" element
     */
    public void setOrganizationDetail(com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetail organizationDetail)
    {
        generatedSetterHelperImpl(organizationDetail, ORGANIZATIONDETAIL$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "OrganizationDetail" element
     */
    public com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetail addNewOrganizationDetail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetail target = null;
            target = (com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetail)get_store().add_element_user(ORGANIZATIONDETAIL$0);
            return target;
        }
    }
    
    /**
     * Nils the "OrganizationDetail" element
     */
    public void setNilOrganizationDetail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetail target = null;
            target = (com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetail)get_store().find_element_user(ORGANIZATIONDETAIL$0, 0);
            if (target == null)
            {
                target = (com.microsoft.schemas.xrm._2011.contracts.discovery.OrganizationDetail)get_store().add_element_user(ORGANIZATIONDETAIL$0);
            }
            target.setNil();
        }
    }
}

/*
 * XML Type:  ArrayOfResourceInfo
 * Namespace: http://schemas.microsoft.com/crm/2011/Contracts
 * Java type: com.microsoft.schemas.crm._2011.contracts.ArrayOfResourceInfo
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.crm._2011.contracts.impl;
/**
 * An XML ArrayOfResourceInfo(@http://schemas.microsoft.com/crm/2011/Contracts).
 *
 * This is a complex type.
 */
public class ArrayOfResourceInfoImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.microsoft.schemas.crm._2011.contracts.ArrayOfResourceInfo
{
    private static final long serialVersionUID = 1L;
    
    public ArrayOfResourceInfoImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCEINFO$0 = 
        new javax.xml.namespace.QName("http://schemas.microsoft.com/crm/2011/Contracts", "ResourceInfo");
    
    
    /**
     * Gets array of all "ResourceInfo" elements
     */
    public com.microsoft.schemas.crm._2011.contracts.ResourceInfo[] getResourceInfoArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(RESOURCEINFO$0, targetList);
            com.microsoft.schemas.crm._2011.contracts.ResourceInfo[] result = new com.microsoft.schemas.crm._2011.contracts.ResourceInfo[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "ResourceInfo" element
     */
    public com.microsoft.schemas.crm._2011.contracts.ResourceInfo getResourceInfoArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.ResourceInfo target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.ResourceInfo)get_store().find_element_user(RESOURCEINFO$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Tests for nil ith "ResourceInfo" element
     */
    public boolean isNilResourceInfoArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.ResourceInfo target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.ResourceInfo)get_store().find_element_user(RESOURCEINFO$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.isNil();
        }
    }
    
    /**
     * Returns number of "ResourceInfo" element
     */
    public int sizeOfResourceInfoArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESOURCEINFO$0);
        }
    }
    
    /**
     * Sets array of all "ResourceInfo" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setResourceInfoArray(com.microsoft.schemas.crm._2011.contracts.ResourceInfo[] resourceInfoArray)
    {
        check_orphaned();
        arraySetterHelper(resourceInfoArray, RESOURCEINFO$0);
    }
    
    /**
     * Sets ith "ResourceInfo" element
     */
    public void setResourceInfoArray(int i, com.microsoft.schemas.crm._2011.contracts.ResourceInfo resourceInfo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.ResourceInfo target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.ResourceInfo)get_store().find_element_user(RESOURCEINFO$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(resourceInfo);
        }
    }
    
    /**
     * Nils the ith "ResourceInfo" element
     */
    public void setNilResourceInfoArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.ResourceInfo target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.ResourceInfo)get_store().find_element_user(RESOURCEINFO$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setNil();
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "ResourceInfo" element
     */
    public com.microsoft.schemas.crm._2011.contracts.ResourceInfo insertNewResourceInfo(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.ResourceInfo target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.ResourceInfo)get_store().insert_element_user(RESOURCEINFO$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "ResourceInfo" element
     */
    public com.microsoft.schemas.crm._2011.contracts.ResourceInfo addNewResourceInfo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.ResourceInfo target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.ResourceInfo)get_store().add_element_user(RESOURCEINFO$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "ResourceInfo" element
     */
    public void removeResourceInfo(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESOURCEINFO$0, i);
        }
    }
}

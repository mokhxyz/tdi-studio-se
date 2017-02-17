/*
 * XML Type:  ArrayOfRequiredResource
 * Namespace: http://schemas.microsoft.com/crm/2011/Contracts
 * Java type: com.microsoft.schemas.crm._2011.contracts.ArrayOfRequiredResource
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.crm._2011.contracts.impl;
/**
 * An XML ArrayOfRequiredResource(@http://schemas.microsoft.com/crm/2011/Contracts).
 *
 * This is a complex type.
 */
public class ArrayOfRequiredResourceImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.microsoft.schemas.crm._2011.contracts.ArrayOfRequiredResource
{
    private static final long serialVersionUID = 1L;
    
    public ArrayOfRequiredResourceImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REQUIREDRESOURCE$0 = 
        new javax.xml.namespace.QName("http://schemas.microsoft.com/crm/2011/Contracts", "RequiredResource");
    
    
    /**
     * Gets array of all "RequiredResource" elements
     */
    public com.microsoft.schemas.crm._2011.contracts.RequiredResource[] getRequiredResourceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(REQUIREDRESOURCE$0, targetList);
            com.microsoft.schemas.crm._2011.contracts.RequiredResource[] result = new com.microsoft.schemas.crm._2011.contracts.RequiredResource[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "RequiredResource" element
     */
    public com.microsoft.schemas.crm._2011.contracts.RequiredResource getRequiredResourceArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.RequiredResource target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.RequiredResource)get_store().find_element_user(REQUIREDRESOURCE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Tests for nil ith "RequiredResource" element
     */
    public boolean isNilRequiredResourceArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.RequiredResource target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.RequiredResource)get_store().find_element_user(REQUIREDRESOURCE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.isNil();
        }
    }
    
    /**
     * Returns number of "RequiredResource" element
     */
    public int sizeOfRequiredResourceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(REQUIREDRESOURCE$0);
        }
    }
    
    /**
     * Sets array of all "RequiredResource" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setRequiredResourceArray(com.microsoft.schemas.crm._2011.contracts.RequiredResource[] requiredResourceArray)
    {
        check_orphaned();
        arraySetterHelper(requiredResourceArray, REQUIREDRESOURCE$0);
    }
    
    /**
     * Sets ith "RequiredResource" element
     */
    public void setRequiredResourceArray(int i, com.microsoft.schemas.crm._2011.contracts.RequiredResource requiredResource)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.RequiredResource target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.RequiredResource)get_store().find_element_user(REQUIREDRESOURCE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(requiredResource);
        }
    }
    
    /**
     * Nils the ith "RequiredResource" element
     */
    public void setNilRequiredResourceArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.RequiredResource target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.RequiredResource)get_store().find_element_user(REQUIREDRESOURCE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setNil();
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "RequiredResource" element
     */
    public com.microsoft.schemas.crm._2011.contracts.RequiredResource insertNewRequiredResource(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.RequiredResource target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.RequiredResource)get_store().insert_element_user(REQUIREDRESOURCE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "RequiredResource" element
     */
    public com.microsoft.schemas.crm._2011.contracts.RequiredResource addNewRequiredResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.RequiredResource target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.RequiredResource)get_store().add_element_user(REQUIREDRESOURCE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "RequiredResource" element
     */
    public void removeRequiredResource(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(REQUIREDRESOURCE$0, i);
        }
    }
}

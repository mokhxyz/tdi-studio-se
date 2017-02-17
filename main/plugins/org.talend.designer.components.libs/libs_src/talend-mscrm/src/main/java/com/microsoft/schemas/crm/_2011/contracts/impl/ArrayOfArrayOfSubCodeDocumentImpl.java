/*
 * An XML document type.
 * Localname: ArrayOfArrayOfSubCode
 * Namespace: http://schemas.microsoft.com/crm/2011/Contracts
 * Java type: com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCodeDocument
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.crm._2011.contracts.impl;
/**
 * A document containing one ArrayOfArrayOfSubCode(@http://schemas.microsoft.com/crm/2011/Contracts) element.
 *
 * This is a complex type.
 */
public class ArrayOfArrayOfSubCodeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCodeDocument
{
    private static final long serialVersionUID = 1L;
    
    public ArrayOfArrayOfSubCodeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ARRAYOFARRAYOFSUBCODE$0 = 
        new javax.xml.namespace.QName("http://schemas.microsoft.com/crm/2011/Contracts", "ArrayOfArrayOfSubCode");
    
    
    /**
     * Gets the "ArrayOfArrayOfSubCode" element
     */
    public com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCode getArrayOfArrayOfSubCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCode target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCode)get_store().find_element_user(ARRAYOFARRAYOFSUBCODE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Tests for nil "ArrayOfArrayOfSubCode" element
     */
    public boolean isNilArrayOfArrayOfSubCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCode target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCode)get_store().find_element_user(ARRAYOFARRAYOFSUBCODE$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * Sets the "ArrayOfArrayOfSubCode" element
     */
    public void setArrayOfArrayOfSubCode(com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCode arrayOfArrayOfSubCode)
    {
        generatedSetterHelperImpl(arrayOfArrayOfSubCode, ARRAYOFARRAYOFSUBCODE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ArrayOfArrayOfSubCode" element
     */
    public com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCode addNewArrayOfArrayOfSubCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCode target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCode)get_store().add_element_user(ARRAYOFARRAYOFSUBCODE$0);
            return target;
        }
    }
    
    /**
     * Nils the "ArrayOfArrayOfSubCode" element
     */
    public void setNilArrayOfArrayOfSubCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCode target = null;
            target = (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCode)get_store().find_element_user(ARRAYOFARRAYOFSUBCODE$0, 0);
            if (target == null)
            {
                target = (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfSubCode)get_store().add_element_user(ARRAYOFARRAYOFSUBCODE$0);
            }
            target.setNil();
        }
    }
}

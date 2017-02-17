/*
 * XML Type:  KeyValuePairOfstringQueryBasegUGIFE1S
 * Namespace: http://schemas.datacontract.org/2004/07/System.Collections.Generic
 * Java type: org.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringQueryBasegUGIFE1S
 *
 * Automatically generated - do not modify.
 */
package org.datacontract.schemas._2004._07.system_collections_generic.impl;
/**
 * An XML KeyValuePairOfstringQueryBasegUGIFE1S(@http://schemas.datacontract.org/2004/07/System.Collections.Generic).
 *
 * This is a complex type.
 */
public class KeyValuePairOfstringQueryBasegUGIFE1SImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringQueryBasegUGIFE1S
{
    private static final long serialVersionUID = 1L;
    
    public KeyValuePairOfstringQueryBasegUGIFE1SImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName KEY$0 = 
        new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/System.Collections.Generic", "key");
    private static final javax.xml.namespace.QName VALUE$2 = 
        new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/System.Collections.Generic", "value");
    
    
    /**
     * Gets the "key" element
     */
    public java.lang.String getKey()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(KEY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "key" element
     */
    public org.apache.xmlbeans.XmlString xgetKey()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(KEY$0, 0);
            return target;
        }
    }
    
    /**
     * Tests for nil "key" element
     */
    public boolean isNilKey()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(KEY$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * Sets the "key" element
     */
    public void setKey(java.lang.String key)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(KEY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(KEY$0);
            }
            target.setStringValue(key);
        }
    }
    
    /**
     * Sets (as xml) the "key" element
     */
    public void xsetKey(org.apache.xmlbeans.XmlString key)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(KEY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(KEY$0);
            }
            target.set(key);
        }
    }
    
    /**
     * Nils the "key" element
     */
    public void setNilKey()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(KEY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(KEY$0);
            }
            target.setNil();
        }
    }
    
    /**
     * Gets the "value" element
     */
    public com.microsoft.schemas.xrm._2011.contracts.QueryBase getValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2011.contracts.QueryBase target = null;
            target = (com.microsoft.schemas.xrm._2011.contracts.QueryBase)get_store().find_element_user(VALUE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Tests for nil "value" element
     */
    public boolean isNilValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2011.contracts.QueryBase target = null;
            target = (com.microsoft.schemas.xrm._2011.contracts.QueryBase)get_store().find_element_user(VALUE$2, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * Sets the "value" element
     */
    public void setValue(com.microsoft.schemas.xrm._2011.contracts.QueryBase value)
    {
        generatedSetterHelperImpl(value, VALUE$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "value" element
     */
    public com.microsoft.schemas.xrm._2011.contracts.QueryBase addNewValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2011.contracts.QueryBase target = null;
            target = (com.microsoft.schemas.xrm._2011.contracts.QueryBase)get_store().add_element_user(VALUE$2);
            return target;
        }
    }
    
    /**
     * Nils the "value" element
     */
    public void setNilValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2011.contracts.QueryBase target = null;
            target = (com.microsoft.schemas.xrm._2011.contracts.QueryBase)get_store().find_element_user(VALUE$2, 0);
            if (target == null)
            {
                target = (com.microsoft.schemas.xrm._2011.contracts.QueryBase)get_store().add_element_user(VALUE$2);
            }
            target.setNil();
        }
    }
}

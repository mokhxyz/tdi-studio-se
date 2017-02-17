/*
 * An XML document type.
 * Localname: ExecuteResponse
 * Namespace: http://schemas.microsoft.com/xrm/2011/Contracts/Discovery
 * Java type: com.microsoft.schemas.xrm._2011.contracts.discovery.ExecuteResponseDocument
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.xrm._2011.contracts.discovery.impl;
/**
 * A document containing one ExecuteResponse(@http://schemas.microsoft.com/xrm/2011/Contracts/Discovery) element.
 *
 * This is a complex type.
 */
public class ExecuteResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.microsoft.schemas.xrm._2011.contracts.discovery.ExecuteResponseDocument
{
    private static final long serialVersionUID = 1L;
    
    public ExecuteResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXECUTERESPONSE$0 = 
        new javax.xml.namespace.QName("http://schemas.microsoft.com/xrm/2011/Contracts/Discovery", "ExecuteResponse");
    
    
    /**
     * Gets the "ExecuteResponse" element
     */
    public com.microsoft.schemas.xrm._2011.contracts.discovery.ExecuteResponseDocument.ExecuteResponse getExecuteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2011.contracts.discovery.ExecuteResponseDocument.ExecuteResponse target = null;
            target = (com.microsoft.schemas.xrm._2011.contracts.discovery.ExecuteResponseDocument.ExecuteResponse)get_store().find_element_user(EXECUTERESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ExecuteResponse" element
     */
    public void setExecuteResponse(com.microsoft.schemas.xrm._2011.contracts.discovery.ExecuteResponseDocument.ExecuteResponse executeResponse)
    {
        generatedSetterHelperImpl(executeResponse, EXECUTERESPONSE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ExecuteResponse" element
     */
    public com.microsoft.schemas.xrm._2011.contracts.discovery.ExecuteResponseDocument.ExecuteResponse addNewExecuteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.microsoft.schemas.xrm._2011.contracts.discovery.ExecuteResponseDocument.ExecuteResponse target = null;
            target = (com.microsoft.schemas.xrm._2011.contracts.discovery.ExecuteResponseDocument.ExecuteResponse)get_store().add_element_user(EXECUTERESPONSE$0);
            return target;
        }
    }
    /**
     * An XML ExecuteResponse(@http://schemas.microsoft.com/xrm/2011/Contracts/Discovery).
     *
     * This is a complex type.
     */
    public static class ExecuteResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.microsoft.schemas.xrm._2011.contracts.discovery.ExecuteResponseDocument.ExecuteResponse
    {
        private static final long serialVersionUID = 1L;
        
        public ExecuteResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName EXECUTERESULT$0 = 
            new javax.xml.namespace.QName("http://schemas.microsoft.com/xrm/2011/Contracts/Discovery", "ExecuteResult");
        
        
        /**
         * Gets the "ExecuteResult" element
         */
        public com.microsoft.schemas.xrm._2011.contracts.discovery.DiscoveryResponse getExecuteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.microsoft.schemas.xrm._2011.contracts.discovery.DiscoveryResponse target = null;
                target = (com.microsoft.schemas.xrm._2011.contracts.discovery.DiscoveryResponse)get_store().find_element_user(EXECUTERESULT$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Tests for nil "ExecuteResult" element
         */
        public boolean isNilExecuteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.microsoft.schemas.xrm._2011.contracts.discovery.DiscoveryResponse target = null;
                target = (com.microsoft.schemas.xrm._2011.contracts.discovery.DiscoveryResponse)get_store().find_element_user(EXECUTERESULT$0, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "ExecuteResult" element
         */
        public boolean isSetExecuteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(EXECUTERESULT$0) != 0;
            }
        }
        
        /**
         * Sets the "ExecuteResult" element
         */
        public void setExecuteResult(com.microsoft.schemas.xrm._2011.contracts.discovery.DiscoveryResponse executeResult)
        {
            generatedSetterHelperImpl(executeResult, EXECUTERESULT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "ExecuteResult" element
         */
        public com.microsoft.schemas.xrm._2011.contracts.discovery.DiscoveryResponse addNewExecuteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.microsoft.schemas.xrm._2011.contracts.discovery.DiscoveryResponse target = null;
                target = (com.microsoft.schemas.xrm._2011.contracts.discovery.DiscoveryResponse)get_store().add_element_user(EXECUTERESULT$0);
                return target;
            }
        }
        
        /**
         * Nils the "ExecuteResult" element
         */
        public void setNilExecuteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.microsoft.schemas.xrm._2011.contracts.discovery.DiscoveryResponse target = null;
                target = (com.microsoft.schemas.xrm._2011.contracts.discovery.DiscoveryResponse)get_store().find_element_user(EXECUTERESULT$0, 0);
                if (target == null)
                {
                    target = (com.microsoft.schemas.xrm._2011.contracts.discovery.DiscoveryResponse)get_store().add_element_user(EXECUTERESULT$0);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "ExecuteResult" element
         */
        public void unsetExecuteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(EXECUTERESULT$0, 0);
            }
        }
    }
}

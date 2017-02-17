
package com.microsoft.schemas.xrm._2011.contracts.services;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.12
 * 2015-05-06T14:46:29.193+08:00
 * Generated source version: 2.7.12
 */

@WebFault(name = "OrganizationServiceFault", targetNamespace = "http://schemas.microsoft.com/xrm/2011/Contracts")
public class IOrganizationServiceExecuteOrganizationServiceFaultFaultFaultMessage extends Exception {
    
    private com.microsoft.schemas.xrm._2011.contracts.OrganizationServiceFault organizationServiceFault;

    public IOrganizationServiceExecuteOrganizationServiceFaultFaultFaultMessage() {
        super();
    }
    
    public IOrganizationServiceExecuteOrganizationServiceFaultFaultFaultMessage(String message) {
        super(message);
    }
    
    public IOrganizationServiceExecuteOrganizationServiceFaultFaultFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public IOrganizationServiceExecuteOrganizationServiceFaultFaultFaultMessage(String message, com.microsoft.schemas.xrm._2011.contracts.OrganizationServiceFault organizationServiceFault) {
        super(message);
        this.organizationServiceFault = organizationServiceFault;
    }

    public IOrganizationServiceExecuteOrganizationServiceFaultFaultFaultMessage(String message, com.microsoft.schemas.xrm._2011.contracts.OrganizationServiceFault organizationServiceFault, Throwable cause) {
        super(message, cause);
        this.organizationServiceFault = organizationServiceFault;
    }

    public com.microsoft.schemas.xrm._2011.contracts.OrganizationServiceFault getFaultInfo() {
        return this.organizationServiceFault;
    }
}

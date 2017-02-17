
package com.netsuite.webservices.platform;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.0
 * 2015-05-08T11:20:34.057+08:00
 * Generated source version: 3.1.0
 */

@WebFault(name = "exceededRequestSizeFault", targetNamespace = "urn:faults_2014_2.platform.webservices.netsuite.com")
public class ExceededRequestSizeFault extends Exception {
    
    private com.netsuite.webservices.platform.faults.ExceededRequestSizeFault exceededRequestSizeFault;

    public ExceededRequestSizeFault() {
        super();
    }
    
    public ExceededRequestSizeFault(String message) {
        super(message);
    }
    
    public ExceededRequestSizeFault(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceededRequestSizeFault(String message, com.netsuite.webservices.platform.faults.ExceededRequestSizeFault exceededRequestSizeFault) {
        super(message);
        this.exceededRequestSizeFault = exceededRequestSizeFault;
    }

    public ExceededRequestSizeFault(String message, com.netsuite.webservices.platform.faults.ExceededRequestSizeFault exceededRequestSizeFault, Throwable cause) {
        super(message, cause);
        this.exceededRequestSizeFault = exceededRequestSizeFault;
    }

    public com.netsuite.webservices.platform.faults.ExceededRequestSizeFault getFaultInfo() {
        return this.exceededRequestSizeFault;
    }
}

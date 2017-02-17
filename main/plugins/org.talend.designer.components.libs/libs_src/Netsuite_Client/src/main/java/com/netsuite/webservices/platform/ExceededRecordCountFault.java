
package com.netsuite.webservices.platform;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.0
 * 2015-05-08T11:20:33.769+08:00
 * Generated source version: 3.1.0
 */

@WebFault(name = "exceededRecordCountFault", targetNamespace = "urn:faults_2014_2.platform.webservices.netsuite.com")
public class ExceededRecordCountFault extends Exception {
    
    private com.netsuite.webservices.platform.faults.ExceededRecordCountFault exceededRecordCountFault;

    public ExceededRecordCountFault() {
        super();
    }
    
    public ExceededRecordCountFault(String message) {
        super(message);
    }
    
    public ExceededRecordCountFault(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceededRecordCountFault(String message, com.netsuite.webservices.platform.faults.ExceededRecordCountFault exceededRecordCountFault) {
        super(message);
        this.exceededRecordCountFault = exceededRecordCountFault;
    }

    public ExceededRecordCountFault(String message, com.netsuite.webservices.platform.faults.ExceededRecordCountFault exceededRecordCountFault, Throwable cause) {
        super(message, cause);
        this.exceededRecordCountFault = exceededRecordCountFault;
    }

    public com.netsuite.webservices.platform.faults.ExceededRecordCountFault getFaultInfo() {
        return this.exceededRecordCountFault;
    }
}

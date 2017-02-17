/**
 * VtigerolserviceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.talend.vtiger.module.outlook;

public class VtigerolserviceLocator extends org.apache.axis.client.Service implements org.talend.vtiger.module.outlook.Vtigerolservice {
	
	private String serverAddr;
	
	private String port;

    public VtigerolserviceLocator(String serverAddr, String port) {
    	this.serverAddr = serverAddr;
    	this.port = port;
    	vtigerolservicePort_address = "http://" + serverAddr + ":" + port + "/vtigerservice.php";
    }


    public VtigerolserviceLocator(org.apache.axis.EngineConfiguration config, String serverAddr, String port) {
        super(config);
    	this.serverAddr = serverAddr;
    	this.port = port;
    	vtigerolservicePort_address = "http://" + serverAddr + ":" + port + "/vtigerservice.php";        
    }

    public VtigerolserviceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName, String serverAddr, String port) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    	this.serverAddr = serverAddr;
    	this.port = port;
    	vtigerolservicePort_address = "http://" + serverAddr + ":" + port + "/vtigerservice.php";        
    }

    // Use to get a proxy class for vtigerolservicePort
    private java.lang.String vtigerolservicePort_address = null;

    public java.lang.String getvtigerolservicePortAddress() {
        return vtigerolservicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String vtigerolservicePortWSDDServiceName = "vtigerolservicePort";

    public java.lang.String getvtigerolservicePortWSDDServiceName() {
        return vtigerolservicePortWSDDServiceName;
    }

    public void setvtigerolservicePortWSDDServiceName(java.lang.String name) {
        vtigerolservicePortWSDDServiceName = name;
    }

    public org.talend.vtiger.module.outlook.VtigerolservicePortType getvtigerolservicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(vtigerolservicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getvtigerolservicePort(endpoint);
    }

    public org.talend.vtiger.module.outlook.VtigerolservicePortType getvtigerolservicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.talend.vtiger.module.outlook.VtigerolserviceBindingStub _stub = new org.talend.vtiger.module.outlook.VtigerolserviceBindingStub(portAddress, this, serverAddr);
            _stub.setPortName(getvtigerolservicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setvtigerolservicePortEndpointAddress(java.lang.String serverAddr, String port) {
        vtigerolservicePort_address = "http://" + serverAddr + ":" + port + "/vtigerservice.php";
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.talend.vtiger.module.outlook.VtigerolservicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.talend.vtiger.module.outlook.VtigerolserviceBindingStub _stub = new org.talend.vtiger.module.outlook.VtigerolserviceBindingStub(new java.net.URL(vtigerolservicePort_address), this, serverAddr);
                _stub.setPortName(getvtigerolservicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("vtigerolservicePort".equals(inputPortName)) {
            return getvtigerolservicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://" + serverAddr + "/soap/vtigerolservice", "vtigerolservice");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://" + serverAddr + "/soap/vtigerolservice", "vtigerolservicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String serverAddr, String port) throws javax.xml.rpc.ServiceException {
        
if ("vtigerolservicePort".equals(portName)) {
            setvtigerolservicePortEndpointAddress(serverAddr, port);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String serverAddr, String port) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), serverAddr, port);
    }

}

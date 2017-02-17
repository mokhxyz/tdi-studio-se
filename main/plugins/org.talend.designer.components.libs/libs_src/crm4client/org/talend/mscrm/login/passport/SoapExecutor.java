package org.talend.mscrm.login.passport;
/*
 * Copyright (c) 2009, GoodData Corporation. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright notice, this list of conditions and
 *        the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *        and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *     * Neither the name of the GoodData Corporation nor the names of its contributors may be used to endorse
 *        or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
 * AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */



import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.jaxen.JaxenException;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.soap.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

/**
 * Executes SOAP message
 *
 * @author zd <zd@gooddata.com>
 * @version 1.0
 */
public class SoapExecutor {

    /**
     * Executes SOAP message
     *
     * @param endpointUrl SOAP endpoint
     * @param request     SOAP request
     * @return SOAP response message
     * @throws SOAPException in case of a SOAP issue
     * @throws IOException   in case of an IO issue
     */
    public SOAPMessage execute(String endpointUrl, String request) throws SOAPException, IOException {
        SOAPMessage message = MessageFactory.newInstance().createMessage(new MimeHeaders(), new ByteArrayInputStream(request.getBytes()));
        return execute(endpointUrl, message);
    }

    /**
     * Executes SOAP message
     *
     * @param endpointUrl SOAP endpoint
     * @param message     SOAP request
     * @return SOAP response message
     * @throws SOAPException in case of a SOAP issue
     * @throws IOException   in case of an IO issue
     */
    public SOAPMessage execute(String endpointUrl, SOAPMessage message) throws SOAPException, IOException {
        SOAPConnection conn = null;
        try {
            conn = SOAPConnectionFactory.newInstance().createConnection();
            SOAPMessage response = conn.call(message, endpointUrl);
            SOAPBody body = response.getSOAPBody();
            if (body.hasFault())
                throw new SOAPException(body.getFault().getFaultString());
            return response;
        } finally {
            if (conn != null)
                conn.close();
        }
    }

    /**
     * Constructs XPath query over the SOAP message
     * @param query XPath query
     * @param response SOAP message
     * @return XPath query
     * @throws SOAPException in case of SOAP issue
     * @throws JaxenException XPath problem
     */
    public XPath createXPath(String query, SOAPMessage response) throws SOAPException, JaxenException {
        //Uses DOM to XPath mapping
        XPath xpath = new DOMXPath(query);
        //Define a namespaces used in response
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        SOAPPart sp = response.getSOAPPart();
        SOAPEnvelope env = sp.getEnvelope();
        SOAPBody bdy = env.getBody();
        //Add namespaces from SOAP envelope
        addNamespaces(nsContext, env);
        //Add namespaces of top body element
        Iterator bodyElements = bdy.getChildElements();
        while (bodyElements.hasNext()) {
            SOAPElement element = (SOAPElement) bodyElements.next();
            addNamespaces(nsContext, element);
        }
        xpath.setNamespaceContext(nsContext);
        return xpath;
    }

    /**
     * Namespace context resolver
     * @param context namespace context
     * @param element SOAP message element
     */
    protected void addNamespaces(SimpleNamespaceContext context,
                       SOAPElement element) {
        Iterator namespaces = element.getNamespacePrefixes();
        while (namespaces.hasNext()) {
            String prefix = (String) namespaces.next();
            String uri = element.getNamespaceURI(prefix);
            context.addNamespace(prefix, uri);
        }
    }

    /**
     * Dumps the SOAPMessage to String
     * @param msg the SOAP message
     * @return the String representation of the message
     * @throws IOException  IO issue
     * @throws SOAPException SOAP issue
     */
    public String dumpSoapMessage(SOAPMessage msg) throws IOException, SOAPException {
        Document doc = msg.getSOAPBody().getOwnerDocument();
        OutputFormat format = new OutputFormat(doc);
        format.setLineWidth(65);
        format.setIndenting(true);
        format.setIndent(2);
        StringWriter s = new StringWriter();
        XMLSerializer serializer = new XMLSerializer(s, format);
        serializer.serialize(doc);
        return s.toString();
    }

}

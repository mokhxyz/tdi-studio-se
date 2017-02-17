package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DescribeSoftphoneScreenPopOption implements com.sforce.ws.bind.XMLizable , IDescribeSoftphoneScreenPopOption{

    /**
     * Constructor
     */
    public DescribeSoftphoneScreenPopOption() {}

    /**
     * element : matchType of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo matchType__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","matchType","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean matchType__is_set = false;

    private java.lang.String matchType;

    @Override
    public java.lang.String getMatchType() {
      return matchType;
    }

    @Override
    public void setMatchType(java.lang.String matchType) {
      this.matchType = matchType;
      matchType__is_set = true;
    }

    protected void setMatchType(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, matchType__typeInfo)) {
        setMatchType(__typeMapper.readString(__in, matchType__typeInfo, java.lang.String.class));
      }
    }

    /**
     * element : screenPopData of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo screenPopData__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","screenPopData","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean screenPopData__is_set = false;

    private java.lang.String screenPopData;

    @Override
    public java.lang.String getScreenPopData() {
      return screenPopData;
    }

    @Override
    public void setScreenPopData(java.lang.String screenPopData) {
      this.screenPopData = screenPopData;
      screenPopData__is_set = true;
    }

    protected void setScreenPopData(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, screenPopData__typeInfo)) {
        setScreenPopData(__typeMapper.readString(__in, screenPopData__typeInfo, java.lang.String.class));
      }
    }

    /**
     * element : screenPopType of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo screenPopType__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","screenPopType","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean screenPopType__is_set = false;

    private java.lang.String screenPopType;

    @Override
    public java.lang.String getScreenPopType() {
      return screenPopType;
    }

    @Override
    public void setScreenPopType(java.lang.String screenPopType) {
      this.screenPopType = screenPopType;
      screenPopType__is_set = true;
    }

    protected void setScreenPopType(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, screenPopType__typeInfo)) {
        setScreenPopType(__typeMapper.readString(__in, screenPopType__typeInfo, java.lang.String.class));
      }
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       __typeMapper.writeString(__out, matchType__typeInfo, matchType, matchType__is_set);
       __typeMapper.writeString(__out, screenPopData__typeInfo, screenPopData, screenPopData__is_set);
       __typeMapper.writeString(__out, screenPopType__typeInfo, screenPopType, screenPopType__is_set);
    }

    @Override
    public void load(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __typeMapper.consumeStartTag(__in);
      loadFields(__in, __typeMapper);
      __typeMapper.consumeEndTag(__in);
    }

    protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
        setMatchType(__in, __typeMapper);
        setScreenPopData(__in, __typeMapper);
        setScreenPopType(__in, __typeMapper);
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DescribeSoftphoneScreenPopOption ");
      sb.append(" matchType='").append(com.sforce.ws.util.Verbose.toString(matchType)).append("'\n");
      sb.append(" screenPopData='").append(com.sforce.ws.util.Verbose.toString(screenPopData)).append("'\n");
      sb.append(" screenPopType='").append(com.sforce.ws.util.Verbose.toString(screenPopType)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}

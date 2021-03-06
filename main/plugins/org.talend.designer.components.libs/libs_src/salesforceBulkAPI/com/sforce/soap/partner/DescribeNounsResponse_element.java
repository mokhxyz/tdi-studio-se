package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DescribeNounsResponse_element implements com.sforce.ws.bind.XMLizable , IDescribeNounsResponse_element{

    /**
     * Constructor
     */
    public DescribeNounsResponse_element() {}

    /**
     * element : result of type {urn:partner.soap.sforce.com}DescribeNounResult
     * java type: com.sforce.soap.partner.DescribeNounResult[]
     */
    private static final com.sforce.ws.bind.TypeInfo result__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","result","urn:partner.soap.sforce.com","DescribeNounResult",0,-1,true);

    private boolean result__is_set = false;

    private com.sforce.soap.partner.DescribeNounResult[] result = new com.sforce.soap.partner.DescribeNounResult[0];

    @Override
    public com.sforce.soap.partner.DescribeNounResult[] getResult() {
      return result;
    }

    @Override
    public void setResult(com.sforce.soap.partner.IDescribeNounResult[] result) {
      this.result = castArray(com.sforce.soap.partner.DescribeNounResult.class, result);
      result__is_set = true;
    }

    protected void setResult(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.isElement(__in, result__typeInfo)) {
        setResult((com.sforce.soap.partner.DescribeNounResult[])__typeMapper.readObject(__in, result__typeInfo, com.sforce.soap.partner.DescribeNounResult[].class));
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
       __typeMapper.writeObject(__out, result__typeInfo, result, result__is_set);
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
        setResult(__in, __typeMapper);
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DescribeNounsResponse_element ");
      sb.append(" result='").append(com.sforce.ws.util.Verbose.toString(result)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private <T,U> T[] castArray(Class<T> clazz, U[] array) {
        if (array == null) {
            return null;
        }
        T[] retVal = (T[]) java.lang.reflect.Array.newInstance(clazz, array.length);
        for (int i=0; i < array.length; i++) {
            retVal[i] = (T)array[i];
        }

        return retVal;
	}
}

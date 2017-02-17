package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class SearchResult implements com.sforce.ws.bind.XMLizable , ISearchResult{

    /**
     * Constructor
     */
    public SearchResult() {}

    /**
     * element : queryId of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo queryId__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","queryId","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean queryId__is_set = false;

    private java.lang.String queryId;

    @Override
    public java.lang.String getQueryId() {
      return queryId;
    }

    @Override
    public void setQueryId(java.lang.String queryId) {
      this.queryId = queryId;
      queryId__is_set = true;
    }

    protected void setQueryId(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, queryId__typeInfo)) {
        setQueryId(__typeMapper.readString(__in, queryId__typeInfo, java.lang.String.class));
      }
    }

    /**
     * element : searchRecords of type {urn:partner.soap.sforce.com}SearchRecord
     * java type: com.sforce.soap.partner.SearchRecord[]
     */
    private static final com.sforce.ws.bind.TypeInfo searchRecords__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","searchRecords","urn:partner.soap.sforce.com","SearchRecord",0,-1,true);

    private boolean searchRecords__is_set = false;

    private com.sforce.soap.partner.SearchRecord[] searchRecords = new com.sforce.soap.partner.SearchRecord[0];

    @Override
    public com.sforce.soap.partner.SearchRecord[] getSearchRecords() {
      return searchRecords;
    }

    @Override
    public void setSearchRecords(com.sforce.soap.partner.ISearchRecord[] searchRecords) {
      this.searchRecords = castArray(com.sforce.soap.partner.SearchRecord.class, searchRecords);
      searchRecords__is_set = true;
    }

    protected void setSearchRecords(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.isElement(__in, searchRecords__typeInfo)) {
        setSearchRecords((com.sforce.soap.partner.SearchRecord[])__typeMapper.readObject(__in, searchRecords__typeInfo, com.sforce.soap.partner.SearchRecord[].class));
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
       __typeMapper.writeString(__out, queryId__typeInfo, queryId, queryId__is_set);
       __typeMapper.writeObject(__out, searchRecords__typeInfo, searchRecords, searchRecords__is_set);
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
        setQueryId(__in, __typeMapper);
        setSearchRecords(__in, __typeMapper);
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[SearchResult ");
      sb.append(" queryId='").append(com.sforce.ws.util.Verbose.toString(queryId)).append("'\n");
      sb.append(" searchRecords='").append(com.sforce.ws.util.Verbose.toString(searchRecords)).append("'\n");
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

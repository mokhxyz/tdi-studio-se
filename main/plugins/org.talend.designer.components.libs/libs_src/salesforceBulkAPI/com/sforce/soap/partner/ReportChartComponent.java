package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class ReportChartComponent extends com.sforce.soap.partner.DescribeLayoutComponent implements IReportChartComponent{

    /**
     * Constructor
     */
    public ReportChartComponent() {}

    /**
     * element : cacheData of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo cacheData__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","cacheData","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

    private boolean cacheData__is_set = false;

    private boolean cacheData;

    @Override
    public boolean getCacheData() {
      return cacheData;
    }

    @Override
    public boolean isCacheData() {
      return cacheData;
    }

    @Override
    public void setCacheData(boolean cacheData) {
      this.cacheData = cacheData;
      cacheData__is_set = true;
    }

    protected void setCacheData(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, cacheData__typeInfo)) {
        setCacheData(__typeMapper.readBoolean(__in, cacheData__typeInfo, boolean.class));
      }
    }

    /**
     * element : contextFilterableField of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo contextFilterableField__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","contextFilterableField","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean contextFilterableField__is_set = false;

    private java.lang.String contextFilterableField;

    @Override
    public java.lang.String getContextFilterableField() {
      return contextFilterableField;
    }

    @Override
    public void setContextFilterableField(java.lang.String contextFilterableField) {
      this.contextFilterableField = contextFilterableField;
      contextFilterableField__is_set = true;
    }

    protected void setContextFilterableField(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, contextFilterableField__typeInfo)) {
        setContextFilterableField(__typeMapper.readString(__in, contextFilterableField__typeInfo, java.lang.String.class));
      }
    }

    /**
     * element : error of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo error__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","error","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean error__is_set = false;

    private java.lang.String error;

    @Override
    public java.lang.String getError() {
      return error;
    }

    @Override
    public void setError(java.lang.String error) {
      this.error = error;
      error__is_set = true;
    }

    protected void setError(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, error__typeInfo)) {
        setError(__typeMapper.readString(__in, error__typeInfo, java.lang.String.class));
      }
    }

    /**
     * element : hideOnError of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo hideOnError__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","hideOnError","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

    private boolean hideOnError__is_set = false;

    private boolean hideOnError;

    @Override
    public boolean getHideOnError() {
      return hideOnError;
    }

    @Override
    public boolean isHideOnError() {
      return hideOnError;
    }

    @Override
    public void setHideOnError(boolean hideOnError) {
      this.hideOnError = hideOnError;
      hideOnError__is_set = true;
    }

    protected void setHideOnError(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, hideOnError__typeInfo)) {
        setHideOnError(__typeMapper.readBoolean(__in, hideOnError__typeInfo, boolean.class));
      }
    }

    /**
     * element : includeContext of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo includeContext__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","includeContext","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

    private boolean includeContext__is_set = false;

    private boolean includeContext;

    @Override
    public boolean getIncludeContext() {
      return includeContext;
    }

    @Override
    public boolean isIncludeContext() {
      return includeContext;
    }

    @Override
    public void setIncludeContext(boolean includeContext) {
      this.includeContext = includeContext;
      includeContext__is_set = true;
    }

    protected void setIncludeContext(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, includeContext__typeInfo)) {
        setIncludeContext(__typeMapper.readBoolean(__in, includeContext__typeInfo, boolean.class));
      }
    }

    /**
     * element : showTitle of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo showTitle__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","showTitle","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

    private boolean showTitle__is_set = false;

    private boolean showTitle;

    @Override
    public boolean getShowTitle() {
      return showTitle;
    }

    @Override
    public boolean isShowTitle() {
      return showTitle;
    }

    @Override
    public void setShowTitle(boolean showTitle) {
      this.showTitle = showTitle;
      showTitle__is_set = true;
    }

    protected void setShowTitle(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, showTitle__typeInfo)) {
        setShowTitle(__typeMapper.readBoolean(__in, showTitle__typeInfo, boolean.class));
      }
    }

    /**
     * element : size of type {urn:partner.soap.sforce.com}ReportChartSize
     * java type: com.sforce.soap.partner.ReportChartSize
     */
    private static final com.sforce.ws.bind.TypeInfo size__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","size","urn:partner.soap.sforce.com","ReportChartSize",1,1,true);

    private boolean size__is_set = false;

    private com.sforce.soap.partner.ReportChartSize size;

    @Override
    public com.sforce.soap.partner.ReportChartSize getSize() {
      return size;
    }

    @Override
    public void setSize(com.sforce.soap.partner.ReportChartSize size) {
      this.size = size;
      size__is_set = true;
    }

    protected void setSize(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, size__typeInfo)) {
        setSize((com.sforce.soap.partner.ReportChartSize)__typeMapper.readObject(__in, size__typeInfo, com.sforce.soap.partner.ReportChartSize.class));
      }
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "urn:partner.soap.sforce.com", "ReportChartComponent");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeBoolean(__out, cacheData__typeInfo, cacheData, cacheData__is_set);
       __typeMapper.writeString(__out, contextFilterableField__typeInfo, contextFilterableField, contextFilterableField__is_set);
       __typeMapper.writeString(__out, error__typeInfo, error, error__is_set);
       __typeMapper.writeBoolean(__out, hideOnError__typeInfo, hideOnError, hideOnError__is_set);
       __typeMapper.writeBoolean(__out, includeContext__typeInfo, includeContext, includeContext__is_set);
       __typeMapper.writeBoolean(__out, showTitle__typeInfo, showTitle, showTitle__is_set);
       __typeMapper.writeObject(__out, size__typeInfo, size, size__is_set);
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
        super.loadFields(__in, __typeMapper);
        setCacheData(__in, __typeMapper);
        setContextFilterableField(__in, __typeMapper);
        setError(__in, __typeMapper);
        setHideOnError(__in, __typeMapper);
        setIncludeContext(__in, __typeMapper);
        setShowTitle(__in, __typeMapper);
        setSize(__in, __typeMapper);
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[ReportChartComponent ");
      sb.append(super.toString());sb.append(" cacheData='").append(com.sforce.ws.util.Verbose.toString(cacheData)).append("'\n");
      sb.append(" contextFilterableField='").append(com.sforce.ws.util.Verbose.toString(contextFilterableField)).append("'\n");
      sb.append(" error='").append(com.sforce.ws.util.Verbose.toString(error)).append("'\n");
      sb.append(" hideOnError='").append(com.sforce.ws.util.Verbose.toString(hideOnError)).append("'\n");
      sb.append(" includeContext='").append(com.sforce.ws.util.Verbose.toString(includeContext)).append("'\n");
      sb.append(" showTitle='").append(com.sforce.ws.util.Verbose.toString(showTitle)).append("'\n");
      sb.append(" size='").append(com.sforce.ws.util.Verbose.toString(size)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}

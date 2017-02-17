package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DescribeAppMenuItem implements com.sforce.ws.bind.XMLizable , IDescribeAppMenuItem{

    /**
     * Constructor
     */
    public DescribeAppMenuItem() {}

    /**
     * element : colors of type {urn:partner.soap.sforce.com}DescribeColor
     * java type: com.sforce.soap.partner.DescribeColor[]
     */
    private static final com.sforce.ws.bind.TypeInfo colors__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","colors","urn:partner.soap.sforce.com","DescribeColor",0,-1,true);

    private boolean colors__is_set = false;

    private com.sforce.soap.partner.DescribeColor[] colors = new com.sforce.soap.partner.DescribeColor[0];

    @Override
    public com.sforce.soap.partner.DescribeColor[] getColors() {
      return colors;
    }

    @Override
    public void setColors(com.sforce.soap.partner.IDescribeColor[] colors) {
      this.colors = castArray(com.sforce.soap.partner.DescribeColor.class, colors);
      colors__is_set = true;
    }

    protected void setColors(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.isElement(__in, colors__typeInfo)) {
        setColors((com.sforce.soap.partner.DescribeColor[])__typeMapper.readObject(__in, colors__typeInfo, com.sforce.soap.partner.DescribeColor[].class));
      }
    }

    /**
     * element : content of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo content__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","content","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean content__is_set = false;

    private java.lang.String content;

    @Override
    public java.lang.String getContent() {
      return content;
    }

    @Override
    public void setContent(java.lang.String content) {
      this.content = content;
      content__is_set = true;
    }

    protected void setContent(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, content__typeInfo)) {
        setContent(__typeMapper.readString(__in, content__typeInfo, java.lang.String.class));
      }
    }

    /**
     * element : icons of type {urn:partner.soap.sforce.com}DescribeIcon
     * java type: com.sforce.soap.partner.DescribeIcon[]
     */
    private static final com.sforce.ws.bind.TypeInfo icons__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","icons","urn:partner.soap.sforce.com","DescribeIcon",0,-1,true);

    private boolean icons__is_set = false;

    private com.sforce.soap.partner.DescribeIcon[] icons = new com.sforce.soap.partner.DescribeIcon[0];

    @Override
    public com.sforce.soap.partner.DescribeIcon[] getIcons() {
      return icons;
    }

    @Override
    public void setIcons(com.sforce.soap.partner.IDescribeIcon[] icons) {
      this.icons = castArray(com.sforce.soap.partner.DescribeIcon.class, icons);
      icons__is_set = true;
    }

    protected void setIcons(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.isElement(__in, icons__typeInfo)) {
        setIcons((com.sforce.soap.partner.DescribeIcon[])__typeMapper.readObject(__in, icons__typeInfo, com.sforce.soap.partner.DescribeIcon[].class));
      }
    }

    /**
     * element : label of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo label__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","label","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean label__is_set = false;

    private java.lang.String label;

    @Override
    public java.lang.String getLabel() {
      return label;
    }

    @Override
    public void setLabel(java.lang.String label) {
      this.label = label;
      label__is_set = true;
    }

    protected void setLabel(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, label__typeInfo)) {
        setLabel(__typeMapper.readString(__in, label__typeInfo, java.lang.String.class));
      }
    }

    /**
     * element : name of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo name__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","name","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean name__is_set = false;

    private java.lang.String name;

    @Override
    public java.lang.String getName() {
      return name;
    }

    @Override
    public void setName(java.lang.String name) {
      this.name = name;
      name__is_set = true;
    }

    protected void setName(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, name__typeInfo)) {
        setName(__typeMapper.readString(__in, name__typeInfo, java.lang.String.class));
      }
    }

    /**
     * element : type of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo type__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","type","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean type__is_set = false;

    private java.lang.String type;

    @Override
    public java.lang.String getType() {
      return type;
    }

    @Override
    public void setType(java.lang.String type) {
      this.type = type;
      type__is_set = true;
    }

    protected void setType(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, type__typeInfo)) {
        setType(__typeMapper.readString(__in, type__typeInfo, java.lang.String.class));
      }
    }

    /**
     * element : url of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo url__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","url","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean url__is_set = false;

    private java.lang.String url;

    @Override
    public java.lang.String getUrl() {
      return url;
    }

    @Override
    public void setUrl(java.lang.String url) {
      this.url = url;
      url__is_set = true;
    }

    protected void setUrl(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, url__typeInfo)) {
        setUrl(__typeMapper.readString(__in, url__typeInfo, java.lang.String.class));
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
       __typeMapper.writeObject(__out, colors__typeInfo, colors, colors__is_set);
       __typeMapper.writeString(__out, content__typeInfo, content, content__is_set);
       __typeMapper.writeObject(__out, icons__typeInfo, icons, icons__is_set);
       __typeMapper.writeString(__out, label__typeInfo, label, label__is_set);
       __typeMapper.writeString(__out, name__typeInfo, name, name__is_set);
       __typeMapper.writeString(__out, type__typeInfo, type, type__is_set);
       __typeMapper.writeString(__out, url__typeInfo, url, url__is_set);
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
        setColors(__in, __typeMapper);
        setContent(__in, __typeMapper);
        setIcons(__in, __typeMapper);
        setLabel(__in, __typeMapper);
        setName(__in, __typeMapper);
        setType(__in, __typeMapper);
        setUrl(__in, __typeMapper);
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DescribeAppMenuItem ");
      sb.append(" colors='").append(com.sforce.ws.util.Verbose.toString(colors)).append("'\n");
      sb.append(" content='").append(com.sforce.ws.util.Verbose.toString(content)).append("'\n");
      sb.append(" icons='").append(com.sforce.ws.util.Verbose.toString(icons)).append("'\n");
      sb.append(" label='").append(com.sforce.ws.util.Verbose.toString(label)).append("'\n");
      sb.append(" name='").append(com.sforce.ws.util.Verbose.toString(name)).append("'\n");
      sb.append(" type='").append(com.sforce.ws.util.Verbose.toString(type)).append("'\n");
      sb.append(" url='").append(com.sforce.ws.util.Verbose.toString(url)).append("'\n");
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

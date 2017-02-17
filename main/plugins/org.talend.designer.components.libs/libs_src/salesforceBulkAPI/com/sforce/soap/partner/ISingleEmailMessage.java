package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public interface ISingleEmailMessage extends com.sforce.soap.partner.IEmail {

      /**
       * element : bccAddresses of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String[]
       */

      public java.lang.String[] getBccAddresses();

      public void setBccAddresses(java.lang.String[] bccAddresses);

      /**
       * element : ccAddresses of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String[]
       */

      public java.lang.String[] getCcAddresses();

      public void setCcAddresses(java.lang.String[] ccAddresses);

      /**
       * element : charset of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getCharset();

      public void setCharset(java.lang.String charset);

      /**
       * element : documentAttachments of type {urn:partner.soap.sforce.com}ID
       * java type: java.lang.String[]
       */

      public java.lang.String[] getDocumentAttachments();

      public void setDocumentAttachments(java.lang.String[] documentAttachments);

      /**
       * element : htmlBody of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getHtmlBody();

      public void setHtmlBody(java.lang.String htmlBody);

      /**
       * element : inReplyTo of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getInReplyTo();

      public void setInReplyTo(java.lang.String inReplyTo);

      /**
       * element : fileAttachments of type {urn:partner.soap.sforce.com}EmailFileAttachment
       * java type: com.sforce.soap.partner.EmailFileAttachment[]
       */

      public com.sforce.soap.partner.IEmailFileAttachment[] getFileAttachments();

      public void setFileAttachments(com.sforce.soap.partner.IEmailFileAttachment[] fileAttachments);

      /**
       * element : orgWideEmailAddressId of type {urn:partner.soap.sforce.com}ID
       * java type: java.lang.String
       */

      public java.lang.String getOrgWideEmailAddressId();

      public void setOrgWideEmailAddressId(java.lang.String orgWideEmailAddressId);

      /**
       * element : plainTextBody of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getPlainTextBody();

      public void setPlainTextBody(java.lang.String plainTextBody);

      /**
       * element : references of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getReferences();

      public void setReferences(java.lang.String references);

      /**
       * element : targetObjectId of type {urn:partner.soap.sforce.com}ID
       * java type: java.lang.String
       */

      public java.lang.String getTargetObjectId();

      public void setTargetObjectId(java.lang.String targetObjectId);

      /**
       * element : templateId of type {urn:partner.soap.sforce.com}ID
       * java type: java.lang.String
       */

      public java.lang.String getTemplateId();

      public void setTemplateId(java.lang.String templateId);

      /**
       * element : toAddresses of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String[]
       */

      public java.lang.String[] getToAddresses();

      public void setToAddresses(java.lang.String[] toAddresses);

      /**
       * element : whatId of type {urn:partner.soap.sforce.com}ID
       * java type: java.lang.String
       */

      public java.lang.String getWhatId();

      public void setWhatId(java.lang.String whatId);


}

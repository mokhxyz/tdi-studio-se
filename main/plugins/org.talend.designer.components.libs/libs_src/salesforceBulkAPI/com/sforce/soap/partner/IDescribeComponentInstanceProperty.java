package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public interface IDescribeComponentInstanceProperty  {

      /**
       * element : name of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getName();

      public void setName(java.lang.String name);

      /**
       * element : region of type {urn:partner.soap.sforce.com}DescribeFlexiPageRegion
       * java type: com.sforce.soap.partner.DescribeFlexiPageRegion
       */

      public com.sforce.soap.partner.IDescribeFlexiPageRegion getRegion();

      public void setRegion(com.sforce.soap.partner.IDescribeFlexiPageRegion region);

      /**
       * element : value of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getValue();

      public void setValue(java.lang.String value);


}

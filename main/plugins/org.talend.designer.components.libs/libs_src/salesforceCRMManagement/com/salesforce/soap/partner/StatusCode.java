/**
 * StatusCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

package com.salesforce.soap.partner;

/**
 * StatusCode bean class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class StatusCode implements org.apache.axis2.databinding.ADBBean {

	public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
			"urn:partner.soap.sforce.com", "StatusCode", "ns1");

	/**
	 * field for StatusCode
	 */

	protected java.lang.String localStatusCode;

	private static java.util.HashMap _table_ = new java.util.HashMap();

	// Constructor

	protected StatusCode(java.lang.String value, boolean isRegisterValue) {
		localStatusCode = value;
		if (isRegisterValue) {

			_table_.put(localStatusCode, this);

		}

	}

	public static final java.lang.String _ALL_OR_NONE_OPERATION_ROLLED_BACK = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("ALL_OR_NONE_OPERATION_ROLLED_BACK");

	public static final java.lang.String _ALREADY_IN_PROCESS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("ALREADY_IN_PROCESS");

	public static final java.lang.String _ASSIGNEE_TYPE_REQUIRED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("ASSIGNEE_TYPE_REQUIRED");

	public static final java.lang.String _BAD_CUSTOM_ENTITY_PARENT_DOMAIN = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("BAD_CUSTOM_ENTITY_PARENT_DOMAIN");

	public static final java.lang.String _BCC_NOT_ALLOWED_IF_BCC_COMPLIANCE_ENABLED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("BCC_NOT_ALLOWED_IF_BCC_COMPLIANCE_ENABLED");

	public static final java.lang.String _CANNOT_CASCADE_PRODUCT_ACTIVE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_CASCADE_PRODUCT_ACTIVE");

	public static final java.lang.String _CANNOT_CHANGE_FIELD_TYPE_OF_APEX_REFERENCED_FIELD = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_CHANGE_FIELD_TYPE_OF_APEX_REFERENCED_FIELD");

	public static final java.lang.String _CANNOT_CREATE_ANOTHER_MANAGED_PACKAGE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_CREATE_ANOTHER_MANAGED_PACKAGE");

	public static final java.lang.String _CANNOT_DEACTIVATE_DIVISION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_DEACTIVATE_DIVISION");

	public static final java.lang.String _CANNOT_DELETE_LAST_DATED_CONVERSION_RATE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_DELETE_LAST_DATED_CONVERSION_RATE");

	public static final java.lang.String _CANNOT_DELETE_MANAGED_OBJECT = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_DELETE_MANAGED_OBJECT");

	public static final java.lang.String _CANNOT_DISABLE_LAST_ADMIN = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_DISABLE_LAST_ADMIN");

	public static final java.lang.String _CANNOT_ENABLE_IP_RESTRICT_REQUESTS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_ENABLE_IP_RESTRICT_REQUESTS");

	public static final java.lang.String _CANNOT_INSERT_UPDATE_ACTIVATE_ENTITY = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_INSERT_UPDATE_ACTIVATE_ENTITY");

	public static final java.lang.String _CANNOT_MODIFY_MANAGED_OBJECT = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_MODIFY_MANAGED_OBJECT");

	public static final java.lang.String _CANNOT_RENAME_APEX_REFERENCED_FIELD = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_RENAME_APEX_REFERENCED_FIELD");

	public static final java.lang.String _CANNOT_RENAME_APEX_REFERENCED_OBJECT = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_RENAME_APEX_REFERENCED_OBJECT");

	public static final java.lang.String _CANNOT_REPARENT_RECORD = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_REPARENT_RECORD");

	public static final java.lang.String _CANNOT_UPDATE_CONVERTED_LEAD = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANNOT_UPDATE_CONVERTED_LEAD");

	public static final java.lang.String _CANT_DISABLE_CORP_CURRENCY = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANT_DISABLE_CORP_CURRENCY");

	public static final java.lang.String _CANT_UNSET_CORP_CURRENCY = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CANT_UNSET_CORP_CURRENCY");

	public static final java.lang.String _CHILD_SHARE_FAILS_PARENT = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CHILD_SHARE_FAILS_PARENT");

	public static final java.lang.String _CIRCULAR_DEPENDENCY = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CIRCULAR_DEPENDENCY");

	public static final java.lang.String _COMMUNITY_NOT_ACCESSIBLE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("COMMUNITY_NOT_ACCESSIBLE");

	public static final java.lang.String _CUSTOM_CLOB_FIELD_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CUSTOM_CLOB_FIELD_LIMIT_EXCEEDED");

	public static final java.lang.String _CUSTOM_ENTITY_OR_FIELD_LIMIT = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CUSTOM_ENTITY_OR_FIELD_LIMIT");

	public static final java.lang.String _CUSTOM_FIELD_INDEX_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CUSTOM_FIELD_INDEX_LIMIT_EXCEEDED");

	public static final java.lang.String _CUSTOM_INDEX_EXISTS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CUSTOM_INDEX_EXISTS");

	public static final java.lang.String _CUSTOM_LINK_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CUSTOM_LINK_LIMIT_EXCEEDED");

	public static final java.lang.String _CUSTOM_TAB_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("CUSTOM_TAB_LIMIT_EXCEEDED");

	public static final java.lang.String _DELETE_FAILED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DELETE_FAILED");

	public static final java.lang.String _DELETE_OPERATION_TOO_LARGE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DELETE_OPERATION_TOO_LARGE");

	public static final java.lang.String _DELETE_REQUIRED_ON_CASCADE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DELETE_REQUIRED_ON_CASCADE");

	public static final java.lang.String _DEPENDENCY_EXISTS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DEPENDENCY_EXISTS");

	public static final java.lang.String _DUPLICATE_CASE_SOLUTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DUPLICATE_CASE_SOLUTION");

	public static final java.lang.String _DUPLICATE_COMM_NICKNAME = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DUPLICATE_COMM_NICKNAME");

	public static final java.lang.String _DUPLICATE_CUSTOM_ENTITY_DEFINITION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DUPLICATE_CUSTOM_ENTITY_DEFINITION");

	public static final java.lang.String _DUPLICATE_CUSTOM_TAB_MOTIF = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DUPLICATE_CUSTOM_TAB_MOTIF");

	public static final java.lang.String _DUPLICATE_DEVELOPER_NAME = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DUPLICATE_DEVELOPER_NAME");

	public static final java.lang.String _DUPLICATE_EXTERNAL_ID = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DUPLICATE_EXTERNAL_ID");

	public static final java.lang.String _DUPLICATE_MASTER_LABEL = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DUPLICATE_MASTER_LABEL");

	public static final java.lang.String _DUPLICATE_SENDER_DISPLAY_NAME = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DUPLICATE_SENDER_DISPLAY_NAME");

	public static final java.lang.String _DUPLICATE_USERNAME = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DUPLICATE_USERNAME");

	public static final java.lang.String _DUPLICATE_VALUE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("DUPLICATE_VALUE");

	public static final java.lang.String _EMAIL_NOT_PROCESSED_DUE_TO_PRIOR_ERROR = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("EMAIL_NOT_PROCESSED_DUE_TO_PRIOR_ERROR");

	public static final java.lang.String _EMPTY_SCONTROL_FILE_NAME = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("EMPTY_SCONTROL_FILE_NAME");

	public static final java.lang.String _ENTITY_FAILED_IFLASTMODIFIED_ON_UPDATE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("ENTITY_FAILED_IFLASTMODIFIED_ON_UPDATE");

	public static final java.lang.String _ENTITY_IS_ARCHIVED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("ENTITY_IS_ARCHIVED");

	public static final java.lang.String _ENTITY_IS_DELETED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("ENTITY_IS_DELETED");

	public static final java.lang.String _ENTITY_IS_LOCKED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("ENTITY_IS_LOCKED");

	public static final java.lang.String _ERROR_IN_MAILER = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("ERROR_IN_MAILER");

	public static final java.lang.String _EXTERNAL_OBJECT_AUTHENTICATION_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("EXTERNAL_OBJECT_AUTHENTICATION_EXCEPTION");

	public static final java.lang.String _EXTERNAL_OBJECT_CONNECTION_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("EXTERNAL_OBJECT_CONNECTION_EXCEPTION");

	public static final java.lang.String _EXTERNAL_OBJECT_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("EXTERNAL_OBJECT_EXCEPTION");

	public static final java.lang.String _EXTERNAL_OBJECT_UNSUPPORTED_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("EXTERNAL_OBJECT_UNSUPPORTED_EXCEPTION");

	public static final java.lang.String _FAILED_ACTIVATION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("FAILED_ACTIVATION");

	public static final java.lang.String _FIELD_CUSTOM_VALIDATION_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("FIELD_CUSTOM_VALIDATION_EXCEPTION");

	public static final java.lang.String _FIELD_FILTER_VALIDATION_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("FIELD_FILTER_VALIDATION_EXCEPTION");

	public static final java.lang.String _FIELD_INTEGRITY_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("FIELD_INTEGRITY_EXCEPTION");

	public static final java.lang.String _FILTERED_LOOKUP_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("FILTERED_LOOKUP_LIMIT_EXCEEDED");

	public static final java.lang.String _HTML_FILE_UPLOAD_NOT_ALLOWED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("HTML_FILE_UPLOAD_NOT_ALLOWED");

	public static final java.lang.String _IMAGE_TOO_LARGE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("IMAGE_TOO_LARGE");

	public static final java.lang.String _INACTIVE_OWNER_OR_USER = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INACTIVE_OWNER_OR_USER");

	public static final java.lang.String _INSUFFICIENT_ACCESS_ON_CROSS_REFERENCE_ENTITY = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INSUFFICIENT_ACCESS_ON_CROSS_REFERENCE_ENTITY");

	public static final java.lang.String _INSUFFICIENT_ACCESS_OR_READONLY = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INSUFFICIENT_ACCESS_OR_READONLY");

	public static final java.lang.String _INVALID_ACCESS_LEVEL = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_ACCESS_LEVEL");

	public static final java.lang.String _INVALID_ARGUMENT_TYPE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_ARGUMENT_TYPE");

	public static final java.lang.String _INVALID_ASSIGNEE_TYPE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_ASSIGNEE_TYPE");

	public static final java.lang.String _INVALID_ASSIGNMENT_RULE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_ASSIGNMENT_RULE");

	public static final java.lang.String _INVALID_BATCH_OPERATION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_BATCH_OPERATION");

	public static final java.lang.String _INVALID_CONTENT_TYPE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_CONTENT_TYPE");

	public static final java.lang.String _INVALID_CREDIT_CARD_INFO = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_CREDIT_CARD_INFO");

	public static final java.lang.String _INVALID_CROSS_REFERENCE_KEY = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_CROSS_REFERENCE_KEY");

	public static final java.lang.String _INVALID_CROSS_REFERENCE_TYPE_FOR_FIELD = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_CROSS_REFERENCE_TYPE_FOR_FIELD");

	public static final java.lang.String _INVALID_CURRENCY_CONV_RATE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_CURRENCY_CONV_RATE");

	public static final java.lang.String _INVALID_CURRENCY_CORP_RATE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_CURRENCY_CORP_RATE");

	public static final java.lang.String _INVALID_CURRENCY_ISO = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_CURRENCY_ISO");

	public static final java.lang.String _INVALID_DATA_CATEGORY_GROUP_REFERENCE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_DATA_CATEGORY_GROUP_REFERENCE");

	public static final java.lang.String _INVALID_DATA_URI = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_DATA_URI");

	public static final java.lang.String _INVALID_EMAIL_ADDRESS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_EMAIL_ADDRESS");

	public static final java.lang.String _INVALID_EMPTY_KEY_OWNER = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_EMPTY_KEY_OWNER");

	public static final java.lang.String _INVALID_FIELD = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_FIELD");

	public static final java.lang.String _INVALID_FIELD_FOR_INSERT_UPDATE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_FIELD_FOR_INSERT_UPDATE");

	public static final java.lang.String _INVALID_FIELD_WHEN_USING_TEMPLATE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_FIELD_WHEN_USING_TEMPLATE");

	public static final java.lang.String _INVALID_FILTER_ACTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_FILTER_ACTION");

	public static final java.lang.String _INVALID_GOOGLE_DOCS_URL = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_GOOGLE_DOCS_URL");

	public static final java.lang.String _INVALID_ID_FIELD = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_ID_FIELD");

	public static final java.lang.String _INVALID_INET_ADDRESS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_INET_ADDRESS");

	public static final java.lang.String _INVALID_LINEITEM_CLONE_STATE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_LINEITEM_CLONE_STATE");

	public static final java.lang.String _INVALID_MASTER_OR_TRANSLATED_SOLUTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_MASTER_OR_TRANSLATED_SOLUTION");

	public static final java.lang.String _INVALID_MESSAGE_ID_REFERENCE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_MESSAGE_ID_REFERENCE");

	public static final java.lang.String _INVALID_OPERATION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_OPERATION");

	public static final java.lang.String _INVALID_OPERATOR = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_OPERATOR");

	public static final java.lang.String _INVALID_OR_NULL_FOR_RESTRICTED_PICKLIST = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_OR_NULL_FOR_RESTRICTED_PICKLIST");

	public static final java.lang.String _INVALID_PACKAGE_VERSION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_PACKAGE_VERSION");

	public static final java.lang.String _INVALID_PARTNER_NETWORK_STATUS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_PARTNER_NETWORK_STATUS");

	public static final java.lang.String _INVALID_PERSON_ACCOUNT_OPERATION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_PERSON_ACCOUNT_OPERATION");

	public static final java.lang.String _INVALID_QUERY_LOCATOR = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_QUERY_LOCATOR");

	public static final java.lang.String _INVALID_READ_ONLY_USER_DML = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_READ_ONLY_USER_DML");

	public static final java.lang.String _INVALID_SAVE_AS_ACTIVITY_FLAG = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_SAVE_AS_ACTIVITY_FLAG");

	public static final java.lang.String _INVALID_SESSION_ID = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_SESSION_ID");

	public static final java.lang.String _INVALID_SETUP_OWNER = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_SETUP_OWNER");

	public static final java.lang.String _INVALID_STATUS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_STATUS");

	public static final java.lang.String _INVALID_TYPE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_TYPE");

	public static final java.lang.String _INVALID_TYPE_FOR_OPERATION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_TYPE_FOR_OPERATION");

	public static final java.lang.String _INVALID_TYPE_ON_FIELD_IN_RECORD = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("INVALID_TYPE_ON_FIELD_IN_RECORD");

	public static final java.lang.String _IP_RANGE_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("IP_RANGE_LIMIT_EXCEEDED");

	public static final java.lang.String _LICENSE_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("LICENSE_LIMIT_EXCEEDED");

	public static final java.lang.String _LIGHT_PORTAL_USER_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("LIGHT_PORTAL_USER_EXCEPTION");

	public static final java.lang.String _LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("LIMIT_EXCEEDED");

	public static final java.lang.String _MALFORMED_ID = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MALFORMED_ID");

	public static final java.lang.String _MANAGER_NOT_DEFINED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MANAGER_NOT_DEFINED");

	public static final java.lang.String _MASSMAIL_RETRY_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MASSMAIL_RETRY_LIMIT_EXCEEDED");

	public static final java.lang.String _MASS_MAIL_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MASS_MAIL_LIMIT_EXCEEDED");

	public static final java.lang.String _MAXIMUM_CCEMAILS_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAXIMUM_CCEMAILS_EXCEEDED");

	public static final java.lang.String _MAXIMUM_DASHBOARD_COMPONENTS_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAXIMUM_DASHBOARD_COMPONENTS_EXCEEDED");

	public static final java.lang.String _MAXIMUM_HIERARCHY_LEVELS_REACHED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAXIMUM_HIERARCHY_LEVELS_REACHED");

	public static final java.lang.String _MAXIMUM_SIZE_OF_ATTACHMENT = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAXIMUM_SIZE_OF_ATTACHMENT");

	public static final java.lang.String _MAXIMUM_SIZE_OF_DOCUMENT = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAXIMUM_SIZE_OF_DOCUMENT");

	public static final java.lang.String _MAX_ACTIONS_PER_RULE_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAX_ACTIONS_PER_RULE_EXCEEDED");

	public static final java.lang.String _MAX_ACTIVE_RULES_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAX_ACTIVE_RULES_EXCEEDED");

	public static final java.lang.String _MAX_APPROVAL_STEPS_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAX_APPROVAL_STEPS_EXCEEDED");

	public static final java.lang.String _MAX_FORMULAS_PER_RULE_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAX_FORMULAS_PER_RULE_EXCEEDED");

	public static final java.lang.String _MAX_RULES_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAX_RULES_EXCEEDED");

	public static final java.lang.String _MAX_RULE_ENTRIES_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAX_RULE_ENTRIES_EXCEEDED");

	public static final java.lang.String _MAX_TASK_DESCRIPTION_EXCEEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAX_TASK_DESCRIPTION_EXCEEEDED");

	public static final java.lang.String _MAX_TM_RULES_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAX_TM_RULES_EXCEEDED");

	public static final java.lang.String _MAX_TM_RULE_ITEMS_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MAX_TM_RULE_ITEMS_EXCEEDED");

	public static final java.lang.String _MERGE_FAILED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MERGE_FAILED");

	public static final java.lang.String _MISSING_ARGUMENT = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MISSING_ARGUMENT");

	public static final java.lang.String _MIXED_DML_OPERATION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("MIXED_DML_OPERATION");

	public static final java.lang.String _NONUNIQUE_SHIPPING_ADDRESS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("NONUNIQUE_SHIPPING_ADDRESS");

	public static final java.lang.String _NO_APPLICABLE_PROCESS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("NO_APPLICABLE_PROCESS");

	public static final java.lang.String _NO_ATTACHMENT_PERMISSION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("NO_ATTACHMENT_PERMISSION");

	public static final java.lang.String _NO_INACTIVE_DIVISION_MEMBERS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("NO_INACTIVE_DIVISION_MEMBERS");

	public static final java.lang.String _NO_MASS_MAIL_PERMISSION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("NO_MASS_MAIL_PERMISSION");

	public static final java.lang.String _NUMBER_OUTSIDE_VALID_RANGE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("NUMBER_OUTSIDE_VALID_RANGE");

	public static final java.lang.String _NUM_HISTORY_FIELDS_BY_SOBJECT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("NUM_HISTORY_FIELDS_BY_SOBJECT_EXCEEDED");

	public static final java.lang.String _OPTED_OUT_OF_MASS_MAIL = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("OPTED_OUT_OF_MASS_MAIL");

	public static final java.lang.String _OP_WITH_INVALID_USER_TYPE_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("OP_WITH_INVALID_USER_TYPE_EXCEPTION");

	public static final java.lang.String _PACKAGE_LICENSE_REQUIRED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("PACKAGE_LICENSE_REQUIRED");

	public static final java.lang.String _PORTAL_NO_ACCESS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("PORTAL_NO_ACCESS");

	public static final java.lang.String _PORTAL_USER_ALREADY_EXISTS_FOR_CONTACT = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("PORTAL_USER_ALREADY_EXISTS_FOR_CONTACT");

	public static final java.lang.String _PRIVATE_CONTACT_ON_ASSET = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("PRIVATE_CONTACT_ON_ASSET");

	public static final java.lang.String _QUERY_TIMEOUT = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("QUERY_TIMEOUT");

	public static final java.lang.String _RECORD_IN_USE_BY_WORKFLOW = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("RECORD_IN_USE_BY_WORKFLOW");

	public static final java.lang.String _REQUEST_RUNNING_TOO_LONG = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("REQUEST_RUNNING_TOO_LONG");

	public static final java.lang.String _REQUIRED_FEATURE_MISSING = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("REQUIRED_FEATURE_MISSING");

	public static final java.lang.String _REQUIRED_FIELD_MISSING = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("REQUIRED_FIELD_MISSING");

	public static final java.lang.String _SELF_REFERENCE_FROM_TRIGGER = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("SELF_REFERENCE_FROM_TRIGGER");

	public static final java.lang.String _SHARE_NEEDED_FOR_CHILD_OWNER = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("SHARE_NEEDED_FOR_CHILD_OWNER");

	public static final java.lang.String _SINGLE_EMAIL_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("SINGLE_EMAIL_LIMIT_EXCEEDED");

	public static final java.lang.String _STANDARD_PRICE_NOT_DEFINED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("STANDARD_PRICE_NOT_DEFINED");

	public static final java.lang.String _STORAGE_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("STORAGE_LIMIT_EXCEEDED");

	public static final java.lang.String _STRING_TOO_LONG = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("STRING_TOO_LONG");

	public static final java.lang.String _TABSET_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("TABSET_LIMIT_EXCEEDED");

	public static final java.lang.String _TEMPLATE_NOT_ACTIVE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("TEMPLATE_NOT_ACTIVE");

	public static final java.lang.String _TERRITORY_REALIGN_IN_PROGRESS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("TERRITORY_REALIGN_IN_PROGRESS");

	public static final java.lang.String _TEXT_DATA_OUTSIDE_SUPPORTED_CHARSET = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("TEXT_DATA_OUTSIDE_SUPPORTED_CHARSET");

	public static final java.lang.String _TOO_MANY_APEX_REQUESTS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("TOO_MANY_APEX_REQUESTS");

	public static final java.lang.String _TOO_MANY_ENUM_VALUE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("TOO_MANY_ENUM_VALUE");

	public static final java.lang.String _TRANSFER_REQUIRES_READ = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("TRANSFER_REQUIRES_READ");

	public static final java.lang.String _UNABLE_TO_LOCK_ROW = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("UNABLE_TO_LOCK_ROW");

	public static final java.lang.String _UNAVAILABLE_RECORDTYPE_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("UNAVAILABLE_RECORDTYPE_EXCEPTION");

	public static final java.lang.String _UNDELETE_FAILED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("UNDELETE_FAILED");

	public static final java.lang.String _UNKNOWN_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("UNKNOWN_EXCEPTION");

	public static final java.lang.String _UNSPECIFIED_EMAIL_ADDRESS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("UNSPECIFIED_EMAIL_ADDRESS");

	public static final java.lang.String _UNSUPPORTED_APEX_TRIGGER_OPERATON = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("UNSUPPORTED_APEX_TRIGGER_OPERATON");

	public static final java.lang.String _UNVERIFIED_SENDER_ADDRESS = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("UNVERIFIED_SENDER_ADDRESS");

	public static final java.lang.String _USER_OWNS_PORTAL_ACCOUNT_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("USER_OWNS_PORTAL_ACCOUNT_EXCEPTION");

	public static final java.lang.String _USER_WITH_APEX_SHARES_EXCEPTION = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("USER_WITH_APEX_SHARES_EXCEPTION");

	public static final java.lang.String _WEBLINK_SIZE_LIMIT_EXCEEDED = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("WEBLINK_SIZE_LIMIT_EXCEEDED");

	public static final java.lang.String _WRONG_CONTROLLER_TYPE = org.apache.axis2.databinding.utils.ConverterUtil
			.convertToString("WRONG_CONTROLLER_TYPE");

	public static final StatusCode ALL_OR_NONE_OPERATION_ROLLED_BACK = new StatusCode(
			_ALL_OR_NONE_OPERATION_ROLLED_BACK, true);

	public static final StatusCode ALREADY_IN_PROCESS = new StatusCode(
			_ALREADY_IN_PROCESS, true);

	public static final StatusCode ASSIGNEE_TYPE_REQUIRED = new StatusCode(
			_ASSIGNEE_TYPE_REQUIRED, true);

	public static final StatusCode BAD_CUSTOM_ENTITY_PARENT_DOMAIN = new StatusCode(
			_BAD_CUSTOM_ENTITY_PARENT_DOMAIN, true);

	public static final StatusCode BCC_NOT_ALLOWED_IF_BCC_COMPLIANCE_ENABLED = new StatusCode(
			_BCC_NOT_ALLOWED_IF_BCC_COMPLIANCE_ENABLED, true);

	public static final StatusCode CANNOT_CASCADE_PRODUCT_ACTIVE = new StatusCode(
			_CANNOT_CASCADE_PRODUCT_ACTIVE, true);

	public static final StatusCode CANNOT_CHANGE_FIELD_TYPE_OF_APEX_REFERENCED_FIELD = new StatusCode(
			_CANNOT_CHANGE_FIELD_TYPE_OF_APEX_REFERENCED_FIELD, true);

	public static final StatusCode CANNOT_CREATE_ANOTHER_MANAGED_PACKAGE = new StatusCode(
			_CANNOT_CREATE_ANOTHER_MANAGED_PACKAGE, true);

	public static final StatusCode CANNOT_DEACTIVATE_DIVISION = new StatusCode(
			_CANNOT_DEACTIVATE_DIVISION, true);

	public static final StatusCode CANNOT_DELETE_LAST_DATED_CONVERSION_RATE = new StatusCode(
			_CANNOT_DELETE_LAST_DATED_CONVERSION_RATE, true);

	public static final StatusCode CANNOT_DELETE_MANAGED_OBJECT = new StatusCode(
			_CANNOT_DELETE_MANAGED_OBJECT, true);

	public static final StatusCode CANNOT_DISABLE_LAST_ADMIN = new StatusCode(
			_CANNOT_DISABLE_LAST_ADMIN, true);

	public static final StatusCode CANNOT_ENABLE_IP_RESTRICT_REQUESTS = new StatusCode(
			_CANNOT_ENABLE_IP_RESTRICT_REQUESTS, true);

	public static final StatusCode CANNOT_INSERT_UPDATE_ACTIVATE_ENTITY = new StatusCode(
			_CANNOT_INSERT_UPDATE_ACTIVATE_ENTITY, true);

	public static final StatusCode CANNOT_MODIFY_MANAGED_OBJECT = new StatusCode(
			_CANNOT_MODIFY_MANAGED_OBJECT, true);

	public static final StatusCode CANNOT_RENAME_APEX_REFERENCED_FIELD = new StatusCode(
			_CANNOT_RENAME_APEX_REFERENCED_FIELD, true);

	public static final StatusCode CANNOT_RENAME_APEX_REFERENCED_OBJECT = new StatusCode(
			_CANNOT_RENAME_APEX_REFERENCED_OBJECT, true);

	public static final StatusCode CANNOT_REPARENT_RECORD = new StatusCode(
			_CANNOT_REPARENT_RECORD, true);

	public static final StatusCode CANNOT_UPDATE_CONVERTED_LEAD = new StatusCode(
			_CANNOT_UPDATE_CONVERTED_LEAD, true);

	public static final StatusCode CANT_DISABLE_CORP_CURRENCY = new StatusCode(
			_CANT_DISABLE_CORP_CURRENCY, true);

	public static final StatusCode CANT_UNSET_CORP_CURRENCY = new StatusCode(
			_CANT_UNSET_CORP_CURRENCY, true);

	public static final StatusCode CHILD_SHARE_FAILS_PARENT = new StatusCode(
			_CHILD_SHARE_FAILS_PARENT, true);

	public static final StatusCode CIRCULAR_DEPENDENCY = new StatusCode(
			_CIRCULAR_DEPENDENCY, true);

	public static final StatusCode COMMUNITY_NOT_ACCESSIBLE = new StatusCode(
			_COMMUNITY_NOT_ACCESSIBLE, true);

	public static final StatusCode CUSTOM_CLOB_FIELD_LIMIT_EXCEEDED = new StatusCode(
			_CUSTOM_CLOB_FIELD_LIMIT_EXCEEDED, true);

	public static final StatusCode CUSTOM_ENTITY_OR_FIELD_LIMIT = new StatusCode(
			_CUSTOM_ENTITY_OR_FIELD_LIMIT, true);

	public static final StatusCode CUSTOM_FIELD_INDEX_LIMIT_EXCEEDED = new StatusCode(
			_CUSTOM_FIELD_INDEX_LIMIT_EXCEEDED, true);

	public static final StatusCode CUSTOM_INDEX_EXISTS = new StatusCode(
			_CUSTOM_INDEX_EXISTS, true);

	public static final StatusCode CUSTOM_LINK_LIMIT_EXCEEDED = new StatusCode(
			_CUSTOM_LINK_LIMIT_EXCEEDED, true);

	public static final StatusCode CUSTOM_TAB_LIMIT_EXCEEDED = new StatusCode(
			_CUSTOM_TAB_LIMIT_EXCEEDED, true);

	public static final StatusCode DELETE_FAILED = new StatusCode(
			_DELETE_FAILED, true);

	public static final StatusCode DELETE_OPERATION_TOO_LARGE = new StatusCode(
			_DELETE_OPERATION_TOO_LARGE, true);

	public static final StatusCode DELETE_REQUIRED_ON_CASCADE = new StatusCode(
			_DELETE_REQUIRED_ON_CASCADE, true);

	public static final StatusCode DEPENDENCY_EXISTS = new StatusCode(
			_DEPENDENCY_EXISTS, true);

	public static final StatusCode DUPLICATE_CASE_SOLUTION = new StatusCode(
			_DUPLICATE_CASE_SOLUTION, true);

	public static final StatusCode DUPLICATE_COMM_NICKNAME = new StatusCode(
			_DUPLICATE_COMM_NICKNAME, true);

	public static final StatusCode DUPLICATE_CUSTOM_ENTITY_DEFINITION = new StatusCode(
			_DUPLICATE_CUSTOM_ENTITY_DEFINITION, true);

	public static final StatusCode DUPLICATE_CUSTOM_TAB_MOTIF = new StatusCode(
			_DUPLICATE_CUSTOM_TAB_MOTIF, true);

	public static final StatusCode DUPLICATE_DEVELOPER_NAME = new StatusCode(
			_DUPLICATE_DEVELOPER_NAME, true);

	public static final StatusCode DUPLICATE_EXTERNAL_ID = new StatusCode(
			_DUPLICATE_EXTERNAL_ID, true);

	public static final StatusCode DUPLICATE_MASTER_LABEL = new StatusCode(
			_DUPLICATE_MASTER_LABEL, true);

	public static final StatusCode DUPLICATE_SENDER_DISPLAY_NAME = new StatusCode(
			_DUPLICATE_SENDER_DISPLAY_NAME, true);

	public static final StatusCode DUPLICATE_USERNAME = new StatusCode(
			_DUPLICATE_USERNAME, true);

	public static final StatusCode DUPLICATE_VALUE = new StatusCode(
			_DUPLICATE_VALUE, true);

	public static final StatusCode EMAIL_NOT_PROCESSED_DUE_TO_PRIOR_ERROR = new StatusCode(
			_EMAIL_NOT_PROCESSED_DUE_TO_PRIOR_ERROR, true);

	public static final StatusCode EMPTY_SCONTROL_FILE_NAME = new StatusCode(
			_EMPTY_SCONTROL_FILE_NAME, true);

	public static final StatusCode ENTITY_FAILED_IFLASTMODIFIED_ON_UPDATE = new StatusCode(
			_ENTITY_FAILED_IFLASTMODIFIED_ON_UPDATE, true);

	public static final StatusCode ENTITY_IS_ARCHIVED = new StatusCode(
			_ENTITY_IS_ARCHIVED, true);

	public static final StatusCode ENTITY_IS_DELETED = new StatusCode(
			_ENTITY_IS_DELETED, true);

	public static final StatusCode ENTITY_IS_LOCKED = new StatusCode(
			_ENTITY_IS_LOCKED, true);

	public static final StatusCode ERROR_IN_MAILER = new StatusCode(
			_ERROR_IN_MAILER, true);

	public static final StatusCode EXTERNAL_OBJECT_AUTHENTICATION_EXCEPTION = new StatusCode(
			_EXTERNAL_OBJECT_AUTHENTICATION_EXCEPTION, true);

	public static final StatusCode EXTERNAL_OBJECT_CONNECTION_EXCEPTION = new StatusCode(
			_EXTERNAL_OBJECT_CONNECTION_EXCEPTION, true);

	public static final StatusCode EXTERNAL_OBJECT_EXCEPTION = new StatusCode(
			_EXTERNAL_OBJECT_EXCEPTION, true);

	public static final StatusCode EXTERNAL_OBJECT_UNSUPPORTED_EXCEPTION = new StatusCode(
			_EXTERNAL_OBJECT_UNSUPPORTED_EXCEPTION, true);

	public static final StatusCode FAILED_ACTIVATION = new StatusCode(
			_FAILED_ACTIVATION, true);

	public static final StatusCode FIELD_CUSTOM_VALIDATION_EXCEPTION = new StatusCode(
			_FIELD_CUSTOM_VALIDATION_EXCEPTION, true);

	public static final StatusCode FIELD_FILTER_VALIDATION_EXCEPTION = new StatusCode(
			_FIELD_FILTER_VALIDATION_EXCEPTION, true);

	public static final StatusCode FIELD_INTEGRITY_EXCEPTION = new StatusCode(
			_FIELD_INTEGRITY_EXCEPTION, true);

	public static final StatusCode FILTERED_LOOKUP_LIMIT_EXCEEDED = new StatusCode(
			_FILTERED_LOOKUP_LIMIT_EXCEEDED, true);

	public static final StatusCode HTML_FILE_UPLOAD_NOT_ALLOWED = new StatusCode(
			_HTML_FILE_UPLOAD_NOT_ALLOWED, true);

	public static final StatusCode IMAGE_TOO_LARGE = new StatusCode(
			_IMAGE_TOO_LARGE, true);

	public static final StatusCode INACTIVE_OWNER_OR_USER = new StatusCode(
			_INACTIVE_OWNER_OR_USER, true);

	public static final StatusCode INSUFFICIENT_ACCESS_ON_CROSS_REFERENCE_ENTITY = new StatusCode(
			_INSUFFICIENT_ACCESS_ON_CROSS_REFERENCE_ENTITY, true);

	public static final StatusCode INSUFFICIENT_ACCESS_OR_READONLY = new StatusCode(
			_INSUFFICIENT_ACCESS_OR_READONLY, true);

	public static final StatusCode INVALID_ACCESS_LEVEL = new StatusCode(
			_INVALID_ACCESS_LEVEL, true);

	public static final StatusCode INVALID_ARGUMENT_TYPE = new StatusCode(
			_INVALID_ARGUMENT_TYPE, true);

	public static final StatusCode INVALID_ASSIGNEE_TYPE = new StatusCode(
			_INVALID_ASSIGNEE_TYPE, true);

	public static final StatusCode INVALID_ASSIGNMENT_RULE = new StatusCode(
			_INVALID_ASSIGNMENT_RULE, true);

	public static final StatusCode INVALID_BATCH_OPERATION = new StatusCode(
			_INVALID_BATCH_OPERATION, true);

	public static final StatusCode INVALID_CONTENT_TYPE = new StatusCode(
			_INVALID_CONTENT_TYPE, true);

	public static final StatusCode INVALID_CREDIT_CARD_INFO = new StatusCode(
			_INVALID_CREDIT_CARD_INFO, true);

	public static final StatusCode INVALID_CROSS_REFERENCE_KEY = new StatusCode(
			_INVALID_CROSS_REFERENCE_KEY, true);

	public static final StatusCode INVALID_CROSS_REFERENCE_TYPE_FOR_FIELD = new StatusCode(
			_INVALID_CROSS_REFERENCE_TYPE_FOR_FIELD, true);

	public static final StatusCode INVALID_CURRENCY_CONV_RATE = new StatusCode(
			_INVALID_CURRENCY_CONV_RATE, true);

	public static final StatusCode INVALID_CURRENCY_CORP_RATE = new StatusCode(
			_INVALID_CURRENCY_CORP_RATE, true);

	public static final StatusCode INVALID_CURRENCY_ISO = new StatusCode(
			_INVALID_CURRENCY_ISO, true);

	public static final StatusCode INVALID_DATA_CATEGORY_GROUP_REFERENCE = new StatusCode(
			_INVALID_DATA_CATEGORY_GROUP_REFERENCE, true);

	public static final StatusCode INVALID_DATA_URI = new StatusCode(
			_INVALID_DATA_URI, true);

	public static final StatusCode INVALID_EMAIL_ADDRESS = new StatusCode(
			_INVALID_EMAIL_ADDRESS, true);

	public static final StatusCode INVALID_EMPTY_KEY_OWNER = new StatusCode(
			_INVALID_EMPTY_KEY_OWNER, true);

	public static final StatusCode INVALID_FIELD = new StatusCode(
			_INVALID_FIELD, true);

	public static final StatusCode INVALID_FIELD_FOR_INSERT_UPDATE = new StatusCode(
			_INVALID_FIELD_FOR_INSERT_UPDATE, true);

	public static final StatusCode INVALID_FIELD_WHEN_USING_TEMPLATE = new StatusCode(
			_INVALID_FIELD_WHEN_USING_TEMPLATE, true);

	public static final StatusCode INVALID_FILTER_ACTION = new StatusCode(
			_INVALID_FILTER_ACTION, true);

	public static final StatusCode INVALID_GOOGLE_DOCS_URL = new StatusCode(
			_INVALID_GOOGLE_DOCS_URL, true);

	public static final StatusCode INVALID_ID_FIELD = new StatusCode(
			_INVALID_ID_FIELD, true);

	public static final StatusCode INVALID_INET_ADDRESS = new StatusCode(
			_INVALID_INET_ADDRESS, true);

	public static final StatusCode INVALID_LINEITEM_CLONE_STATE = new StatusCode(
			_INVALID_LINEITEM_CLONE_STATE, true);

	public static final StatusCode INVALID_MASTER_OR_TRANSLATED_SOLUTION = new StatusCode(
			_INVALID_MASTER_OR_TRANSLATED_SOLUTION, true);

	public static final StatusCode INVALID_MESSAGE_ID_REFERENCE = new StatusCode(
			_INVALID_MESSAGE_ID_REFERENCE, true);

	public static final StatusCode INVALID_OPERATION = new StatusCode(
			_INVALID_OPERATION, true);

	public static final StatusCode INVALID_OPERATOR = new StatusCode(
			_INVALID_OPERATOR, true);

	public static final StatusCode INVALID_OR_NULL_FOR_RESTRICTED_PICKLIST = new StatusCode(
			_INVALID_OR_NULL_FOR_RESTRICTED_PICKLIST, true);

	public static final StatusCode INVALID_PACKAGE_VERSION = new StatusCode(
			_INVALID_PACKAGE_VERSION, true);

	public static final StatusCode INVALID_PARTNER_NETWORK_STATUS = new StatusCode(
			_INVALID_PARTNER_NETWORK_STATUS, true);

	public static final StatusCode INVALID_PERSON_ACCOUNT_OPERATION = new StatusCode(
			_INVALID_PERSON_ACCOUNT_OPERATION, true);

	public static final StatusCode INVALID_QUERY_LOCATOR = new StatusCode(
			_INVALID_QUERY_LOCATOR, true);

	public static final StatusCode INVALID_READ_ONLY_USER_DML = new StatusCode(
			_INVALID_READ_ONLY_USER_DML, true);

	public static final StatusCode INVALID_SAVE_AS_ACTIVITY_FLAG = new StatusCode(
			_INVALID_SAVE_AS_ACTIVITY_FLAG, true);

	public static final StatusCode INVALID_SESSION_ID = new StatusCode(
			_INVALID_SESSION_ID, true);

	public static final StatusCode INVALID_SETUP_OWNER = new StatusCode(
			_INVALID_SETUP_OWNER, true);

	public static final StatusCode INVALID_STATUS = new StatusCode(
			_INVALID_STATUS, true);

	public static final StatusCode INVALID_TYPE = new StatusCode(_INVALID_TYPE,
			true);

	public static final StatusCode INVALID_TYPE_FOR_OPERATION = new StatusCode(
			_INVALID_TYPE_FOR_OPERATION, true);

	public static final StatusCode INVALID_TYPE_ON_FIELD_IN_RECORD = new StatusCode(
			_INVALID_TYPE_ON_FIELD_IN_RECORD, true);

	public static final StatusCode IP_RANGE_LIMIT_EXCEEDED = new StatusCode(
			_IP_RANGE_LIMIT_EXCEEDED, true);

	public static final StatusCode LICENSE_LIMIT_EXCEEDED = new StatusCode(
			_LICENSE_LIMIT_EXCEEDED, true);

	public static final StatusCode LIGHT_PORTAL_USER_EXCEPTION = new StatusCode(
			_LIGHT_PORTAL_USER_EXCEPTION, true);

	public static final StatusCode LIMIT_EXCEEDED = new StatusCode(
			_LIMIT_EXCEEDED, true);

	public static final StatusCode MALFORMED_ID = new StatusCode(_MALFORMED_ID,
			true);

	public static final StatusCode MANAGER_NOT_DEFINED = new StatusCode(
			_MANAGER_NOT_DEFINED, true);

	public static final StatusCode MASSMAIL_RETRY_LIMIT_EXCEEDED = new StatusCode(
			_MASSMAIL_RETRY_LIMIT_EXCEEDED, true);

	public static final StatusCode MASS_MAIL_LIMIT_EXCEEDED = new StatusCode(
			_MASS_MAIL_LIMIT_EXCEEDED, true);

	public static final StatusCode MAXIMUM_CCEMAILS_EXCEEDED = new StatusCode(
			_MAXIMUM_CCEMAILS_EXCEEDED, true);

	public static final StatusCode MAXIMUM_DASHBOARD_COMPONENTS_EXCEEDED = new StatusCode(
			_MAXIMUM_DASHBOARD_COMPONENTS_EXCEEDED, true);

	public static final StatusCode MAXIMUM_HIERARCHY_LEVELS_REACHED = new StatusCode(
			_MAXIMUM_HIERARCHY_LEVELS_REACHED, true);

	public static final StatusCode MAXIMUM_SIZE_OF_ATTACHMENT = new StatusCode(
			_MAXIMUM_SIZE_OF_ATTACHMENT, true);

	public static final StatusCode MAXIMUM_SIZE_OF_DOCUMENT = new StatusCode(
			_MAXIMUM_SIZE_OF_DOCUMENT, true);

	public static final StatusCode MAX_ACTIONS_PER_RULE_EXCEEDED = new StatusCode(
			_MAX_ACTIONS_PER_RULE_EXCEEDED, true);

	public static final StatusCode MAX_ACTIVE_RULES_EXCEEDED = new StatusCode(
			_MAX_ACTIVE_RULES_EXCEEDED, true);

	public static final StatusCode MAX_APPROVAL_STEPS_EXCEEDED = new StatusCode(
			_MAX_APPROVAL_STEPS_EXCEEDED, true);

	public static final StatusCode MAX_FORMULAS_PER_RULE_EXCEEDED = new StatusCode(
			_MAX_FORMULAS_PER_RULE_EXCEEDED, true);

	public static final StatusCode MAX_RULES_EXCEEDED = new StatusCode(
			_MAX_RULES_EXCEEDED, true);

	public static final StatusCode MAX_RULE_ENTRIES_EXCEEDED = new StatusCode(
			_MAX_RULE_ENTRIES_EXCEEDED, true);

	public static final StatusCode MAX_TASK_DESCRIPTION_EXCEEEDED = new StatusCode(
			_MAX_TASK_DESCRIPTION_EXCEEEDED, true);

	public static final StatusCode MAX_TM_RULES_EXCEEDED = new StatusCode(
			_MAX_TM_RULES_EXCEEDED, true);

	public static final StatusCode MAX_TM_RULE_ITEMS_EXCEEDED = new StatusCode(
			_MAX_TM_RULE_ITEMS_EXCEEDED, true);

	public static final StatusCode MERGE_FAILED = new StatusCode(_MERGE_FAILED,
			true);

	public static final StatusCode MISSING_ARGUMENT = new StatusCode(
			_MISSING_ARGUMENT, true);

	public static final StatusCode MIXED_DML_OPERATION = new StatusCode(
			_MIXED_DML_OPERATION, true);

	public static final StatusCode NONUNIQUE_SHIPPING_ADDRESS = new StatusCode(
			_NONUNIQUE_SHIPPING_ADDRESS, true);

	public static final StatusCode NO_APPLICABLE_PROCESS = new StatusCode(
			_NO_APPLICABLE_PROCESS, true);

	public static final StatusCode NO_ATTACHMENT_PERMISSION = new StatusCode(
			_NO_ATTACHMENT_PERMISSION, true);

	public static final StatusCode NO_INACTIVE_DIVISION_MEMBERS = new StatusCode(
			_NO_INACTIVE_DIVISION_MEMBERS, true);

	public static final StatusCode NO_MASS_MAIL_PERMISSION = new StatusCode(
			_NO_MASS_MAIL_PERMISSION, true);

	public static final StatusCode NUMBER_OUTSIDE_VALID_RANGE = new StatusCode(
			_NUMBER_OUTSIDE_VALID_RANGE, true);

	public static final StatusCode NUM_HISTORY_FIELDS_BY_SOBJECT_EXCEEDED = new StatusCode(
			_NUM_HISTORY_FIELDS_BY_SOBJECT_EXCEEDED, true);

	public static final StatusCode OPTED_OUT_OF_MASS_MAIL = new StatusCode(
			_OPTED_OUT_OF_MASS_MAIL, true);

	public static final StatusCode OP_WITH_INVALID_USER_TYPE_EXCEPTION = new StatusCode(
			_OP_WITH_INVALID_USER_TYPE_EXCEPTION, true);

	public static final StatusCode PACKAGE_LICENSE_REQUIRED = new StatusCode(
			_PACKAGE_LICENSE_REQUIRED, true);

	public static final StatusCode PORTAL_NO_ACCESS = new StatusCode(
			_PORTAL_NO_ACCESS, true);

	public static final StatusCode PORTAL_USER_ALREADY_EXISTS_FOR_CONTACT = new StatusCode(
			_PORTAL_USER_ALREADY_EXISTS_FOR_CONTACT, true);

	public static final StatusCode PRIVATE_CONTACT_ON_ASSET = new StatusCode(
			_PRIVATE_CONTACT_ON_ASSET, true);

	public static final StatusCode QUERY_TIMEOUT = new StatusCode(
			_QUERY_TIMEOUT, true);

	public static final StatusCode RECORD_IN_USE_BY_WORKFLOW = new StatusCode(
			_RECORD_IN_USE_BY_WORKFLOW, true);

	public static final StatusCode REQUEST_RUNNING_TOO_LONG = new StatusCode(
			_REQUEST_RUNNING_TOO_LONG, true);

	public static final StatusCode REQUIRED_FEATURE_MISSING = new StatusCode(
			_REQUIRED_FEATURE_MISSING, true);

	public static final StatusCode REQUIRED_FIELD_MISSING = new StatusCode(
			_REQUIRED_FIELD_MISSING, true);

	public static final StatusCode SELF_REFERENCE_FROM_TRIGGER = new StatusCode(
			_SELF_REFERENCE_FROM_TRIGGER, true);

	public static final StatusCode SHARE_NEEDED_FOR_CHILD_OWNER = new StatusCode(
			_SHARE_NEEDED_FOR_CHILD_OWNER, true);

	public static final StatusCode SINGLE_EMAIL_LIMIT_EXCEEDED = new StatusCode(
			_SINGLE_EMAIL_LIMIT_EXCEEDED, true);

	public static final StatusCode STANDARD_PRICE_NOT_DEFINED = new StatusCode(
			_STANDARD_PRICE_NOT_DEFINED, true);

	public static final StatusCode STORAGE_LIMIT_EXCEEDED = new StatusCode(
			_STORAGE_LIMIT_EXCEEDED, true);

	public static final StatusCode STRING_TOO_LONG = new StatusCode(
			_STRING_TOO_LONG, true);

	public static final StatusCode TABSET_LIMIT_EXCEEDED = new StatusCode(
			_TABSET_LIMIT_EXCEEDED, true);

	public static final StatusCode TEMPLATE_NOT_ACTIVE = new StatusCode(
			_TEMPLATE_NOT_ACTIVE, true);

	public static final StatusCode TERRITORY_REALIGN_IN_PROGRESS = new StatusCode(
			_TERRITORY_REALIGN_IN_PROGRESS, true);

	public static final StatusCode TEXT_DATA_OUTSIDE_SUPPORTED_CHARSET = new StatusCode(
			_TEXT_DATA_OUTSIDE_SUPPORTED_CHARSET, true);

	public static final StatusCode TOO_MANY_APEX_REQUESTS = new StatusCode(
			_TOO_MANY_APEX_REQUESTS, true);

	public static final StatusCode TOO_MANY_ENUM_VALUE = new StatusCode(
			_TOO_MANY_ENUM_VALUE, true);

	public static final StatusCode TRANSFER_REQUIRES_READ = new StatusCode(
			_TRANSFER_REQUIRES_READ, true);

	public static final StatusCode UNABLE_TO_LOCK_ROW = new StatusCode(
			_UNABLE_TO_LOCK_ROW, true);

	public static final StatusCode UNAVAILABLE_RECORDTYPE_EXCEPTION = new StatusCode(
			_UNAVAILABLE_RECORDTYPE_EXCEPTION, true);

	public static final StatusCode UNDELETE_FAILED = new StatusCode(
			_UNDELETE_FAILED, true);

	public static final StatusCode UNKNOWN_EXCEPTION = new StatusCode(
			_UNKNOWN_EXCEPTION, true);

	public static final StatusCode UNSPECIFIED_EMAIL_ADDRESS = new StatusCode(
			_UNSPECIFIED_EMAIL_ADDRESS, true);

	public static final StatusCode UNSUPPORTED_APEX_TRIGGER_OPERATON = new StatusCode(
			_UNSUPPORTED_APEX_TRIGGER_OPERATON, true);

	public static final StatusCode UNVERIFIED_SENDER_ADDRESS = new StatusCode(
			_UNVERIFIED_SENDER_ADDRESS, true);

	public static final StatusCode USER_OWNS_PORTAL_ACCOUNT_EXCEPTION = new StatusCode(
			_USER_OWNS_PORTAL_ACCOUNT_EXCEPTION, true);

	public static final StatusCode USER_WITH_APEX_SHARES_EXCEPTION = new StatusCode(
			_USER_WITH_APEX_SHARES_EXCEPTION, true);

	public static final StatusCode WEBLINK_SIZE_LIMIT_EXCEEDED = new StatusCode(
			_WEBLINK_SIZE_LIMIT_EXCEEDED, true);

	public static final StatusCode WRONG_CONTROLLER_TYPE = new StatusCode(
			_WRONG_CONTROLLER_TYPE, true);

	public java.lang.String getValue() {
		return localStatusCode;
	}

	public boolean equals(java.lang.Object obj) {
		return (obj == this);
	}

	public int hashCode() {
		return toString().hashCode();
	}

	public java.lang.String toString() {

		return localStatusCode.toString();

	}

	/**
	 * 
	 * @param parentQName
	 * @param factory
	 * @return org.apache.axiom.om.OMElement
	 */
	public org.apache.axiom.om.OMElement getOMElement(
			final javax.xml.namespace.QName parentQName,
			final org.apache.axiom.om.OMFactory factory)
			throws org.apache.axis2.databinding.ADBException {

		org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
				this, MY_QNAME);
		return factory.createOMElement(dataSource, MY_QNAME);

	}

	public void serialize(final javax.xml.namespace.QName parentQName,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException,
			org.apache.axis2.databinding.ADBException {
		serialize(parentQName, xmlWriter, false);
	}

	public void serialize(final javax.xml.namespace.QName parentQName,
			javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
			throws javax.xml.stream.XMLStreamException,
			org.apache.axis2.databinding.ADBException {

		// We can safely assume an element has only one type associated with it

		java.lang.String namespace = parentQName.getNamespaceURI();
		java.lang.String _localName = parentQName.getLocalPart();

		writeStartElement(null, namespace, _localName, xmlWriter);

		// add the type details if this is used in a simple type
		if (serializeType) {
			java.lang.String namespacePrefix = registerPrefix(xmlWriter,
					"urn:partner.soap.sforce.com");
			if ((namespacePrefix != null)
					&& (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						namespacePrefix + ":StatusCode", xmlWriter);
			} else {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						"StatusCode", xmlWriter);
			}
		}

		if (localStatusCode == null) {

			throw new org.apache.axis2.databinding.ADBException(
					"StatusCode cannot be null !!");

		} else {

			xmlWriter.writeCharacters(localStatusCode);

		}

		xmlWriter.writeEndElement();

	}

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("urn:partner.soap.sforce.com")) {
			return "ns1";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * Utility method to write an element start tag.
	 */
	private void writeStartElement(java.lang.String prefix,
			java.lang.String namespace, java.lang.String localPart,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
		if (writerPrefix != null) {
			xmlWriter.writeStartElement(namespace, localPart);
		} else {
			if (namespace.length() == 0) {
				prefix = "";
			} else if (prefix == null) {
				prefix = generatePrefix(namespace);
			}

			xmlWriter.writeStartElement(prefix, localPart, namespace);
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}
	}

	/**
	 * Util method to write an attribute with the ns prefix
	 */
	private void writeAttribute(java.lang.String prefix,
			java.lang.String namespace, java.lang.String attName,
			java.lang.String attValue,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		if (xmlWriter.getPrefix(namespace) == null) {
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}
		xmlWriter.writeAttribute(namespace, attName, attValue);
	}

	/**
	 * Util method to write an attribute without the ns prefix
	 */
	private void writeAttribute(java.lang.String namespace,
			java.lang.String attName, java.lang.String attValue,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		if (namespace.equals("")) {
			xmlWriter.writeAttribute(attName, attValue);
		} else {
			registerPrefix(xmlWriter, namespace);
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}
	}

	/**
	 * Util method to write an attribute without the ns prefix
	 */
	private void writeQNameAttribute(java.lang.String namespace,
			java.lang.String attName, javax.xml.namespace.QName qname,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {

		java.lang.String attributeNamespace = qname.getNamespaceURI();
		java.lang.String attributePrefix = xmlWriter
				.getPrefix(attributeNamespace);
		if (attributePrefix == null) {
			attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
		}
		java.lang.String attributeValue;
		if (attributePrefix.trim().length() > 0) {
			attributeValue = attributePrefix + ":" + qname.getLocalPart();
		} else {
			attributeValue = qname.getLocalPart();
		}

		if (namespace.equals("")) {
			xmlWriter.writeAttribute(attName, attributeValue);
		} else {
			registerPrefix(xmlWriter, namespace);
			xmlWriter.writeAttribute(namespace, attName, attributeValue);
		}
	}

	/**
	 * method to handle Qnames
	 */

	private void writeQName(javax.xml.namespace.QName qname,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		java.lang.String namespaceURI = qname.getNamespaceURI();
		if (namespaceURI != null) {
			java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
			if (prefix == null) {
				prefix = generatePrefix(namespaceURI);
				xmlWriter.writeNamespace(prefix, namespaceURI);
				xmlWriter.setPrefix(prefix, namespaceURI);
			}

			if (prefix.trim().length() > 0) {
				xmlWriter.writeCharacters(prefix
						+ ":"
						+ org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			} else {
				// i.e this is the default namespace
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}

		} else {
			xmlWriter
					.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(qname));
		}
	}

	private void writeQNames(javax.xml.namespace.QName[] qnames,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {

		if (qnames != null) {
			// we have to store this data until last moment since it is not
			// possible to write any
			// namespace data after writing the charactor data
			java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
			java.lang.String namespaceURI = null;
			java.lang.String prefix = null;

			for (int i = 0; i < qnames.length; i++) {
				if (i > 0) {
					stringToWrite.append(" ");
				}
				namespaceURI = qnames[i].getNamespaceURI();
				if (namespaceURI != null) {
					prefix = xmlWriter.getPrefix(namespaceURI);
					if ((prefix == null) || (prefix.length() == 0)) {
						prefix = generatePrefix(namespaceURI);
						xmlWriter.writeNamespace(prefix, namespaceURI);
						xmlWriter.setPrefix(prefix, namespaceURI);
					}

					if (prefix.trim().length() > 0) {
						stringToWrite
								.append(prefix)
								.append(":")
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				} else {
					stringToWrite
							.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
				}
			}
			xmlWriter.writeCharacters(stringToWrite.toString());
		}

	}

	/**
	 * Register a namespace prefix
	 */
	private java.lang.String registerPrefix(
			javax.xml.stream.XMLStreamWriter xmlWriter,
			java.lang.String namespace)
			throws javax.xml.stream.XMLStreamException {
		java.lang.String prefix = xmlWriter.getPrefix(namespace);
		if (prefix == null) {
			prefix = generatePrefix(namespace);
			javax.xml.namespace.NamespaceContext nsContext = xmlWriter
					.getNamespaceContext();
			while (true) {
				java.lang.String uri = nsContext.getNamespaceURI(prefix);
				if (uri == null || uri.length() == 0) {
					break;
				}
				prefix = org.apache.axis2.databinding.utils.BeanUtil
						.getUniquePrefix();
			}
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}
		return prefix;
	}

	/**
	 * databinding method to get an XML representation of this object
	 * 
	 */
	public javax.xml.stream.XMLStreamReader getPullParser(
			javax.xml.namespace.QName qName)
			throws org.apache.axis2.databinding.ADBException {

		// We can safely assume an element has only one type associated with it
		return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
				MY_QNAME,
				new java.lang.Object[] {
						org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
						org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localStatusCode) }, null);

	}

	/**
	 * Factory class that keeps the parse method
	 */
	public static class Factory {

		public static StatusCode fromValue(java.lang.String value)
				throws java.lang.IllegalArgumentException {
			StatusCode enumeration = (StatusCode)

			_table_.get(value);

			if ((enumeration == null)
					&& !((value == null) || (value.equals("")))) {
				enumeration = new StatusCode(value, true);
				// throw new java.lang.IllegalArgumentException();
			}
			return enumeration;
		}

		public static StatusCode fromString(java.lang.String value,
				java.lang.String namespaceURI)
				throws java.lang.IllegalArgumentException {
			try {

				return fromValue(org.apache.axis2.databinding.utils.ConverterUtil
						.convertToString(value));

			} catch (java.lang.Exception e) {
				throw new java.lang.IllegalArgumentException();
			}
		}

		public static StatusCode fromString(
				javax.xml.stream.XMLStreamReader xmlStreamReader,
				java.lang.String content) {
			if (content.indexOf(":") > -1) {
				java.lang.String prefix = content.substring(0,
						content.indexOf(":"));
				java.lang.String namespaceUri = xmlStreamReader
						.getNamespaceContext().getNamespaceURI(prefix);
				return StatusCode.Factory.fromString(content, namespaceUri);
			} else {
				return StatusCode.Factory.fromString(content, "");
			}
		}

		/**
		 * static method to create the object Precondition: If this object is an
		 * element, the current or next start element starts this object and any
		 * intervening reader events are ignorable If this object is not an
		 * element, it is a complex type and the reader is at the event just
		 * after the outer start element Postcondition: If this object is an
		 * element, the reader is positioned at its end element If this object
		 * is a complex type, the reader is positioned at the end element of its
		 * outer element
		 */
		public static StatusCode parse(javax.xml.stream.XMLStreamReader reader)
				throws java.lang.Exception {
			StatusCode object = null;
			// initialize a hash map to keep values
			java.util.Map attributeMap = new java.util.HashMap();
			java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();

			int event;
			java.lang.String nillableValue = null;
			java.lang.String prefix = "";
			java.lang.String namespaceuri = "";
			try {

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				// Note all attributes that were handled. Used to differ normal
				// attributes
				// from anyAttributes.
				java.util.Vector handledAttributes = new java.util.Vector();

				while (!reader.isEndElement()) {
					if (reader.isStartElement() || reader.hasText()) {

						nillableValue = reader.getAttributeValue(
								"http://www.w3.org/2001/XMLSchema-instance",
								"nil");
						if ("true".equals(nillableValue)
								|| "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException(
									"The element: " + "StatusCode"
											+ "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						if (content.indexOf(":") > 0) {
							// this seems to be a Qname so find the namespace
							// and send
							prefix = content.substring(0, content.indexOf(":"));
							namespaceuri = reader.getNamespaceURI(prefix);
							object = StatusCode.Factory.fromString(content,
									namespaceuri);
						} else {
							// this seems to be not a qname send and empty
							// namespace incase of it is
							// check is done in fromString method
							object = StatusCode.Factory.fromString(content, "");
						}

					} else {
						reader.next();
					}
				} // end of while loop

			} catch (javax.xml.stream.XMLStreamException e) {
				throw new java.lang.Exception(e);
			}

			return object;
		}

	}// end of factory class

}

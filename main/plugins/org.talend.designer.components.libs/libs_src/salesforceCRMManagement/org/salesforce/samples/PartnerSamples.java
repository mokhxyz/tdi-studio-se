package org.salesforce.samples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;

import javax.xml.rpc.ServiceException;

import org.apache.axis.message.MessageElement;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

import com.salesforce.soap.partner.DeleteResult;
import com.salesforce.soap.partner.DescribeGlobalResult;
import com.salesforce.soap.partner.DescribeGlobalSObjectResult;
import com.salesforce.soap.partner.DescribeLayout;
import com.salesforce.soap.partner.DescribeLayoutItem;
import com.salesforce.soap.partner.DescribeLayoutResult;
import com.salesforce.soap.partner.DescribeLayoutRow;
import com.salesforce.soap.partner.DescribeLayoutSection;
import com.salesforce.soap.partner.DescribeSObjectResult;
import com.salesforce.soap.partner.DescribeSoftphoneLayoutCallType;
import com.salesforce.soap.partner.DescribeSoftphoneLayoutInfoField;
import com.salesforce.soap.partner.DescribeSoftphoneLayoutItem;
import com.salesforce.soap.partner.DescribeSoftphoneLayoutResult;
import com.salesforce.soap.partner.DescribeSoftphoneLayoutSection;
import com.salesforce.soap.partner.DescribeTab;
import com.salesforce.soap.partner.DescribeTabSetResult;
import com.salesforce.soap.partner.Field;
import com.salesforce.soap.partner.FieldType;
import com.salesforce.soap.partner.GetDeletedResult;
import com.salesforce.soap.partner.GetUpdatedResult;
import com.salesforce.soap.partner.GetUserInfoResult;
import com.salesforce.soap.partner.LeadConvert;
import com.salesforce.soap.partner.LeadConvertResult;
import com.salesforce.soap.partner.LoginResult;
import com.salesforce.soap.partner.MergeRequest;
import com.salesforce.soap.partner.MergeResult;
import com.salesforce.soap.partner.PicklistEntry;
import com.salesforce.soap.partner.ProcessRequest;
import com.salesforce.soap.partner.ProcessResult;
import com.salesforce.soap.partner.ProcessSubmitRequest;
import com.salesforce.soap.partner.ProcessWorkitemRequest;
import com.salesforce.soap.partner.QueryOptions;
import com.salesforce.soap.partner.QueryResult;
import com.salesforce.soap.partner.ResetPasswordResult;
import com.salesforce.soap.partner.SaveResult;
import com.salesforce.soap.partner.SearchRecord;
import com.salesforce.soap.partner.SearchResult;
import com.salesforce.soap.partner.SessionHeader;
import com.salesforce.soap.partner.SetPasswordResult;
import com.salesforce.soap.partner.SforceServiceLocator;
import com.salesforce.soap.partner.SoapBindingStub;
import com.salesforce.soap.partner.UndeleteResult;
import com.salesforce.soap.partner.UpsertResult;
import com.salesforce.soap.partner.fault.ApiFault;
import com.salesforce.soap.partner.fault.InvalidQueryLocatorFault;
import com.salesforce.soap.partner.fault.LoginFault;
import com.salesforce.soap.partner.fault.UnexpectedErrorFault;
import com.salesforce.soap.partner.sobject.SObject;

/**
 * <p>
 * Title: sforce Login Sample
 * </p>
 * <p>
 * Description: Console application illustrating login, session management and server redirection.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: salesforce.com
 * </p>
 * 
 * @author Dave Carroll
 * @version 4.0
 */

public class PartnerSamples {

    private SoapBindingStub binding;

    private LoginResult loginResult = null;

    private String un = "";

    private String pw = "";

    private boolean loggedIn = false;

    private GetUserInfoResult userInfo = null;

    private String[] accounts = null;

    private String[] contacts = null;

    private String[] tasks = null;

    private boolean logOn = false;

    static BufferedReader rdr = new BufferedReader(new java.io.InputStreamReader(System.in));

    public PartnerSamples() {
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        PartnerSamples samples1 = new PartnerSamples();
        samples1.run();
    }

    /*
     * Simple helper for getting user input from console
     */
    String getUserInput(String prompt) {
        System.out.print(prompt);
        try {
            return rdr.readLine();
        } catch (IOException ex) {
            return null;
        }
    }

    /*
     * login sample Prompts for username and password, set class variable binding resets the url for the binding and
     * adds the session header to the binding class variable
     */
    private boolean login() {
        un = getUserInput("Enter user name: ");
        if (un.length() == 0) {
            return false;
        }
        pw = getUserInput("Enter password: ");
        if (pw.length() == 0) {
            return false;
        }

        // Provide feed back while we create the web service binding
        System.out.println("Creating the binding to the web service...");

        /*
         * There are 2 ways to get the binding, one by passing a url to the getSoap() method of the
         * SforceServiceLocator, the other by not passing a url. In the second case the binding will use the url
         * contained in the wsdl file when the proxy was generated.
         */
        try {
            binding = (SoapBindingStub) new SforceServiceLocator().getSoap();
        } catch (ServiceException ex) {
            System.out.println("ERROR: createing binding to soap service, error was: \n" + ex.getMessage());
            System.out.print("Hit return to continue...");
            return false;
        }

        // Time out after a minute
        binding.setTimeout(60000);

        // binding._setProperty(Stub.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/services/Soap/u/8.0");

        // Attempt the login giving the user feedback
        System.out.println("LOGGING IN NOW....");
        try {
            loginResult = binding.login(un, pw);
        } catch (LoginFault lf) {
            System.out.println(lf.getExceptionMessage());
            // lf.printStackTrace();
            getUserInput("\nHit return to continue...");
            return false;
        } catch (ApiFault af) {
            System.out.println(af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (RemoteException re) {
            System.out.println(re.getMessage());
            re.printStackTrace();
            getUserInput("\nHit return to continue...");
            return false;
        }

        System.out.println("\nThe session id is: " + loginResult.getSessionId());
        System.out.println("\nThe new server url is: " + loginResult.getServerUrl());

        binding._setProperty(SoapBindingStub.ENDPOINT_ADDRESS_PROPERTY, loginResult.getServerUrl());

        // binding._setProperty(Stub.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/services/Soap/u/8.0");

        // Create a new session header object and set the session id to that
        // returned by the login
        SessionHeader sh = new SessionHeader();
        sh.setSessionId(loginResult.getSessionId());
        binding.setHeader(new SforceServiceLocator().getServiceName().getNamespaceURI(), "SessionHeader", sh);

        loggedIn = true;

        // call the getServerTimestamp method
        getServerTimestampSample();

        // call the getUserInfo method
        getUserInfoSample();

        return true;

    }

    private void getUserInfoSample() {
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            System.out.println("\nGetting user info...");
            userInfo = binding.getUserInfo();
            System.out.println("User Name: " + userInfo.getUserFullName());
            System.out.println("User Email: " + userInfo.getUserEmail());
            System.out.println("User Language: " + userInfo.getUserLanguage());
            System.out.println("User Organization: " + userInfo.getOrganizationName());
        } catch (ApiFault af) {
            System.out.println("ERROR: getting user info.\n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (RemoteException ex) {
            System.out.println("ERROR: getting user info.\n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
    }

    private void getServerTimestampSample() {
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        System.out.println("\nGetting server's timestamp...");
        try {
            Calendar cal = binding.getServerTimestamp().getTimestamp();
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
            df.setCalendar(cal);
            System.out.println("Time stamp on server: " + df.format(cal.getTime()));
        } catch (ApiFault af) {
            System.out.println("ERROR: getting server timestamp.\n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (RemoteException ex2) {
            System.out.println("ERROR: getting server timestamp.\n" + ex2.getMessage());
            getUserInput("\nHit return to continue...");
        }

    }

    private void describeLayoutSample() {
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        String objectToDescribe = getUserInput("Enter the name of an object to describe the layout of: ");
        try {
            DescribeLayoutResult dlr = binding.describeLayout(objectToDescribe, null);
            System.out.println("There are " + dlr.getLayouts().length + " layouts for the " + objectToDescribe + " object.");
            for (int i = 0; i < dlr.getLayouts().length; i++) {
                DescribeLayout layout = dlr.getLayouts(i);
                System.out.println("    There are " + layout.getDetailLayoutSections().length + " detail layout sections");
                for (int j = 0; j < layout.getDetailLayoutSections().length; j++) {
                    DescribeLayoutSection dls = layout.getDetailLayoutSections(j);
                    System.out.println(new Integer(j).toString() + "        This section has a heading of " + dls.getHeading());
                }
                if (layout.getEditLayoutSections() != null) {
                    System.out.println("    There are " + layout.getEditLayoutSections().length + " edit layout sections");
                    for (int j = 0; j < layout.getEditLayoutSections().length; j++) {
                        DescribeLayoutSection els = layout.getEditLayoutSections(j);
                        System.out.println(new Integer(j).toString() + "        This section has a heading of "
                                + els.getHeading());
                        System.out.println("This section has " + els.getLayoutRows().length + " layout rows.");
                        for (int k = 0; k < els.getLayoutRows().length; k++) {
                            DescribeLayoutRow lr = els.getLayoutRows(k);
                            System.out.println("            This row has " + lr.getNumItems() + " items.");
                            for (int h = 0; h < lr.getLayoutItems().length; h++) {
                                DescribeLayoutItem li = lr.getLayoutItems(h);
                                if (li.getLayoutComponents() != null) {
                                    System.out.println("                " + new Integer(h).toString() + " "
                                            + li.getLayoutComponents(0).getValue());
                                } else {
                                    System.out.println("                " + new Integer(h).toString());
                                }
                            }
                        }
                    }
                }
            }
            if (dlr.getRecordTypeMappings() != null) {
                System.out.println("There are " + dlr.getRecordTypeMappings().length + " record type mappings for the "
                        + objectToDescribe + " object");
            } else {
                System.out.println("There are not record type mappings for the " + objectToDescribe + " object.");
            }
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("\nFailed to describe layout for: " + objectToDescribe + ", error message was: \n"
                    + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to describe layout for: " + objectToDescribe + ", error message was: \n"
                    + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
    }

    private void describeTabsSample() {
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            DescribeTabSetResult[] dtsrs = binding.describeTabs();

            System.out.println("There are " + new Integer(dtsrs.length).toString() + " tabsets defined.");
            for (int i = 0; i < dtsrs.length; i++) {
                System.out.println("Tabset " + new Integer(i + 1).toString() + ":");
                DescribeTabSetResult dtsr = dtsrs[i];
                String tabSetLabel = dtsr.getLabel();
                String logoUrl = dtsr.getLogoUrl();
                boolean isSelected = dtsr.isSelected();
                DescribeTab[] tabs = dtsr.getTabs();
                System.out.println("Label is " + tabSetLabel + " logo url is " + logoUrl + ", there are "
                        + new Integer(tabs.length) + " tabs defined in this set.");
                for (int j = 0; j < tabs.length; j++) {
                    DescribeTab tab = tabs[j];
                    String tabLabel = tab.getLabel();
                    String objectName = tab.getSobjectName();
                    String tabUrl = tab.getUrl();
                    System.out.println("\tTab " + new Integer(j + 1) + ": \n\t\tLabel = " + tabLabel
                            + "\n\t\tObject details on tab: " + objectName + "\n\t\t" + "Url to tab: " + tabUrl);
                }
            }
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("Failed to successfully describe tabs.\n\n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("Failed to successfully describe tabs.\n\n" + ex.getMessage());
            getUserInput("\nHit return to continue...");

        }
    }

    private void describeGlobalSample() {
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            DescribeGlobalResult describeGlobalResult = binding.describeGlobal();
            if (!(describeGlobalResult == null)) {
                // String[] types = describeGlobalResult.getTypes();
                // if (!(types == null)) {
                // for (int i = 0; i < types.length; i++) {
                // System.out.println(types[i]);
                // }
                // getUserInput("\nDescribe global was successful.\n\nHit the enter key to conutinue....");
                // }
                DescribeGlobalSObjectResult[] sobjects = describeGlobalResult.getSobjects();
                if (!(sobjects == null)) {
                    for (int i = 0; i < sobjects.length; i++) {
                        System.out.println(sobjects[i].getName());
                    }
                    getUserInput("\nDescribe global was successful.\n\nHit the enter key to conutinue....");
                }
            }
        } catch (ApiFault af) {
            System.out.println("\nFailed to return types, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to return types, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
    }

    private void describeSObjectsSample() {
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            DescribeSObjectResult[] describeSObjectResults = binding
                    .describeSObjects(new String[] { "account", "contact", "lead" });
            for (int x = 0; x < describeSObjectResults.length; x++) {
                DescribeSObjectResult describeSObjectResult = describeSObjectResults[x];
                // Retrieve fields from the results
                Field[] fields = describeSObjectResult.getFields();
                // Get the name of the object
                String objectName = describeSObjectResult.getName();
                // Get some flags
                boolean isActivateable = describeSObjectResult.isActivateable();
                // Many other values are accessible
                if (fields != null) {
                    // Iterate through the fields to get properties for each
                    // field
                    for (int i = 0; i < fields.length; i++) {
                        Field field = fields[i];
                        int byteLength = field.getByteLength();
                        int digits = field.getDigits();
                        String label = field.getLabel();
                        int length = field.getLength();
                        String name = field.getName();
                        PicklistEntry[] picklistValues = field.getPicklistValues();
                        int precision = field.getPrecision();
                        String[] referenceTos = field.getReferenceTo();
                        int scale = field.getScale();
                        FieldType fieldType = field.getType();
                        boolean fieldIsCreateable = field.isCreateable();
                        // Determine whether there are picklist values
                        if (picklistValues != null && picklistValues[0] != null) {
                            System.out.println("Picklist values = ");
                            for (int j = 0; j < picklistValues.length; j++) {
                                if (picklistValues[j].getLabel() != null) {
                                    System.out.println(" Item: " + picklistValues[j].getLabel());
                                }
                            }
                        }
                        // Determine whether this field refers to another object
                        if (referenceTos != null && referenceTos[0] != null) {
                            System.out.println("Field references the following objects:");
                            for (int j = 0; j < referenceTos.length; j++) {
                                System.out.println(" " + referenceTos[j]);
                            }
                        }
                    }
                }
            }
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("\nFailed to get describe multiple objects, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to get describe multiple objects, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
    }

    private void describeSample() {

        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }
        String objectToDescribe = getUserInput("\nType the name of the object to describe (try Account): ");
        try {
            DescribeSObjectResult ds;
            DescribeSObjectResult describeSObjectResult = binding.describeSObject(objectToDescribe);
            if (!(describeSObjectResult == null)) {
                Field[] fields = describeSObjectResult.getFields();
                String objectName = describeSObjectResult.getName();
                boolean isActivateable = describeSObjectResult.isActivateable();
                boolean isCreateable = describeSObjectResult.isCreateable();
                boolean isCustom = describeSObjectResult.isCustom();
                boolean isDeleteable = describeSObjectResult.isDeletable();
                boolean isQueryable = describeSObjectResult.isQueryable();
                boolean isReplicateable = describeSObjectResult.isReplicateable();
                boolean isRetrieveable = describeSObjectResult.isRetrieveable();
                boolean isSearchable = describeSObjectResult.isSearchable();
                boolean isUndeleteable = describeSObjectResult.isUndeletable();
                boolean isUpdateable = describeSObjectResult.isUpdateable();
                System.out.println("Metadata for " + objectToDescribe + " object:\n");
                System.out.println("Object name                       = " + objectName);
                System.out.println("Number of fields                  = " + fields.length);
                System.out.println("Object can be activated           = " + isActivateable);
                System.out.println("Can create rows of data           = " + isCreateable);
                System.out.println("Object is custom object           = " + isCustom);
                System.out.println("Can delete rows of data           = " + isDeleteable);
                System.out.println("Can query for rows of data        = " + isQueryable);
                System.out.println("Object can be used in replication = " + isReplicateable);
                System.out.println("Can use retrieve method on object = " + isRetrieveable);
                System.out.println("Can use search method on object   = " + isSearchable);
                System.out.println("Can un-delete rows of data        = " + isUndeleteable);
                System.out.println("Can update rows of data           = " + isUpdateable);
                System.out.println("\nField metadata for " + objectToDescribe + " object:\n");

                if (!(fields == null)) {
                    for (int i = 0; i < fields.length; i++) {
                        Field field = fields[i];
                        int byteLength = field.getByteLength();
                        int digits = field.getDigits();
                        String label = field.getLabel();
                        int length = field.getLength();
                        String name = field.getName();
                        PicklistEntry[] picklistValues = field.getPicklistValues();
                        int precision = field.getPrecision();
                        String[] referenceTos = field.getReferenceTo();
                        int scale = field.getScale();
                        FieldType fieldType = field.getType();
                        boolean fieldIsAutoNumber = field.isAutoNumber();
                        boolean fieldIsCreateable = field.isCreateable();
                        boolean fieldIsCustom = field.isCustom();
                        boolean fieldIsDefaultedOnCreate = field.isDefaultedOnCreate();
                        boolean fieldIsFilterable = field.isFilterable();
                        boolean fieldIsNillable = field.isNillable();
                        boolean fieldIsRestrictedPicklist = field.isRestrictedPicklist();
                        boolean fieldIsUpdateable = field.isUpdateable();
                        System.out.println("*************  New Field  ***************");
                        System.out.println("Name            = " + name);
                        System.out.println("Label           = " + label);
                        System.out.println("Length          = " + length);
                        System.out.println("Bytelength      = " + byteLength);
                        System.out.println("Digits          = " + digits);
                        System.out.println("Precision       = " + precision);
                        System.out.println("Scale           = " + scale);
                        System.out.println("Field type      = " + fieldType);
                        if (picklistValues != null) {
                            System.out.println("Picklist values = ");
                            for (int j = 0; j < picklistValues.length; j++) {
                                if (picklistValues[j].getLabel() != null) {
                                    System.out.println("    Item:  " + picklistValues[j].getLabel());
                                } else {
                                    System.out.println("    Item:  " + picklistValues[j].getValue());
                                }
                                System.out.println("        value           = " + picklistValues[j].getValue());
                                System.out.println("        is default      = " + picklistValues[j].isDefaultValue());
                            }
                        }
                        if (referenceTos != null) {
                            System.out.println("Field references the following objects:");
                            for (int j = 0; j < referenceTos.length; j++) {
                                System.out.println("    " + referenceTos[j]);
                            }
                        }
                        System.out.println("\n");
                    }
                    getUserInput("\nDescribe " + objectToDescribe + " was successful.\n\nHit the enter key to conutinue....");
                }
            }
        } catch (ApiFault af) {
            System.out.println("\nFailed to get " + objectToDescribe + " description, error message was: \n"
                    + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to get " + objectToDescribe + " description, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
    }

    private MessageElement newMessageElement(String name, Object value) throws Exception {

        MessageElement me = new MessageElement("", name); // , value);
        me.setObjectValue(value);
        Element e = me.getAsDOM();
        e.removeAttribute("xsi:type");
        e.removeAttribute("xmlns:ns1");
        e.removeAttribute("xmlns:xsd");
        e.removeAttribute("xmlns:xsi");

        me = new MessageElement(e);
        return me;
    }

    private void createAccountSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            SObject[] accs = new SObject[2];
            for (int j = 0; j < accs.length; j++) {
                MessageElement[] account = new MessageElement[14];
                int index = 0;
                if (accounts == null) {
                    account[index++] = newMessageElement("AccountNumber", "00000000");
                } else {
                    account[index++] = newMessageElement("AccountNumber", "000000" + (accounts.length + 1));
                }
                account[index++] = newMessageElement("BillingCity", "Wichita");
                account[index++] = newMessageElement("BillingCountry", "US");
                account[index++] = newMessageElement("BillingState", "KA");
                account[index++] = newMessageElement("BillingStreet", "4322 Haystack Boulevard");
                account[index++] = newMessageElement("BillingPostalCode", "87901");
                account[index++] = newMessageElement("Description", "World class hay makers.");
                account[index++] = newMessageElement("Fax", "555.555.5555");
                account[index++] = newMessageElement("Industry", "Farming");
                account[index++] = newMessageElement("Name", "Golden Straw");
                account[index++] = newMessageElement("NumberOfEmployees", new java.lang.Integer(40).toString());
                account[index++] = newMessageElement("Ownership", "Privately Held");
                account[index++] = newMessageElement("Phone", "666.666.6666");
                account[index++] = newMessageElement("Website", "www.oz.com");
                accs[j] = new SObject();
                accs[j].set_any(account);
                accs[j].setType("Account");
                accs[j + 1] = accs[j];
                j++;
            }

            // create the object(s) by sending the array to the web service
            SaveResult[] sr = binding.create(accs);
            for (int j = 0; j < sr.length; j++) {
                if (sr[j].isSuccess()) {
                    System.out.println("An account was create with an id of: " + sr[j].getId());

                    // save the account ids in a class array
                    if (accounts == null) {
                        accounts = new String[] { sr[j].getId() };
                    } else {
                        String[] tempAccounts = null;
                        tempAccounts = new String[accounts.length + 1];
                        for (int i = 0; i < accounts.length; i++) {
                            tempAccounts[i] = accounts[i];
                        }
                        tempAccounts[accounts.length] = sr[j].getId();
                        accounts = tempAccounts;
                    }
                } else {
                    // there were errors during the create call, go through the
                    // errors
                    // array and write them to the screen
                    for (int i = 0; i < sr[j].getErrors().length; i++) {
                        // get the next error
                        com.salesforce.soap.partner.Error err = sr[j].getErrors()[i];
                        System.out.println("Errors were found on item " + new Integer(j).toString());
                        System.out.println("Error code is: " + err.getStatusCode().toString());
                        System.out.println("Error message: " + err.getMessage());
                    }
                }
            }
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("\nFailed to create account, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("\nFailed to create account, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }

    }

    private ArrayList loadQueryResults(QueryResult qr) {
        ArrayList returnVal = new ArrayList();
        if (qr.getSize() > 0) {
            boolean keepLooping = true;
            while (keepLooping) {
                for (int i = 0; i < qr.getRecords().length; i++) {
                    MessageElement[] records = qr.getRecords(i).get_any();
                    HashMap fields = new HashMap();
                    if (qr.getRecords(i).getId() != null)
                        fields.put("id", qr.getRecords(i).getId());
                    for (int j = 0; j < records.length; j++) {
                        MessageElement record = records[j];
                        if (!fields.containsKey(record.getName()))
                            fields.put(record.getName().toLowerCase(), record);
                    }
                    returnVal.add(fields);
                }
                if (qr.isDone())
                    keepLooping = false;
                else
                    try {
                        qr = binding.queryMore(qr.getQueryLocator());
                    } catch (InvalidQueryLocatorFault e) {
                        System.out.println("\nFailed to query, error message was: \n" + e.getExceptionMessage());
                        getUserInput("\nHit return to continue...");
                    } catch (ApiFault af) {
                        System.out.println("\nFailed to query, error message was: \n" + af.getExceptionMessage());
                        getUserInput("\nHit return to continue...");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        getUserInput("\nHit return to continue...");
                    }
            }
        }
        return returnVal;
    }

    private String getFieldValue(MessageElement[] value, String name) {
        for (int i = 0; i < value.length; i++) {
            if (value[i].getName().toLowerCase().equals(name.toLowerCase()))
                return value[i].getValue();
        }
        return "";
    }

    private void querySample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        QueryResult qr = null;
        QueryOptions qo = new QueryOptions();
        qo.setBatchSize(new Integer(3));
        binding.setHeader(new SforceServiceLocator().getServiceName().getNamespaceURI(), "QueryOptions", qo);

        try {
            qr = binding.query("select id, Website, Name from Account where Name = 'Golden Straw'");
            ArrayList records = this.loadQueryResults(qr);
            if (records.size() != 0) {
                HashMap record = (HashMap) records.get(0);
                System.out.println("Retrieved " + new Integer(records.size()).toString()
                        + " account(s) using Name = 'Golden Straw', String = "
                        + (record.containsKey("id") ? record.get("id").toString() : " ").toString() + ", website = "
                        + (record.containsKey("website") ? record.get("website").toString() : " ").toString());
            }
            // if (qr.getSize() != 0) {
            // SObject account = qr.getRecords()[0];
            //
            // System.out.println("Retrieved "
            // + new Integer(qr.getSize()).toString()
            // + " account(s) using Name = 'Golden Straw', String = "
            // + account.getId() + ", website = "
            // + account.get_any()[1]);
            // }

            qr = binding.query("select FirstName, LastName from Contact");
            int loopCount = 0;
            boolean continueLoop = true;
            while (continueLoop) {
                System.out.println("Results set " + new Integer(loopCount++).toString() + " - ");
                // process the query results
                for (int i = 0; i < qr.getRecords().length; i++) {
                    SObject con = qr.getRecords()[i];
                    String fName = "";
                    String lName = "";
                    if (con.get_any()[0].getName().toLowerCase().equals("firstname")) {
                        fName = con.get_any()[0].getValue();
                        lName = con.get_any()[1].getValue();
                    } else
                        lName = con.get_any()[0].getValue();

                    if (fName == null) {
                        System.out.println("Contact " + (i + 1) + ": " + lName);
                    } else {
                        System.out.println("Contact " + (i + 1) + ": " + fName + " " + lName);
                    }
                }
                // handle the loop + 1 problem by checking to see if the most
                // recent queryResult
                if (qr.isDone())
                    continueLoop = false;
                else
                    qr = binding.queryMore(qr.getQueryLocator());
            }
            System.out.println("\nQuery succesfully executed.");
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("\nFailed to execute query succesfully, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to execute query succesfully, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }

    }

    private void searchSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        SearchResult sr = null;
        QueryResult qr = null;
        try {
            sr = binding
                    .search("find {4159017000} in phone fields returning contact(id, phone, firstname, lastname), lead(id, phone, firstname, lastname), account(id, phone, name)");
            SearchRecord[] records = sr.getSearchRecords();
            Vector contacts = new Vector();
            Vector leads = new Vector();
            Vector accounts = new Vector();

            if (records != null && records.length > 0) {
                for (int i = 0; i < records.length; i++) {
                    SObject record = records[i].getRecord();
                    if (record.getType().toLowerCase().equals("contact")) {
                        contacts.add(record);
                    } else if (record.getType().toLowerCase().equals("lead")) {
                        leads.add(record);
                    } else if (record.getType().toLowerCase().equals("account")) {
                        accounts.add(record);
                    }
                }
                if (contacts.size() > 0) {
                    System.out.println("Found " + new Integer(contacts.size()).toString() + " contacts:");
                    for (int i = 0; i < contacts.size(); i++) {
                        SObject c = (SObject) contacts.get(i);
                        System.out.println(c.getId() + " - " + c.get_any()[1] + " " + c.get_any()[2] + " - " + c.get_any()[0]);
                    }
                }
                if (leads.size() > 0) {
                    System.out.println("Found " + new Integer(leads.size()).toString() + " leads:");
                    for (int i = 0; i < leads.size(); i++) {
                        SObject l = (SObject) leads.get(i);
                        System.out.println(l.getId() + " - " + l.get_any()[1] + " " + l.get_any()[2] + " - " + l.get_any()[0]);
                    }
                }
                if (accounts.size() > 0) {
                    System.out.println("Found " + new Integer(accounts.size()).toString() + " accounts:");
                    for (int i = 0; i < accounts.size(); i++) {
                        SObject a = (SObject) accounts.get(i);
                        System.out.println(a.getId() + " - " + a.get_any()[1] + " - " + a.get_any()[0]);
                    }
                }
            } else {
                System.out.println("No records were found for the search.");
            }

            System.out.println("\nSearch succesfully executed.");
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("\nFailed to execute search succesfully, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to execute search succesfully, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }

    }

    private void getDeletedSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            // Calendar deletedDate
            GregorianCalendar cal = (GregorianCalendar) binding.getServerTimestamp().getTimestamp();
            GregorianCalendar calEnd = (GregorianCalendar) cal.clone();
            cal.add(GregorianCalendar.MINUTE, -5);

            GetDeletedResult mr = binding.getDeleted("Contact", cal, calEnd);
            if (mr.getDeletedRecords() != null) {
                for (int i = 0; i < mr.getDeletedRecords().length; i++) {
                    System.out.println(mr.getDeletedRecords(i).getId()

                    + " was deleted on " + mr.getDeletedRecords(i).getDeletedDate().getTime().toString());
                }
            } else {
                System.out.println("No deletions from contacts in the last 5 minutes.");
            }
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("\nFailed to get deleted records, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to get deleted records, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
    }

    private void getUpdatedSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            // Calendar deletedDate
            GregorianCalendar cal = (GregorianCalendar) binding.getServerTimestamp().getTimestamp();
            GregorianCalendar calEnd = (GregorianCalendar) cal.clone();
            cal.add(GregorianCalendar.MINUTE, -5);

            GetUpdatedResult mr = binding.getUpdated("Account", cal, calEnd);
            if (mr.getIds() != null && mr.getIds().length > 0) {
                for (int i = 0; i < mr.getIds().length; i++) {
                    System.out.println(mr.getIds(i) + " was updated.");
                }
            } else {
                System.out.println("No updates to accounts in the last 5 minutes.");
            }
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("\nFailed to get updated records, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to get updated records, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
    }

    private void createContactSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {

            SObject[] cons = new SObject[2];
            MessageElement[] contact;
            for (int j = 0; j < cons.length; j++) {
                int index = 0;
                if (accounts != null) {
                    contact = new MessageElement[18];
                    contact[index++] = newMessageElement("AccountId", accounts[0]);
                } else {
                    contact = new MessageElement[17];
                }
                contact[index++] = newMessageElement("AssistantName", "Jane");
                contact[index++] = newMessageElement("AssistantPhone", "777.777.7777");
                contact[index++] = newMessageElement("Department", "Purchasing");
                contact[index++] = newMessageElement("Description", "International IT Purchaser");
                contact[index++] = newMessageElement("Email", "joeblow@isp.com");
                contact[index++] = newMessageElement("Fax", "555.555.5555");
                contact[index++] = newMessageElement("MailingCity", "San Mateo");
                contact[index++] = newMessageElement("MailingCountry", "US");
                contact[index++] = newMessageElement("MailingState", "CA");
                contact[index++] = newMessageElement("MailingStreet", "1129 B Street");
                contact[index++] = newMessageElement("MailingPostalCode", "94105");
                contact[index++] = newMessageElement("MobilePhone", "888.888.8888");
                contact[index++] = newMessageElement("FirstName", "Joe");
                contact[index++] = newMessageElement("LastName", "Blow");
                contact[index++] = newMessageElement("Salutation", "Mr.");
                contact[index++] = newMessageElement("Phone", "999.999.9999");
                contact[index++] = newMessageElement("Title", "Purchasing Director");
                cons[j] = new SObject();
                cons[j].setType("Contact");
                cons[j].set_any(contact);
            }

            SaveResult[] sr = binding.create(cons);
            for (int j = 0; j < sr.length; j++) {
                if (sr[j].isSuccess()) {
                    System.out.println("A contact was create with an id of: " + sr[j].getId());
                    if (accounts != null) {
                        System.out.println(" - the contact was associated with the account you created with an id of "
                                + accounts[0] + ".");

                    }

                    if (contacts == null) {
                        contacts = new String[] { sr[j].getId() };
                    } else {
                        String[] tempContacts = null;
                        tempContacts = new String[contacts.length + 1];
                        for (int i = 0; i < contacts.length; i++) {
                            tempContacts[i] = contacts[i];
                        }
                        tempContacts[contacts.length] = sr[j].getId();
                        contacts = tempContacts;
                    }
                } else {
                    // there were errors during the create call, go through the
                    // errors
                    // array and write them to the screen
                    for (int i = 0; i < sr[j].getErrors().length; i++) {
                        // get the next error
                        com.salesforce.soap.partner.Error err = sr[j].getErrors()[i];
                        System.out.println("Errors were found on item " + new Integer(j).toString());
                        System.out.println("Error code is: " + err.getStatusCode().toString());
                        System.out.println("Error message: " + err.getMessage());
                    }
                }
            }
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("\nFailed to create contacts, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to create contacts, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
    }

    private void updateAccountSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            // check to see if there are any accounts created in this session
            if (accounts == null) {
                System.out
                        .println("\nUpdate operation not completed.  You will need to create an account during this session to run the update sample.");
                getUserInput("\nHit return to continue...");
                return;
            }

            // create the account object to hold our changes
            SObject updateAccount = new SObject();
            updateAccount.setType("Account");
            // need to have the id so that web service knows which account to
            // update
            updateAccount.setId(accounts[0]);
            // set a new value for the name property
            MessageElement[] ufields = new MessageElement[1];
            ufields[0] = newMessageElement("Name", "New Account Name from Update Sample");
            updateAccount.set_any(ufields);

            // create one that will throw an error
            SObject errorAccount = new SObject();
            errorAccount.setType("Account");
            errorAccount.setId(new String("SLFKJLFKJ"));
            errorAccount.setFieldsToNull(new String[] { "Name" });

            // call the update passing an array of object
            SaveResult[] saveResults = binding.update(new SObject[] { updateAccount, errorAccount });

            // loop through the results, checking for errors
            for (int j = 0; j < saveResults.length; j++) {
                System.out.println("Item: " + new Integer(j).toString());
                if (saveResults[j].isSuccess()) {
                    System.out.println("An account with an id of: " + saveResults[j].getId() + " was updated.\n");
                } else {
                    System.out.println("Item " + new Integer(j).toString() + " had an error updating.");
                    System.out.println("    The error reported was: " + saveResults[j].getErrors()[0].getMessage() + "\n");
                }
            }
        } catch (ApiFault af) {
            System.out.println("\nFailed to succesfully update an account, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to succesfully update an account, error message was: \n" + ex.getMessage());
        }
        getUserInput("\nHit return to continue...");
    }

    private void createLeadSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login())
                return;
        }

        try {

            SObject[] leads = new SObject[1];
            // SObject lead;
            // lead = new SObject();
            MessageElement[] lead = new MessageElement[23];
            lead[0] = newMessageElement("AnnualRevenue", "1000000.0");
            lead[1] = newMessageElement("City", "San Francisco");
            lead[2] = newMessageElement("Company", "Acme Anvils");
            lead[3] = newMessageElement("Country", "United States");
            lead[4] = newMessageElement("Description", "This is a lead that can be converted.");
            String email = getUserInput("\nPlease enter an email for the lead we are creating.");
            if (email == null)
                lead[5] = newMessageElement("Email", "some.email@some.domain.com");
            else
                lead[5] = newMessageElement("Email", email);
            lead[6] = newMessageElement("Fax", "5555555555");
            lead[7] = newMessageElement("FirstName", "Wiley");
            lead[8] = newMessageElement("Industry", "Blacksmithery");
            lead[9] = newMessageElement("LastName", "Coyote");
            lead[10] = newMessageElement("LeadSource", "Web");
            lead[11] = newMessageElement("MobilePhone", "4444444444");
            lead[12] = newMessageElement("NumberOfEmployees", new Integer(30));
            lead[13] = newMessageElement("NumberofLocations__c", new Double(1.0));
            lead[14] = newMessageElement("Phone", "6666666666");
            lead[15] = newMessageElement("PostalCode", "94105");
            lead[16] = newMessageElement("Rating", "Hot");
            lead[17] = newMessageElement("Salutation", "Mr.");
            lead[18] = newMessageElement("State", "California");
            lead[19] = newMessageElement("Status", "Working");
            lead[20] = newMessageElement("Street", "10 Downing Street");
            lead[21] = newMessageElement("Title", "Director of Directors");
            lead[22] = newMessageElement("Website", "www.acmeanvils.com");

            leads[0].setType("Lead");
            leads[0].set_any(lead);

            SaveResult[] sr = binding.create(leads);

            for (int j = 0; j < sr.length; j++) {
                if (sr[j].isSuccess()) {
                    System.out.println("A lead was create with an id of: " + sr[j].getId());

                } else {
                    // there were errors during the create call, go through the
                    // errors
                    // array and write them to the screen
                    for (int i = 0; i < sr[j].getErrors().length; i++) {
                        // get the next error
                        com.salesforce.soap.partner.Error err = sr[j].getErrors()[i];
                        System.out.println("Errors were found on item " + new Integer(j).toString());
                        System.out.println("Error code is: " + err.getStatusCode().toString());
                        System.out.println("Error message: " + err.getMessage());
                    }
                }
                getUserInput("\nHit return to continue...");
            }
        } catch (ApiFault af) {
            System.out.println("\nFailed to create lead succesfully, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to create lead succesfully, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
    }

    private SObject getUnconvertedLead() throws Exception {
        SObject leadToReturn = null;
        // get a list of leads so the user can select one
        QueryResult qr = binding.query("Select Id, FirstName, LastName from Lead where ConvertedDate = Null");
        if (qr.getSize() == 0) { // No leads where found that have not been
            // converted, so....
            // we will create a lead and then run the query again
            System.out.println("No unconverted leads found, will create one for you...");
            createLeadSample();
            qr = binding.query("Select Id, FirstName, LastName from Lead where ConvertedDate = Null");
        }

        if (qr.getSize() > 0) {
            for (int i = 0; i < qr.getRecords().length; i++) {
                SObject lead = qr.getRecords()[i];
                System.out.println(new Integer(i + 1).toString() + ": " + getFieldValue(lead.get_any(), "FirstName") + " "
                        + getFieldValue(lead.get_any(), "LastName"));
            }
            String selectedLead = getUserInput("/nSelect the number of the lead to convert. ");
            if (selectedLead != null) {
                try {
                    int selLead = new Integer(selectedLead).intValue();
                    leadToReturn = qr.getRecords(selLead - 1);
                } catch (Exception ex) {
                    System.out.println("The number you selected is not valid, conversion failed...");
                }
            }
        }
        if (leadToReturn == null) {
            throw new Exception("No lead selected, required data, conversion failed");
        } else {
            return leadToReturn;
        }
    }

    private SObject getContact() throws Exception {
        SObject contactToReturn = null;
        // get a list of contacts so the user can select one
        QueryResult qr = binding.query("Select Id, FirstName, LastName, AccountId from Contact Where not AccountId = null");
        if (qr.getSize() == 0) { // No leads where found that have not been
            // converted, so....
            // we will create a lead and then run the query again
            System.out.println("No contacts found, will create one for you...");
            this.createContactSample();
            qr = binding.query("Select Id, FirstName, LastName, AccountId from Contact");
        }
        if (qr.getSize() > 0) {
            for (int i = 0; i < qr.getRecords().length; i++) {
                SObject contact = qr.getRecords(i);
                System.out.println(new Integer(i + 1).toString() + ": " + getFieldValue(contact.get_any(), "FirstName") + " "
                        + getFieldValue(contact.get_any(), "LastName"));
            }
            String selectedContact = getUserInput("/nSelect the number of the contact to use. ");
            if (selectedContact != null) {
                try {
                    int selContact = new Integer(selectedContact).intValue();
                    contactToReturn = qr.getRecords(selContact - 1);
                } catch (Exception ex) {
                    System.out.println("The number you selected is not valid, exiting...");
                }
            }
        }
        if (contactToReturn == null) {
            throw new Exception("No contact was selected, conversion failed.");
        } else {
            return contactToReturn;
        }
    }

    private SObject getAccount() throws Exception {
        SObject accountToReturn = null;
        // get a list of Accounts so the user can select one
        QueryResult qr = binding.query("Select Id, Name from Account");
        if (qr.getSize() == 0) { // No accounts found (Not Likely), so...
            // we will create an account and then run the query again
            this.createAccountSample();
            qr = binding.query("Select Id, Name from Account");
        }
        if (qr.getSize() > 0) {
            for (int i = 0; i < qr.getRecords().length; i++) {
                SObject account = qr.getRecords(i);
                System.out.println(new Integer(i + 1).toString() + ": " + getFieldValue(account.get_any(), "Name"));
            }
            String selectedAccount = getUserInput("/nSelect the number of the account to use. ");
            if (selectedAccount != null) {
                try {
                    int selAccount = new Integer(selectedAccount).intValue();
                    accountToReturn = qr.getRecords(selAccount - 1);
                } catch (Exception ex) {
                    System.out.println("The number you selected is not valid, exiting...");
                }
            }
        }
        if (accountToReturn == null) {
            throw new Exception("Bad account selection, conversion failed.");
        } else {
            return accountToReturn;
        }
    }

    private String getAccountName(String accountId) throws UnexpectedErrorFault, RemoteException {
        String aid = new String();
        aid = accountId;
        SObject[] ret = binding.retrieve("Name", "Account", new String[] { aid });
        if (ret != null) {
            return getFieldValue(ret[0].get_any(), "Name");
        } else {
            return null;
        }
    }

    private String getLeadStatus() throws UnexpectedErrorFault, RemoteException {
        QueryResult qr = binding.query("Select Id, MasterLabel from LeadStatus Where IsConverted = true");
        if (qr.getSize() > 0) {
            System.out.println("\n");
            for (int i = 0; i < qr.getRecords().length; i++) {
                System.out.println(new Integer(i + 1).toString() + ": "
                        + getFieldValue(qr.getRecords(i).get_any(), "MasterLabel"));
            }
            String stat = getUserInput("\nEnter the number of the status to use. ");
            if (stat != null)
                return getFieldValue(qr.getRecords(new Integer(stat).intValue() - 1).get_any(), "MasterLabel");
            else
                return getFieldValue(qr.getRecords(0).get_any(), "MasterLabel");

        } else {
            return null;
        }
    }

    private void convertLeadSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login())
                return;
        }

        try {
            // This is the structure we need to fill in to effect a conversion
            LeadConvert lc = new LeadConvert();
            String summary = "Converting lead to contact.\n";

            // When converting a lead you have the option of creating a new
            // contact, or
            // merging the lead with an existing contact. This sample will show
            // both
            // cases. So the first thing to do, is get the lead to convert.

            // Step 1 - Determine the String of the lead to conver
            SObject lead;
            lead = this.getUnconvertedLead();

            // Set the lead id on the structure.
            String lid = new String();
            lid = lead.getId().substring(0, 15);
            lc.setLeadId(lid);

            // Step2 - determine if the user wants to merge the lead to an
            // existing contact,
            // or have a new contact created.
            String merge = getUserInput("\nDo you want to merge this lead into an existing contact (Y/N)? ");
            SObject contact = null;
            if (merge != null && merge.toLowerCase().equals("y")) {
                contact = getContact();

                if (contact == null) {
                    summary += "  Create new contact.\n";
                } else {
                    summary += "  Merge with " + getFieldValue(contact.get_any(), "FirstName") + " "
                            + getFieldValue(contact.get_any(), "LastName") + "\n";
                    String cid = new String();
                    cid = contact.getId().substring(0, 15);
                    lc.setContactId(cid);
                    // We have the option of resetting the contact status to
                    // that of the lead,
                    // so we will query the user for that information.
                    String overWrite = getUserInput("Do you want to overwrite the contact status with the lead status (Y/N)? ");
                    if (overWrite != null && overWrite.toLowerCase().equals("y"))
                        lc.setOverwriteLeadSource(true);
                    else
                        lc.setOverwriteLeadSource(false);
                }
            } else
                summary += "  Create new contact.\n";

            // Step 3 - Determine account id, if a contact is chosen, we will
            // use the accountid of the contact, this must
            // be specified. If the contact is not chosen, then the user needs
            // to select
            // an account to place the new contact in.
            String accountId = null;

            if (contact != null) {
                accountId = getFieldValue(contact.get_any(), "AccountId");
                String aid = new String();
                aid = accountId.substring(0, 15);
                lc.setAccountId(aid);
            } else // get an account chosen by the user
            {
                String newAccount = getUserInput("Do you want to create a new account for this lead (Y/N)? ");
                if (newAccount == null || !newAccount.toLowerCase().equals("y"))
                    accountId = this.getAccount().getId().substring(0, 15);

                if (accountId != null) {
                    String aid = new String();
                    aid = accountId;
                    lc.setAccountId(aid);
                    String accountName;
                    accountName = getAccountName(accountId);
                    if (accountName != null)
                        summary += "  New contact will be in account '" + accountName + "'.\n";
                    else
                        summary += "  New contact will be in account with an String of '" + accountId + "'.\n";
                } else {
                    summary += "  A new account will be created.";
                }
            }

            // Step 4 - Determine if opportunity is to be created.
            // We will now ask the user if they would like to create a new
            // opportunity
            // based on the information on this lead
            String opp = getUserInput("Do you want to create an opportunity for this conversion (Y/N)? ");
            lc.setDoNotCreateOpportunity(true);
            if (opp != null && opp.toLowerCase().equals("y")) {
                lc.setDoNotCreateOpportunity(false);
                String oppName = getUserInput("Enter the name of the opportunity to create.. ");
                if (oppName == null) {
                    System.out.println("No opportunity name given, NO opportunity will be created.");
                    lc.setDoNotCreateOpportunity(true);
                    summary += "  No opportunity will be created.\n";
                } else {
                    lc.setOpportunityName(oppName);
                    summary += "  An opportunity named: " + oppName + " will be created.\n";
                }
            }

            // Step 5 - Obtain the proper lead status to place on the converted
            // lead
            // The lead needs to have it's status updated to reflect the
            // conversion operation,
            // so we will ask the user to select the status to use
            System.out.println("Select the lead status to use to update the converted lead. ");
            lc.setConvertedStatus(getLeadStatus());
            summary += "  The converted lead will be assigned a status of " + lc.getConvertedStatus() + ".\n";

            // Step 6 - Finally, we have the option of notifying the owner of
            // the lead that it
            // has been converted.
            String sendMail = getUserInput("Would you like to have an email sent to the owner of the lead after the conversion (Y/N)?");
            if (sendMail != null && sendMail.toLowerCase().equals("y")) {
                lc.setSendNotificationEmail(true);
                summary += "  Email notification will be sent.\n";
            } else {
                lc.setSendNotificationEmail(false);
                summary += "  Email notificatino will NOT be sent.\n";
            }

            String cont;
            System.out.println("\n\nDEBUG VALUES\n");
            System.out.println("account id: " + (lc.getAccountId() == null ? "(create new)" : lc.getAccountId()));
            System.out.println("contact id: " + (lc.getContactId() == null ? "(create new)" : lc.getContactId()));
            System.out.println("converted status: " + lc.getConvertedStatus());
            System.out.println("do not create opp: " + new Boolean(lc.isDoNotCreateOpportunity()).toString());
            System.out.println("lead id: " + lc.getLeadId());
            System.out.println("opp name: " + (lc.getOpportunityName() == null ? "(no opp)" : lc.getOpportunityName()));
            System.out.println("overwrite lead source: " + new Boolean(lc.isOverwriteLeadSource()).toString());
            System.out.println("send email: " + new Boolean(lc.isSendNotificationEmail()).toString());

            // Get a final verification of lead conversion from the user.
            cont = getUserInput(summary + "\n Enter 'Y' to convert the lead.");
            if (cont != null && cont.toLowerCase().equals("y")) {
                LeadConvertResult[] lcr = null;
                lcr = binding.convertLead(new LeadConvert[] { lc });

                // although we only converted a single lead, we will use a loop
                // to process the
                // results since the return value is an array of
                // LeadConvertResults
                for (int i = 0; i < lcr.length; i++) {
                    if (lcr[i].isSuccess()) {
                        try {
                            System.out.println("Conversion of lead " + getFieldValue(lead.get_any(), "FirstName") + " "
                                    + getFieldValue(lead.get_any(), "LastName") + " was successful.");
                            if (contact != null && contact.getId().equals(lcr[i].getContactId()))
                                System.out.println("  Contact with String of '" + lcr[i].getContactId() + "' was merged.");
                            else
                                System.out.println("  Contact with String of '" + lcr[i].getContactId() + "' was created.");
                            if (lcr[i].getOpportunityId() != null)
                                System.out.println("  An opportunity with an String of '" + lcr[i].getOpportunityId()
                                        + "' was created.");
                            else
                                System.out.println("  No opportunity was created.");
                            System.out.println("  The contact was created in the account with an String of '"
                                    + lcr[i].getAccountId() + "'.");
                        } catch (Exception e) {
                            getUserInput("Although the lead was converted, some error prevented the reporting of results.");
                        }
                    } else {
                        System.out.println("One or more errors where encountered during the lead conversion process...\n");
                        for (int j = 0; j < lcr[i].getErrors().length; j++) {
                            System.out.println((j + 1) + ". " + lcr[0].getErrors(j).getMessage());
                        }
                    }
                }
            } else {
                System.out.println("Lead conversion was aborted.");
            }
        } catch (ApiFault af) {
            System.out.println("Errors occurred during conversion preventing any conversion to take place.\n\n"
                    + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception e) {
            System.out.println("Errors occurred during conversion preventing any conversion to take place.\n\n" + e.getMessage());
        }
    }

    private void createTaskSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            // create an array to create 4 items in one call
            SObject[] taskarray = new SObject[4];
            for (int x = 0; x < 4; x++) {
                // Declare a new task object to hold our values
                final java.text.SimpleDateFormat ISO8601UTC = new java.text.SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss+SSSS");
                // Set the appropriate values on the task
                SObject task = new SObject();
                task.setType("Task");
                Date activityDate = new Date();
                int taskUbound = 5;
                int index = 0;
                if (contacts != null)
                    taskUbound++;
                if (accounts != null)
                    taskUbound++;
                if (x > 1)
                    taskUbound++;
                MessageElement[] fields = new MessageElement[taskUbound];
                fields[index++] = newMessageElement("ActivityDate", ISO8601UTC.format(activityDate));
                fields[index++] = newMessageElement("Description", "Get in touch with this person");
                fields[index++] = newMessageElement("Priority", "Normal");
                fields[index++] = newMessageElement("Status", "Not Started");
                fields[index++] = newMessageElement("Subject", "Setup Call");
                // make sure we get some errors on records 3 and 4
                if (x > 1) {
                    fields[index++] = newMessageElement("OwnerId", "DSF:LJKSDFLKJ");
                    // The two lines below illustrate associating an object with
                    // another object. If
                    // we have created an account and/or a contact prior to
                    // creating the task, we will
                    // just grab the first account and/or contact id and place
                    // it in the appropriate
                    // reference field. WhoId can be a reference to a contact or
                    // a lead or a user.
                    // WhatId can be a reference to an account, campaign, case,
                    // contract or opportunity
                }
                if (contacts != null) {
                    fields[index++] = newMessageElement("WhoId", contacts[0]);
                }
                if (accounts != null) {
                    fields[index++] = newMessageElement("WhatId", accounts[0]);
                }
                taskarray[x] = task;
            }

            // call the create method passing the array of tasks as sobjects
            SaveResult[] sr = binding.create(taskarray);

            for (int j = 0; j < sr.length; j++) {
                if (sr[j].isSuccess()) {
                    System.out.println("A task was create with an id of: " + sr[j].getId());
                    if (accounts != null) {
                        System.out.println(" - the task was associated with the account you created with an id of " + accounts[0]
                                + ".");

                    }

                    if (tasks == null) {
                        tasks = new String[] { sr[j].getId() };
                    } else {
                        String[] tempTasks = null;
                        tempTasks = new String[tasks.length + 1];
                        for (int i = 0; i < tasks.length; i++) {
                            tempTasks[i] = tasks[i];
                        }
                        tempTasks[tasks.length] = sr[j].getId();
                        tasks = tempTasks;
                    }
                } else {
                    // there were errors during the create call, go through the
                    // errors
                    // array and write them to the screen
                    for (int i = 0; i < sr[j].getErrors().length; i++) {
                        // get the next error
                        com.salesforce.soap.partner.Error err = sr[j].getErrors()[i];
                        System.out.println("Errors were found on item " + new Integer(j).toString());
                        System.out.println("Error code is: " + err.getStatusCode().toString());
                        System.out.println("Error message: " + err.getMessage());
                    }
                }
            }
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("\nFailed to succesfully create a task, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to succesfully create a task, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
    }

    private void deleteSample() {
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }
        // check to see if we know anything that was created
        if (tasks == null && contacts == null && accounts == null) {
            System.out
                    .println("\nDelete operation not completed.  You will need to create a task, account or contact during this session to run the delete sample.");
            getUserInput("\nHit return to continue...");
            return;
        }
        try {
            if (tasks != null) {
                binding.delete(tasks);
                System.out.println("\nSuccessfully deleted " + tasks.length + " tasks.");
                tasks = null;
            } else {
                System.out.println("\nDeleted 0 tasks.");
            }
            if (contacts != null) {
                binding.delete(contacts);
                System.out.println("\nSuccessfully deleted " + contacts.length + " contacts.");
                contacts = null;
            } else {
                System.out.println("\nDeleted 0 contacts.");
            }
            if (accounts != null) {
                binding.delete(accounts);
                System.out.println("\nSuccessfully deleted " + accounts.length + " accounts.");
                accounts = null;
            } else {
                System.out.println("\nDeleted 0 accounts.");
            }
            System.out.println("\nDelete sample completed successfully.");
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("\nFailed to succesfully delete an account, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (RemoteException ex) {
            System.out.println("\nFailed to succesfully delete an account, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
    }

    private void resetPasswordSample() {
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }
        try {
            QueryResult qr = binding.query("select UserName, LastName, FirstName, Id from User");
            if (qr.getSize() > 0) {
                SObject[] users = qr.getRecords();
                if (users != null) {
                    System.out.println("\nUser List: ");
                    for (int i = 0; i < users.length; i++) {
                        int printInd = i + 1;
                        SObject user = users[i];
                        System.out.println(printInd + ". " + user.get_any()[0].getValue() + " - " + user.get_any()[2].getValue()
                                + " " + user.get_any()[1].getValue());
                    }
                }
                String idToReset = getUserInput("\nEnter user to reset: ");
                if (idToReset != null) {
                    int userIndex = new Integer(idToReset).intValue() - 1;
                    String verify = getUserInput("Please verify that you want to reset the password for \n"
                            + users[userIndex].get_any()[2] + " " + users[userIndex].get_any()[1] + "\nby entering OK.");
                    if (verify.equals("OK")) {
                        ResetPasswordResult resetPasswordResult = binding.resetPassword(users[userIndex].getId());
                        if (resetPasswordResult != null) {
                            System.out.println("\nThe password for user " + users[userIndex].get_any()[2].getValue() + " "
                                    + users[userIndex].get_any()[1].getValue() + " has been reset to "
                                    + resetPasswordResult.getPassword());
                            getUserInput("\nHit enter to continue...");
                            return;
                        }
                    }
                }
            }
        } catch (ApiFault af) {
            System.out.println("\nFailed to succesfully reset password, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (RemoteException ex) {
            System.out.println("\nFailed to succesfully reset password, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
        getUserInput("No password was reset....\nHit return to continue...");
    }

    private void setPasswordSample() {
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }
        try {
            QueryResult qr = binding.query("select UserName, LastName, FirstName, Id from User");
            if (qr.getSize() > 0) {
                SObject[] users = qr.getRecords();
                if (users != null) {
                    System.out.println("\nUser List: ");
                    for (int i = 0; i < users.length; i++) {
                        int printInd = i + 1;
                        SObject user = users[i];
                        System.out.println(printInd + ". " + user.get_any()[0].getValue() + " - " + user.get_any()[2].getValue()
                                + " " + user.get_any()[1].getValue());
                    }
                }
                String idToReset = getUserInput("\nEnter user to set password for: ");
                if (idToReset != null) {
                    int userIndex = new Integer(idToReset).intValue() - 1;
                    String newPassword = getUserInput("Enter the new password: ");
                    if (newPassword != null) {
                        String verify = getUserInput("Please verify that you want to reset the password for \n"
                                + users[userIndex].get_any()[2] + " " + users[userIndex].get_any()[1] + "\n to " + newPassword
                                + " by entering OK.");
                        if (verify.equals("OK")) {
                            SetPasswordResult setPasswordResult = binding.setPassword(users[userIndex].getId(), newPassword);
                            if (setPasswordResult != null) {
                                System.out.println("\nThe password for user " + users[userIndex].get_any()[2].getValue() + " "
                                        + users[userIndex].get_any()[1].getValue() + " has been reset to " + newPassword);
                                getUserInput("\nHit enter to continue...");
                                return;
                            }
                        }
                    }
                }
            }
        } catch (ApiFault af) {
            System.out.println("\nFailed to succesfully set password, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (RemoteException ex) {
            System.out.println("\nFailed to succesfully set password, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
        getUserInput("No password was set....\nHit return to continue...");
    }

    private void retrieveSample() {
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }
        if (accounts == null) {
            System.out
                    .println("To run the retrieve sample, create one or more\naccounts using the Create Accounts Sample first.\n\nHit return to continue...");
        } else {
            try {
                SObject[] sObjects = binding.retrieve("Id, AccountNumber, Name, Website", "Account", accounts);
                if (sObjects != null) {
                    System.out.println("Returning data for " + sObjects.length + " accounts: ");
                    for (int i = 0; i < sObjects.length; i++) {
                        System.out.println("Account: " + sObjects[i].getId());
                        System.out.println("    AccountNumber = " + sObjects[i].get_any()[1]);
                        System.out.println("    Name          = " + sObjects[i].get_any()[2]);
                        System.out.println("    Website       = " + sObjects[i].get_any()[3] + "\n");
                    }
                    getUserInput("\nRetrive executed successfully, hit return to continue....");
                }
            } catch (ApiFault af) {
                System.out.println("\nFailed to succesfully retrieve records, error message was: \n" + af.getExceptionMessage());
                getUserInput("\nHit return to continue...");
            } catch (RemoteException ex) {
                System.out.println("\nFailed to succesfully retrieve records, error message was: \n" + ex.getMessage());
                getUserInput("\nHit return to continue...");
            }
        }

    }

    private void toggleSoapLogging() {
        if (logOn) {
            Logger.getLogger("org.apache.axis.transport.http.HTTPSender").setLevel(Level.OFF);
            logOn = false;
        } else {
            Logger.getLogger("org.apache.axis.transport.http.HTTPSender").setLevel(Level.DEBUG);
            logOn = true;
        }
    }

    private void showMenu() {

        System.out.println(" 1. Login Only");
        System.out.println(" 2. Create Account");
        System.out.println(" 3. Create Contact");
        System.out.println(" 4. Create Task");
        System.out.println(" 5. Query");
        System.out.println(" 6. Query All");
        System.out.println(" 7. Retrieve");
        System.out.println(" 8. Update");
        System.out.println(" 9. Upsert Account");
        System.out.println("10. Merge Accounts");
        System.out.println("11. Convert Lead");
        System.out.println("12. Delete");
        System.out.println("13. Un-delete");
        System.out.println("14. Process Workflow");
        System.out.println("15. Describe Global");
        System.out.println("16. Describe SObject");
        System.out.println("17. Describe Mulitple SObjects");
        System.out.println("18. Describe Tabs");
        System.out.println("19. Describe Layout");
        System.out.println("20. Describe Softphone Layout");
        System.out.println("21. Set Password");
        System.out.println("22. Reset Password");
        System.out.println("23. Search Sample");
        System.out.println("24. Get Deleted");
        System.out.println("25. Get Updated");
        System.out.println("26. Get Server Timestamp");
        System.out.println("27. Get User Info");
        System.out.println("");
        System.out.println("98. Turn Soap Logging " + (logOn ? "off" : "on"));
        System.out.println("99. Exit");
        System.out.println("   "); // (soap logging level = " +
        // CommonsHTTPSender.getLoggingLevel() + ",
        // compression is " +
        // (CommonsHTTPSender.isZipping() ? "on":
        // "off") + ")");
        System.out.print("Enter the number of the sample to run: ");
    }

    private String getUserInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException ex) {
            return null;
        }
    }

    private void run() {
        Logger.getLogger("org.apache.axis").setLevel(Level.OFF);

        showMenu();
        String choice = getUserInput();
        while (choice != null && !choice.equals("99")) {
            try {
                if (choice.length() == 1 || choice.length() == 2) {
                    switch (new Integer(choice).intValue()) {
                    case 1:
                        if (login()) {
                            getUserInput("\nSUCESSFUL LOGIN! Hit the enter key to continue.");
                        }
                        break;
                    case 2:
                        createAccountSample();
                        break;
                    case 3:
                        createContactSample();
                        break;
                    case 4:
                        createTaskSample();
                        break;
                    case 5:
                        querySample();
                        break;
                    case 6:
                        queryAllSample();
                        break;
                    case 7:
                        retrieveSample();
                        break;
                    case 8:
                        updateAccountSample();
                        break;
                    case 9:
                        upsertSample();
                        break;
                    case 10:
                        mergeSample();
                        break;
                    case 11:
                        convertLeadSample();
                        break;
                    case 12:
                        deleteSample();
                        break;
                    case 13:
                        undeleteSample();
                        break;
                    case 14:
                        processSample();
                        break;
                    case 15:
                        describeGlobalSample();
                        break;
                    case 16:
                        describeSample();
                        break;
                    case 17:
                        describeSObjectsSample();
                        break;
                    case 18:
                        describeTabsSample();
                        break;
                    case 19:
                        describeLayoutSample();
                        break;
                    case 20:
                        describeSoftphoneLayoutSample();
                        break;
                    case 21:
                        setPasswordSample();
                        break;
                    case 22:
                        resetPasswordSample();
                        break;
                    case 23:
                        searchSample();
                        break;
                    case 24:
                        getDeletedSample();
                        break;
                    case 25:
                        getUpdatedSample();
                        break;
                    case 26:
                        getServerTimestampSample();
                        break;
                    case 27:
                        getUserInfoSample();
                        break;
                    case 98:
                        toggleSoapLogging();
                    }
                }
                showMenu();

            } catch (Exception e) {
                System.out.print("Enter the number of the sample to run: ");
            }
            choice = getUserInput();
        }
    }

    private void processSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            // First step is to create an account that matches the approval process criteria
            SObject acct = new SObject();
            acct.setType("Account");
            acct.set_any(new MessageElement[] { newMessageElement("Name", "API Approval Sample") });
            acct.setId(binding.create(new SObject[] { acct })[0].getId());

            // Next step is to submit the account for approval using a ProcessSubmitRequest
            ProcessSubmitRequest psr = new ProcessSubmitRequest();
            psr.setObjectId(acct.getId());
            psr.setComments("This approval request was initiated from the API.");
            ProcessResult p_res = binding.process(new ProcessRequest[] { psr })[0];
            if (p_res.isSuccess()) {
                // Since the submission was successful we can now approve or reject it with
                // a ProcessWorkItmeRequest
                ProcessWorkitemRequest pwr = new ProcessWorkitemRequest();

                pwr.setAction("Approve");
                pwr.setComments("This request was approved from the API.");
                pwr.setWorkitemId(p_res.getNewWorkitemIds(0));
                p_res = binding.process(new ProcessRequest[] { pwr })[0];
                if (p_res.isSuccess()) {
                    System.out.println("Successfully submitted and then approved an approval request.");
                } else {
                    System.out.println("Error approving the work item: " + p_res.getErrors(0).getMessage());
                }
            } else {
                System.out.println("Error submitting the account for approval: " + p_res.getErrors(0).getMessage());
            }
        } catch (ApiFault e) {
            System.out.println("The API returned a fault: " + e.getExceptionMessage());
        } catch (RemoteException e) {
            System.out.println("There was an Axis generated error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        getUserInput("\nHit the enter key to continue...");
    }

    private void undeleteSample() {
        // Create and delete the account, like the queryAll sample
        // Undelete the account

        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        // For this sample we will create an account and then delete it
        // to demonstrate the power of queryAll
        String accountName = getUserInput("\nEnter a name for a test account:");
        if (accountName == null || accountName.length() == 0) {
            return;
        }
        String accountId = createAndDeleteAnAccount(accountName);
        getUserInput("You can check your recycle bin now to see the deleted account.\nHit return to continue...");

        // Now, we can undelete the account
        try {
            UndeleteResult udr = binding.undelete(new String[] { accountId })[0];
            if (udr.isSuccess()) {
                System.out.println("The account was successfully undeleted.");
                System.out.println("If you check your recycle bin you will see the account is no longer present.");
            } else {
                System.out.println("Undelete failed: " + udr.getErrors(0).getMessage());
            }
        } catch (ApiFault e) {
            System.out.println("Error un-deleting test account: " + e.getExceptionMessage());
        } catch (RemoteException e) {
            System.out.println("Error from the server on create test account: " + e.getMessage());
        }
        getUserInput("\nHit return to continue...");
    }

    private void mergeSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            SObject masterAccount = new SObject();
            MessageElement masterAccountName = newMessageElement("Name", "MasterAccount");
            masterAccount.set_any(new MessageElement[] { masterAccountName });
            masterAccount.setType("Account");
            SaveResult masterAccountSaveResult;

            masterAccountSaveResult = binding.create(new SObject[] { masterAccount })[0];

            masterAccount.setId(masterAccountSaveResult.getId());
            MessageElement masterAccountDescription = newMessageElement("Description", "Old description");
            masterAccount.set_any(new MessageElement[] { masterAccountName, masterAccountDescription });

            SObject accountToMerge = new SObject();
            accountToMerge.setType("Account");
            MessageElement mergeAccountName = newMessageElement("Name", "AccountToMerge");
            MessageElement mergeAccountDesc = newMessageElement("Description", "Duplicate account");
            accountToMerge.set_any(new MessageElement[] { mergeAccountDesc, mergeAccountName });

            SaveResult accountToMergeSaveResult = binding.create(new SObject[] { accountToMerge })[0];

            // Attach a note, which will get re-parented
            SObject note = new SObject();
            note.setType("Note");
            MessageElement noteParentId = newMessageElement("ParentId", accountToMergeSaveResult.getId());
            MessageElement noteBody = newMessageElement("Body", "This note will be moved to the MasterAccount during merge.");
            MessageElement noteTitle = newMessageElement("Title", "Test note to be reparented.");
            note.set_any(new MessageElement[] { noteBody, noteParentId, noteTitle });

            @SuppressWarnings("unused")
            SaveResult noteSave = binding.create(new SObject[] { note })[0];

            MergeRequest mr = new MergeRequest();

            // Perform an update on the master record as part of the merge:
            masterAccountDescription = newMessageElement("Description", "Was merged");
            masterAccount.set_any(new MessageElement[] { masterAccountName, masterAccountDescription });

            mr.setMasterRecord(masterAccount);
            mr.setRecordToMergeIds(new String[] { accountToMergeSaveResult.getId() });
            MergeResult result = binding.merge(new MergeRequest[] { mr })[0];

            getUserInput("Merged " + result.isSuccess() + " got " + result.getUpdatedRelatedIds().length
                    + " updated child records\nHit return to continue.");

        } catch (ApiFault e) {
            System.out.println("Error merging account: " + e.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (RemoteException e) {
            System.out.println("Error from the server on the merge sample: " + e.getMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, Field> makeFieldMap(Field[] fields) {

        HashMap<String, Field> fieldMap = new HashMap<String, Field>();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            fieldMap.put(field.getName(), field);
        }
        return fieldMap;
    }

    private void upsertSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            DescribeSObjectResult dsr = binding.describeSObject("Account");
            HashMap fieldMap = makeFieldMap(dsr.getFields());
            if (!fieldMap.containsKey("External_Id__c")) {
                System.out
                        .println("\n\nATTENTION: To run this sample you need to \ncreate a custom text field on the Account object \nnamed External_Id with a length of 8 characters \nand with the 'external id' checkbox checked.");
            } else {
                // First, we need to make sure the test accounts do not exist.
                QueryResult qr = binding
                        .query("Select Id From Account Where External_Id__c = '11111111' or External_Id__c = '22222222'");
                if (qr.getSize() > 0) {
                    SObject[] accounts = qr.getRecords();
                    // Get the ids
                    String[] ids = new String[accounts.length];
                    for (int i = 0; i < ids.length; i++) {
                        ids[i] = accounts[i].getId();
                    }
                    // Delete the accounts
                    binding.delete(ids);
                }

                // Create a new account using create, we wil use this to update via upsert
                // We will set the external id to be ones so that we can use that value for the upsert
                SObject newAccount = new SObject();
                newAccount.setType("Account");
                MessageElement acctName = newMessageElement("Name", "Account to update");
                MessageElement extId = newMessageElement("External_Id__c", "11111111");
                newAccount.set_any(new MessageElement[] { acctName, extId });

                binding.create(new SObject[] { newAccount });

                // Now we will create an account that should be updated on insert based
                // on the external id field.
                SObject updateAccount = new SObject();
                updateAccount.setType("Account");
                MessageElement webSite = newMessageElement("Website", "http://www.website.com");
                MessageElement extId1 = newMessageElement("External_Id__c", "11111111");
                updateAccount.set_any(new MessageElement[] { webSite, extId1 });

                // This account is meant to be new
                SObject createAccount = new SObject();
                createAccount.setType("Account");
                MessageElement cacctName = newMessageElement("Name", "My Company, Inc");
                MessageElement extId3 = newMessageElement("External_Id__c", "22222222");
                createAccount.set_any(new MessageElement[] { cacctName, extId3 });

                // We have our two accounts, one should be new, the other should be updated.
                try {
                    // Invoke the upsert call and save the results.
                    // Use External_Id custom field for matching records
                    UpsertResult[] upsertResults = binding.upsert("External_Id__c",
                            new SObject[] { createAccount, updateAccount });
                    for (UpsertResult result : upsertResults) {
                        if (result.isSuccess()) {
                            System.out.println("\nUpsert succeeded.");
                            System.out.println((result.isCreated() ? "Inserted" : "Updated") + " account, id is "
                                    + result.getId().toString());
                        } else {
                            System.out.println("The Upsert failed because: " + result.getErrors(0).getMessage());
                        }
                    }
                } catch (RemoteException ex) {
                    System.out.println("An unexpected error has occurred." + ex.getMessage());
                }
            }
            getUserInput("\nPress the RETURN key to continue...");
        } catch (ApiFault e) {
            System.out.println("Error merging account: " + e.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (RemoteException e) {
            System.out.println("Error from the server on the merge sample: " + e.getMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String createAndDeleteAnAccount(String accountName) {
        String returnId = null;
        SObject acct = new SObject();
        acct.setType("Account");
        String acctName = (accountName == null) ? "QueryAll Sample" : accountName;
        try {
            MessageElement nameField = newMessageElement("Name", acctName);
            acct.set_any(new MessageElement[] { nameField });
            // We are only creating one account so we can index the return array directly
            SaveResult sr = binding.create(new SObject[] { acct })[0];
            if (sr.isSuccess()) {

                acct.setId(sr.getId());
                // Ok, now we will delete that account
                DeleteResult dr = binding.delete(new String[] { acct.getId() })[0];
                if (!dr.isSuccess()) {
                    System.out.println("The web service would not let us delete the account: \n" + dr.getErrors(0).getMessage());
                    getUserInput("\nHit return to continue...");
                } else {
                    returnId = acct.getId();
                }

            } else {
                System.out.println("The web service would not let us create the account: \n" + sr.getErrors(0).getMessage());
                getUserInput("\nHit return to continue...");
            }
        } catch (ApiFault e) {
            System.out.println("Error creating test account: " + e.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (RemoteException e) {
            System.out.println("Error from the server on create test account: " + e.getMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnId;
    }

    private void queryAllSample() {
        // Verify that we are already authenticated, if not
        // call the login function to do so
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        // For this sample we will create an account and then delete it
        // to demonstrate the power of queryAll
        String accountName = getUserInput("\nEnter a name for a test account:");
        if (accountName == null || accountName.length() == 0) {
            return;
        }
        createAndDeleteAnAccount(accountName);

        // Now for Query All. Query all allows you to return items that have been moved to the recycle
        // bin, like the account we just deleted.
        QueryResult qr = null;
        try {
            qr = binding.queryAll("select id, Name from Account where name = '" + accountName + "' and IsDeleted = true");
            if (qr.getSize() != 0) {
                SObject account = qr.getRecords()[0];
                System.out.println("Retrieved the deleted account: " + getFieldValue(account.get_any(), "Name"));
            } else {
                System.out.println("Hmm...\nDid not find the account, that's strange.");
            }
            System.out.println("\nQuery succesfully executed.");
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("\nFailed to execute query succesfully, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to execute query succesfully, error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }
    }

    private void describeSoftphoneLayoutSample() {
        if (!loggedIn) {
            if (!login()) {
                return;
            }
        }

        try {
            DescribeSoftphoneLayoutResult slr = binding.describeSoftphoneLayout();
            DescribeSoftphoneLayoutCallType[] callTypes = slr.getCallTypes();
            System.out.println("There are " + callTypes.length + " call types.");
            for (int i = 0; i < callTypes.length; i++) {
                DescribeSoftphoneLayoutCallType callType = callTypes[i];
                DescribeSoftphoneLayoutInfoField[] fields = callType.getInfoFields();
                System.out.println("    There are " + fields.length + " info fields.");
                for (int j = 0; j < fields.length; j++) {
                    System.out.println("\t" + fields[j].getName() + "\n");
                }
                DescribeSoftphoneLayoutSection[] sections = callType.getSections();
                System.out.println("\tThere are " + sections.length + " sections on this layout.");
                for (int j = 0; j < sections.length; j++) {
                    DescribeSoftphoneLayoutSection section = sections[j];
                    DescribeSoftphoneLayoutItem[] items = section.getItems();
                    for (int k = 0; k < items.length; k++) {
                        DescribeSoftphoneLayoutItem item = items[k];
                        System.out.println("Section " + j + " - item api name: " + item.getItemApiName());
                    }
                }
            }
            getUserInput("\nHit return to continue...");
        } catch (ApiFault af) {
            System.out.println("\nFailed to describe softphone layout, error message was: \n" + af.getExceptionMessage());
            getUserInput("\nHit return to continue...");
        } catch (Exception ex) {
            System.out.println("\nFailed to describe softphone layout , error message was: \n" + ex.getMessage());
            getUserInput("\nHit return to continue...");
        }

    }
}

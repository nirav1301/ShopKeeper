package com.example.shopkeeper.addcustomer.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class AddCustomerRequestBody {
    public RequestAddCustomer requestAddCustomer;
    public static class RequestAddCustomer{
        @Attribute(name = "xmlns")
        public String xmlns;

        @Element(name = "CompanyCustomerID", required = false)
        public String CompanyCustomerID;

        @Element(name = "CompanyName", required = false)
        public String CompanyName;


        @Element(name = "CustomerCompanyName", required = false)
        public String CustomerCompanyName;

        @Element(name = "CustomerName", required = false)
        public String CustomerName;

        @Element(name = "LoginID", required = false)
        public String LoginID;

        @Element(name = "ActiveStatus", required = false)
        public String ActiveStatus;

        @Element(name = "MailingPhone", required = false)
        public String MailingPhone;

        @Element(name = "MailingFax", required = false)
        public String MailingFax;

        @Element(name = "BusinessLicenseOrPermit", required = false)
        public String BusinessLicenseOrPermit;

        @Element(name = "CustomerFirstName", required = false)
        public String CustomerFirstName;

        @Element(name = "CustomerLastName", required = false)
        public String CustomerLastName;

        @Element(name = "RegDate", required = false)
        public String RegDate;

        @Element(name = "LastLogin", required = false)
        public String LastLogin;

        @Element(name = "BarcodeCustomerID", required = false)
        public String BarcodeCustomerID;

        @Element(name = "ApprovalStatus", required = false)
        public String ApprovalStatus;

        @Element(name = "UserRightsId", required = false)
        public String UserRightsId;

        @Element(name = "DateTimeRegistered", required = false)
        public String DateTimeRegistered;

        @Element(name = "ApprovalFlag", required = false)
        public String ApprovalFlag;

        @Element(name = "LoginCount", required = false)
        public String LoginCount;

        @Element(name = "LoginPassword", required = false)
        public String LoginPassword;

        @Element(name = "Address", required = false)
        public String Address;

        @Element(name = "CompanyId", required = false)
        public String CompanyId;

        @Element(name = "ShippingStreet", required = false)
        public String ShippingStreet;

        @Element(name = "ShippingStreet2", required = false)
        public String ShippingStreet2;

        @Element(name = "ShippingStateOrProvince", required = false)
        public String ShippingStateOrProvince;

        @Element(name = "ShippingCity", required = false)
        public String ShippingCity;

        @Element(name = "ShippingCountry", required = false)
        public String ShippingCountry;

        @Element(name = "ShippingZipcode", required = false)
        public String ShippingZipcode;

        @Element(name = "ShippingPhone", required = false)
        public String ShippingPhone;

        @Element(name = "SeekLevel", required = false)
        public String SeekLevel;

        @Element(name = "CurrencyCode", required = false)
        public String CurrencyCode;

        @Element(name = "IsCODCustomer", required = false)
        public String IsCODCustomer;

        @Element(name = "IsNET30Customer", required = false)
        public String IsNET30Customer;


        @Element(name = "IsSubscribe", required = false)
        public String IsSubscribe;

        @Element(name = "MailingStreet", required = false)
        public String MailingStreet;

        @Element(name = "MailingStreet1", required = false)
        public String MailingStreet1;

        @Element(name = "MailingCity", required = false)
        public String MailingCity;

        @Element(name = "MailingStateOrProvince", required = false)
        public String MailingStateOrProvince;

        @Element(name = "MailingZipcode", required = false)
        public String MailingZipcode;

        @Element(name = "MailingCountry", required = false)
        public String MailingCountry;

        @Element(name = "Note", required = false)
        public String Note;

        @Element(name = "CompanyPhoneNumber", required = false)
        public String CompanyPhoneNumber;

        @Element(name = "CompanyPhone", required = false)
        public String CompanyPhone;

        @Element(name = "CompanyEmail", required = false)
        public String CompanyEmail;

        @Element(name = "Email", required = false)
        public String Email;

        @Element(name = "ShippingAddressID", required = false)
        public String ShippingAddressID;

        @Element(name = "CompanyCustomerType", required = false)
        public String CompanyCustomerType;


    }
}

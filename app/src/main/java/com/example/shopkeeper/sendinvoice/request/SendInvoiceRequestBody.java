package com.example.shopkeeper.sendinvoice.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class SendInvoiceRequestBody {
    @Element(name = "EmailPlaceOrder", required = false)
    public RequestSendInvoice requestSendInvoice;
    public static class RequestSendInvoice{
        @Attribute(name = "xmlns")
        public String xmlns;

        @Element(name = "adminId", required = false)
        public String adminId;

        @Element(name = "companyId", required = false)
        public String companyId;

        @Element(name = "inventoryOrderId", required = false)
        public String inventoryOrderId;

        @Element(name = "productStyle", required = false)
        public String productStyle;

        @Element(name = "email", required = false)
        public String email;

        @Element(name = "comment", required = false)
        public String comment;

        @Element(name = "companyWebsite", required = false)
        public String companyWebsite;
    }

}

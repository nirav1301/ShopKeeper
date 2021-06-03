package com.example.shopkeeper.sendorder.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class SendOrderRequestBody {
    @Element(name = "SendOrder", required = false)
    public SendOrderRequestBody.RequestSendOrder requestSendOrder;
    public static class RequestSendOrder {
        @Attribute(name = "xmlns")
        public String xmlns;
        @Element(name = "AdminId", required = false)
        public String AdminId;

        @Element(name = "CompanyId", required = false)
        public String CompanyId;

        @Element(name = "CustomerId", required = false)
        public String CustomerId;

        @Element(name = "OrderNote", required = false)
        public String OrderNote;

        @Element(name = "ProductStyle", required = false)
        public String ProductStyle;

        @Element(name = "CompanyWebsite", required = false)
        public String CompanyWebsite;

        @Element(name = "ProductInfo", required = false)
        public String ProductInfo;

    }
}

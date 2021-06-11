package com.example.shopkeeper.sendorder.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "soap:Body", strict = false)
public class SendOrderRequestBody {

    @Element(name = "SendOrder", required = false)
    public SendOrderRequestBody.SendRequestOrder sendOrderRoot;

    public static class SendRequestOrder {
        @Element(name = "sendOrderRequest", required = false)
        public SendOrderRequestBody.RequestSendOrder requestSendOrder;

        @Attribute(name = "xmlns")
        public String xmlns;
    }

    public static class RequestSendOrder {

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
        public ProductInfo ProductInfo;

    }

    public static class ProductInfo {
        @ElementList(name = "ProductInfoAPI",inline = true)
        public ArrayList<ProductInfoAPI> productInfoAPIList;
    }

    @Root(name = "ProductInfoAPI")
    public static class ProductInfoAPI {
        @Element(name = "ProductId", required = false)
        public long productId;

        @Element(name = "ColorId", required = false)
        public int colorId;

        @Element(name = "Quantity", required = false)
        public double quantity;
    }
}


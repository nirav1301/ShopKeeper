package com.example.shopkeeper.sendorder.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

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
        public ProductInfo ProductInfo;

    }

    public class ProductInfo {
        @ElementList(name = "ProductInfoAPI")
        List<ProductInfoAPI> productInfoAPIList;
    }

    public class ProductInfoAPI {
        @Element(name = "ProductId", required = false)
        String productId;

        @Element(name = "ColorId", required = false)
        String colorId;

        @Element(name = "Quantity", required = false)
        String quantity;
    }
}


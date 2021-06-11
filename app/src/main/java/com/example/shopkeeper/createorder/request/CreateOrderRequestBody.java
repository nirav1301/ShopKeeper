package com.example.shopkeeper.createorder.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class CreateOrderRequestBody {
    @Element(name = "GetProductDetailByProductCode", required = false)
    public RequestCreateOrder requestCreateOrder;

    public static class RequestCreateOrder {
        @Attribute(name = "xmlns")
        public String xmlns;

        @Element(name = "companyId", required = false)
        public String companyId;

        @Element(name = "productId", required = false)
        public String productId;

        @Element(name = "colorId", required = false)
        public String colorId;

        @Element(name = "userId", required = false)
        public String userId;

    }
}

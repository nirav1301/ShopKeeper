package com.example.shopkeeper.orderhistory.Request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class OrderHistoryRequestBody {
    @Element(name = "GetOrderHistry", required = false)
    public RequestOrderHistory requestOrderHistory;

    public static class RequestOrderHistory {
        @Attribute(name = "xmlns")
        public String xmlns;

        @Element(name = "companyId", required = false)
        public String companyId;

        @Element(name = "pageNum", required = false)
        public String pageNum;

        @Element(name = "recordPerPage", required = false)
        public String recordPerPage;

        @Element(name = "orderId", required = false)
        public String orderId;

        @Element(name = "userId", required = false)
        public String userId;

        @Element(name = "searchtext", required = false)
        public String searchtext;

    }
}

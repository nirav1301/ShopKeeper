package com.example.shopkeeper.recentorder.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class RecentOrderRequestBody {
    @Element(name = "GetRecentOrders", required = false)
    public RequestRecentOrders requestRecentOrders;

    public static class RequestRecentOrders {
        @Attribute(name = "xmlns")
        public String xmlns;

        @Element(name = "companyId", required = false)
        public String companyId;

        @Element(name = "userId", required = false)
        public String userId;

    }
}

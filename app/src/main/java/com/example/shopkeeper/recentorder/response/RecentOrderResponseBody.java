package com.example.shopkeeper.recentorder.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class RecentOrderResponseBody {
    @Element(name = "GetRecentOrdersResponse", required = false)
    public RecentOrderResponseModel recentOrderResponseModel;
}

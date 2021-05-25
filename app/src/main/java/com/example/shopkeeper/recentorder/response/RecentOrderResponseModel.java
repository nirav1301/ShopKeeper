package com.example.shopkeeper.recentorder.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "GetRecentOrdersResponse")
@Namespace(reference = "http://tempuri.org/")
public class RecentOrderResponseModel {
    @Element(name = "GetRecentOrdersResult",required = false)
    public String GetRecentOrdersResult;
}


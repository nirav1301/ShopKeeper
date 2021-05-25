package com.example.shopkeeper.orderhistory.Response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "GetOrderHistryResponse")
@Namespace(reference = "http://tempuri.org/")
public class OrderHistoryResponseModel {
    @Element(name = "GetOrderHistryResult",required = false)
    public String GetOrderHistryResult;
}

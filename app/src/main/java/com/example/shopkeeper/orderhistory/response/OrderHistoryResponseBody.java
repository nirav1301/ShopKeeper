package com.example.shopkeeper.orderhistory.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class OrderHistoryResponseBody {
    @Element(name = "GetOrderHistryResponse", required = false)
    public OrderHistoryResponseModel orderHistoryResponseModel;
}

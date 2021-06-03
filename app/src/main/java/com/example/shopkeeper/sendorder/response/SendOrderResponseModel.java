package com.example.shopkeeper.sendorder.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "EmailPlaceOrderResponse")
public class SendOrderResponseModel {
    @Element(name = "SendOrderResult",required = false)
    public String SendOrderResult;
}

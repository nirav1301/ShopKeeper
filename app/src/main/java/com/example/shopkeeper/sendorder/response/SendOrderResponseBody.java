package com.example.shopkeeper.sendorder.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class SendOrderResponseBody {
    @Element(name = "SendOrderResponse", required = false)
    public SendOrderResponseModel sendOrderResponseModel;
}

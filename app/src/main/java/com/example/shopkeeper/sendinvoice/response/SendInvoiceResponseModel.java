package com.example.shopkeeper.sendinvoice.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "EmailPlaceOrderResponse")
public class SendInvoiceResponseModel {
    @Element(name = "EmailPlaceOrderResult",required = false)
    public String EmailPlaceOrderResult;
}

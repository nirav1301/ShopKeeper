package com.example.shopkeeper.sendinvoice.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class SendInvoiceResponseBody {
    @Element(name = "EmailPlaceOrderResponse", required = false)
    public SendInvoiceResponseModel sendInvoiceResponseModel;

}

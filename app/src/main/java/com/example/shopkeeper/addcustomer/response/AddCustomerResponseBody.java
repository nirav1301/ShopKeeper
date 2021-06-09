package com.example.shopkeeper.addcustomer.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class AddCustomerResponseBody {
    @Element(name = "AddCustomerResponse", required = false)
    public AddCustomerResponseModel addCustomerResponseModel;
}

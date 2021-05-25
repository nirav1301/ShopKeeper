package com.example.shopkeeper.findcustomer.Response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class FindCustomerResponseBody {
    @Element(name = "FindCustomerResponse", required = false)
    public FindCustomerReponseModel findCustomerReponseModel;
}

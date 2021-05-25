package com.example.shopkeeper.findcustomer.Response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "FindCustomerResponse")
@Namespace(reference = "http://tempuri.org/")

public class FindCustomerReponseModel {
    @Element(name = "FindCustomerResult",required = false)
    public String FindCustomerResult;
}

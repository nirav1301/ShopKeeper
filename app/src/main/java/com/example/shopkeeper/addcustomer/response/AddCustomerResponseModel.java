package com.example.shopkeeper.addcustomer.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "AddCustomerResponse")
@Namespace(reference = "http://tempuri.org/")
public class AddCustomerResponseModel {
    @Element(name = "AddCustomerResult ",required = false)
    public String AddCustomerResult ;
}

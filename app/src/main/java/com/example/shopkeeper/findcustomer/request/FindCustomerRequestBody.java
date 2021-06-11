package com.example.shopkeeper.findcustomer.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class FindCustomerRequestBody {
    @Element(name = "FindCustomer", required = false)
    public RequestFindCustomer requestFindCustomer;

    public static class RequestFindCustomer {
            @Attribute(name = "xmlns")
            public String xmlns;

            @Element(name = "searchtext", required = false)
            public String searchtext;

            @Element(name = "companyId", required = false)
            public String companyId;
    }
}

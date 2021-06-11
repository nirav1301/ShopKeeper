package com.example.shopkeeper.createorder.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class CreateOrderResponseBody {
    @Element(name = "GetProductDetailByProductCodeResponse", required = false)
    public CreateOrderResponseModel createOrderResponseModel;
}

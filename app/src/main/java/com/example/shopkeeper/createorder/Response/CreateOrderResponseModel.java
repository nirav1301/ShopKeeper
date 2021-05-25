package com.example.shopkeeper.createorder.Response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "GetProductDetailByProductCodeResponse")
@Namespace(reference = "http://tempuri.org/")
public class CreateOrderResponseModel {
    @Element(name = "GetProductDetailByProductCodeResult",required = false)
    public String GetProductDetailByProductCodeResult;
}

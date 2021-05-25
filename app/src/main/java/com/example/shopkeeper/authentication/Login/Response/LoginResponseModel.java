package com.example.shopkeeper.authentication.Login.Response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "ValidateUserResponse")
@Namespace(reference = "http://tempuri.org/")

public class LoginResponseModel {
    @Element(name = "ValidateUserResult",required = false)
    public String ValidateUserResult;
}

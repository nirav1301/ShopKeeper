package com.example.shopkeeper.authentication.login.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class LoginResponseBody {
    @Element(name = "ValidateUserResponse", required = false)
    public LoginResponseModel loginResponseModel;
}

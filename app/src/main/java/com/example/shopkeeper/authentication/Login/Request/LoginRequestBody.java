package com.example.shopkeeper.authentication.Login.Request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body", strict = false)
public class LoginRequestBody {
    @Element(name = "ValidateUser", required = false)
    public LoginRequestBody.RequestUserLogin requestUserLogin;

    public static class RequestUserLogin {
        @Attribute(name = "xmlns")
        public String xmlns;

        @Element(name = "loginId", required = false)
        public String loginId;

        @Element(name = "password", required = false)
        public String password;

    }
}

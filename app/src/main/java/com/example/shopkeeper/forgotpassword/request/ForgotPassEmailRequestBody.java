package com.example.shopkeeper.forgotpassword.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 用户角色返回body
 * Created by Jeeson on 16/7/15.
 */
@Root(name = "soap:Body", strict = false)
public class ForgotPassEmailRequestBody {

    @Element(name = "ForgotPasswordEmail", required = false)
    public RequestForgotPassEmail requestForgotPassEmail;

     public static class RequestForgotPassEmail {
        @Attribute(name = "xmlns")
        public String xmlns;

        @Element(name = "ToEmailID", required = false)
        public String emailID;

    }
}

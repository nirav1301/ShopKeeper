package com.example.shopkeeper.forgotpassword.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "ForgotPasswordEmailResponse")
@Namespace(reference = "http://tempuri.org/")
public class ForgotPassEmailResponseModel {

    @Element(name = "ForgotPasswordEmailResult",required = false)
    public String ForgotPasswordEmailResult;

}

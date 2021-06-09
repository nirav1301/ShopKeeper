package com.example.shopkeeper.forgotpassword.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 用户角色返回body
 * Created by Jeeson on 16/7/15.
 */
@Root(name = "soap:Body", strict = false)
public class ForgotPassEmailResponseBody {

    @Element(name = "ForgotPasswordEmailResponse", required = false)
    public ForgotPassEmailResponseModel forgotPassEmailResponseModel;


}

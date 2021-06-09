package com.example.shopkeeper.forgotpassword.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * 用户角色返回总信息
 * Created by Jeeson on 16/7/15.
 */
@Root(name = "soap:Envelope")
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class ForgotPasswordResponseEnvelope {
    @Element(name = "Body")
    public ForgotPassEmailResponseBody body;

}

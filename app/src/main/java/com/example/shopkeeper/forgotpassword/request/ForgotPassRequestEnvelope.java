package com.example.shopkeeper.forgotpassword.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;


/**
 * 用户角色请求Envelope
 * Created by Jeeson on 16/7/15.
 */
@Root(name = "soap:Envelope")
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class ForgotPassRequestEnvelope {
    @Element(name = "soap:Body", required = false)
    public ForgotPassEmailRequestBody body;

}

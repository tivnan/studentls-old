package com.tivnan.studentls.webservice;


import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "HelloWorld", targetNamespace = "http://studentls.tivnan.com/")
public interface HlloWorld {
    String sayHello(@WebParam(name = "str") String str);
}

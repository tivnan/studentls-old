package com.tivnan.studentls.webservice;

import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @project: studentls
 * @description:
 * @author: tivnan
 * @create: 2020-2020/11/26-上午12:50
 * @version:
 **/
@Component("helloWorld")
@WebService(endpointInterface = "com.tivnan.studentls.webservice.HlloWorld", serviceName = "HelloWorld", targetNamespace = "http://studentls.tivnan.com/")
public class HlloWorldImpl implements HlloWorld {

    @Override
    public String sayHello(String str) {
        return "Hello"+str;
    }
}

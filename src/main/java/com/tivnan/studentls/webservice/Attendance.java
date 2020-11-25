package com.tivnan.studentls.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "Attendance", targetNamespace = "http://studentls.tivnan.cn/")
public interface Attendance {
    Integer leaveNum(@WebParam(name = "id") Integer id);
}

package com.tivnan.studentls.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "Attendance", targetNamespace = "http://studentls.tivnan.cn/")
public interface Attendance {
    Integer leaveNum(@WebParam(name = "courseId") Integer courseId,
                     @WebParam(name = "week") Integer week,
                     @WebParam(name = "time") Integer time);
}

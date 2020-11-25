package com.tivnan.studentls.webservice;

import com.tivnan.studentls.dao.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @project: studentls
 * @description:
 * @author: tivnan
 * @create: 2020-2020/11/26-上午1:16
 * @version:
 **/
@Component("attendance")
@WebService(endpointInterface = "com.tivnan.studentls.webservice.Attendance", serviceName = "Attendance", targetNamespace = "http://studentls.tivnan.cn/")
public class AttendanceImpl implements Attendance {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public Integer leaveNum(Integer id) {

        return courseMapper.countByleaveNum(id);

    }
}

package com.tivnan.studentls.webservice;

import com.tivnan.studentls.bean.CourseExample;
import com.tivnan.studentls.bean.Times;
import com.tivnan.studentls.bean.TimesExample;
import com.tivnan.studentls.dao.CourseMapper;
import com.tivnan.studentls.dao.TimesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

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

    @Autowired
    TimesMapper timesMapper;

//    public Integer leaveNum(Integer id) {
//
//        return courseMapper.countByleaveNum(id);
//
//    }

    @Override
    public Integer leaveNum(Integer courseId, Integer week, Integer time) {

        TimesExample timesExample = new TimesExample();

        TimesExample.Criteria criteria = timesExample.createCriteria();

        criteria.andCourseIdEqualTo(courseId);
        criteria.andTimeEqualTo(time);
        criteria.andWeekEqualTo(week);

        Integer id = timesMapper.selectByExampleWithTimesId(timesExample);

        return courseMapper.countByleaveNum(id);

    }


}

package com.tivnan.studentls.service;

import com.tivnan.studentls.bean.StudentExample;
import com.tivnan.studentls.bean.Teacher;
import com.tivnan.studentls.bean.TeacherExample;
import com.tivnan.studentls.dao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project: studentls
 * @description: service of tescher
 * @author: tivnan
 * @create: 2020-2020/11/21-下午4:52
 * @version: 1.0
 **/
@Service
public class TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    public Teacher login(String openID) {

        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andOpenIdEqualTo(openID);

        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);

        if (teachers.size()==0||teachers==null) {
            return null;
        }else{
            return teachers.get(0);
        }
    }
}

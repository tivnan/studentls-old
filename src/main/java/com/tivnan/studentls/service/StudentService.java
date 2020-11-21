package com.tivnan.studentls.service;

import com.tivnan.studentls.bean.Student;
import com.tivnan.studentls.bean.StudentExample;
import com.tivnan.studentls.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project: studentls
 * @description: in charge of login
 * @author: tivnan
 * @create: 2020-2020/11/20-下午2:26
 * @version: 1.0
 **/
@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;

    public Student login(String openID) {

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andOpenIdEqualTo(openID);

        List<Student> students = studentMapper.selectByExample(studentExample);

        if (students.size()==0||students==null) {
            return null;
        }else{
            return students.get(0);
        }

//        return studentMapper.selectByExample(studentExample).get(0);
    }

}

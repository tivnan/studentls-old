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

    public Student login(String openID, Integer id) {

        Student student = studentMapper.selectByPrimaryKey(id);

//        先确认这个身份是不是真的存在
        if (student == null) {
            return null;
        }

//        确认学生号和openid是不是确实对应
        if (student.getOpenId() != null && openID.equals(student.getOpenId())) {
            return student;
        }

        if (student.getOpenId() != null && !openID.equals(student.getOpenId())) {
            return null;
        }

        if (student.getOpenId() == null) {
            student.setOpenId(openID);
            studentMapper.updateByPrimaryKey(student);
            return student;
        }

        return null;


//        StudentExample studentExample = new StudentExample();
//        StudentExample.Criteria criteria = studentExample.createCriteria();
//        criteria.andOpenIdEqualTo(openID);
//
//        List<Student> students = studentMapper.selectByExample(studentExample);
//
//        if (students.size()==0||students==null) {
//            return null;
//        }else{
//            return students.get(0);
//        }

//        return studentMapper.selectByExample(studentExample).get(0);
    }

}

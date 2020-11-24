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

//        先确认openid有没有
//          有，比对id和记录的id
//                相同，登录成功
//                 不同，一个设备尝试登录多个账号或者打错id
//          没，查找id有没有
//                有，插入openid到这个账号，登录成功
//                 没，id错了

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andOpenIdEqualTo(openID);
        List<Student> students = studentMapper.selectByExample(studentExample);

        if (students != null && students.size() != 0) {
            if (students.get(0).getStudentId().equals(id)) {
                return students.get(0);
            } else {
                return null;
            }
        } else {
            Student student = studentMapper.selectByPrimaryKey(id);

            if (student != null) {
                student.setOpenId(openID);
                studentMapper.updateByPrimaryKey(student);
                return student;
            } else {
                return null;
            }
        }


//        Student student = studentMapper.selectByPrimaryKey(id);
//
////        先确认这个身份是不是真的存在
//        if (student == null) {
//            return null;
//        }
//
////        确认学生号和openid是不是确实对应
//        if (student.getOpenId() != null && openID.equals(student.getOpenId())) {
//            return student;
//        }
//
//        if (student.getOpenId() != null && !openID.equals(student.getOpenId())) {
//            return null;
//        }
//
//        if (student.getOpenId() == null) {
//            student.setOpenId(openID);
//            studentMapper.updateByPrimaryKey(student);
//            return student;
//        }
//
//        return null;


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

    public Student login(String openID) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andOpenIdEqualTo(openID);
        List<Student> students = studentMapper.selectByExample(studentExample);

        if (students != null && students.size() != 0) {
            return students.get(0);
        }

        return null;
    }
}

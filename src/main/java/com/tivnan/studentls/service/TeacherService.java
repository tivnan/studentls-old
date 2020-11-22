package com.tivnan.studentls.service;

import com.tivnan.studentls.bean.Student;
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

    public Teacher login(String openID,Integer id) {

        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andOpenIdEqualTo(openID);

        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);

        if (teachers != null && teachers.size() != 0) {
            if (teachers.get(0).getTeacherId().equals(id)) {
                return teachers.get(0);
            } else {
                return null;
            }
        } else {
            Teacher teacher = teacherMapper.selectByPrimaryKey(id);

            if (teacher != null) {
                teacher.setOpenId(openID);
                teacherMapper.updateByPrimaryKey(teacher);
                return teacher;
            } else {
                return null;
            }
        }



//        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
//
////        先确认这个身份是不是真的存在
//        if (teacher == null) {
//            return null;
//        }
//
////        确认学生号和openid是不是确实对应
//        if (teacher.getOpenId() != null && openID.equals(teacher.getOpenId())) {
//            return teacher;
//        }
//
//        if (teacher.getOpenId() != null && !openID.equals(teacher.getOpenId())) {
//            return null;
//        }
//
//        if (teacher.getOpenId() == null) {
//            teacher.setOpenId(openID);
//            teacherMapper.updateByPrimaryKey(teacher);
//            return teacher;
//        }
//
//        return null;


//        TeacherExample teacherExample = new TeacherExample();
//        TeacherExample.Criteria criteria = teacherExample.createCriteria();
//        criteria.andOpenIdEqualTo(openID);
//
//        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
//
//        if (teachers.size()==0||teachers==null) {
//            return null;
//        }else{
//            return teachers.get(0);
//        }
    }
}

package com.tivnan.studentls.dao;

import com.tivnan.studentls.bean.vo.Section;
import com.tivnan.studentls.bean.Student;
import com.tivnan.studentls.bean.StudentExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer studentId);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);


    //    查找信息
    List<Section> selectWithSection(@Param("studentId") Integer studentId,
                                    @Param("timeWeek") Integer timeWeek,
                                    @Param("timeSlotBegin") Integer timeSlotBegin,
                                    @Param("timeSlotEnd") Integer timeSlotEnd);


}
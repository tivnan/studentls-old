package com.tivnan.studentls.bean.vo;

/**
 * @project: studentls
 * @description: section
 * @author: tivnan
 * @create: 2020-2020/11/22-下午5:07
 * @version: 1.0
 **/
public class Section {
    private Integer id;

    private String courseName;

    private String teacherName;

    private Integer timeWeek;

    private Integer timeSlot;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTimeWeek() {
        return timeWeek;
    }

    public void setTimeWeek(Integer timeWeek) {
        this.timeWeek = timeWeek;
    }

    public Integer getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Integer timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "Section{" +
                "courseId=" + id +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", timeWeek=" + timeWeek +
                ", timeSLot=" + timeSlot +
                '}';
    }
}

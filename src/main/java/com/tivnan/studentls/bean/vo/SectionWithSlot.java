package com.tivnan.studentls.bean.vo;

/**
 * @project: studentls
 * @description: change the week day and week slot to str
 * @author: tivnan
 * @create: 2020-2020/11/23-上午3:47
 * @version: 2.0
 **/
public class SectionWithSlot {

    private Integer id;
    private String courseName;
    private String teacher;
    private String timeSlot;

    public SectionWithSlot(Section section) {
        this.id = section.getId();
        this.courseName = section.getCourseName();
        this.teacher = section.getTeacherName();
        this.timeSlot = weekToTimeSlot(section.getTimeWeek(), section.getTimeSlot());
    }

    @Override
    public String toString() {
        return "SectionWithSlot{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", teacher='" + teacher + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                '}';
    }

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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String weekToTimeSlot(Integer timeWeek, Integer timeSlot) {

        String weekDay = "";
        String slot = "";

//        一：1~4
//        二：5~8
//        三：9~12
//        四：13~16
//        五：17~20
        if (timeSlot == 1 || timeSlot == 2 || timeSlot == 3 || timeSlot == 4) {
            weekDay = "一";
        } else if (timeSlot == 5 || timeSlot == 6 || timeSlot == 7 || timeSlot == 8) {
            weekDay = "二";
        } else if (timeSlot == 9 || timeSlot == 10 || timeSlot == 11 || timeSlot == 12) {
            weekDay = "三";
        } else if (timeSlot == 13 || timeSlot == 14 || timeSlot == 15 || timeSlot == 16) {
            weekDay = "四";
        } else if (timeSlot == 17 || timeSlot == 18 || timeSlot == 19 || timeSlot == 20) {
            weekDay = "五";
        }


//        1 5 9 13 17
//        2 6 10 14 18
//        3 7 11 15 19
//        4 8 12 16 20
        if (timeSlot == 1 || timeSlot == 5 || timeSlot == 9 || timeSlot == 13 || timeSlot == 17) {
            slot = "1-2";
        } else if (timeSlot == 2 || timeSlot == 6 || timeSlot == 10 || timeSlot == 14 || timeSlot == 18) {
            slot = "3-4";
        } else if (timeSlot == 3 || timeSlot == 7 || timeSlot == 11 || timeSlot == 15 || timeSlot == 19) {
            slot = "5-6";
        } else if (timeSlot == 4 || timeSlot == 8 || timeSlot == 12 || timeSlot == 16 || timeSlot == 20) {
            slot = "7-8";
        }

        return "第" + timeWeek + "周"
                + " "
                + "周" + weekDay
                + " "
                + "第" + slot + "节";

    }
}

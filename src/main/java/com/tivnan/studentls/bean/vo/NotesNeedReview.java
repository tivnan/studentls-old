package com.tivnan.studentls.bean.vo;

/**
 * @project: studentls
 * @description:
 * @author: tivnan
 * @create: 2020-2020/11/25-下午9:50
 * @version:
 **/
public class NotesNeedReview {

           /* "reqId|5":"adfafa",
            "sectionId|5":"adfffa",
            "courseId|5":"dqdqwdqddqd",
            "courseName":"@string(6,12)",
            "sectionTime":"第10周 周二 5-6节",
            "stuName":"@cname",
            "stuId|3":"2313",
            "reqType":"@integer(1, 2)",
            "content":"@string(40, 120)"*/

    private String reqId;
    private Integer sectionId;
    private Integer courseId;
    private String courseName;
    private String sectionTime;
    private String stuName;
    private Integer stuId;
    private Integer reqType;
    private String content;

    public NotesNeedReview() {
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(String sectionTime) {
        this.sectionTime = sectionTime;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getReqType() {
        return reqType;
    }

    public void setReqType(Integer reqType) {
        this.reqType = reqType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void updateSectionTime() {

        String aXb = getSectionTime();

//        开始时间
        String a = aXb.substring(0, aXb.indexOf("X"));
//        结束时间
        String b = aXb.substring(a.length() + 1, aXb.length());

    }
}

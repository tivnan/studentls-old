package com.tivnan.studentls.bean.vo;

/**
 * @project: studentls
 * @description: Note With Stu Name
 * @author: tivnan
 * @create: 2020-2020/11/24-上午11:27
 * @version: 1.0
 **/
public class NoteWithStuName {

    private String noteId;

    private String startTime;

    private String endTime;

    private String content;

    private long state;

    private Integer type;

    private String studentName;

    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public NoteWithStuName() {
    }

    public NoteWithStuName(String noteId,
                           String startTime,
                           String endTime,
                           String content,
                           long state,
                           Integer type,
                           String studentName,
                           String course_name) {
        this.noteId = noteId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.content = content;
        this.state = state;
        this.type = type;
        this.studentName = studentName;
        this.courseName = course_name;
    }

    @Override
    public String toString() {
        return "NoteWithStuName{" +
                "noteId='" + noteId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", type=" + type +
                ", studentName='" + studentName + '\'' +
                ", course_name='" + courseName + '\'' +
                '}';
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}

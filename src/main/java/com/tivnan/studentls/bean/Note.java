package com.tivnan.studentls.bean;

public class Note {
    private String noteId;

    private String startTime;

    private String endTime;

    private String content;

    private Integer state;

    private Integer type;

    private Integer studentId;

    public Note() {
    }

    public Note(String noteId, String startTime, String endTime, String content, Integer state, Integer type, Integer studentId) {
        this.noteId = noteId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.content = content;
        this.state = state;
        this.type = type;
        this.studentId = studentId;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId == null ? null : noteId.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
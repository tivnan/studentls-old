package com.tivnan.studentls.bean;

import com.tivnan.studentls.bean.vo.Section;

import java.util.List;

public class Note {
    private String noteId;

    private String startTime;

    private String endTime;

    private String content;

    private long state;

    private Integer type;

    private Integer studentId;

//    SelectedLIst selectedList;

    public Note() {
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId='" + noteId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", type=" + type +
                ", studentId=" + studentId +
                '}';
    }

    public Note(String startTime,
                String endTime,
                String content,
                Integer type,
                Integer studentId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.content = content;
        this.type = type;
        this.studentId = studentId;
    }

    public Note(String noteId,
                String startTime,
                String endTime,
                String content,
                Integer state,
                Integer type,
                Integer studentId) {
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

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
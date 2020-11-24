package com.tivnan.studentls.bean;

public class HitsKey {
    private String noteId;

    private Integer courseId;

    public HitsKey() {
    }

    public HitsKey(String noteId, Integer courseId) {
        this.noteId = noteId;
        this.courseId = courseId;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
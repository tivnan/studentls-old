package com.tivnan.studentls.bean;

/**
 * @project: studentls
 * @description:
 * @author: tivnan
 * @create: 2020-2020/11/25-下午12:39
 * @version:
 **/
public class Review {
    private String noteId;
    private Integer id;
    private Integer timesId;

    public Review(String noteId, Integer id, Integer timesId) {
        this.noteId = noteId;
        this.id = id;
        this.timesId = timesId;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimesId() {
        return timesId;
    }

    public void setTimesId(Integer timesId) {
        this.timesId = timesId;
    }
}

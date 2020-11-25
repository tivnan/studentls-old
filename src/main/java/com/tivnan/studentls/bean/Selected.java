package com.tivnan.studentls.bean;

/**
 * @project: studentls
 * @description:
 * @author: tivnan
 * @create: 2020-2020/11/25-下午4:06
 * @version:
 **/
public class Selected {
    private String noteId;
    private Integer timesId;

    public Selected() {
    }

    public Selected(String noteId, Integer timesId) {
        this.noteId = noteId;
        this.timesId = timesId;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public Integer getTimesId() {
        return timesId;
    }

    public void setTimesId(Integer timesId) {
        this.timesId = timesId;
    }
}

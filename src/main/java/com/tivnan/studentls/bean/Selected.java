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
    private String timesId;

    public Selected() {
    }

    public Selected(String noteId, String timesId) {
        this.noteId = noteId;
        this.timesId = timesId;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getTimesId() {
        return timesId;
    }

    public void setTimesId(String timesId) {
        this.timesId = timesId;
    }
}

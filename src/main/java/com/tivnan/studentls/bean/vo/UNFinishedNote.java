package com.tivnan.studentls.bean.vo;

import com.tivnan.studentls.bean.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @project: studentls
 * @description:
 * @author: tivnan
 * @create: 2020-2020/11/25-下午9:02
 * @version:
 **/
public class UNFinishedNote {
//        "reqType": "@integer(1, 2)",
//            "startDate": "@date('yy-MM-dd')",
//            "endDate": "@date('yy-MM-dd')",
//            "total": "@integer(1, 12)",
//            "content": "@string(40, 120)",

    private Integer reqType;
    private String startDate;
    private String endDate;
    private Integer total;
    private String content;

    public UNFinishedNote() {
    }

    public Integer getReqType() {
        return reqType;
    }

    public void setReqType(Integer reqType) {
        this.reqType = reqType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UNFinishedNote(Note note) {
        reqType = note.getType();
        startDate = note.getStartTime();
        endDate = note.getEndTime();
        total = getTotalDate(startDate, endDate);
        content=note.getContent();
    }

    public Integer getTotalDate(String startDate, String endDate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date smdate = null;
        Date bdate = null;
        try {
            smdate = dateFormat.parse(startDate);
            bdate = dateFormat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();

        long between_days = (time2 - time1) / (1000 * 3600 * 24)+1;
        return Integer.parseInt(String.valueOf(between_days));

    }
}

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
 * @create: 2020-2020/11/25-下午8:44
 * @version:
 **/
public class FinishedNote {

//    {
//        "processType": "@integer(1, 2)",
//            "reqType": "@integer(1, 2)",
//            "startDate": "@date('yy-MM-dd')",
//            "endDate": "@date('yy-MM-dd')",
//            "total": "@integer(1, 12)",
//    }

    private Integer processType;
    private Integer reqType;
    private String startDate;
    private String endDate;
    private Integer total;

    public FinishedNote() {
    }

    public Integer getProcessType() {
        return processType;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
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

    //    0: 审核拒绝
//    1： 审核通过
//    改为
//          1通过
//          2拒绝
    public FinishedNote(Note note) {

        if (Math.toIntExact(note.getState()) == 0) {
            processType = 2;
        } else {
            processType = 1;
        }
        reqType = note.getType();
        startDate = note.getStartTime();
        endDate = note.getEndTime();
        total = getTotalDate(startDate, endDate);
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

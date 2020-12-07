package com.tivnan.studentls.utils;

import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @project: studentls
 * @description: transfer date to time slot
 * @author: tivnan
 * @create: 2020-2020/11/23-上午12:08
 * @version: 1.0
 **/
public class DataAndSlot {

    public static List<Integer> data2slot(String date) {
//        yy-mm-dd转换为
//        [x,y]
//        第x周，周y

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Integer> list = new ArrayList<>();

        try {
            Date nowDate = dateFormat.parse(date);
            Date registDate = dateFormat.parse("2020-09-01");

            //        一年中的第几周
            dateFormat.applyPattern("w");
            String weekOfYearI = dateFormat.format(nowDate);
            String registWeekOfYearI = dateFormat.format(registDate);

            int registWeekOfYear = Integer.parseInt(registWeekOfYearI);
            int weekOfYear = Integer.parseInt(weekOfYearI);

//            相对开学的第几周
            list.add((weekOfYear - registWeekOfYear + 1));


            dateFormat.applyPattern("E");
            String weekDate = dateFormat.format(nowDate);

//            周一：Monday Mon. 周二：Tuesday Tue. 周三：Wednesday Wed. 周四：Thursday Thur. 周五：Friday Fri

            if ("Mon".equals(weekDate)) {
                list.add(1);
            } else if ("Tue".equals(weekDate)) {
                list.add(2);
            } else if ("Wed".equals(weekDate)) {
                list.add(3);
            } else if ("Thu".equals(weekDate)) {
                list.add(4);
            } else if ("Fri".equals(weekDate)) {
                list.add(5);
            } else {
                list.add(0);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return list;
    }

//    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = dateFormat.parse("2020-09-06");
//        System.out.println("date = " + date);
//
//        dateFormat.applyPattern("w");
//        System.out.println("第" + dateFormat.format(date) + "周");
//
//        dateFormat.applyPattern("E");
//        System.out.println("周" + dateFormat.format(date));
//
//    }

    //    将weekXtime转换成第几周第几节
    public static String weekXtimeToSlot(String weekXtime) {
        String week = weekXtime.substring(0, weekXtime.indexOf("X"));
        String time = weekXtime.substring(week.length() + 1, weekXtime.length());

        int timeSlot = Integer.parseInt(time);

        String weekDay = "";
        String slot = "";

//        一：1~4
//        二：5~8
//        三：9~12
//        四：13~16
//        五：17~20
        if (timeSlot == 1 || timeSlot == 2 || timeSlot == 3 || timeSlot == 4) {
            weekDay = "一";
        } else if (timeSlot == 5 || timeSlot == 6 || timeSlot == 7 || timeSlot == 8) {
            weekDay = "二";
        } else if (timeSlot == 9 || timeSlot == 10 || timeSlot == 11 || timeSlot == 12) {
            weekDay = "三";
        } else if (timeSlot == 13 || timeSlot == 14 || timeSlot == 15 || timeSlot == 16) {
            weekDay = "四";
        } else if (timeSlot == 17 || timeSlot == 18 || timeSlot == 19 || timeSlot == 20) {
            weekDay = "五";
        }


//        1 5 9 13 17
//        2 6 10 14 18
//        3 7 11 15 19
//        4 8 12 16 20
        if (timeSlot == 1 || timeSlot == 5 || timeSlot == 9 || timeSlot == 13 || timeSlot == 17) {
            slot = "1-2";
        } else if (timeSlot == 2 || timeSlot == 6 || timeSlot == 10 || timeSlot == 14 || timeSlot == 18) {
            slot = "3-4";
        } else if (timeSlot == 3 || timeSlot == 7 || timeSlot == 11 || timeSlot == 15 || timeSlot == 19) {
            slot = "5-6";
        } else if (timeSlot == 4 || timeSlot == 8 || timeSlot == 12 || timeSlot == 16 || timeSlot == 20) {
            slot = "7-8";
        }

        return "第" + week + "周"
                + " "
                + "周" + weekDay
                + " "
                + "第" + slot + "节";
    }


}

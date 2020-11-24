package com.tivnan.studentls.utils;

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

            if ("Mon".equals(weekDate))
                list.add(1);
            else if ("Tue".equals(weekDate))
                list.add(2);
            else if ("Wed".equals(weekDate))
                list.add(3);
            else if ("Thu".equals(weekDate))
                list.add(4);
            else if ("Fri".equals(weekDate))
                list.add(5);
            else
                list.add(0);

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

}

package com.tivnan.studentls.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @project: studentls
 * @description:
 * @author: tivnan
 * @create: 2020-2020/11/24-下午9:08
 * @version:
 **/
public class SEToDates {

    public static List<String> SEToDates(String startTime, String endTime) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date startDate = simpleDateFormat.parse(startTime);
            Date endDate = simpleDateFormat.parse(endTime);

            ArrayList<String> list = new ArrayList<>();

            if (startTime.equals(endTime)) {
                list.add(startTime);
                return list;

            } else {
                list.add(startTime);


                Calendar calendar = Calendar.getInstance();
                calendar.setTime(startDate);
                calendar.add(Calendar.DAY_OF_MONTH, 1);

                String nextDate = simpleDateFormat.format(calendar.getTime());

                while (!nextDate.equals(endTime)) {
                    list.add(nextDate);

                    calendar.add(Calendar.DAY_OF_MONTH, 1);

                    nextDate = simpleDateFormat.format(calendar.getTime());
                }

                list.add(endTime);
                return list;
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

//    public static void main(String[] args) {
//        List<String> strings = SEToDates("2020-09-07", "2020-09-19");
//        System.out.println(strings);
//    }

}

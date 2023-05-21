package com.a3fun.learn.java.common;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    @Test
    public void Test1() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date nowTime = df.parse(df.format(new Date()));
        Date dayTimeStart = df.parse("08:00:00");
        Date dayTimeEnd = df.parse("20:00:00");
        if (timeCalendar(nowTime, dayTimeStart, dayTimeEnd)) {
            System.out.println("这里是白天");
        }else{
            System.out.println("这里是晚上");
        }
    }
    public boolean timeCalendar(Date nowTime, Date dayTimeStart, Date dayTimeEnd) {
        //设置当前时间
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        //设置开始时间
        Calendar timeStart = Calendar.getInstance();
        timeStart.setTime(dayTimeStart);
        //设置结束时间
        Calendar timeEnd = Calendar.getInstance();
        timeEnd.setTime(dayTimeEnd);
        if (date.after(timeStart) && date.before(timeEnd)) {
            return true;
        } else {
            return false;
        }
    }
}

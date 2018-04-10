package com.boot.study;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by hujh on 2018/3/27.
 */
public class Main {


    public static void main(String[] args) {
        test2();
    }


    public static void test2() {
        String content = "20170";
        String pattern = "\\d{6}";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("isMatch:" + isMatch);
    }

    public static void test1() {
        String str = "201712";
        String y = str.substring(0, 4);
        String m = str.substring(4);
        Date d = calendarToData(Integer.parseInt(y), Integer.parseInt(m), 1);
        System.out.println(d.getYear());
        System.out.println(d.getMonth());
        System.out.println(d.getTime());
    }

    public static Long parse(String str) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        String y = str.substring(0, 4);
        cal.set(Calendar.YEAR, Integer.parseInt(y));
        String m = str.substring(4);
        cal.set(Calendar.MONTH, Integer.parseInt(m));
        return cal.getTimeInMillis();
    }



    public static Date calendarToData(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();//日历类的实例化
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.set(year, month - 1, day);//设置日历时间，月份必须减一
        Date date = calendar.getTime(); // 从一个 Calendar 对象中获取 Date 对象
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        return date;
    }

    public static Calendar dataToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

}

package com.pika.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用来将日期和字符串相互转换的工具类
 */
public class DateTransfer {
    // 时间转换成字符串
    public static String date2String(Date date, String format){
        DateFormat df = new SimpleDateFormat(format);
        String s = df.format(date);
        return s;
    }

    // 字符串转换成时间
    public static Date string2Date(String str, String format) throws ParseException {
        DateFormat df = new SimpleDateFormat(format);
        return df.parse(str);
    }

}

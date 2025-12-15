package com.mimu.simple.java.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeRelevant {
    // 该对象是线程安全的
    protected static final DateTimeFormatter TIME_FORMATTER_DAY = DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            TIME_FORMATTER_MILLSECOND = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Test
    public void timeFormat(){
        String timeStr="2024-11-26 00:00:00.000";
        /*String format = TIME_FORMATTER_MILLSECOND.format(now);
        System.out.println(format);*/
        LocalDateTime parse = LocalDateTime.parse(timeStr, TIME_FORMATTER_MILLSECOND);
        System.out.println(parse);
        System.out.println(parse.isAfter(LocalDateTime.now()));
    }
}

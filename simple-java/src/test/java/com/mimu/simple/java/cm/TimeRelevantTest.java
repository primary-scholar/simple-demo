package com.mimu.simple.java.cm;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.time.LocalDateTime;

public class TimeRelevantTest {

    @Test
    public void test() {
        String time = "2024-10";
        String registerTime = StringUtils.isEmpty(time) ? "1971-1-1" : time;
        String[] split = registerTime.split("-");
        if (split.length < 3
                || LocalDateTime.now().isAfter(LocalDateTime.of(NumberUtils.toInt(split[0], 1971),
                NumberUtils.toInt(split[1], 11), NumberUtils.toInt(split[2],
                        1), 0, 0).plusDays(9))) {
            System.out.println(true);
        }
    }
}

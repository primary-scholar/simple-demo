package com.mimu.simple.java.cm;

import com.mimu.simple.java.abase.Student;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StringRelevantTest {
    private static final Logger log = LoggerFactory.getLogger(StringRelevantTest.class);

    @Test
    public void test() {
        String abc = "#abc#124#5678#da";
        Integer s1 = 0, s2 = 4, s3 = 8, s4 = 13, s12Len = s2 - s1 + 1, s34Len = s4 - s3 + 1;
        System.out.println(abc);
        StringBuilder replace = new StringBuilder(abc).replace(s1, s2 + 1, StringUtils.repeat("&", s12Len));
        System.out.println(replace);
        StringBuilder replaced = new StringBuilder(replace).replace(s3, s4 + 1, StringUtils.repeat("&", s34Len));
        System.out.println(replaced);

        String bcd = "";
        System.out.println(Arrays.asList(bcd.split(",")));
    }

    @Test
    public void test2() {
        ArrayList<Student> list = new ArrayList<>(NumberUtils.INTEGER_TWO);
        Collections.fill(list, null);
        System.out.println(list.size());
        for (Student student : list) {
            System.out.println(student);
        }
    }
}

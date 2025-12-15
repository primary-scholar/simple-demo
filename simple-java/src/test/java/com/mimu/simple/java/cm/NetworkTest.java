package com.mimu.simple.java.cm;


import com.mimu.simple.java.abase.Student;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * author: mimu
 * date: 2019/7/12
 */
public class NetworkTest {

    @Before
    public void init() {
        Properties properties = new Properties();
        properties.put("a", "a");
        properties.put("b", "b");
        System.setProperties(properties);
    }

    @Test
    public void info() {
        System.out.println(System.getProperty("a"));
        System.out.println(System.getProperty("b"));
    }

    @Test
    public void info1() {
        List<Student> objects = Collections.emptyList();
        Map<Long, List<Student>> collect = objects.stream().collect(Collectors.groupingBy(new Function<Student, Long>() {
            @Override
            public Long apply(Student student) {
                return student.getStId();
            }
        }));
        System.out.println(collect);
    }

    @Test
    public void equalTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(RandomUtils.nextLong(0, list.size()));
        System.out.println(RandomUtils.nextLong());
        System.out.println(RandomUtils.nextLong());
    }
}

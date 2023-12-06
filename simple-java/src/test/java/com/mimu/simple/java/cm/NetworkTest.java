package com.mimu.simple.java.cm;


import com.mimu.simple.java.fastjson.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
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

    }
}

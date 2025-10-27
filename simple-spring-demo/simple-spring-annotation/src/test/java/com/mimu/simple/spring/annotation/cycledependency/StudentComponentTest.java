package com.mimu.simple.spring.annotation.cycledependency;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class StudentComponentTest {

    @Test
    public void info() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(CycleDependencyConfig.class);
        StudentComponent bean = configApplicationContext.getBean(StudentComponent.class);
        log.info("student component {}", JSONObject.toJSONString(bean));
    }

}
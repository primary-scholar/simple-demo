package com.mimu.simple.spring.annotation.cycledependency;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentComponentTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(CycleDependencyConfig.class);
        System.out.println(configApplicationContext.getBean(StudentComponent.class));
    }

}
package com.mimu.simple.spring.annotation.autowires;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

@Slf4j
public class SimpleAutowireTest {

    @Test
    public void info() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.mimu.simple.spring.annotation.autowires");
        context.refresh();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            log.info(beanDefinitionName);
        }
        int beanDefinitionCount = context.getBeanDefinitionCount();
        Assert.isTrue(beanDefinitionCount == 7, "7");
        context.close();
    }

}
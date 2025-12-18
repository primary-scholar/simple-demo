package com.mimu.simple.spring.annotation.packagescan;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ComponentScanTest {

    @Test
    public void info() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.mimu.simple.spring.annotation.packagescan.inner");
        context.refresh();
        log.info("bean name: {}", List.of(context.getBeanDefinitionNames()));
        log.info("bean count {}", context.getBeanDefinitionCount());
        context.close();
    }


    @Test
    public void info1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.mimu.simple.spring.annotation.packagescan.layer");
        context.refresh();
        log.info("bean name: {}", List.of(context.getBeanDefinitionNames()));
        log.info("bean count {}", context.getBeanDefinitionCount());
        context.close();
    }

    @Test
    public void info2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.mimu.simple.spring.annotation.packagescan");
        context.refresh();
        log.info("bean name: {}", List.of(context.getBeanDefinitionNames()));
        log.info("bean count {}", context.getBeanDefinitionCount());
        context.close();
    }

}
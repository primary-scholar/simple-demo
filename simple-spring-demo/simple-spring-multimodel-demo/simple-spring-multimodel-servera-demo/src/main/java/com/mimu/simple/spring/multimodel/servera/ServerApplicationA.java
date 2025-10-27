package com.mimu.simple.spring.multimodel.servera;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class ServerApplicationA {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.mimu.simple.spring.multimodel");
        context.refresh();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            log.info(beanDefinitionName);
        }
        log.info("bean count {}", context.getBeanDefinitionCount());
        context.close();
    }
}

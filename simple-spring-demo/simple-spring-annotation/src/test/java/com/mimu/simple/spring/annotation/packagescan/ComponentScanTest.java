package com.mimu.simple.spring.annotation.packagescan;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class ComponentScanTest {

    @Test
    public void info() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.mimu.simple.spring.annotation.packagescan.inner");
        context.refresh();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            log.info("bean definition name {}", beanDefinitionName);
        }
        log.info("bean count {}", context.getBeanDefinitionCount());
        context.close();
    }
}

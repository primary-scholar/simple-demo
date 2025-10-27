package com.mimu.simple.spring.annotation.dependency;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author: mimu
 * date: 2019/10/17
 */
@Slf4j
public class DependencyFunctionTest {
    @Test
    public void info() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(DependencyConfig.class);
        log.info("objectA {}",configApplicationContext.getBean(ObjectA.class));
        log.info("objectB {}",configApplicationContext.getBean(ObjectB.class));
    }
}
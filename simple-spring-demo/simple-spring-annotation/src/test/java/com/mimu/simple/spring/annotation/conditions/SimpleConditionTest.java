package com.mimu.simple.spring.annotation.conditions;


import com.mimu.simple.spring.annotation.conditions.config.SimpleConditionAnnotationConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class SimpleConditionTest {

    @Test
    public void info() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(SimpleConditionAnnotationConfig.class);
        configApplicationContext.refresh();
        for (String s : configApplicationContext.getBeanDefinitionNames()) {
            log.info(s);
        }
        configApplicationContext.getEnvironment().getSystemProperties().forEach((key, value) -> log.info(key + "=" + value));
    }

}
package com.mimu.simple.spring.lifecycle;


import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 不添加以下两个注解也ok
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class SpringAnnotationLifeCycleTest {

    @Test
    public void info() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Person person = annotationConfigApplicationContext.getBean("person", Person.class);
        log.info("person:{}", JSONObject.toJSONString(person));
    }

    @Test
    public void factoryBeanTest() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        CustomFactoryBean bean = annotationConfigApplicationContext.getBean(CustomFactoryBean.class);
        try {
            log.info("bean:{}", JSONObject.toJSONString(bean.getObject()));
        } catch (Exception e) {
        }
    }
}

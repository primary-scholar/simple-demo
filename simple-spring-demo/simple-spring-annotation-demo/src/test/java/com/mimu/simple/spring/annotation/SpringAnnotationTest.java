package com.mimu.simple.spring.annotation;

import com.mimu.simple.spring.annotation.config.ApplicationConfig;
import com.mimu.simple.spring.annotation.event.AsyncTranEvent;
import com.mimu.simple.spring.annotation.handler.AsyncTranEventHandler;
import com.mimu.simple.spring.annotation.model.PersonData;
import com.mimu.simple.spring.annotation.model.TermData;
import com.mimu.simple.spring.annotation.service.CommonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class SpringAnnotationTest {

    @Autowired
    private AsyncTranEventHandler asyncTranEventHandler;

    @Test
    public void info() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.refresh();
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Test
    public void info1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.refresh();
        CommonService commonService = context.getBean(CommonService.class);
        commonService.saveInfo(new PersonData(1, ""), new TermData());
        System.out.println(commonService.getPeople(1));
    }

    @Test
    public void test() {
        asyncTranEventHandler.onTranEvent(new AsyncTranEvent());
    }

}

package com.mimu.simple.springboot.dubbo.consumer;

import com.mimu.simple.springboot.dubbo.consumer.config.ServiceConsumerConfig;
import com.mimu.simple.springboot.dubbo.consumer.service.CommonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author: mimu
 * date: 2019/10/12
 */
public class SBDCApplicationTest {

    @Test
    public void info(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(ServiceConsumerConfig.class);
        configApplicationContext.refresh();
        System.out.println(configApplicationContext.getBean(CommonService.class).getUserData(1));

    }
}
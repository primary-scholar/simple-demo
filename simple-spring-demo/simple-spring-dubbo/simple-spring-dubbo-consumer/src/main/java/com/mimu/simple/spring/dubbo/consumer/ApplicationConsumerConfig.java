package com.mimu.simple.spring.dubbo.consumer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * author: mimu
 * date: 2019/10/15
 */
@Configuration
@ImportResource(value = {"classpath:consumer.xml"})
public class ApplicationConsumerConfig {

}
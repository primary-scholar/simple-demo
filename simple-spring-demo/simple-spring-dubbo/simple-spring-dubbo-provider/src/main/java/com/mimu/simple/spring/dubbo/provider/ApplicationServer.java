package com.mimu.simple.spring.dubbo.provider;

import com.mimu.simple.spring.dubbo.provider.config.ApplicationConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationServer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.refresh();
        context.start();
        DubboBootstrap instance = DubboBootstrap.getInstance();
        instance.start().await();


    }
}

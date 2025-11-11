package com.mimu.simple.spring.dubbo.provider.service;

import com.mimu.simple.spring.dubbo.api.HelloApi;
import com.mimu.simple.spring.dubbo.api.model.HelloData;
import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements HelloApi {
    @Override
    public String sayHello(String name) {
        return "";
    }

    @Override
    public HelloData sayHelloData(String name) {
        return null;
    }
}

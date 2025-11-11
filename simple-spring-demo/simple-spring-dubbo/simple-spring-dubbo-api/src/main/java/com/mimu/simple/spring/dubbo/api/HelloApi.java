package com.mimu.simple.spring.dubbo.api;

import com.mimu.simple.spring.dubbo.api.model.HelloData;

public interface HelloApi {

    String sayHello(String name);

    HelloData sayHelloData(String name);

}
package com.mimu.simple.sd.consumer.service;

import com.mimu.simple.sd.api.HelloStringApi;
import com.mimu.simple.sd.core.model.HelloData;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;


/**
 * author: mimu
 * date: 2019/9/18
 */


@Service
public class HelloService {
    @Reference(check = false, retries = 0,version = "*")
    private HelloStringApi helloStringApi;

    public HelloData getHello(String name) {
        return helloStringApi.hello(name);
    }
}

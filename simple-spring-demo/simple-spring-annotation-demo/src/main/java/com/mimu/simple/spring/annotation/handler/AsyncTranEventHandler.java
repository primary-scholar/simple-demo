package com.mimu.simple.spring.annotation.handler;

import com.mimu.simple.spring.annotation.event.AsyncTranEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class AsyncTranEventHandler {

    @Async
    @EventListener(AsyncTranEvent.class)
    public void onTranEvent(AsyncTranEvent event){
        System.out.println(1/0);
    }
}

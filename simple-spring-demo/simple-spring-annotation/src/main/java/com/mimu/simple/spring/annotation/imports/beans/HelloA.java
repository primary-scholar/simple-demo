package com.mimu.simple.spring.annotation.imports.beans;

import com.mimu.simple.spring.annotation.imports.api.Hello;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloA implements Hello {
    @Override
    public void sayHi() {
        log.info("HI A");
    }
}

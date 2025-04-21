package com.mimu.simple.java;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleLoggerTest {

    public void info() {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            log.error("wrong", e);
        }
    }

}

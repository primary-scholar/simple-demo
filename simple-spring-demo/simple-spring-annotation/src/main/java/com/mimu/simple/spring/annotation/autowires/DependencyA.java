package com.mimu.simple.spring.annotation.autowires;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DependencyA implements IDependency {
    public void info() {
        log.info("this is dependencyA");
    }
}

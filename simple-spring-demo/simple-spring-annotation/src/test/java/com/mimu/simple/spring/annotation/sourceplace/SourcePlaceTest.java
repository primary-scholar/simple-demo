package com.mimu.simple.spring.annotation.sourceplace;

import com.mimu.simple.spring.annotation.sourceplace.config.SourceConfig;
import com.mimu.simple.spring.annotation.sourceplace.model.DomainA;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author: mimu
 * date: 2019/12/16
 */

@Slf4j
public class SourcePlaceTest {
    private static  final Logger serverLogger = LoggerFactory.getLogger("serverLogger");

    @Test
    public void info() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(SourceConfig.class);
        log.info("bean {}", configApplicationContext.getBean(DomainA.class));
        serverLogger.info("bean {}", configApplicationContext.getBean(DomainA.class));
        log.error("bean {}", configApplicationContext.getBean(DomainA.class));
    }
}
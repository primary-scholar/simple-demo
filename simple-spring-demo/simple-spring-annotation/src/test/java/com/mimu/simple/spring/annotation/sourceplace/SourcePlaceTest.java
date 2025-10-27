package com.mimu.simple.spring.annotation.sourceplace;

import com.mimu.simple.spring.annotation.sourceplace.config.SourceConfig;
import com.mimu.simple.spring.annotation.sourceplace.model.DomainA;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author: mimu
 * date: 2019/12/16
 */

@Slf4j
public class SourcePlaceTest {

    @Test
    public void info() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(SourceConfig.class);
        log.info("bean {}", configApplicationContext.getBean(DomainA.class));
    }
}

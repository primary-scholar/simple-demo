package com.mimu.simple.spring.annotation.imports;

import com.mimu.simple.spring.annotation.imports.config.BeanImportConfig;
import com.mimu.simple.spring.annotation.imports.config.BeanImportDefinitionRegistrarConfig;
import com.mimu.simple.spring.annotation.imports.config.BeanImportSelectorConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class SimpleImportTest {

    @Test
    public void importInfo() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(BeanImportConfig.class);
        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            log.info("beanDefinitionName:{}", beanDefinitionName);
        }
        configApplicationContext.close();
    }

    @Test
    public void importSelectorInfo() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(BeanImportSelectorConfig.class);
        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            log.info("beanDefinitionName:{}", beanDefinitionName);
        }
        configApplicationContext.close();
    }

    @Test
    public void importBeanDefinitionInfo() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(BeanImportDefinitionRegistrarConfig.class);
        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            log.info("beanDefinitionName:{}", beanDefinitionName);
        }
        configApplicationContext.close();
    }
}
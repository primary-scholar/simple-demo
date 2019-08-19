package com.mimu.simple.psa;

import com.mimu.simple.psa.imports.config.BeanImportConfig;
import com.mimu.simple.psa.imports.config.BeanImportDefinitionRegistraConfig;
import com.mimu.simple.psa.imports.config.BeanImportSelectorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimpleImportTest {

    public static void main(String[] args) {
        SimpleImportTest simpleImportTest = new SimpleImportTest();
        //simpleImportTest.importInfo();
        //simpleImportTest.importSelectorInfo();
        simpleImportTest.importBeanDefinitionInfo();
    }

    public void importInfo(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(BeanImportConfig.class);
        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    public void importSelectorInfo(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(BeanImportSelectorConfig.class);
        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    public void importBeanDefinitionInfo(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(BeanImportDefinitionRegistraConfig.class);
        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}

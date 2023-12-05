package com.mimu.simple.spring.file.lifecycle.l;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * author: mimu
 * date: 2019/1/14
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {

    public CustomBeanPostProcessor() {
        System.out.println("CustomBeanPostProcessor constructor() invoke...");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        String format = String.format("CustomBeanPostProcessor postProcessBeforeInitialization() bean %s beanName %s", bean.getClass(), beanName);
        System.out.println(format);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        String format = String.format("CustomBeanPostProcessor postProcessAfterInitialization() bean %s beanName %s", bean.getClass(), beanName);
        System.out.println(format);
        return bean;
    }
}

package com.mimu.simple.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * author: mimu
 * date: 2019/1/14
 */
@Component
public class CustomInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("CustomInstantiationAwareBeanPostProcessor postProcessBeforeInstantiation() invoke...");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("CustomInstantiationAwareBeanPostProcessor postProcessAfterInstantiation() invoke...");
        return Boolean.TRUE;
    }
}

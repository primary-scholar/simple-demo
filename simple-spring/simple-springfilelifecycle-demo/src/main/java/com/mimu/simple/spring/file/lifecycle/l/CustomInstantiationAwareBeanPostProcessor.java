package com.mimu.simple.spring.file.lifecycle.l;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * author: mimu
 * date: 2019/1/14
 */
public class CustomInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        String format = String.format("CustomInstantiationAwareBeanPostProcessor postProcessProperties() invoke... pvs %s,bean %s,beanName %s", pvs, bean.getClass(), beanName);
        System.out.println(format);
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        String format = String.format("CustomInstantiationAwareBeanPostProcessor postProcessBeforeInitialization() invoke...,bean %s,beanName %s", bean.getClass(), beanName);
        System.out.println(format);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        String format = String.format("CustomInstantiationAwareBeanPostProcessor postProcessAfterInitialization() invoke...,bean %s,beanName %s", bean.getClass(), beanName);
        System.out.println(format);
        return bean;
    }
}

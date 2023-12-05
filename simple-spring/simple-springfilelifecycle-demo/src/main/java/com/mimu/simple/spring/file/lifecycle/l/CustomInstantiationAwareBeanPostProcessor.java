package com.mimu.simple.spring.file.lifecycle.l;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

/**
 * author: mimu
 * date: 2019/1/14
 */
public class CustomInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public CustomInstantiationAwareBeanPostProcessor() {
        super();
        String format = String.format("CustomInstantiationAwareBeanPostProcessor constructor() invoke... ");
        System.out.println(format);
    }

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        String format = String.format("CustomInstantiationAwareBeanPostProcessor predictBeanType() invoke... beanClass %s,beanName %s", beanClass.getClass(), beanName);
        System.out.println(format);
        return super.predictBeanType(beanClass, beanName);
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        String format = String.format("CustomInstantiationAwareBeanPostProcessor determineCandidateConstructors() invoke... beanClass %s,beanName %s", beanClass.getClass(), beanName);
        System.out.println(format);
        return super.determineCandidateConstructors(beanClass, beanName);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        String format = String.format("CustomInstantiationAwareBeanPostProcessor getEarlyBeanReference() invoke... bean %s,beanName %s", bean.getClass(), beanName);
        System.out.println(format);
        return super.getEarlyBeanReference(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        String format = String.format("CustomInstantiationAwareBeanPostProcessor postProcessBeforeInstantiation() invoke... beanClass %s,beanName %s", beanClass.getClass(), beanName);
        System.out.println(format);
        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        String format = String.format("CustomInstantiationAwareBeanPostProcessor postProcessAfterInstantiation() invoke... bean %s,beanName %s", bean.getClass(), beanName);
        System.out.println(format);
        return super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        String format = String.format("CustomInstantiationAwareBeanPostProcessor postProcessProperties() invoke... pvs %s,bean %s,beanName %s", pvs, bean.getClass(), beanName);
        System.out.println(format);
        return super.postProcessProperties(pvs, bean, beanName);
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        String format = String.format("CustomInstantiationAwareBeanPostProcessor postProcessPropertyValues() invoke... pvs %s,pds %s,bean %s,beanName %s", pvs, pds, bean.getClass(), beanName);
        System.out.println(format);
        return super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        String format = String.format("CustomInstantiationAwareBeanPostProcessor postProcessBeforeInitialization() invoke... bean %s,beanName %s", bean.getClass(), beanName);
        System.out.println(format);
        return super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        String format = String.format("CustomInstantiationAwareBeanPostProcessor postProcessAfterInitialization() invoke... bean %s,beanName %s", bean.getClass(), beanName);
        System.out.println(format);
        return super.postProcessAfterInitialization(bean, beanName);
    }
}

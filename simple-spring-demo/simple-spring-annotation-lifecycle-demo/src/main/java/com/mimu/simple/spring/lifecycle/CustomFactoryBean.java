package com.mimu.simple.spring.lifecycle;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author luyahui
 * @date 2023/12/4
 * @description
 */
@Component
public class CustomFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        Person person = new Person();
        person.setName("factory bean set name");
        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}

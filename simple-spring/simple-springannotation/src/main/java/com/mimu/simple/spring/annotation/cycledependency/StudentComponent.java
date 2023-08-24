package com.mimu.simple.spring.annotation.cycledependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentComponent extends PersonComponent {

    @Autowired
    private PersonComponent personComponent;

}

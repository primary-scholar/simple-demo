package com.mimu.simple.spring.annotation.cycledependency;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class StudentComponent extends PersonComponent {

    @Autowired
    private PersonComponent personComponent;

}

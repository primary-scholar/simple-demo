package com.mimu.simple.spring.annotation.cycledependency;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class PersonComponent {
    private String name;
}

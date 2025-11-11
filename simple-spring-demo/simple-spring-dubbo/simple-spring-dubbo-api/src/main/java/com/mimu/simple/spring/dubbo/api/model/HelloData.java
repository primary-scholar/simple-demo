package com.mimu.simple.spring.dubbo.api.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
public class HelloData implements Serializable {
    @Serial
    private static final long serialVersionUID = 2887291716774055279L;

    private String name;
}

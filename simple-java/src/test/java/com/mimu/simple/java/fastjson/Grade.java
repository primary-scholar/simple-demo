package com.mimu.simple.java.fastjson;

import lombok.Getter;
import lombok.Setter;

import java.io.PipedReader;
import java.io.Serializable;

/**
 * @author luyahui
 * @date 2023/9/27
 * @description
 */
@Setter
@Getter
public class Grade implements Serializable {
    private Integer degree;
    private String degreeDesc;
}

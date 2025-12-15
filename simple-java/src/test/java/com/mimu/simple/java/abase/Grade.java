package com.mimu.simple.java.abase;

import lombok.Getter;
import lombok.Setter;

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

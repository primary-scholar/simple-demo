package com.mimu.simple.java.abase;

import com.mimu.simple.java.abase.Grade;
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
public class Student implements Serializable {
    private Long stId;
    private Grade grade;
}

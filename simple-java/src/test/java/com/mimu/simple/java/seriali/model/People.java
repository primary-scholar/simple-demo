package com.mimu.simple.java.seriali.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 如果该类 定义在某个类的内部，即内部类如果不使用static修饰，序列化时会报错
 */
@Setter
@Getter
@ToString
public class People implements Serializable {
    private String name;
    private int age;
}

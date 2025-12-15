package com.mimu.simple.java.seriali.model;

import lombok.Getter;
import lombok.Setter;

/**
 * FastJson 是根据 getXXX() isXXX() 方法来获取key的 因此被序列化的 对象必须有 getXXX() 方法 或 isXXX() 方法
 */
@Setter
@Getter
public class FastJsonFeaturePeople {
    private String name;
    private int age;

}

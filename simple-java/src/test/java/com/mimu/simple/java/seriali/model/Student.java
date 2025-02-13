package com.mimu.simple.java.seriali.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 1.一个类如果需要序列化，则必须要实现 Serializable 接口；
 * 1.1 当前类可以明确使用 implements Serializable 语法
 * 1.2 当前类也可以继承一个 已经实现了 Serializable 接口的类；
 *1.1.1 如果当前类 继承了某个没有实现 Serializable 接口的类，并且在当前类中实现了 Serializable 接口，则序列化时 父类中的字段将不可序列化；
 */
@Setter
@Getter
@ToString(callSuper = true)
public class Student extends People {
    private Integer classNo;
}

package com.mimu.simple.java.generic;

public class GenericFunction {


    /**
     * 该方法是一个 泛型方法 该方法中的 <T> 的类型 和泛型类中的 <T> 是毫无关系的 类型(可相同，可不同)
     *
     * @param type
     * @param <T>
     * @return
     */
    public <T> T apply(T type) {
        return type;
    }
}

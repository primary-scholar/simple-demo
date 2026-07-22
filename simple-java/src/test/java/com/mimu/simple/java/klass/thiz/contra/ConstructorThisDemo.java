package com.mimu.simple.java.klass.thiz.contra;

public class ConstructorThisDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.SubClazz subClazz = outer.newObject();
        System.out.println(subClazz);
    }
}

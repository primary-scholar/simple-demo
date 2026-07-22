package com.mimu.simple.java.klass.thiz.filedz;

public class ParentClass {

    protected String parentField = "父类字段";

    public void parentMethod() {
        // 这里的 this 指向当前实例
        // 由于内部类继承了 ParentClass，内部类对象就是 ParentClass 的实例
        System.out.println("父类方法中的 this: " + this.getClass().getName());
        System.out.println("父类字段: " + this.parentField);
        System.out.println("this 的哈希码: " + System.identityHashCode(this));
    }

    public void testThis() {
        System.out.println("父类的 testThis 方法:");
        System.out.println("this 的类: " + this.getClass());
        System.out.println("this 是否等于子类实例: " + (this == this)); // 永远 true
    }
}

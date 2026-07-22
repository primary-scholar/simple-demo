package com.mimu.simple.java.klass.thiz.filedz;

public class ThisDemo {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();

        System.out.println("外部类对象: " + System.identityHashCode(outer));
        System.out.println("内部类对象: " + System.identityHashCode(inner));
        System.out.println("=== 调用内部类的 showThis ===");
        inner.showThis();

        System.out.println("\n=== 直接调用父类方法 ===");
        inner.parentMethod(); // 通过内部类调用父类方法
    }
}

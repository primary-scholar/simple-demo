package com.mimu.simple.java.klass.thiz.filedz;

public class OuterClass {
    private String outerField = "外部类字段";


    // 内部类继承 ParentClass
    class InnerClass extends ParentClass {
        private String innerField = "内部类字段";

        public InnerClass() {
            // 调用父类构造器
            super();
        }

        public void showThis() {
            System.out.println("内部类方法中的 this: " + this.getClass().getName());
            // this 指向内部类实例
            System.out.println("内部类字段: " + this.innerField);
            // 可以访问父类字段
            System.out.println("父类字段（通过 this）: " + this.parentField);

            // 调用父类方法
            this.parentMethod(); // this 会传递给父类方法

            // 访问外部类
            System.out.println("外部类字段: " + OuterClass.this.outerField);
        }
    }
}

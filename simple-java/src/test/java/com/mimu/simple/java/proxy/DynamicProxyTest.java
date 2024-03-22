package com.mimu.simple.java.proxy;

import org.junit.Test;

/**
 * author: mimu
 * date: 2018/12/4
 */
public class DynamicProxyTest {

    @Test
    public void printInfo() {
        SubjectInterface subjectInterface = new DynamicProxy(new Subject()).getProxyObject();
        subjectInterface.printInfo();
        subjectInterface.printInfoAgain();
        // jdk 动态代理必须实现接口
        //SubjectNonInterface proxyObject = new DynamicProxy(new SubjectNonInterface()).getProxyObject();
        //proxyObject.printSomething();
    }
}

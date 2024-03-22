package com.mimu.simple.java.proxy;

import org.junit.Test;

/**
 * author: mimu
 * date: 2018/12/4
 */
public class CglibProxyTest {

    @Test
    public void printInfo() {
        Subject subject = new CglibProxy().getProxy(Subject.class);
        subject.printInfo();
        subject.printInfoAgain();
        SubjectNonInterface proxy = new CglibProxy().getProxy(SubjectNonInterface.class);
        proxy.printSomething();
    }
}

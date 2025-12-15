package com.mimu.simple.java.lock;


/**
 * author: mimu
 * date: 2019/12/6
 */
public class LockRelevantTest {

    public void info3() {
        LockRelevant.InnerLock3 innerLock3 = new LockRelevant.InnerLock3(false);
        new Thread(() -> {
            for (int i = 1; i < 100; i += 2) {
                innerLock3.printOdd(i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 2; i < 100; i += 2) {
                innerLock3.printEvent(i);
            }
        }).start();
    }

    /**
     * 在JUnit的@Test方法中启用多线程，新启动的线程会随着@Test主线程的结束而结束
     * 即 info2() 方法执行完毕 其开启的 两个线程同时也会执行完毕
     */
    public void info2() {
        LockRelevant.InnerLock2 innerLock2 = new LockRelevant.InnerLock2(false);
        new Thread(() -> {
            while (true) {
                innerLock2.printA();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                innerLock2.printB();
            }
        }).start();
    }

    public void info1() {
        LockRelevant.InnerLock1 innerLock1 = new LockRelevant.InnerLock1(false);
        new Thread(() -> {
            while (true) {
                innerLock1.printA();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                innerLock1.printA();
            }
        }).start();
    }

    public static void main(String[] args) {
        LockRelevantTest test = new LockRelevantTest();
        test.info2();
        //test.info3();
    }

}
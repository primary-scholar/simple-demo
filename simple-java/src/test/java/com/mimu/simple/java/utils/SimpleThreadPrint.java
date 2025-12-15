package com.mimu.simple.java.utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleThreadPrint {
    private final ReentrantLock lock;
    private Integer flag;
    private final Condition c1;
    private final Condition c2;
    private final Condition c3;

    public SimpleThreadPrint() {
        this.lock = new ReentrantLock();
        this.c1 = lock.newCondition();
        this.c2 = lock.newCondition();
        this.c3 = lock.newCondition();
        this.flag = 1;
    }

    public void printA() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (flag != 1) {
                c1.await();
            }
            Thread.sleep(1000);
            System.out.print("咕咕");
            flag = 2;
            c2.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            Thread.sleep(1000);
            System.out.print("嘎嘎");
            flag = 3;
            c3.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            Thread.sleep(1000);
            System.out.println("呱呱");
            flag = 1;
            c1.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SimpleThreadPrint print = new SimpleThreadPrint();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printA();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printB();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printC();
            }
        }).start();
    }
}

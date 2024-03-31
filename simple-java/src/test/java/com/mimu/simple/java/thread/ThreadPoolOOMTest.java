package com.mimu.simple.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 由于ThreadLocalMap 的生命周期跟 Thread 一样长，对于重复利用的线程来说，
 * 如果没有手动删除（remove()方法）对应 key 就会导致entry(null，value)的对象越来越多，从而导致内存泄漏
 */
public class ThreadPoolOOMTest {
    private static final int size = 1024 * 1024 * 1024;
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException {
        new ThreadPoolOOMTest().oomFunction();
        //new ThreadPoolOOMTest().noneOomFunction();
    }

    public void noneOomFunction() {
        while (true) {
            executor.execute(() -> {
                ThreadLocal<byte[]> threadLocal = new ThreadLocal<>();
                threadLocal.set(ContentFillUtil.fillContent());
                System.out.println("thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadLocal.remove();
            });
        }
    }

    public void oomFunction() {
        while (true) {
            executor.execute(() -> {
                ThreadLocal<byte[]> threadLocal = new ThreadLocal<>();
                threadLocal.set(ContentFillUtil.fillContent());
                System.out.println("thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadLocal = null;
            });
        }
    }


    static class ContentFillUtil {

        public static byte[] fillContent() {
            byte[] content = new byte[size];
            for (int i = 0; i < size; i++) {
                content[i] = 'a';
            }
            return content;
        }
    }
}

package com.mimu.simple.java.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class ThreadLocalRelevantTest {

    /**
     * ThreadLocal 典型使用场景：
     * 1.方法调用期间 传递参数--调用方法时可以不明确指定参数(可以无参),而在ThreadLocal 中获取需要的参数数据；局限于同一个线程；
     * <p>
     * ThreadLocal 线程本地变量，同一个线程，对于执行过程中的 任何地方 都可以 从 threadLocal 中查询或存放数据，即对于当前线程
     * 它随时 可以获取 之前某个操作中 放入到 threadLocal 中的数据：典型应用场景 1；
     *
     * ThreadLocal并不是为了解决线程安全问题，而是提供了一种将变量绑定到当前线程的机制，类似于隔离的效果
     */
    static class ThreadLocalClassicScence {
        private static final ThreadLocal<AtomicInteger> threadLocal = ThreadLocal.withInitial(() -> new AtomicInteger(0));

        public void setData() {
            threadLocal.set(new AtomicInteger(10));
        }

        public void modifyData() {
            AtomicInteger atomicInteger = threadLocal.get();
            atomicInteger.incrementAndGet();
            threadLocal.set(atomicInteger);
        }

        /**
         * 同一个线程中可以获取到数据
         */
        public void printData() {
            System.out.printf("thread name %s, value=%s%n", Thread.currentThread().getName(), threadLocal.get());
        }

        /**
         * 不在同一个线程中 如子线程获取不到数据
         */
        public void printDataAgain() {
            new Thread(() -> {
                System.out.printf("thread name %s, value=%s%n", Thread.currentThread().getName(), threadLocal.get());
                System.out.println();
            }).start();
        }

    }

    /**
     * 对于 ThreadLocal 的局限性(不在同一个线程获取不到数据的问题) 可以使用 jdk 自带的  InheritableThreadLocal 来解决；
     * 但是这里 仅限于 子线程获取 父线程设置的数据；谨记：子线程！子线程！
     */
    static class ThreadLocalClassicScenceSecond {
        /**
         * 使用 InheritableThreadLocal 可以 子线程中 获取 父线程 设置的数据
         */
        private static final InheritableThreadLocal<AtomicInteger> threadLocal = new InheritableThreadLocal<>();

        public void setData() {
            threadLocal.set(new AtomicInteger(10));
        }

        public void modifyData() {
            AtomicInteger atomicInteger = threadLocal.get();
            atomicInteger.incrementAndGet();
            threadLocal.set(atomicInteger);
        }

        /**
         * 同一个线程中可以获取到数据
         */
        public void printData() {
            System.out.printf("thread name %s, value=%s%n", Thread.currentThread().getName(), threadLocal.get());
        }

        /**
         * 不在同一个线程中 如子线程也可以获取到数据
         */
        public void printDataAgain() {
            new Thread(() -> {
                System.out.printf("thread name %s, value=%s%n", Thread.currentThread().getName(), threadLocal.get());
                System.out.println();
            }).start();
        }

    }


    static class TaskFirst implements Runnable {
        private static final ThreadLocal<AtomicInteger> initValue = ThreadLocal.withInitial(() -> new AtomicInteger(0));

        @Override
        public void run() {
            AtomicInteger s = initValue.get();
            int initial = s.getAndIncrement();
            System.out.println(initial);
        }
    }

    static class TaskSecond implements Runnable {
        private static final ThreadLocal<AtomicInteger> initValue = ThreadLocal.withInitial(() -> new AtomicInteger(0));

        @Override
        public void run() {
            AtomicInteger s = initValue.get();
            int initial = s.getAndIncrement();
            System.out.println(initial);
            initValue.remove();
        }
    }

    @Test
    public void threadLocalClassicScenceResult() {
        ThreadLocalClassicScence classicScence = new ThreadLocalClassicScence();
        classicScence.setData();
        classicScence.modifyData();
        classicScence.printData();
        classicScence.printDataAgain();
        ThreadLocalClassicScenceSecond classicScenceSecond = new ThreadLocalClassicScenceSecond();
        classicScenceSecond.setData();
        classicScenceSecond.modifyData();
        classicScenceSecond.printData();
        classicScenceSecond.printDataAgain();
    }


    /**
     * in the task first test situation: the print result in run is not the initialized value
     * which we initialized in the ThreadLocal
     * here print is 0 1 2 not 0 0 0 why!!
     * because here we define a executorService with only one thread,
     * so the second task and the third task will reuse the first thread to execute the task
     * so in the second and third task will get the initialized value which it initialized in the first thread
     * so the result print is 0 1 2
     */
    @Test
    public void info1() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.execute(new TaskFirst());
        executor.execute(new TaskFirst());
        executor.execute(new TaskFirst());
        executor.shutdown();
    }

    /**
     * in the task second test situation: the only different point is that we invoke the remove() method
     * in the task logic so the result is we expect 0 0 0
     */
    @Test
    public void info() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.execute(new TaskSecond());
        executor.execute(new TaskSecond());
        executor.execute(new TaskSecond());
        executor.shutdown();
    }


    /**
     * 对于不使用 线程池的 线程，都是没有问题的 因为每次都是创建的新线程，不存在 同一线程内 上下文获取的 操作
     */
    @Test
    public void info2() {
        new Thread(new TaskFirst()).start();
        new Thread(new TaskFirst()).start();
        new Thread(new TaskFirst()).start();
        new Thread(new TaskSecond()).start();
        new Thread(new TaskSecond()).start();
        new Thread(new TaskSecond()).start();
    }

}

package com.mimu.simple.java.thread;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadLambdaTest {

    private final ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Test
    public void threadInterruptTest() {
        Future<?> waitTenSecond = executorService.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        try {
            Object o = waitTenSecond.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

}

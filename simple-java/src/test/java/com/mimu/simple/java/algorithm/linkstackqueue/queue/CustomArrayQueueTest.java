package com.mimu.simple.java.algorithm.linkstackqueue.queue;

import com.mimu.simple.java.algorithm.BaseTest;
import org.junit.Test;

import java.util.Objects;

public class CustomArrayQueueTest extends BaseTest {
    CustomArrayQueue<Integer> customArrayQueue = new CustomArrayQueue<>(capacity);

    @Test
    public void arrayQueueTest() {
        for (int i = 0; i < capacity; i++) {
            Boolean enQueue = customArrayQueue.enQueue((int) (Math.random() * 100) + i);
            assert enQueue.equals(Boolean.TRUE);
        }
        Boolean enQueue = customArrayQueue.enQueue(10);
        assert enQueue.equals(Boolean.FALSE);
        for (int i = 0; i < capacity; i++) {
            Integer object = customArrayQueue.deQueue();
            assert Objects.nonNull(object);
        }
        Integer queue = customArrayQueue.deQueue();
        assert Objects.isNull(queue);
    }
}

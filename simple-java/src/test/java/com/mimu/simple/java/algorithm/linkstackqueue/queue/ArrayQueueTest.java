package com.mimu.simple.java.algorithm.linkstackqueue.queue;

import com.mimu.simple.java.algorithm.BaseTest;
import org.junit.Test;

import java.util.Objects;

public class ArrayQueueTest extends BaseTest {
    ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(capacity);

    @Test
    public void arrayQueueTest() {
        for (int i = 0; i < capacity; i++) {
            Boolean enQueue = arrayQueue.enQueue((int) (Math.random() * 100) + i);
            assert enQueue.equals(Boolean.TRUE);
        }
        Boolean enQueue = arrayQueue.enQueue(10);
        assert enQueue.equals(Boolean.FALSE);
        for (int i = 0; i < capacity; i++) {
            Integer object = arrayQueue.deQueue();
            assert Objects.nonNull(object);
        }
        Integer queue = arrayQueue.deQueue();
        assert Objects.isNull(queue);
    }
}

package com.mimu.simple.java.algorithm;

import org.junit.Test;

import java.util.Objects;


public class ClassicStackQueueTest {
    private Integer capacity = (int) (Math.random() * 10) + 1;
    ClassicStackQueue.ArrayQueue<Integer> arrayQueue = new ClassicStackQueue.ArrayQueue<>(capacity);
    ClassicStackQueue.LinkQueue<Integer> linkQueue = new ClassicStackQueue.LinkQueue<>(capacity);

    @Test
    public void arrayQueueTest() {
        Integer integer = arrayQueue.deQueue();
        assert Objects.isNull(integer);
        for (Integer i = 0; i < capacity; i++) {
            Boolean enQueue = arrayQueue.enQueue((int) (Math.random() * 100) + i);
            assert enQueue.equals(Boolean.TRUE);
        }
        Boolean enQueue = arrayQueue.enQueue(10);
        assert enQueue.equals(Boolean.FALSE);
        for (Integer i = 0; i < capacity; i++) {
            Integer object = arrayQueue.deQueue();
            assert Objects.nonNull(object);
        }
        Integer queue = arrayQueue.deQueue();
        assert Objects.isNull(queue);
    }

    @Test
    public void linkQueueTest() {
        Integer integer = linkQueue.deQueue();
        assert Objects.isNull(integer);
        for (Integer i = 0; i < capacity; i++) {
            Boolean enQueue = linkQueue.enQueue((int) (Math.random() * 100) + i);
            assert enQueue.equals(Boolean.TRUE);
        }
        Boolean enQueue = linkQueue.enQueue(10);
        assert enQueue.equals(Boolean.FALSE);
        for (Integer i = 0; i < capacity; i++) {
            Integer object = linkQueue.deQueue();
            assert Objects.nonNull(object);
        }
        Integer queue = linkQueue.deQueue();
        assert Objects.isNull(queue);
    }

}
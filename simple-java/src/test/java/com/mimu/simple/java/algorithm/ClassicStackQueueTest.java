package com.mimu.simple.java.algorithm;

import org.junit.Test;

import java.util.Objects;


public class ClassicStackQueueTest {
    private Integer capacity = (int) (Math.random() * 10) + 1;
    ClassicStackQueue.ArrayQueue<Integer> arrayQueue = new ClassicStackQueue.ArrayQueue<>(capacity);
    ClassicStackQueue.LinkQueue<Integer> linkQueue = new ClassicStackQueue.LinkQueue<>(capacity);

    ClassicStackQueue.ArrayStack<Integer> arrayStack = new ClassicStackQueue.ArrayStack<>(capacity);

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

    @Test
    public void linkQueueTest() {
        for (int i = 0; i < capacity; i++) {
            Boolean enQueue = linkQueue.enQueue((int) (Math.random() * 100) + i);
            assert enQueue.equals(Boolean.TRUE);
        }
        Boolean enQueue = linkQueue.enQueue(10);
        assert enQueue.equals(Boolean.FALSE);
        for (int i = 0; i < capacity; i++) {
            Integer object = linkQueue.deQueue();
            assert Objects.nonNull(object);
        }
        Integer queue = linkQueue.deQueue();
        assert Objects.isNull(queue);
    }

    @Test
    public void arrayStackTest() {
        for (int i = 0; i < capacity; i++) {
            Boolean put = arrayStack.put((int) (Math.random() * 100) + i);
            assert put.equals(Boolean.TRUE);
        }
        Boolean put = arrayStack.put(10);
        assert Boolean.FALSE.equals(put);
        for (int i = 0; i < capacity; i++) {
            Integer integer = arrayStack.pop();
            assert Objects.nonNull(integer);
        }
        Integer integer = arrayStack.pop();
        assert Objects.isNull(integer);
    }

}
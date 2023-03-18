package com.mimu.simple.java.algorithm;

import org.junit.Test;


public class ClassicStackQueueTest {
    private Integer capacity = (int) (Math.random() * 20) + 1;
    ClassicStackQueue.ArrayQueue<Integer> arrayQueue = new ClassicStackQueue.ArrayQueue<>(capacity);

    @Test
    public void arrayQueueEnQueue() {
        Boolean enQueue = arrayQueue.enQueue(5);
        System.out.println(enQueue);
    }

}
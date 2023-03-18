package com.mimu.simple.java.algorithm;

import org.junit.Test;


public class ClassicStackQueueTest {
    private Integer capacity = (int) (Math.random() * 20) + 1;
    ClassicStackQueue.ArrayQueue<Integer> arrayQueue = new ClassicStackQueue.ArrayQueue<>(capacity);

    @Test
    public void arrayQueueEnQueue() {
        for (Integer i = 0; i < capacity; i++) {
            Boolean enQueue = arrayQueue.enQueue((int) (Math.random() * 100) + i);
            if (!enQueue) {
                System.out.println("error");
            }
        }
        Boolean enQueue = arrayQueue.enQueue(10);
        System.out.println(enQueue);
    }

}
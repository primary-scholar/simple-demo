package com.mimu.simple.java.algorithm;

import org.apache.tools.ant.types.Environment;

import static org.junit.Assert.*;

public class ClassicStackQueueTest {
    private Integer capacity = (int) (Math.random() * 20) + 1;
    ClassicStackQueue.ArrayQueue<Integer> arrayQueue = new ClassicStackQueue.ArrayQueue<>(capacity);

    public void arrayQueueEnQueue() {
        arrayQueue.enQueue(5);
    }

}
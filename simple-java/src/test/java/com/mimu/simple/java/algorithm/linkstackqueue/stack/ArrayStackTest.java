package com.mimu.simple.java.algorithm.linkstackqueue.stack;

import com.mimu.simple.java.algorithm.BaseTest;
import org.junit.Test;

import java.util.Objects;

public class ArrayStackTest extends BaseTest {

    ArrayStack<Integer> arrayStack = new ArrayStack<>(capacity);

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

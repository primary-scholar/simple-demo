package com.mimu.simple.java.algorithm.linkstackqueue.stack;

import com.mimu.simple.java.algorithm.BaseTest;
import org.junit.Test;

import java.util.Objects;

public class LinkStackTest extends BaseTest {
    LinkStack<Integer> linkStack = new LinkStack<>(capacity);

    @Test
    public void linkStackTest() {
        for (int i = 0; i < capacity; i++) {
            Boolean put = linkStack.put((int) (Math.random() * 100) + i);
            assert put.equals(Boolean.TRUE);
        }
        Boolean put = linkStack.put(10);
        assert Boolean.FALSE.equals(put);
        for (int i = 0; i < capacity; i++) {
            Integer integer = linkStack.pop();
            assert Objects.nonNull(integer);
        }
        Integer integer = linkStack.pop();
        assert Objects.isNull(integer);
    }
}

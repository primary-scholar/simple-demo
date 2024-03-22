package com.mimu.simple.java.algorithm.linkstackqueue.queue;

import com.mimu.simple.java.algorithm.BaseTest;
import org.junit.Test;

import java.util.Objects;

public class LinkQueueTest extends BaseTest {
    LinkQueue<Integer> linkQueue = new LinkQueue<>(capacity);

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
}

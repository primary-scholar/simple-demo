package com.mimu.simple.java.algorithm;

/**
 * 栈和队列 的实现方式可以有 链表 和 数组两种方式实现
 */
public class ClassicStackQueue extends ClassicNodeRelevant {

    public void inQueue(NodeQueue<Integer> queue, Integer data) {
    }

    public static class NodeQueue<T> {
        private DoubleNodeLink<T> head;
        private DoubleNodeLink<T> tail;
    }

}

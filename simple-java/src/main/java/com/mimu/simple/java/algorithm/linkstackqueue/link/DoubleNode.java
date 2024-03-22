package com.mimu.simple.java.algorithm.linkstackqueue.link;

import lombok.Getter;
import lombok.Setter;

/**
 * 双链表
 *
 * @param <T>
 */
@Setter
@Getter
public class DoubleNode<T> {
    private T data;
    private DoubleNode<T> pre;
    private DoubleNode<T> next;

    public DoubleNode(T data) {
        this.data = data;
        this.pre = null;
        this.next = null;
    }
}

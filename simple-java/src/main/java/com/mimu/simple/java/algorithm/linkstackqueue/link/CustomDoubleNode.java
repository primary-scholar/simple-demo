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
public class CustomDoubleNode<T> {
    private T data;
    private CustomDoubleNode<T> pre;
    private CustomDoubleNode<T> next;

    public CustomDoubleNode(T data) {
        this.data = data;
        this.pre = null;
        this.next = null;
    }
}

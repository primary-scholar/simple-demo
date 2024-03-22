package com.mimu.simple.java.algorithm.linkstackqueue.link;

import lombok.Getter;
import lombok.Setter;

/**
 * 单链表
 */
@Setter
@Getter
public class SingleNode<T> {
    private T data;
    private SingleNode<T> next;

    public SingleNode(T data) {
        this.data = data;
        this.next = null;
    }
}

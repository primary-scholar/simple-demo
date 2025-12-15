package com.mimu.simple.java.algorithm.linkstackqueue.link;

import lombok.Getter;
import lombok.Setter;

/**
 * 单链表
 */
@Setter
@Getter
public class CustomSingleNode<T> {
    private T data;
    private CustomSingleNode<T> next;

    public CustomSingleNode(T data) {
        this.data = data;
        this.next = null;
    }
}
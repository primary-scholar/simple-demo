package com.mimu.simple.java.algorithm.linkstackqueue.queue;

import com.mimu.simple.java.algorithm.linkstackqueue.link.DoubleNode;

import java.util.Objects;

/**
 * 链表实现队列
 * 链表实现的队列 可使用 双链表保存数据，初始时 给定容量 capacity 使用 num 记录当前数据中的 数据个数
 * <p>
 * 首先初始化 时 为 capacity，head，tail，num 赋值
 * <p>
 * 入队操作：首先判断 数组元素的个数 num >= capacity 如果true 则表示 队列已满，否则 创建一个双向链表 节点 并把该节点 放在 head的 pre 方向，然后向前移动head 到新
 * 创建的 节点上 (这里注意 双向链表的 pre，next 的赋值操作)
 * 同时 num++
 * <p>
 * 出队操作：首先判断 num<=0 如果 true 则队列已空 ，如果 num=1 则除了取值外 还要为 head tail 节点置空
 * 同时 num--
 * 若 num>1 则 tail 节点前移 并删除 tail 节点即可 同时 num--；
 *
 * @param <T>
 */
public class LinkQueue<T> {
    private Integer capacity;
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private Integer num;

    public LinkQueue(Integer capacity) {
        if (Objects.isNull(capacity) || capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.num = 0;
    }

    public Boolean enQueue(T data) {
        if (num >= capacity) {
            return Boolean.FALSE;
        }
        DoubleNode<T> element = new DoubleNode<>(data);
        if (Objects.isNull(head)) {
            head = element;
            tail = element;
        } else {
            head.setPre(element);
            element.setNext(head);
            head = element;
        }
        num++;
        return Boolean.TRUE;
    }

    public T deQueue() {
        if (num <= 0) {
            return null;
        }
        T data;
        if (num == 1) {
            data = (T) tail.getData();
            head = null;
            tail = null;
        } else {
            DoubleNode<T> pre = tail.getPre();
            pre.setNext(null);
            data = (T) tail.getData();
            tail.setPre(null);
            tail = pre;
        }
        num--;
        return data;
    }

}

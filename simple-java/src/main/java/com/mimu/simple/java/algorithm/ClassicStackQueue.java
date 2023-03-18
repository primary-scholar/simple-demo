package com.mimu.simple.java.algorithm;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 栈和队列 的实现方式可以有 链表 和 数组两种方式实现
 */
public class ClassicStackQueue {


    public static class ArrayQueue<T> {
        private Integer capacity;
        private Object[] array;
        private Integer index;

        public ArrayQueue(Integer capacity) {
            if (Objects.isNull(capacity) || capacity <= 0) {
                throw new IllegalArgumentException();
            }
            this.capacity = capacity;
            this.array = new Object[capacity];
            this.index = 0;
        }

        public Boolean enQueue(T data) {
            if (index > capacity) {
                throw new IllegalArgumentException();
            }
            array[index++] = data;
            return Boolean.TRUE;
        }

        public T deQueue() {
            if (index < 0) {
                throw new IllegalArgumentException();
            }
            return (T) array[index--];
        }

    }

    public static class LinkQueue<T> {
        private Integer capacity;
        private Node<T> head;
        private Node<T> tail;
        private Integer num;

        public LinkQueue(Integer capacity) {
            this.capacity = capacity;
            this.head = null;
            this.tail = null;
            this.num = 0;
        }

        public Boolean enQueue(T data) {
            if (num > capacity) {
                throw new IllegalArgumentException();
            }
            Node<T> element = new Node<>(data);
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
                throw new IllegalArgumentException();
            }
            T data = null;
            if (Objects.nonNull(tail)) {
                data = (T) tail.getData();
            }
            num--;
            return (T) data;
        }

    }

    public static class ArrayStack<T> {
        private Integer capacity;
        private Object[] array;
        private Integer num;
        private Integer putIx;
        private Integer popIx;

        public ArrayStack(Integer capacity) {
            this.capacity = capacity;
            this.array = new Object[capacity];
            this.num = 0;
            this.putIx = 0;
            this.popIx = 0;
        }

        public Boolean put(T data) {
            if (num > capacity) {
                throw new IllegalArgumentException();
            }
            array[putIx++] = data;
            num++;
            return Boolean.TRUE;
        }

        public T pop() {
            if (num < 0) {
                throw new IllegalArgumentException();
            }
            T data = (T) array[popIx++];
            num--;
            return data;
        }

    }

    public static class LinkStack<T> {
    }


    @Setter
    @Getter
    public static class Node<T> {
        private T data;
        private Node<T> pre;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.pre = null;
            this.next = null;
        }
    }

}

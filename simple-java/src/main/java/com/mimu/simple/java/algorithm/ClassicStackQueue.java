package com.mimu.simple.java.algorithm;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 栈和队列 的实现方式可以有 链表 和 数组两种方式实现
 */
public class ClassicStackQueue {


    /**
     * 数组队列 记得使用 循环 队列的思想来循环使用数组
     *
     * @param <T>
     */
    public static class ArrayQueue<T> {
        private Integer capacity;
        private Object[] array;
        private Integer num;
        private Integer putIdx;
        private Integer popIdx;

        public ArrayQueue(Integer capacity) {
            if (Objects.isNull(capacity) || capacity <= 0) {
                throw new IllegalArgumentException();
            }
            this.capacity = capacity;
            this.array = new Object[capacity];
            this.num = 0;
            this.putIdx = 0;
            this.popIdx = 0;
        }

        public Boolean enQueue(T data) {
            if (num > capacity) {
                return Boolean.FALSE;
            }
            array[(putIdx++) % capacity] = data;
            num++;
            return Boolean.TRUE;
        }

        public T deQueue() {
            if (num < 0) {
                return null;
            }
            return (T) array[(popIdx++) % capacity];
        }

    }

    public static class LinkQueue<T> {
        private Integer capacity;
        private Node<T> head;
        private Node<T> tail;
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
            if (num > capacity) {
                return Boolean.FALSE;
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
                return null;
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
        private Integer index;

        public ArrayStack(Integer capacity) {
            if (Objects.isNull(capacity) || capacity <= 0) {
                throw new IllegalArgumentException();
            }
            this.capacity = capacity;
            this.array = new Object[capacity];
            this.num = 0;
            this.index = 0;
        }

        public Boolean put(T data) {
            if (num > capacity) {
                return Boolean.FALSE;
            }
            array[index++] = data;
            num++;
            return Boolean.TRUE;
        }

        public T pop() {
            if (num < 0) {
                return null;
            }
            T data = (T) array[index--];
            num--;
            return data;
        }

    }

    public static class LinkStack<T> {
        private Integer capacity;
        private Node<T> head;
        private Integer num;

        public LinkStack(Integer capacity) {
            if (Objects.isNull(capacity) || capacity <= 0) {
                throw new IllegalArgumentException();
            }
            this.capacity = capacity;
            this.head = null;
            this.num = 0;
        }

        public Boolean put(T data) {
            if (num > capacity) {
                return Boolean.FALSE;
            }
            Node<T> element = new Node<>(data);
            if (!Objects.isNull(head)) {
                element.setNext(head);
                head.setPre(element);
            }
            head = element;
            return Boolean.TRUE;
        }

        public T pop() {
            if (num < 0) {
                return null;
            }
            T data = head.getData();
            num--;
            return data;
        }

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

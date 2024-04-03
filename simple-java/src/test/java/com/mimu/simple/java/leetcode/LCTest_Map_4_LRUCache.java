package com.mimu.simple.java.leetcode;


import java.util.HashMap;
import java.util.Objects;

/**
 * 最近最少使用
 * 实现一个 LRU 缓存器，LRU 是 Least Recently Used 的简写，并实现两种操作 get,put
 * <p>
 * get() 返回缓存器中的数据如果不存在，则返回-1
 * put() 向缓存器中添加数据，如果不存在，则直接添加，如果超过容量则需要把最不常用的那个元素删除；
 * 要求：
 * 每一个操作时间复杂度都是 O(1)
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
 * should invalidate the least recently used item before inserting a new item.
 * <p>
 * Could you do both operations in O(1) time complexity?
 */
public class LCTest_Map_4_LRUCache {

    /**
     * 使用双向链表和HashMap 可以实现复杂度都为O(1)的 get()和put() 方法
     */
    class LRUCache {
        private Integer size;
        private Integer capacity;
        private HashMap<Integer, LinkNode> data;
        private LinkNode head, tail;

        /**
         * 该结构中 初始化就包含了 头结点和尾节点；因此对于头结点的添加和尾节点的删除，需要注意
         *
         * @param capacity
         */
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.head = new LinkNode();
            this.tail = new LinkNode();
            this.head.setNext(tail);
            this.head.setPre(null);
            this.tail.setPre(head);
            this.tail.setNext(null);
            this.data = new HashMap<>();
        }

        public int get(int key) {
            LinkNode linkNode = this.data.get(key);
            if (Objects.isNull(linkNode)) {// 如果数据不存在，则返回-1；
                return -1;
            }
            remove(linkNode);//如果数据存在，则需要把该数据删除，同时在头结点后添加该节点；
            addHead(linkNode);//在链表中头结点之后 添加该数据节点
            return linkNode.getData();
        }

        public void put(int key, int value) {
            LinkNode linkNode = this.data.get(key);
            if (Objects.isNull(linkNode)) {
                if (size >= capacity) {
                    removeTail();
                }
                addHead(new LinkNode(key, value));
            } else {
                linkNode.setData(value);
                move2Head(linkNode);
            }
        }

        public void move2Head(LinkNode node) {
            remove(node);
            addHead(node);
        }

        public void removeTail() {
            LinkNode pre = this.tail.getPre();
            remove(pre);
        }

        public void remove(LinkNode node) {
            if (Objects.isNull(node)) {
                return;
            }
            this.size--;
            this.data.remove(node.getKey());
            node.getPre().setNext(node.getNext());
            node.getNext().setPre(node.getPre());
        }

        public void addHead(LinkNode node) {
            if (Objects.isNull(node)) {
                return;
            }
            this.size++;
            this.data.put(node.getKey(), node);
            head.getNext().setPre(node);
            node.setNext(head.getNext());
            head.setNext(node);
            node.setPre(head);
        }

        /**
         * 使用循环链表来进行数据的存储，这样删除操作可直接通过pre进行赋值；
         */
        class LinkNode {
            private Integer key;
            private Integer data;

            private LinkNode pre;
            private LinkNode next;

            public LinkNode() {
                this(null, null);
            }

            public LinkNode(Integer key, Integer data) {
                this.setKey(key);
                this.setData(data);
                this.setPre(null);
                this.setNext(null);
            }

            public Integer getKey() {
                return key;
            }

            public void setKey(Integer key) {
                this.key = key;
            }

            public Integer getData() {
                return data;
            }

            public void setData(Integer data) {
                this.data = data;
            }

            public LinkNode getPre() {
                return pre;
            }

            public void setPre(LinkNode pre) {
                this.pre = pre;
            }

            public LinkNode getNext() {
                return next;
            }

            public void setNext(LinkNode next) {
                this.next = next;
            }
        }

    }

}

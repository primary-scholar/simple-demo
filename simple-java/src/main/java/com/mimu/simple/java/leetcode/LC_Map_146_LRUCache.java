package com.mimu.simple.java.leetcode;


import java.util.HashMap;
import java.util.Objects;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
 * should invalidate the least recently used item before inserting a new item.
 * <p>
 * Could you do both operations in O(1) time complexity?
 * <p>
 * 最近最少使用
 * 实现一个 LRU 缓存器，LRU 是 Least Recently Used 的简写，并实现两种操作 get,put
 * get() 返回缓存器中的数据如果不存在，则返回-1
 * put() 向缓存器中添加数据，如果不存在，则直接添加，如果超过容量则需要把最不常用的那个元素删除；
 * 要求：
 * 每一个操作时间复杂度都是 O(1)
 */
public class LC_Map_146_LRUCache {

    /**
     * 使用双向链表和HashMap 可以实现复杂度都为O(1)的 get()和put() 方法
     * 双向链表 头尾都使用 哨兵节点
     */
    static class LRUCache {
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
            this.head.next = tail;
            this.head.pre = null;
            this.tail.pre = head;
            this.tail.next = null;
            this.data = new HashMap<>(this.capacity);
        }

        public int get(int key) {
            LinkNode linkNode = this.data.get(key);
            if (Objects.isNull(linkNode)) {// 如果数据不存在，则返回-1；
                return -1;
            }
            move2Head(linkNode);
            return linkNode.data;
        }

        public void put(int key, int value) {
            LinkNode linkNode = this.data.get(key);
            if (Objects.isNull(linkNode)) {
                if (size >= capacity) {
                    removeTail();
                }
                addHead(new LinkNode(key, value));
            } else {
                linkNode.data = value;
                move2Head(linkNode);
            }
        }

        public void move2Head(LinkNode node) {
            remove(node);
            addHead(node);
        }

        public void removeTail() {
            LinkNode pre = this.tail.pre;
            remove(pre);
        }

        private void remove(LinkNode node) {
            if (Objects.isNull(node)) {
                return;
            }
            this.size--;
            this.data.remove(node.key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void addHead(LinkNode node) {
            if (Objects.isNull(node)) {
                return;
            }
            this.size++;
            this.data.put(node.key, node);
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
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
                this.key = key;
                this.data = data;
                this.pre = null;
                this.next = null;
            }
        }
    }

}

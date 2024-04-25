package com.mimu.simple.java.leetcode;


import org.junit.Test;

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
public class LCTest_Map_146_LRUCache {

    private LC_Map_146_LRUCache.LRUCache lruCache = new LC_Map_146_LRUCache.LRUCache(2);

    @Test
    public void cacheResult() {
        lruCache.put(1, 1); // 缓存是 {1=1}
        lruCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lruCache.get(1));    // 返回 1
        lruCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lruCache.get(2));    // 返回 -1 (未找到)
        lruCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lruCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lruCache.get(3));    // 返回 3
        System.out.println(lruCache.get(4));    // 返回 4
    }

}

package com.mimu.simple.java.utils.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 author: mimu
 date: 2019/11/2
 */


/**
 *在JDK1.8主要设计上的改进有以下几点:
 *
 * 1、不采用segment而采用node，锁住node来实现减小锁粒度。jdk7 一个segment包含多个 node
 * 2、设计了MOVED状态 当resize的中过程中 线程2还在put数据，线程2会帮助resize。
 * 3、使用3个CAS操作来确保node的一些操作的原子性，这种方式代替了锁。
 * 4、sizeCtl的不同值来代表不同含义，起到了控制的作用。
 * 采用synchronized而不是ReentrantLock
 *
 */
public class CollectionMapTest {

    /**
     * HashMap 内部使用 Node<K,V>[] table 或 TreeNode<k,v>[] table 来进行数据的存储
     * 节点数>=8 转化为 TreeNode<k,v>[] table 红黑树数组 节点数 <=6 转化为Node<K,V>[] table 单链表数组
     * 并提供 map.keySet() Set 结构;map.values() Collections 结构; map.entrySet();  三种数据的 访问方式,
     * 增 put()
     * 删 remove()
     * 查 get()
     *
     * static class Node<K,V> implements Map.Entry<K,V> {
     *         final int hash;
     *         final K key;
     *         V value;
     *         Node<K,V> next;
     *
     *         Node(int hash, K key, V value, Node<K,V> next) {
     *             this.hash = hash;
     *             this.key = key;
     *             this.value = value;
     *             this.next = next;
     *         }
     *
     * /**** Entry<K,V> 为 LineHashMap 中的 数据结构
     * static class LinkedHashMap.Entry<K,V> extends HashMap.Node<K,V> {
     *         Entry<K,V> before, after;
     *         Entry(int hash, K key, V value, Node<K,V> next) {
     *             super(hash, key, value, next);
     *         }
     *     }
     * static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
     *         TreeNode<K,V> parent;  // red-black tree links
     *         TreeNode<K,V> left;
     *         TreeNode<K,V> right;
     *         TreeNode<K,V> prev;    // needed to unlink next upon deletion
     *         boolean red;
     *         TreeNode(int hash, K key, V val, Node<K,V> next) {
     *             super(hash, key, val, next);
     *         }
     *
     *
     *特点如下
     *1.容量不限制
     *2.无序集合只能使用 iterator 进行循环遍历 iterator
     *3.插入元素可为null, key:null;value:null (key唯一) 放在 HashMap 数组[0] 的位置
     *4.线程不安全
     *
     *
     * HashMap.put() 过程
     * 1.首先获取Node数组table对象和长度，若table为null或长度为0，则调用resize()扩容方法获取table最新对象，并通过此对象获取长度大小
     * 2.判定数组中指定索引下的节点是否为Null，若为Null 则new出一个单链表赋给table中索引下的这个节点
     * 3.若判定不为Null,我们的判断再做分支
     * 3.1 首先对hash和key进行匹配,若判定成功直接赋予e
     * 3.2 若匹配判定失败,则进行类型匹配是否为TreeNode 若判定成功则在红黑树中查找符合条件的节点并将其回传赋给e
     * 3.3 若以上判定全部失败则进行最后操作,向单向链表中添加数据若单向链表的长度大于等于8,则将其转为红黑树保存，记录下一个节点,对e进行判定若成功则返回旧值
     * 4.最后判定数组大小需不需要扩容
     *
     * HashMap.get() 过程
     * 1.判定Node数组table不为Null且table的长度大于0且table指定的索引值不为Null
     * 2.判定 匹配hash值 & 匹配key值 成功则返回 该值
     * 3.若 first节点的下一个节点不为Null
     * 3.1 若first的类型为TreeNode 红黑树 通过红黑树查找匹配值 并返回查询值
     * 3.2若上面判定不成功 则认为下一个节点为单向链表,通过循环匹配值
     *
     */
    @Test
    public void hashMapInfo() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(null, null);
        map.put(1, "1");
        map.put(15, "15");
        map.put(12, "12");
        map.put(3, "3");
        map.put(12, "13");
        map.get(100);
        map.remove(8);
        Iterator<Integer> key = map.keySet().iterator();
        while (key.hasNext()) {
            System.out.print(key.next() + " ");
        }
        System.out.println();
        Iterator<String> value = map.values().iterator();
        while (value.hasNext()) {
            System.out.print(value.next() + " ");
        }
        System.out.println();
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.print("key " + next.getKey() + " value " + next.getValue());
            System.out.println();
        }
        System.out.println();
    }

    /**
     * LinkedHashMap 继承自 HashMap 特性类似 但改结构是有序结构(插入的顺序==输出的顺序)
     * 内部使用 Entry<K,V>[] table 双向链表数组存储数据
     *
     * static class Entry<K,V> extends HashMap.Node<K,V> {
     *         Entry<K,V> before, after;
     *         Entry(int hash, K key, V value, Node<K,V> next) {
     *             super(hash, key, value, next);
     *         }
     *     }
     *
     *
     *特点如下
     *1.容量不限制
     *2.有序集合(插入的顺序==输出的顺序)使用 iterator 进行循环遍历 iterator
     *3.插入元素可为null, key:null;value:null (key唯一) 放在 HashMap 数组[0] 的位置
     *4.线程不安全
     */
    @Test
    public void linkHashMapInfo() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(null, null);
        map.put(1, "1");
        map.put(15, "15");
        map.put(12, "12");
        map.put(3, "3");
        map.put(12, "13");
        map.remove(8);
        Iterator<Integer> key = map.keySet().iterator();
        while (key.hasNext()) {
            System.out.print(key.next() + " ");
        }
        System.out.println();
        Iterator<String> value = map.values().iterator();
        while (value.hasNext()) {
            System.out.print(value.next() + " ");
        }
        System.out.println();
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.print("key " + next.getKey() + " value " + next.getValue());
            System.out.println();
        }
        System.out.println();
    }

    /**
     * ConcurrentHashMap 结构过程大致 和 HashMap 类似
     * ConcurrentHashMap 内部使用 Node<K,V>[] table 或 TreeNode<K,V>[] table 存储数据
     * 节点数>=8 转化为 TreeNode<k,v>[] table 红黑树数组 节点数 <=6 转化为Node<K,V>[] table 单链表数组
     * 并提供 map.keySet() Set 结构;map.values() Collections 结构; map.entrySet();  三种数据的 访问方式,
     * 使用 cas 和加锁 进行并发控制
     *
     * static class Node<K,V> implements Map.Entry<K,V> {
     *         final int hash;
     *         final K key;
     *         volatile V val;
     *         volatile Node<K,V> next;
     *
     *         Node(int hash, K key, V val, Node<K,V> next) {
     *             this.hash = hash;
     *             this.key = key;
     *             this.val = val;
     *             this.next = next;
     *         }
     *}
     *
     * static final class TreeNode<K,V> extends Node<K,V> {
     *         TreeNode<K,V> parent;  // red-black tree links
     *         TreeNode<K,V> left;
     *         TreeNode<K,V> right;
     *         TreeNode<K,V> prev;    // needed to unlink next upon deletion
     *         boolean red;
     *
     *         TreeNode(int hash, K key, V val, Node<K,V> next,
     *                  TreeNode<K,V> parent) {
     *             super(hash, key, val, next);
     *             this.parent = parent;
     *         }
     *}
     *
     *
     *
     *特点如下
     *相同点参考 HashMap 不同点如下
     *1.插入元素不可为 key!=null;value!=null (key唯一)
     *2.线程安全 使用 cas 和 加锁的方式 进行并发控制
     *
     * ConcurrentHashMap.put() 过程
     * 1、判断Node[]数组是否初始化，没有则进行初始化操作
     * 2、通过hash定位数组的索引坐标，是否有Node节点，如果没有则使用CAS进行添加（链表的头节点），添加失败则进入下次循环。
     * 3、检查到内部正在扩容，就帮助它一块扩容。
     * 4、如果头节点！=null，则使用synchronized锁住头节点元素（链表/红黑树的头元素）。如果是Node（链表结构）则执行链表的添加操作；如果是TreeNode（树型结构）则执行树添加操作。
     * 5、判断链表长度已经达到临界值8（默认值），当节点超过这个值就需要把链表转换为树结构。
     * 6、如果添加成功就调用addCount（）方法统计size，并且检查是否需要扩容
     *
     */
    @Test
    public void concurrentHashMapInfo() {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "1");
        map.put(15, "15");
        map.put(12, "12");
        map.put(3, "3");
        map.put(12, "13");
        map.remove(8);
        Iterator<Integer> key = map.keySet().iterator();
        while (key.hasNext()) {
            System.out.print(key.next() + " ");
        }
        System.out.println();
        Iterator<String> value = map.values().iterator();
        while (value.hasNext()) {
            System.out.print(value.next() + " ");
        }
        System.out.println();
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.print("key " + next.getKey() + " value " + next.getValue());
            System.out.println();
        }
        System.out.println();
    }

}

package com.mimu.simple.java.algorithm.linkstackqueue.queue;

import java.util.Objects;

/**
 * 数组实现队列
 * 整体思路： 数组实现的队列可 使用 object[] 数组保存数据，初始时 给定容量 capacity 使用 num 记录当前数据中的 数据个数，这样就简化了
 * 入队和出队的 比较问题，由于入队和出队和交替操作，则 数组低位处 还可以继续放置元素，所以 元素操作时 使用 循环数组 来放置或取 元素；
 * <p>
 * 首先初始化 时 为 capacity，array，num，enIdx,deIdx 赋值
 * <p>
 * 入队操作：首先判断 数组元素的个数 num >= capacity 如果true 则表示 队列已满，否则可在 数组 (enIdx++)%capacity 处放置元素
 * 同时 num++
 * <p>
 * 出队操作：首先判断 num<=0 如果 true 则队列已空 否则 取 (deIdx++)%capacity 位置的元素 返回
 * 同时 num--
 *
 * @param <T>
 */
public class CustomArrayQueue<T> {
    private Integer capacity;
    private Object[] array;
    private Integer num;
    private Integer enIdx;
    private Integer deIdx;

    public CustomArrayQueue(Integer capacity) {
        if (Objects.isNull(capacity) || capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.num = 0;
        this.enIdx = 0;
        this.deIdx = 0;
    }

    public Boolean enQueue(T data) {
        if (num >= capacity) {
            return Boolean.FALSE;
        }
        array[(enIdx++) % capacity] = data;  // 循环队列的 赋值操作
        num++;
        return Boolean.TRUE;
    }

    public T deQueue() {
        if (num <= 0) {
            return null;
        }
        T data = (T) array[(deIdx++) % capacity];  // 循环队列的 取值操作
        num--;
        return data;
    }

}

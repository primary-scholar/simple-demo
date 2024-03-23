package com.mimu.simple.java.algorithm.linkstackqueue.stack;

import java.util.Objects;

/**
 * 数组实现 栈结构
 * 数组实现的栈 可使用 object[] 数组保存数据，初始时 给定容量 capacity 使用 num 记录当前数据中的 数据个数
 * <p>
 * 首先初始化时 为 capacity，array，num，index 赋值
 * <p>
 * 入栈操作：首先判断 数组元素的个数 num >= capacity 如果true 则表示 栈已满，否则可在 数组 (index++) 处放置元素
 * 同时 num++
 * <p>
 * 出栈操作：首先判断 num<=0 如果 true 则栈已空 否则 取 (--index) 位置的元素 返回 这里一定是 --index 否则数组会越界
 * 同时 num--
 *
 * @param <T>
 */
public class CustomArrayStack<T> {
    private Integer capacity;
    private Object[] array;
    private Integer num;
    private Integer index;

    public CustomArrayStack(Integer capacity) {
        if (Objects.isNull(capacity) || capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.num = 0;
        this.index = 0;
    }

    public Boolean put(T data) {
        if (num >= capacity) {
            return Boolean.FALSE;
        }
        array[index++] = data;  //index++ 赋值
        num++;
        return Boolean.TRUE;
    }

    public T pop() {
        if (num <= 0) {
            return null;
        }
        T data = (T) array[--index];  // --index 取值 否则数组越界
        num--;
        return data;
    }

}

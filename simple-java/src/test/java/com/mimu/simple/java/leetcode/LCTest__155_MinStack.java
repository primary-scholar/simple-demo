package com.mimu.simple.java.leetcode;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * 最小栈 支持常数级获取 最小元素
 *
 */
public class LCTest__155_MinStack {
    private Stack<Integer> data;
    private Stack<Integer> leastData;

    public LCTest__155_MinStack() {
        data = new Stack<>();
        leastData = new Stack<>();
        leastData.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        data.push(val);
        leastData.push(Math.min(leastData.peek(), val));
    }

    public void pop() {
        data.pop();
        leastData.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return leastData.peek();
    }
}

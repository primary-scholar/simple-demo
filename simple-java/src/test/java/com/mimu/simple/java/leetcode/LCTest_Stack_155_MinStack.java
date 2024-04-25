package com.mimu.simple.java.leetcode;

import org.junit.Test;


/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * 最小栈 支持常数级获取 最小元素
 */
public class LCTest_Stack_155_MinStack {

    private LC_Stack_155_MinStack minStack = new LC_Stack_155_MinStack();

    @Test
    public void stackInfo() {
        minStack.push(3);
        minStack.push(1);
        minStack.push(5);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
    }
}

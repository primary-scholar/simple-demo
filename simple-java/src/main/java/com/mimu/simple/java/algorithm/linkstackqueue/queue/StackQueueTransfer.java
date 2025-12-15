package com.mimu.simple.java.algorithm.linkstackqueue.queue;

import java.util.Stack;

/**
 * 两个栈实现队列的操作方式
 *
 * @param <T>
 */
public class StackQueueTransfer<T> {
    private Stack<T> pushStack;
    private Stack<T> popStack;

    public StackQueueTransfer() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public Boolean enQueue(T data) {
        pushStack.push(data);
        pushToPop();
        return Boolean.TRUE;
    }

    public T deQueue() {
        if (pushStack.empty() && popStack.empty()) {
            return null;
        }
        pushToPop();
        return popStack.pop();
    }


    /**
     * 从 pushStack 向 popStack 栈倒入数据时 必须保证
     * 1.只有 popStack 为空时 在可以倒入数据
     * 2.每次倒入数据时 需要把 pushStack 中的数据全部 倒进去
     */
    private void pushToPop() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

}

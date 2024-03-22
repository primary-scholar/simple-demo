package com.mimu.simple.java.algorithm.linkstackqueue;

import com.mimu.simple.java.algorithm.linkstackqueue.queue.StackQueueTransfer;
import org.junit.Test;

public class StackQueueTransferTest {

    /**
     * 栈实现队列
     * <p>
     * 使用两个栈 把其中一个栈中的元素 全量倒入到两一个栈中 倒的过程依然遵循 栈的 后进先出操作
     */
    @Test
    public void stackImplementQueue() {
        StackQueueTransfer<Integer> stackQueue = new StackQueueTransfer<>();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());

    }

    /**
     * 队列实现栈
     * <p>
     * 使用两个队列 来回把其中一个队列中的数据(除最后一个)导入到其中一个队列中 倒的过程依然遵循 队列的先进先出原则
     */
    @Test
    public void queueImplStack() {
        StackQueueTransfer<Integer> stackQueue = new StackQueueTransfer<>();
    }
}

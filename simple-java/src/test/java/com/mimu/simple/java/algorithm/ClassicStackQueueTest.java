package com.mimu.simple.java.algorithm;

import org.junit.Test;

import java.util.Objects;


public class ClassicStackQueueTest extends BaseTest {
    private Integer capacity = (int) (Math.random() * 10) + 1;
    ClassicStackQueue.ArrayQueue<Integer> arrayQueue = new ClassicStackQueue.ArrayQueue<>(capacity);
    ClassicStackQueue.LinkQueue<Integer> linkQueue = new ClassicStackQueue.LinkQueue<>(capacity);

    ClassicStackQueue.ArrayStack<Integer> arrayStack = new ClassicStackQueue.ArrayStack<>(capacity);
    ClassicStackQueue.LinkStack<Integer> linkStack = new ClassicStackQueue.LinkStack<>(capacity);

    @Test
    public void arrayQueueTest() {
        for (int i = 0; i < capacity; i++) {
            Boolean enQueue = arrayQueue.enQueue((int) (Math.random() * 100) + i);
            assert enQueue.equals(Boolean.TRUE);
        }
        Boolean enQueue = arrayQueue.enQueue(10);
        assert enQueue.equals(Boolean.FALSE);
        for (int i = 0; i < capacity; i++) {
            Integer object = arrayQueue.deQueue();
            assert Objects.nonNull(object);
        }
        Integer queue = arrayQueue.deQueue();
        assert Objects.isNull(queue);
    }

    @Test
    public void linkQueueTest() {
        for (int i = 0; i < capacity; i++) {
            Boolean enQueue = linkQueue.enQueue((int) (Math.random() * 100) + i);
            assert enQueue.equals(Boolean.TRUE);
        }
        Boolean enQueue = linkQueue.enQueue(10);
        assert enQueue.equals(Boolean.FALSE);
        for (int i = 0; i < capacity; i++) {
            Integer object = linkQueue.deQueue();
            assert Objects.nonNull(object);
        }
        Integer queue = linkQueue.deQueue();
        assert Objects.isNull(queue);
    }

    @Test
    public void arrayStackTest() {
        for (int i = 0; i < capacity; i++) {
            Boolean put = arrayStack.put((int) (Math.random() * 100) + i);
            assert put.equals(Boolean.TRUE);
        }
        Boolean put = arrayStack.put(10);
        assert Boolean.FALSE.equals(put);
        for (int i = 0; i < capacity; i++) {
            Integer integer = arrayStack.pop();
            assert Objects.nonNull(integer);
        }
        Integer integer = arrayStack.pop();
        assert Objects.isNull(integer);
    }

    @Test
    public void linkStackTest() {
        for (int i = 0; i < capacity; i++) {
            Boolean put = linkStack.put((int) (Math.random() * 100) + i);
            assert put.equals(Boolean.TRUE);
        }
        Boolean put = linkStack.put(10);
        assert Boolean.FALSE.equals(put);
        for (int i = 0; i < capacity; i++) {
            Integer integer = linkStack.pop();
            assert Objects.nonNull(integer);
        }
        Integer integer = linkStack.pop();
        assert Objects.isNull(integer);
    }

    /**
     * 栈实现队列
     * <p>
     * 使用两个栈 把其中一个栈中的元素 全量倒入到两一个栈中 倒的过程依然遵循 栈的 后进先出操作
     */
    @Test
    public void stackImplementQueue() {
        ClassicStackQueue.TwoStackQueue<Integer> stackQueue = new ClassicStackQueue.TwoStackQueue<>();
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
    }


}
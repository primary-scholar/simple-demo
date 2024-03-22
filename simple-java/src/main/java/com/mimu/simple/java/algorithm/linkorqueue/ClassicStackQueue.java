package com.mimu.simple.java.algorithm.linkorqueue;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Stack;

/**
 * 栈和队列 的实现方式可以有 链表 和 数组两种方式实现
 */
public class ClassicStackQueue {


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
    public static class ArrayQueue<T> {
        private Integer capacity;
        private Object[] array;
        private Integer num;
        private Integer enIdx;
        private Integer deIdx;

        public ArrayQueue(Integer capacity) {
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

    /**
     * 链表实现队列
     * 链表实现的队列 可使用 双链表保存数据，初始时 给定容量 capacity 使用 num 记录当前数据中的 数据个数
     * <p>
     * 首先初始化 时 为 capacity，head，tail，num 赋值
     * <p>
     * 入队操作：首先判断 数组元素的个数 num >= capacity 如果true 则表示 队列已满，否则 创建一个双向链表 节点 并把该节点 放在 head的 pre 方向，然后向前移动head 到新
     * 创建的 节点上 (这里注意 双向链表的 pre，next 的赋值操作)
     * 同时 num++
     * <p>
     * 出队操作：首先判断 num<=0 如果 true 则队列已空 ，如果 num=1 则除了取值外 还要为 head tail 节点置空
     * 同时 num--
     * 若 num>1 则 tail 节点前移 并删除 tail 节点即可 同时 num--；
     *
     * @param <T>
     */
    public static class LinkQueue<T> {
        private Integer capacity;
        private Node<T> head;
        private Node<T> tail;
        private Integer num;

        public LinkQueue(Integer capacity) {
            if (Objects.isNull(capacity) || capacity <= 0) {
                throw new IllegalArgumentException();
            }
            this.capacity = capacity;
            this.head = null;
            this.tail = null;
            this.num = 0;
        }

        public Boolean enQueue(T data) {
            if (num >= capacity) {
                return Boolean.FALSE;
            }
            Node<T> element = new Node<>(data);
            if (Objects.isNull(head)) {
                head = element;
                tail = element;
            } else {
                head.setPre(element);
                element.setNext(head);
                head = element;
            }
            num++;
            return Boolean.TRUE;
        }

        public T deQueue() {
            if (num <= 0) {
                return null;
            }
            T data;
            if (num == 1) {
                data = (T) tail.getData();
                head = null;
                tail = null;
            } else {
                Node<T> pre = tail.getPre();
                pre.setNext(null);
                data = (T) tail.getData();
                tail.setPre(null);
                tail = pre;
            }
            num--;
            return data;
        }

    }

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
    public static class ArrayStack<T> {
        private Integer capacity;
        private Object[] array;
        private Integer num;
        private Integer index;

        public ArrayStack(Integer capacity) {
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

    /**
     * 链表实现栈结构
     * 链表实现的栈 可使用 双链表保存数据，初始时 给定容量 capacity 使用 num 记录当前数据中的 数据个数
     * <p>
     * 首先初始化 时 为 capacity，head，num 赋值
     * <p>
     * 入栈操作：首先判断 数组元素的个数 num >= capacity 如果true 则表示 栈已满，否则 创建一个双向链表 节点 并把该节点 放在 head的 pre 方向，然后向前移动head 到新
     * 创建的 节点上 (这里注意 双向链表的 pre，next 的赋值操作)
     * 同时 num++
     * <p>
     * 出栈操作：首先判断 num<=0 如果 true 则栈已空 ，如果 num=1 则除了取值外 还要为 head 节点置空
     * 同时 num--
     * 若 num>1 则 head 节点后移 并删除 head 节点即可 同时 num--；
     *
     * @param <T>
     */
    public static class LinkStack<T> {
        private Integer capacity;
        private Node<T> head;
        private Integer num;

        public LinkStack(Integer capacity) {
            if (Objects.isNull(capacity) || capacity <= 0) {
                throw new IllegalArgumentException();
            }
            this.capacity = capacity;
            this.head = null;
            this.num = 0;
        }

        public Boolean put(T data) {
            if (num >= capacity) {
                return Boolean.FALSE;
            }
            Node<T> element = new Node<>(data);
            if (Objects.isNull(head)) {
                head = element;
            } else {
                head.setPre(element);
                element.setNext(head);
                head = element;
            }
            num++;
            return Boolean.TRUE;
        }

        public T pop() {
            if (num <= 0) {
                return null;
            }
            T data;
            if (num == 1) {
                data = head.getData();
                head = null;
            } else {
                Node<T> next = head.getNext();
                data = head.getData();
                head.setNext(null);
                head = next;
            }
            num--;
            return data;
        }

    }


    /**
     * 两个栈实现队列的操作方式
     *
     * @param <T>
     */
    public static class TwoStackQueue<T> {
        private Stack<T> pushStack;
        private Stack<T> popStack;

        public TwoStackQueue() {
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


    @Setter
    @Getter
    public static class Node<T> {
        private T data;
        private Node<T> pre;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.pre = null;
            this.next = null;
        }
    }

}

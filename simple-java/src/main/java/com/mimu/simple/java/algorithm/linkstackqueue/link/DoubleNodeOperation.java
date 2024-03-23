package com.mimu.simple.java.algorithm.linkstackqueue.link;

import java.util.Objects;

public class DoubleNodeOperation<T> {
    /**
     * 双链表 倒序  和单链表类似
     * 整体思路：在反转过程中 取 pre，head，next(临时节点-head的后继节点) 三个节点
     * 分别表示 单链表 头节点的 前驱节点，头节点和 头节点的后继节点 初始时 pre 和 next 都为 null 即可
     * 头节点非空 开始循环
     * <p>
     * 首先 给 next 即 head 的后继节点赋值，
     * 然后 头节点 的 next 赋值为 前驱 pre 节点， 头节点的 pre 赋值为 后继 next 节点
     * pre 节点后移即当前的 head 节点 ，
     * head 节点继续后即当前的 next 节点
     * <p>
     * 然后 无限循环直到 头节点为空；
     *
     * @param head
     * @return
     */
    public CustomDoubleNode<Integer> revertDoubleNodeList(CustomDoubleNode<Integer> head) {
        // 给 pre next 节点赋值
        CustomDoubleNode<Integer> pre = null;
        CustomDoubleNode<Integer> next;
        while (Objects.nonNull(head)) {     // head 节点非空 开始循环
            next = head.getNext();      // 首先为 head 的后继节点 next 赋值
            head.setNext(pre);      // head 的后继节点 置为pre节点
            head.setPre(next);      // head 的前驱节点 置为next节点
            pre = head;     // pre 节点后移为 当前 head 节点
            head = next;        // head 节点后移为当前的 next 节点
        }
        return pre;
    }

    /**
     * 双链表 删除某个元素 整体思路和单链表 删除 类似
     * 不同的地方在于 必须使用中间变量 把 待删除的 节点的 前后 节点都置空
     * 并且 设置节点时 要接的同时设置 pre 和next 两个节点
     *
     * @param head
     * @param delete
     * @return
     */
    public CustomDoubleNode<Integer> deleteDoubleNodeLink(CustomDoubleNode<Integer> head, Integer delete) {
        if (Objects.isNull(head)) {
            return null;
        }
        // 整体与单链表删除类似
        while (Objects.nonNull(head) && head.getData().equals(delete)) {
            CustomDoubleNode<Integer> next = head.getNext();
            head.setPre(null);      // head 前后继节点置空
            head.setNext(null);     // head 前后继节点置空
            head = next;
        }
        CustomDoubleNode<Integer> curr = head;
        CustomDoubleNode<Integer> next = head;
        while (Objects.nonNull(next)) {
            if (!next.getData().equals(delete)) {
                curr = next;
                next = next.getNext();
            } else {
                CustomDoubleNode<Integer> tmp = next;
                next = next.getNext();
                tmp.setPre(null);       // 待删除的临时节点 前后继置空
                tmp.setNext(null);      // 待删除的临时节点 前后继置空
                curr.setNext(next);     // 需要调整 两个节点
                next.setPre(curr);      // 需要调整 两个节点
            }
        }
        return head;
    }
}

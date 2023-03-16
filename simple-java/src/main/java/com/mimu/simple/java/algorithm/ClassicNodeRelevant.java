package com.mimu.simple.java.algorithm;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 链表 1-单链表；2-双链表
 * 算法：1-链表倒序；2-链表删除某个元素(如果有多个全部删除)
 */
public class ClassicNodeRelevant {

    /**
     * 单链表 倒序
     * 整体思路：在反转过程中 取 pre，head，next(临时节点-head的后继节点) 三个节点
     * 分别表示 单链表 头节点的 前驱节点，头节点和 头节点的后继节点 初始时 pre 和 next 都为 null 即可
     * 头节点非空 开始循环
     * <p>
     * 首先 给 next 即 head 的后继节点赋值，
     * 然后 头节点 的 next 赋值为 前驱 pre 节点，
     * pre 节点后移即当前的 head 节点 ，
     * head 头节点继续后移 即当前的 next 节点
     * <p>
     * 然后 无限循环知道 头节点为空；
     *
     * @param head
     * @return
     */
    public SingleNodeList<Integer> revertSingleNodeList(SingleNodeList<Integer> head) {
        SingleNodeList<Integer> pre = null;
        SingleNodeList<Integer> next;
        while (Objects.nonNull(head)) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

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
     * 然后 无限循环知道 头节点为空；
     *
     * @param head
     * @return
     */
    public DoubleNodeList<Integer> revertDoubleNodeList(DoubleNodeList<Integer> head) {
        DoubleNodeList<Integer> pre = null;
        DoubleNodeList<Integer> next;
        while (Objects.nonNull(head)) {
            next = head.getNext();
            head.setNext(pre);
            head.setPre(next);
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 单链表 删除 某些元素
     *
     * @param head
     * @param delete
     * @return
     */
    public SingleNodeList<Integer> deleteSingleNodeList(SingleNodeList<Integer> head, Integer delete) {
        if (Objects.isNull(head)) {
            return null;
        }
        while (Objects.nonNull(head) && head.getData().equals(delete)) {
            SingleNodeList<Integer> next = head.getNext();
            head.setNext(null);
            head = next;
        }
        if (Objects.nonNull(head)) {
            SingleNodeList<Integer> curr = head;
            SingleNodeList<Integer> next = curr.getNext();
            while (Objects.nonNull(next)) {
                if (next.getData().equals(delete)) {
                    SingleNodeList<Integer> tmp = next;
                    next = next.getNext();
                    curr.setNext(next);
                    tmp.setNext(null);
                } else {
                    curr = next;
                    next = next.getNext();
                }
            }
        }
        return head;
    }

    /**
     * 双链表 倒序
     *
     * @param node
     * @return
     */
    public DoubleNodeList<Integer> twoLinkNodeRevert(DoubleNodeList<Integer> node) {
        return null;
    }

    /**
     * 双链表 删除某个元素
     *
     * @param node
     * @param delete
     * @return
     */
    public DoubleNodeList<Integer> twoLinkNodeDelete(DoubleNodeList<Integer> node, Integer delete) {
        return null;
    }


    /**
     * 单链表
     */
    @Setter
    @Getter
    public static class SingleNodeList<T> {
        private T data;
        private SingleNodeList<T> next;
    }

    /**
     * 双链表
     */
    @Setter
    @Getter
    public static class DoubleNodeList<T> {
        private T data;
        private DoubleNodeList<T> pre;
        private DoubleNodeList<T> next;
    }
}

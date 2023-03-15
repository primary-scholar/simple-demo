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
     *
     * @param head
     * @return
     */
    public OneLinkNode<Integer> oneLinkNodeRevert(OneLinkNode<Integer> head) {
        if (Objects.isNull(head)) {
            return null;
        }
        OneLinkNode<Integer> curr = head;
        OneLinkNode<Integer> next = head.getNext();
        while (Objects.nonNull(next)) {
            OneLinkNode<Integer> temp = next.getNext();
            next.setNext(curr);
            curr = next;
            next = temp;

        }
        head.setNext(null);
        return curr;
    }


    /**
     * 单链表 删除 某些元素
     *
     * @param head
     * @param delete
     * @return
     */
    public OneLinkNode<Integer> oneLinkNodeDelete(OneLinkNode<Integer> head, Integer delete) {
        if (Objects.isNull(head)) {
            return null;
        }
        OneLinkNode<Integer> curr = head;
        while (Objects.nonNull(curr) && curr.getData().equals(delete)) {
            OneLinkNode<Integer> tmp = curr.getNext();
            curr.setNext(null);
            curr = tmp;
        }
        if (Objects.isNull(curr)) {
            return null;
        }
        head = curr;
        OneLinkNode<Integer> next = curr.getNext();
        while (Objects.nonNull(next)) {
            OneLinkNode<Integer> tmp = next.getNext();
            if (next.getData().equals(delete)) {
                next.setNext(null);
                curr.setNext(tmp);
            } else {
                curr = next;
            }
            next = tmp;
        }
        return head;
    }

    /**
     * 双链表 倒序
     *
     * @param node
     * @return
     */
    public TwoLinkNode<Integer> twoLinkNodeRevert(TwoLinkNode<Integer> node) {
        return null;
    }

    /**
     * 双链表 删除某个元素
     *
     * @param node
     * @param delete
     * @return
     */
    public TwoLinkNode<Integer> twoLinkNodeDelete(TwoLinkNode<Integer> node, Integer delete) {
        return null;
    }


    /**
     * 单链表
     */
    @Setter
    @Getter
    public static class OneLinkNode<T> {
        private T data;
        private OneLinkNode<T> next;
    }

    /**
     * 双链表
     */
    @Setter
    @Getter
    public static class TwoLinkNode<T> {
        private T data;
        private TwoLinkNode<T> pre;
        private TwoLinkNode<T> next;
    }
}

package com.mimu.simple.java.algorithm;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 快慢节点
 * 慢节点一次走一个节点
 * 快节点一次走两个节点
 */
public class ClassicSlowFastNodeOperation extends ClassicNodeOperation {

    /**
     * 单链表 中点或 上中点(偶数个节点时)
     *
     * @param head
     * @return
     */
    public SingleNodeOP.SingleNode<Integer> midOrUpMidNode(SingleNodeOP.SingleNode<Integer> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext()) || Objects.isNull(head.getNext().getNext())) {
            return head;
        }
        SingleNodeOP.SingleNode<Integer> slow = head.getNext();
        SingleNodeOP.SingleNode<Integer> fast = head.getNext().getNext();
        while (Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public SingleNodeOP.SingleNode<Integer> midOrUpMidNodeAnother(SingleNodeOP.SingleNode<Integer> head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ArrayList<SingleNodeOP.SingleNode<Integer>> list = new ArrayList<>();
        while (Objects.nonNull(head)) {
            list.add(head);
            head = head.getNext();
        }
        return list.get((list.size() - 1) / 2);
    }

    public SingleNodeOP.SingleNode<Integer> midOrDownMidNode(SingleNodeOP.SingleNode<Integer> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            return head;
        }
        SingleNodeOP.SingleNode<Integer> slow = head.getNext();
        SingleNodeOP.SingleNode<Integer> fast = head.getNext();
        while (Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public SingleNodeOP.SingleNode<Integer> midOrDownMidNodeAnother(SingleNodeOP.SingleNode<Integer> head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ArrayList<SingleNodeOP.SingleNode<Integer>> list = new ArrayList<>();
        while (Objects.nonNull(head)) {
            list.add(head);
            head = head.getNext();
        }
        return list.get(list.size() / 2);
    }

    public SingleNodeOP.SingleNode<Integer> midOrUpMidPrNode(SingleNodeOP.SingleNode<Integer> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext()) || Objects.isNull(head.getNext().getNext())) {
            return head;
        }
        SingleNodeOP.SingleNode<Integer> slow = head;
        SingleNodeOP.SingleNode<Integer> fast = head.getNext().getNext();
        while (Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public SingleNodeOP.SingleNode<Integer> midOrUpMidPrNodeAnother(SingleNodeOP.SingleNode<Integer> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext()) || Objects.isNull(head.getNext().getNext())) {
            return head;
        }
        ArrayList<SingleNodeOP.SingleNode<Integer>> list = new ArrayList<>();
        while (Objects.nonNull(head)) {
            list.add(head);
            head = head.getNext();
        }
        return list.get((list.size() - 2) / 2);
    }

    public SingleNodeOP.SingleNode<Integer> midOrDownMidPreNode(SingleNodeOP.SingleNode<Integer> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            return head;
        }
        if (Objects.isNull(head.getNext().getNext())) {
            return head;
        }
        SingleNodeOP.SingleNode<Integer> slow = head;
        SingleNodeOP.SingleNode<Integer> fast = head.getNext();
        while (Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public SingleNodeOP.SingleNode<Integer> midOrDownMidPreNodeAnother(SingleNodeOP.SingleNode<Integer> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            return head;
        }
        if (Objects.isNull(head.getNext().getNext())) {
            return head;
        }
        ArrayList<SingleNodeOP.SingleNode<Integer>> list = new ArrayList<>();
        while (Objects.nonNull(head)) {
            list.add(head);
            head = head.getNext();
        }
        return list.get((list.size() - 1) / 2);
    }


}

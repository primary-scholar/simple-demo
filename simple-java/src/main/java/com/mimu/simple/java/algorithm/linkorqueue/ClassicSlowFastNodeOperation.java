package com.mimu.simple.java.algorithm.linkorqueue;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 快慢节点
 * 慢节点一次走一个节点
 * 快节点一次走两个节点
 * <p>
 * <p>
 * <p>
 * 单链表是否是回文
 * 1。使用栈结构可以实现
 * 2。使用快慢节点找到中间节点(慢节点依次走一步，快节点依次走两步)后，把后半部分进行逆序操作
 *
 * @see SingleNodeOP#revertSingleNodeList(SingleNodeOP.SingleNode)
 * 然后进行比对即可
 * <p>
 * <p>
 * 单链表是否有环(若有则求第一个入环节点)
 * 1。使用 hashSet 可以实现
 * 2。使用快慢节点(慢节点依次走一步，快节点依次走两步) 如果有环 快慢节点一定会相遇；第一个
 * 入环节点的求法：快慢节点相遇后，慢节点暂停，快节点回到head，然后快慢节点都变成慢节点并都开始走，再次相遇的节点即为第一个入环的头节点(已证明)
 * <p>
 * <p>
 * 两个无环链表是否相交
 * 1。使用hashSet 可以实现
 * 2。使用快慢节点可以实现
 * 2。1
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

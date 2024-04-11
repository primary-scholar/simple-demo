package com.mimu.simple.java.algorithm.linkstackqueue.link;


import java.util.ArrayList;
import java.util.Objects;

/**
 * 1.获取链表倒数第k个元素
 * 2.判断单链表是否回文，或获取单链表中间节点
 * 3.判断单链表是否有环以及环的长度
 * 4.判断两个无环单链表是否相交
 * 以上可以使用双指针来实现
 * <p>
 * 双指针有可分为--快慢节点
 * 慢节点一次走一个节点
 * 快节点一次走两个节点
 * <p>
 * <p>
 * <p>
 * 单链表是否是回文
 * 1。使用栈结构可以实现
 * 2。使用快慢节点找到中间节点(慢节点依次走一步，快节点依次走两步)后，把后半部分进行逆序操作
 *
 * @see com.mimu.simple.java.algorithm.linkstackqueue.link.SingleNodeOperation#revertSingleNodeList(CustomSingleNode)
 * 然后进行比对即可
 * <p>
 * <p>
 * 单链表是否有环(若有则求第一个入环节点)
 * 1。使用 hashSet 可以实现
 * 2。使用快慢节点(慢节点依次走一步，快节点依次走两步) 如果有环 快慢节点一定会相遇；第一个
 * 入环节点的求法：快慢节点相遇后，慢节点暂停，快节点回到head，然后快慢节点都变成慢节点并都开始走，再次相遇的节点即为第一个入环的头节点(已证明)
 * 这里需要注意：快慢节点需要同时从 head 出发；
 * <p>
 * <p>
 * 两个无环链表是否相交
 * 1。使用hashSet 可以实现
 * 2。使用快慢节点可以实现
 * <p>
 * 获取单链表倒数第k个元素
 * 使用快慢节点可以实现；
 */
public class ClassicLinkNodeSlowFastNodeOperation {

    /**
     * 单链表 中点或 上中点(偶数个节点时)
     *
     * @param head
     * @return
     */
    public CustomSingleNode<Integer> midOrUpMidNode(CustomSingleNode<Integer> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext()) || Objects.isNull(head.getNext().getNext())) {
            return head;
        }
        CustomSingleNode<Integer> slow = head;
        CustomSingleNode<Integer> fast = head;
        while (Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public CustomSingleNode<Integer> midOrUpMidNodeAnother(CustomSingleNode<Integer> head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ArrayList<CustomSingleNode<Integer>> list = new ArrayList<>();
        while (Objects.nonNull(head)) {
            list.add(head);
            head = head.getNext();
        }
        return list.get((list.size() - 1) / 2);
    }

    public CustomSingleNode<Integer> midOrDownMidNode(CustomSingleNode<Integer> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            return head;
        }
        CustomSingleNode<Integer> slow = head;
        CustomSingleNode<Integer> fast = head;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public CustomSingleNode<Integer> midOrDownMidNodeAnother(CustomSingleNode<Integer> head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ArrayList<CustomSingleNode<Integer>> list = new ArrayList<>();
        while (Objects.nonNull(head)) {
            list.add(head);
            head = head.getNext();
        }
        return list.get(list.size() / 2);
    }

    public CustomSingleNode<Integer> midOrUpMidPrNode(CustomSingleNode<Integer> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext()) || Objects.isNull(head.getNext().getNext())) {
            return head;
        }
        CustomSingleNode<Integer> slow = head;
        CustomSingleNode<Integer> fast = head.getNext().getNext();
        while (Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public CustomSingleNode<Integer> midOrUpMidPrNodeAnother(CustomSingleNode<Integer> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext()) || Objects.isNull(head.getNext().getNext())) {
            return head;
        }
        ArrayList<CustomSingleNode<Integer>> list = new ArrayList<>();
        while (Objects.nonNull(head)) {
            list.add(head);
            head = head.getNext();
        }
        return list.get((list.size() - 2) / 2);
    }

    public CustomSingleNode<Integer> midOrDownMidPreNode(CustomSingleNode<Integer> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            return head;
        }
        if (Objects.isNull(head.getNext().getNext())) {
            return head;
        }
        CustomSingleNode<Integer> slow = head;
        CustomSingleNode<Integer> fast = head.getNext();
        while (Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public CustomSingleNode<Integer> midOrDownMidPreNodeAnother(CustomSingleNode<Integer> head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            return head;
        }
        if (Objects.isNull(head.getNext().getNext())) {
            return head;
        }
        ArrayList<CustomSingleNode<Integer>> list = new ArrayList<>();
        while (Objects.nonNull(head)) {
            list.add(head);
            head = head.getNext();
        }
        return list.get((list.size() - 1) / 2);
    }


}

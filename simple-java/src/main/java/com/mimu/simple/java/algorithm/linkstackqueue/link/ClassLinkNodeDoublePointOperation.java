package com.mimu.simple.java.algorithm.linkstackqueue.link;

import java.util.Objects;

/**
 * * 1.获取链表倒数第k个元素，使用快 k 个节点的快节点和慢节点
 * * 2.判断单链表是否回文，或获取单链表中间节点 这里可参考
 *
 * @see ClassicLinkNodeSlowFastNodeOperation
 * <p>
 * * 3.判断单链表是否有环以及环的长度，使用 快慢节点
 * * 4.判断两个无环单链表是否相交，使用 双节点即可，无所谓快慢
 * * 以上可以使用双指针来实现
 */
public class ClassLinkNodeDoublePointOperation {


    /**
     * 倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public CustomSingleNode<Integer> getKthFromEnd(CustomSingleNode<Integer> head, Integer k) {
        if (Objects.isNull(head) || k <= 0) {
            return null;
        }
        CustomSingleNode<Integer> slow = head;
        CustomSingleNode<Integer> fast = head;
        while (Objects.nonNull(fast) && k > 0) {
            k--;
            fast = fast.getNext();
        }
        while (Objects.nonNull(fast) && k == 0) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        if (k != 0) {
            return null;
        }
        return slow;
    }

    /**
     * 因为是单链表，每个节点只有一个后继结点，所以如果有环存在，那也只能是 尾节点和 单链表上的某个节点相遇；
     * 这里需要注意：快慢节点需要同时从 head 出发；
     *
     * @param head
     * @return
     */
    public Boolean hasCycle(CustomSingleNode<Integer> head) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        CustomSingleNode<Integer> slow = head;
        CustomSingleNode<Integer> fast = head;
        while (Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow.equals(fast)) { // 快慢节点如果相遇 则存在环
                return Boolean.TRUE; // 存在环 直接退出
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 因为是单链表，每个节点只有一个后继结点，所以如果有环存在，那也只能是 尾节点和 单链表上的某个节点相遇；
     * 快慢节点相遇后，慢节点暂停，快节点回到head，然后快慢节点都变成慢节点并都开始走，再次相遇的节点即为第一个入环的头节点
     * 这里需要注意：快慢节点需要同时从 head 出发；
     *
     * @param head
     * @return
     */
    public CustomSingleNode<Integer> cycleNode(CustomSingleNode<Integer> head) {
        boolean hasCycle = Boolean.FALSE;
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            return null;
        }
        CustomSingleNode<Integer> slow = head;
        CustomSingleNode<Integer> fast = head;
        while (Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            // 快慢节点如果相遇 则存在环,这时跳出当前循环，
            if (slow.equals(fast)) {
                hasCycle = Boolean.TRUE;
                break;
            }
        }
        if (hasCycle) { // 存在环
            fast = head; // 快节点回到 head
            while (!slow.equals(fast)) {
                slow = slow.getNext(); // 快慢节点同时 亦步亦趋 每次一步
                fast = fast.getNext(); // 快慢节点同时 亦步亦趋 每次一步
            }
            return slow;
        }
        return null;
    }

    /**
     * 求 单链表 环的长度
     * 这里如果单链表有环的话，可以不用找到 环的头结点，通过快慢节点就可以求得 环的长度；
     *
     * @param head
     * @return
     */
    public Integer cycleLength(CustomSingleNode<Integer> head) {
        Integer length = 0;
        boolean hasCycle = Boolean.FALSE;
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            return length;
        }
        CustomSingleNode<Integer> slow = head;
        CustomSingleNode<Integer> fast = head;
        while (Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            // 快慢节点如果相遇 则存在环,这时跳出当前循环，
            if (slow.equals(fast)) {
                hasCycle = Boolean.TRUE;
                break;
            }
        }
        if (hasCycle) { // 存在环
            while (!slow.equals(fast)) {
                slow = slow.getNext();
                fast = fast.getNext().getNext();
                length++;
            }
        }
        return length;
    }

}

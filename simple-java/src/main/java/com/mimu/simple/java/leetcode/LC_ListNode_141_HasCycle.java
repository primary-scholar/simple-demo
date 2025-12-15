package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_ListNode;

import java.util.Objects;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。如果链表中存在环 ，则返回 true 。 否则，返回 false
 * <p>
 * 使用快慢节点 策略进行判断
 * 两个节点都从head 出发，慢节点每次循环走一步 slow.next,快节点每次走两步 fast.next.next；如果快慢节点不相遇 则无环
 */
public class LC_ListNode_141_HasCycle extends LC_ListNode {


    /**
     * 快慢节点 策略进行判断
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (Objects.nonNull(fast.next) && Objects.nonNull(fast.next.next)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) { // 快慢节点如果相遇 则存在环
                return Boolean.TRUE; // 存在环 直接退出
            }
        }
        return Boolean.FALSE;
    }
}

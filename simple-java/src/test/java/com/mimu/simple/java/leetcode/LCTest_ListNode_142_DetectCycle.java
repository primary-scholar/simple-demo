package com.mimu.simple.java.leetcode;


import java.util.Objects;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * Note: Do not modify the linked list.
 * <p>
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 * <p>
 * 单链表是否存在环 这里要求不让使用额外的空间，所以 set，map 就都不可使用
 * 使用快慢节点 策略进行判断
 * 两个节点都从head 出发，慢节点每次循环走一步 slow.next,快节点每次走两步 fast.next.next；如果快慢节点不相遇 则无环
 * 如果相遇则有环 ，有环时 则快节点回到head，然后快慢节点都变成慢节点并都开始走，再次相遇的节点即为第一个入环的头节点
 */
public class LCTest_ListNode_142_DetectCycle extends LC_ListNode {

    public ListNode detectCycle(ListNode head) {
        Boolean hasCycle = Boolean.FALSE;
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (Objects.nonNull(fast.next) && Objects.nonNull(fast.next.next)) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢节点如果相遇 则存在环,这时跳出当前循环，
            if (slow.equals(fast)) {
                hasCycle = Boolean.TRUE;
                break;
            }
        }
        // 有环时 则快节点回到head，然后快慢节点都变成慢节点并都开始走，再次相遇的节点即为第一个入环的头节点
        if (hasCycle) {
            fast = head;
            while (!slow.equals(fast)) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

}

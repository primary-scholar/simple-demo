package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_ListNode;

import java.util.Objects;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Example 1:
 * **Input:** head = [1,2,3,4,5], n = 2
 * **Output:** [1,2,3,5]
 * Example 2:
 * **Input:** head = [1], n = 1
 * **Output:** []
 * Example 3:
 * **Input:** head = [1,2], n = 1
 * **Output:** [1]
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * Follow up: Could you do this in one pass
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 */
public class LC_ListNode_19_RemoveNthFromEnd extends LC_ListNode {

    /**
     * 使用两个指针来进行操作，首先第一个指针先向前走 n 步，这时如果
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (Objects.isNull(head) || n <= 0) {
            return head;
        }
        ListNode fast = head;
        while (Objects.nonNull(fast) && n > 0) { // 从头结点开始，先让 fast 指针 走n步，
            n--;
            fast = fast.next;
        }
        if (n > 0) { // 这里如果 n>0 说明 fast 指针已经为空，即倒数 n 个节点 已经超过 链表的长度
            return head;
        }
        if (Objects.isNull(fast) && n == 0) { // 这里如果 n=0 且 fast 为空，说明删除的是头结点
            return head.next;
        }
        ListNode slow = head;
        ListNode pre = slow;
        while (Objects.nonNull(fast)) { // 这里领先n步的fast指针和在头结点的slow指针同步走，直到fast为空，这时找到倒数第n个节点
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        pre.next = slow.next;
        return head;
    }
}

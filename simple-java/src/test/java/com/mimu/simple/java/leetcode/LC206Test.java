package com.mimu.simple.java.leetcode;

import java.util.Objects;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class LC206Test {

    /**
     * 使用 pre，current，next 三个节点来进行单链表的翻转；
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {// 如果是空或者是单节点链表 直接返回；
            return head;
        }
        ListNode pre = head;
        ListNode current = head.next;
        head.next = null;
        ListNode next = current.next;
        while (Objects.nonNull(next)) {
            current.next = pre;
            pre = current;
            current = next;
            next = next.next;
        }
        current.next = pre;
        return current;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

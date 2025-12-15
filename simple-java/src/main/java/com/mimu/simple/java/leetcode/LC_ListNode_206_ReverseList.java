package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_ListNode;

import java.util.Objects;

/**
 * Reverse a singly linked list.
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * <p>
 * 单链表翻转
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */
public class LC_ListNode_206_ReverseList extends LC_ListNode {

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
        ListNode pre = null;
        ListNode current = head;
        while (Objects.nonNull(current)) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public ListNode reverseList_another(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {// 如果是空或者是单节点链表 直接返回；
            return head;
        }
        ListNode pre = head;
        ListNode current = pre.next;
        head.next = null;  // 头结点的 next 先置空
        ListNode next = current.next;
        while (Objects.nonNull(next)) {
            current.next = pre;
            pre = current;
            current = next;
        }
        current.next = pre;
        return current;
    }


}

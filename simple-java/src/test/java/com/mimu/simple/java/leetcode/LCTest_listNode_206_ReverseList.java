package com.mimu.simple.java.leetcode;

import org.junit.Test;

import java.util.Arrays;
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
public class LCTest_listNode_206_ReverseList extends LC_ListNode {

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
        ListNode current = pre.next;
        head.next = null;  // 头结点的 next 先置空
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

    @Test
    public void reverseListResult() {
        ListNode listNode = list2ListNode(Arrays.asList(8, 9, 9, 9, 0, 0, 0, 1));
        ListNode reverseList = reverseList(listNode);
        assert listNode2List(reverseList).equals(Arrays.asList(1, 0, 0, 0, 9, 9, 9, 8));
    }

}

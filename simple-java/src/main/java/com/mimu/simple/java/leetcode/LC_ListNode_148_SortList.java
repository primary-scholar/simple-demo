package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_ListNode;

import java.util.Objects;

/**
 * Sort a linked list in  O ( n  log  n ) time using constant space complexity.
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * <p>
 * 单链表 排序 要求O(nlogn)
 * 采用 归并排序 思想
 */
public class LC_ListNode_148_SortList extends LC_ListNode {

    public ListNode sortList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode mid = split(head);
        ListNode firstPart = sortList(head);
        ListNode secondPart = sortList(mid);
        return merge(firstPart, secondPart);
    }

    private ListNode split(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode pre = head, slow = head, fast = head;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        return slow;
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (Objects.nonNull(first) && Objects.nonNull(second)) {
            if (first.val < second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }
        current.next = Objects.isNull(first) ? second : first;
        return head.next;
    }

}

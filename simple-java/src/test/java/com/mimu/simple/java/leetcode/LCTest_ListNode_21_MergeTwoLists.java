package com.mimu.simple.java.leetcode;

import java.util.Objects;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * Example 1:
 * **Input:** list1 = [1,2,4], list2 = [1,3,4]
 * **Output:** [1,1,2,3,4,4]
 * Example 2:
 * **Input:** list1 = [], list2 = []
 * **Output:** []
 * Example 3:
 * **Input:** list1 = [], list2 = [0]
 * **Output:** [0]
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class LCTest_ListNode_21_MergeTwoLists extends LC_ListNode {

    /**
     * 这里 没有要求原来的 链表 不变，所以此时可以 复用原来的 节点，而不需要重新构造 节点；
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = Objects.isNull(list1) ? list2 : list1;
        return head.next;
    }
}

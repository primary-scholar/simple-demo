package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_ListNode;

import java.util.Objects;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only  distinct  numbers from the original list.
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 * <p>
 * 删除单链表 重复节点
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表
 */
public class LC_ListNode_82_DeleteDuplicates extends LC_ListNode {

    /**
     * 使用 pre，current，current.next 三指针 来进行重复节点的标记和删除
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy; // pre 节点 从 哑元节点开始
        ListNode current = head;  // 当前节点从 head 开始
        while (Objects.nonNull(current) && Objects.nonNull(current.next)) {
            if (current.val == current.next.val) { // 当前节点 和 其后续节点 相等 则当前节点后移，直到相等节点的最后一个
                while (Objects.nonNull(current.next) && current.val == current.next.val) {
                    current = current.next;
                }
                pre.next = current.next; // 前驱结点 后继为 当前节点的后一个节点 即删除重复节点的最后一个节点
            } else {
                pre = pre.next; //否则 前驱结点后移
            }
            current = current.next; // 不管当前节点是否 和其后继结点相等，当前节点每次都 后移
        }
        return dummy.next;
    }

}

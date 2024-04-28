package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_ListNode;

import java.util.Objects;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * Example 1:
 * Input: 1->2
 * Output: false
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * <p>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为
 * 回文链表 如果是，返回 true ；否则，返回 false
 */
public class LC_ListNode_234_IsPalindrome extends LC_ListNode {

    /**
     * 链表回文
     * 1.取链表 中间节点
     * 2.后半部分逆序
     * 3.判断是否回文
     * 4.原链表 复原
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(LinkNode head) {
        if (Objects.isNull(head)) {
            return Boolean.TRUE;
        }
        LinkNode midOrUpMid = midOrUpMidNode(head);
        LinkNode reversed = reverseList(midOrUpMid);
        LinkNode first = head;
        LinkNode second = reversed;
        while (Objects.nonNull(first) && Objects.nonNull(second)) {
            if (first.val != second.val) {
                return Boolean.FALSE;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(reversed);
        return Boolean.TRUE;
    }

    public LinkNode reverseList(LinkNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {// 如果是空或者是单节点链表 直接返回；
            return head;
        }
        LinkNode pre = null;
        LinkNode current = head;
        while (Objects.nonNull(current)) {
            LinkNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public LinkNode midOrUpMidNode(LinkNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next) || Objects.isNull(head.next.next)) {
            return head;
        }
        LinkNode slow = head;
        LinkNode fast = head;
        while (Objects.nonNull(fast.next) && Objects.nonNull(fast.next.next)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

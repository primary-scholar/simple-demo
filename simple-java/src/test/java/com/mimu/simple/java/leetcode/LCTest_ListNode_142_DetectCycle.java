package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.algorithm.linkstackqueue.link.CustomSingleNode;

import java.util.Objects;

/**
 *
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

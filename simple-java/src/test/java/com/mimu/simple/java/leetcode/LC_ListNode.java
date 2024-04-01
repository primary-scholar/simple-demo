package com.mimu.simple.java.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LC_ListNode {

    protected ListNode list2ListNode(List<Integer> number) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (Integer i : number) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head.next;
    }

    protected List<Integer> listNode2List(ListNode node) {
        if (Objects.isNull(node)) {
            return Collections.emptyList();
        }
        ArrayList<Integer> result = new ArrayList<>();
        ListNode next = node;
        while (Objects.nonNull(next)) {
            result.add(next.val);
            next = next.next;
        }
        return result;
    }

    protected static class ListNode {
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

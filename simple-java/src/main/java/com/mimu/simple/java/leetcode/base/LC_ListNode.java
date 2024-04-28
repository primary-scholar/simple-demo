package com.mimu.simple.java.leetcode.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LC_ListNode {

    public ListNode list2Node(List<Integer> number) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (Integer i : number) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head.next;
    }

    public List<Integer> node2List(ListNode node) {
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

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

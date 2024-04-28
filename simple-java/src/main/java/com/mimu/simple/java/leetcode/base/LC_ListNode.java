package com.mimu.simple.java.leetcode.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LC_ListNode {

    public LinkNode list2LinkNode(List<Integer> number) {
        LinkNode head = new LinkNode(-1);
        LinkNode curr = head;
        for (Integer i : number) {
            curr.next = new LinkNode(i);
            curr = curr.next;
        }
        return head.next;
    }

    public List<Integer> linkNode2List(LinkNode node) {
        if (Objects.isNull(node)) {
            return Collections.emptyList();
        }
        ArrayList<Integer> result = new ArrayList<>();
        LinkNode next = node;
        while (Objects.nonNull(next)) {
            result.add(next.val);
            next = next.next;
        }
        return result;
    }

    public class LinkNode {
        public int val;
        public LinkNode next;

        public LinkNode() {
        }

        public LinkNode(int val) {
            this.val = val;
        }

        public LinkNode(int val, LinkNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

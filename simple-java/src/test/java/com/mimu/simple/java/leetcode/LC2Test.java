package com.mimu.simple.java.leetcode;

/**
 * author: mimu
 * date: 2019/9/30
 */


import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import javax.crypto.Cipher;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * **Input:** l1 = [0], l2 = [0]
 * **Output:** [0]
 *
 * Example 3:
 *
 * **Input:** l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * **Output:** [8,9,9,9,0,0,0,1]
 */
public class LC2Test {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);// 构建一个头结点为-1的节点数据
        ListNode cur = node;
        int carry = 0;// 进位初始为0
        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {// 两个链表 只要一个非空就循环
            int d1 = Objects.isNull(l1) ? 0 : l1.val;// 分别获取该节点的数字
            int d2 = Objects.isNull(l2) ? 0 : l2.val;// 分别获取该节点的数字
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0;// 设置需要的进位
            cur.next = new ListNode(sum % 10);// 设置个位数字的节点数据
            cur = cur.next;// 当前节点后移
            if (Objects.nonNull(l1)) l1 = l1.next;
            if (Objects.nonNull(l2)) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return node.next;// 返回头结点的下一个节点数据
    }

    class ListNode {
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

    @Test
    public void printResult() {
        ListNode node = addTwoNumbers(prepare(Arrays.asList(2, 4, 3)), prepare(Arrays.asList(5, 6, 4)));
        while (Objects.nonNull(node)) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
        ListNode node1 = addTwoNumbers(prepare(Arrays.asList(9, 9, 9, 9, 9, 9, 9)), prepare(Arrays.asList(9, 9, 9, 9)));
        while (Objects.nonNull(node1)) {
            System.out.print(node1.val);
            node1 = node1.next;
        }
    }

    public ListNode prepare(List<Integer> number) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (Integer i : number) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head.next;
    }

}

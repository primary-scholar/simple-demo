package com.mimu.simple.java.leetcode;

/**
 * author: mimu
 * date: 2019/9/30
 */


import org.junit.Test;

import java.util.Arrays;
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
 * <p>
 * Example 2:
 * <p>
 * **Input:** l1 = [0], l2 = [0]
 * **Output:** [0]
 * <p>
 * Example 3:
 * <p>
 * **Input:** l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * **Output:** [8,9,9,9,0,0,0,1]
 */
public class LCTest_ListNode_AddTwoNumbers_2 extends LC_ListNode {

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

    @Test
    public void printResult() {
        ListNode node = addTwoNumbers(list2ListNode(Arrays.asList(2, 4, 3)), list2ListNode(Arrays.asList(5, 6, 4)));
        ListNode convert = list2ListNode(Arrays.asList(7, 0, 8));
        assert listNode2List(node).equals(listNode2List(convert));
        ListNode node1 = addTwoNumbers(list2ListNode(Arrays.asList(9, 9, 9, 9, 9, 9, 9)), list2ListNode(Arrays.asList(9, 9, 9, 9)));
        ListNode convert1 = list2ListNode(Arrays.asList(8, 9, 9, 9, 0, 0, 0, 1));
        assert listNode2List(node1).equals(listNode2List(convert1));
    }

}

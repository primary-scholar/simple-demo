package com.mimu.simple.java.leetcode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * * A:          a1 → a2
 * *                       ↘
 * *                         c1 → c2 → c3
 * *                       ↗
 * * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.、
 * <p>
 * 两个无环链表 求相交的首节点 要求 内存空间 O(1) 所以 只能在原链表上 进行查找
 * 因为是单链表 每个节点只有一个直接后继，所以 如果两个 单链表相交，则必然 是从某个节点开始，其余后继结点 都一样
 * * * A:       a1 → a2
 * * *                   ↘                       a1 -> a2 -> c1 -> c2 -> c3 -> null -> b1 -> b2 -> b3 -> c1;
 * * *                     c1 → c2 → c3  ---->                                                          相交点
 * * *                   ↗                       b1 -> b2 -> b3 -> c1 -> c2 -> c3 -> null -> a1 -> a2 -> c1
 * * * B:  b1 → b2 → b3
 * 如果两个链表相交，那么相交点之后的长度是相同的
 * <p>
 * 我们需要做的事情是，让两个链表从同距离末尾同等距离的位置开始遍历。这个位置只能是较短链表的头结点位置。
 * 为此，我们必须消除两个链表的长度差
 * 1.指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
 * 2.如果 pA 到了末尾，则 pA = headB 继续遍历
 * 3.如果 pB 到了末尾，则 pB = headA 继续遍历
 * 4.比较长的链表指针指向较短链表head时，长度差就消除了
 * 5.如此，只需要将最短链表遍历两次即可找到位置；
 */
public class LCTest_ListNode_160_GetIntersectionNode extends LC_ListNode {

    /**
     * * 1.指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
     * * 2.如果 pA 到了末尾，则 pA = headB 继续遍历
     * * 3.如果 pB 到了末尾，则 pB = headA 继续遍历
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
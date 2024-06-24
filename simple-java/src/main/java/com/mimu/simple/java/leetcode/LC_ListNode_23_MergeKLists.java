package com.mimu.simple.java.leetcode;


import com.mimu.simple.java.leetcode.base.LC_ListNode;

import java.util.Objects;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Example 1:
 * **Input:** lists = [[1,4,5],[1,3,4],[2,6]]
 * **Output:** [1,1,2,3,4,4,5,6]
 * **Explanation:** The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * <p>
 * Example 2:
 * **Input:** lists = []
 * **Output:** []
 * <p>
 * Example 3:
 * **Input:** lists = [[]]
 * **Output:** []
 * <p>
 * 合并k个升序链表
 * <p>
 * 思路：整体按照 两个有序链表的合并方法，进行合并
 * 不过初始时 是 使用 空 链表和 数组中的 第一个进行合并，得到一个合并的结果，然后把该结果在和 后续的链表合并
 * 即不断地把合并后的结果，当做参数 继续后数组内的后续链表合并，直到数组全部合并完
 */
public class LC_ListNode_23_MergeKLists extends LC_ListNode {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode element = null;
        for (int i = 0; i < lists.length; i++) {
            element = mergeListNode(element, lists[i]); // 这里循环 把lists 中的 链表 和构造的链表 进行 合并；
        }
        return element;
    }

    /**
     * 这里 没有要求原来的 链表 不变，所以此时可以 复用原来的 节点，而不需要重新构造 节点；
     *
     * @param first
     * @param second
     * @return
     */
    private ListNode mergeListNode(ListNode first, ListNode second) {
        if (Objects.isNull(first) || Objects.isNull(second)) {
            return Objects.nonNull(first) ? first : second;
        }
        ListNode head = new ListNode(-1); // 设置一个 哨兵 头结点
        ListNode current = head;
        ListNode firstCurrent = first;
        ListNode secondCurrent = second;
        while (Objects.nonNull(firstCurrent) && Objects.nonNull(secondCurrent)) {
            if (firstCurrent.val <= secondCurrent.val) { // 取两个链表中 较小的 节点，同时 下一个节点 后移，并把选择的节点 设置在 tail 节点之后；
                current.next = firstCurrent;
                firstCurrent = firstCurrent.next;
            } else {  // 取两个链表中 较小的 节点，同时 下一个节点 后移，并把选择的节点 设置在 tail 节点之后；
                current.next = secondCurrent;
                secondCurrent = secondCurrent.next;
            }
            current = current.next; // tail 节点不断后移
        }
        current.next = Objects.nonNull(firstCurrent) ? firstCurrent : secondCurrent; // 对于没有结束的 剩余链表，直接挂载到 tail 节点之后即可
        return head.next; // 返回哨兵节点 之后的节点链表；
    }

}

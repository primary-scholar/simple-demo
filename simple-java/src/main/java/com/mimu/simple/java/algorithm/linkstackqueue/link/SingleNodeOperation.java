package com.mimu.simple.java.algorithm.linkstackqueue.link;

import java.util.Objects;

public class SingleNodeOperation<T> {
    /**
     * 单链表 倒序
     * 整体思路：在反转过程中 取 pre，head，next(临时节点-head的后继节点) 三个节点
     * 分别表示 单链表 头节点的 前驱节点，头节点和 头节点的后继节点 初始时 pre 和 next 都为 null 即可
     * 头节点非空 开始循环
     * <p>
     * 首先 给 next 即 head 的后继节点赋值，
     * 然后 头节点 的 next 赋值为 前驱 pre 节点，
     * pre 节点后移即当前的 head 节点 ，
     * head 头节点继续后移 即当前的 next 节点
     * <p>
     * 然后 无限循环知道 头节点为空；
     *
     * @param head
     * @return
     */
    public CustomSingleNode<T> revertSingleNodeList(CustomSingleNode<T> head) {
        // 给 pre next 节点赋值
        CustomSingleNode<T> pre = null;
        CustomSingleNode<T> next;
        while (Objects.nonNull(head)) {     // head 节点非空 开始循环
            next = head.getNext();      // 首先为 head 的后继节点 next 赋值
            head.setNext(pre);      // head 的后继节点 置为前驱节点
            pre = head;     // pre 节点后移 为 head 节点
            head = next;    // head 节点后移为 next 节点
        }
        return pre;
    }


    /**
     * 单链表 删除 某些元素
     * 整体思路：首先删除单链表 表头及其后继节点为 待删除的 case1，以及其他间隔节点为 待删除的case2；
     * case1：可使用 head,和 next 两个节点来循环后移删除操作
     * 头节点非空 且和待删除元素相等 则开始循环
     * <p>
     * 首先 给 next 即 head 的后继节点赋值，然后 head 节点的 next 置空，head 节点 后移到 当前的 next 节点
     * <p>
     * case2:在剩余的链表中 需要保留头节点并返回，所以这里需要 head，curr，next 三个相邻的 节点来操作 待删除的数据
     * 首先给 curr，next 节点赋值，开始都为 head 的节点
     * 如果 next 节点非空 则开始循环
     * <p>
     * 若 next 节点的数据即为待删数据 则
     * 首先使用一个 tmp 节点暂存 next 节点 (便于为删除节点的 next 置空  在单链表中该操作可不做)
     * 然后 next 节点后移，curr 的后继节点 只为 当前后移后的 next 节点， tmp 后继 节点置空
     * 若 next 节点的数据为非待删除数据 则
     * curr 节点后移 到当前的 next 节点，next 节点后移到下一个节点
     * <p>
     * 然后 无限循环直到 next 节点为空；
     *
     * @param head
     * @param delete
     * @return
     */
    public CustomSingleNode<T> deleteSingleNodeList(CustomSingleNode<T> head, T delete) {
        if (Objects.isNull(head)) {
            return null;
        }
        // head 节点非空 且为待删除节点
        while (Objects.nonNull(head) && head.getData().equals(delete)) {
            CustomSingleNode<T> next = head.getNext();      // 首先为 head 的后继节点 next 赋值
            head.setNext(null);     // head 后继节点置空
            head = next;        // head 节点后移
        }
        // 给 pre next 节点赋值
        CustomSingleNode<T> curr = head;
        CustomSingleNode<T> next = head;
        while (Objects.nonNull(next)) {
            // 首次进入到该循环时 这里 next 一定为非待删除节点(否则 在 case1 中就被删除了)，if中为 待删除的 数据节点
            if (next.getData().equals(delete)) {
                CustomSingleNode<T> tmp = next;     // 临时节点tmp 暂存每一个待删除的 节点 (便于后续该节点的 后继节点置空)
                next = next.getNext();      // next 节点后移
                curr.setNext(next);     // curr 节点的 后继节点为 next 节点
                tmp.setNext(null);      // 待删除的临时节点 后继置空
            } else {
                curr = next;        // curr 节点后移到 next 节点
                next = next.getNext();      // next 节点继续后移
            }
        }
        return head;
    }
}

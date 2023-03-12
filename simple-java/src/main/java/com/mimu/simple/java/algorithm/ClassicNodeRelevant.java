package com.mimu.simple.java.algorithm;

/**
 * 链表 1-单链表；2-双链表
 * 算法：1-链表倒序；2-链表删除某个元素(如果有多个全部删除)
 */
public class ClassicNodeRelevant {


    /**
     * 单链表 倒序
     *
     * @param node
     * @return
     */
    public OneLinkNode<Integer> oneLinkNodeRevert(OneLinkNode<Integer> node) {
        return null;
    }


    /**
     * 单链表 删除 某些元素
     *
     * @param node
     * @param delete
     * @return
     */
    public OneLinkNode<Integer> oneLinkNodeDelete(OneLinkNode<Integer> node, Integer delete) {
        return null;
    }

    /**
     * 双链表 倒序
     *
     * @param node
     * @return
     */
    public TwoLinkNode<Integer> twoLinkNodeRevert(TwoLinkNode<Integer> node) {
        return null;
    }

    /**
     * 双链表 删除某个元素
     *
     * @param node
     * @param delete
     * @return
     */
    public TwoLinkNode<Integer> twoLinkNodeDelete(TwoLinkNode<Integer> node, Integer delete) {
        return null;
    }


    /**
     * 单链表
     */
    public static class OneLinkNode<T> {
        private T data;
        private OneLinkNode<T> next;
    }

    /**
     * 双链表
     */
    public static class TwoLinkNode<T> {
        private T data;
        private TwoLinkNode<T> pre;
        private TwoLinkNode<T> next;
    }
}

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
    public OneLinkNode oneLinkNodeRevert(OneLinkNode node) {
        return null;
    }


    /**
     * 单链表 删除 某些元素
     *
     * @param node
     * @param delete
     * @return
     */
    public OneLinkNode oneLinkNodeDelete(OneLinkNode node, Integer delete) {
        return null;
    }

    /**
     * 双链表 倒序
     *
     * @param node
     * @return
     */
    public TwoLinkNode twoLinkNodeRevert(TwoLinkNode node) {
        return null;
    }

    /**
     * 双链表 删除某个元素
     *
     * @param node
     * @param delete
     * @return
     */
    public TwoLinkNode twoLinkNodeDelete(TwoLinkNode node, Integer delete) {
        return null;
    }


    /**
     * 单链表
     */
    public static class OneLinkNode {
        private Integer data;
        private OneLinkNode next;
    }

    /**
     * 双链表
     */
    public static class TwoLinkNode {
        private Integer data;
        private TwoLinkNode pre;
        private TwoLinkNode next;
    }
}

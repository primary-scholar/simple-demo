package com.mimu.simple.java.leetcode.base;


import org.apache.commons.collections.CollectionUtils;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LC_TreeNode {

    public TreeNode list2TreeByPre(Queue<Integer> queueNode) {
        if (CollectionUtils.isEmpty(queueNode)) {
            return null;
        }
        LinkedList<Integer> copy = new LinkedList<>(queueNode);
        return preDecode(copy);
    }

    private TreeNode preDecode(Queue<Integer> queue) {
        Integer poll = queue.poll();
        if (Objects.isNull(poll)) {
            return null;
        }
        TreeNode treeNode = new TreeNode(poll);
        treeNode.left = preDecode(queue);
        treeNode.right = preDecode(queue);
        return treeNode;
    }

    public TreeNode list2TreeByLevel(Queue<Integer> levelQueue) {
        if (CollectionUtils.isEmpty(levelQueue)) {
            return null;
        }
        TreeNode treeNode = createTreeNode(levelQueue.poll());
        Queue<TreeNode> queue = new LinkedList<>();
        if (Objects.nonNull(treeNode)) {
            queue.add(treeNode);//头结点入队
        }
        TreeNode current;
        while (!queue.isEmpty()) {//队列非空 循环
            current = queue.poll();//弹出
            current.left = createTreeNode(levelQueue.poll());
            current.right = createTreeNode(levelQueue.poll());
            if (Objects.nonNull(current.left)) {
                queue.add(current.left);
            }
            if (Objects.nonNull(current.right)) {
                queue.add(current.right);
            }
        }
        return treeNode;
    }

    private TreeNode createTreeNode(Integer data) {
        if (Objects.isNull(data)) {
            return null;
        }
        return new TreeNode(data);
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

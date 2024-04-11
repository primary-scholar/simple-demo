package com.mimu.simple.java.leetcode;

import java.util.*;

/**
 * 二叉树按层遍历
 * 使用队列让节点入队，
 * <p>
 * Given a binary tree, return the  level order  traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * <p>
 * *     3
 * *    / \
 * *   9  20
 * *     /  \
 * *    15   7
 * *
 * return its level order traversal as:
 * * [
 * *   [3],
 * *   [9,20],
 * *   [15,7]
 * * ]
 */
public class LCTest_BinTreeNode_102_LevelOrder extends LC_TreeNode {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);// 头结点入队
        while (!queue.isEmpty()) {// 队列非空则循环
            int levelSize = queue.size();// 每一层节点个数
            ArrayList<Integer> levelResult = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();// 弹出队列 中的节点 并添加到list中
                levelResult.add(poll.val);
                if (Objects.nonNull(poll.left)) { // 当前节点左子树非空则，左子树入队
                    queue.add(poll.left);
                }
                if (Objects.nonNull(poll.right)) { // 当前节点右子树非空则，右子树入队
                    queue.add(poll.right);
                }
            }
            result.add(levelResult); // 收集每一层的数据
        }
        return result;
    }

}

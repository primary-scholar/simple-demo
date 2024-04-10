package com.mimu.simple.java.leetcode;

import java.util.*;

/**
 * 求二叉树 的最大深度
 * <p>
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * *     3
 * *    / \
 * *   9  20
 * *     /  \
 * *    15   7
 * return its depth = 3.
 */
public class LCTest_BinTreeNode_104_MaxDepth extends LC_TreeNode {

    /**
     * 参照 二叉树的 按层 遍历 即树的广度优先遍历；
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int result = 0;
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            result++;
            int levelSize = nodeQueue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodeQueue.poll();
                if (Objects.nonNull(node.left)) {
                    nodeQueue.add(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    nodeQueue.add(node.right);
                }
            }
        }
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public int maxDepthAnother(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}

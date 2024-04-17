package com.mimu.simple.java.leetcode;

import java.util.Objects;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longestpath between any two nodes in a tree. This path may or may not pass through the root.
 * Example:
 * Given a binary tree
 * *           1
 * *          / \
 * *         2   3
 * *        / \
 * *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * <p>
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示
 */
public class LCTest_BinTreeNode_543_DiameterOfBinaryTree extends LC_TreeNode {

    private int diameter;

    /**
     * 二叉树的直径 即二叉树 左右子树 深度之和 的最大值；
     * 1.求某棵树的 左子树最大深度和右子树最大深度，取最大值；
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    /**
     * step1,step2,step3 这里是 典型的求一棵树的 最大深度的递归算法；
     * 而这里，我们需要分别计算一个树，左子树的最大深度，和右子树的最大深度 然后求和；
     *
     * @param node
     * @return
     */
    public int maxDepth(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int leftDepth = maxDepth(node.left); // step1: 当前节点 左子树 深度
        int rightDepth = maxDepth(node.right); // step2: 当前节点 右子树 深度
        diameter = Math.max(leftDepth + rightDepth, diameter);
        return Math.max(leftDepth, rightDepth) + 1; // step3: 当前节点 深度
    }
}

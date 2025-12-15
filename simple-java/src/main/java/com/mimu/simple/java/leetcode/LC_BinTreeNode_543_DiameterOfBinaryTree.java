package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_TreeNode;

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
public class LC_BinTreeNode_543_DiameterOfBinaryTree extends LC_TreeNode {

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

    public int diameterOfBinaryTree_another(TreeNode root) {
        NodeInfo process = NodeInfo.process(root);
        return process.distance - 1;
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

    static class NodeInfo {
        private Integer distance;
        private Integer height;

        NodeInfo(Integer dis, Integer hei) {
            this.distance = dis;
            this.height = hei;
        }

        /**
         * 二叉树的 递归套路
         * 当前节点的 最大直径 分为两种情况
         * 1.当前节点 在最大直径的路径上，即最大路径在 当前节点的 左子树和右子树上
         * 2.当前节点 不在最大直径的路径上，即最大路径在 当前节点的 左子树或右子树上
         *
         * @param node
         * @return
         */
        public static NodeInfo process(TreeNode node) {
            if (Objects.isNull(node)) {
                return new NodeInfo(0, 0);
            }
            NodeInfo leftNode = process(node.left);
            NodeInfo rightNode = process(node.right);
            // 当前节点的 最大高度 是左右子树最大高度 +1
            int height = Math.max(leftNode.height, rightNode.height) + 1;
            // 当前节点的 最大距离 左右子树最大距离，和当前节点 左右高度+1 中的最大值
            int distance = Math.max(Math.max(leftNode.distance, rightNode.distance),
                    leftNode.height + rightNode.height + 1);
            return new NodeInfo(distance, height);
        }
    }
}

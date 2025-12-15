package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_TreeNode;

import java.util.Objects;
import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * Input:
 * *     2
 * *    / \
 * *   1   3
 * Output: true
 * Example 2:
 * *     5
 * *    / \
 * *   1   4
 * *      / \
 * *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value is 5 but its right child's value is 4.
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树
 */
public class LC_BinTreeNode_98_IsValidBST extends LC_TreeNode {

    public boolean isValidBST(TreeNode root) {
        if (Objects.isNull(root)) {
            return Boolean.TRUE;
        }
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归算法
     * 二叉搜索树 当前节点的值 < 右子树所有节点，> 左子树所有节点
     *
     * @param node
     * @param left
     * @param right
     * @return
     */
    private boolean valid(TreeNode node, long left, long right) {
        if (Objects.isNull(node)) {
            return Boolean.TRUE;
        }
        int data = node.val;
        if (data <= left || data >= right) {
            return Boolean.FALSE;
        }
        // 对于左子树来说 当前节点数值，是左子树的最大值；对于右子树来说，当前节点的数值，是右子树的最小值；
        return valid(node.left, left, data) && valid(node.right, data, right);
    }

    /**
     * 中序遍历 有序序列
     * 这里使用 中序遍历 非递归算法
     *
     * @param root
     * @return
     */
    public boolean isValidBST_nonRe(TreeNode root) {
        if (Objects.isNull(root)) {
            return Boolean.TRUE;
        }
        long min = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || Objects.nonNull(current)) {
            if (Objects.nonNull(current)) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode pop = stack.pop();
                if (pop.val < min) {
                    return Boolean.FALSE;
                }
                min = pop.val;
                current = pop.right;
            }
        }
        return Boolean.TRUE;
    }
}

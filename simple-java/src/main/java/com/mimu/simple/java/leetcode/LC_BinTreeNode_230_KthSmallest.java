package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_TreeNode;

import java.util.Objects;
import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 * *    3
 * *   / \
 * *  1   4
 * *   \
 * *    2
 * Output: 1
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * *        5
 * *       / \
 * *      3   6
 * *     / \
 * *    2   4
 * *   /
 * *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 * <p>
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）
 */
public class LC_BinTreeNode_230_KthSmallest extends LC_TreeNode {

    /**
     * 使用 二叉树 中序遍历，是有序序列的 特点进行计算
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (Objects.isNull(root) || k <= 0) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || Objects.nonNull(current)) {
            if (Objects.nonNull(current)) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode pop = stack.pop();
                current = pop.right;
                k--;
                if (k == 0) {
                    return pop.val;
                }
            }
        }
        return -1;
    }
}

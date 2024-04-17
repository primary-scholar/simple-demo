package com.mimu.simple.java.leetcode;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Invert a binary tree.
 * *
 * *      4
 * *    /   \
 * *   2     7
 * *  / \   / \
 * * 1   3 6   9
 * * to
 * *
 * *      4
 * *    /   \
 * *   7     2
 * *  / \   / \
 * * 9   6 3   1
 * <p>
 * 反转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点
 */
public class LCTest_BinTreeNode_266_InvertTree extends LC_TreeNode {
    /**
     * 递归调用即可
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode left = root.left; // 临时 节点 保存左子树
        root.left = root.right; // 左右子树交换
        root.right = left;
        invertTree(root.left); // 递归左子树
        invertTree(root.right); // 递归右子树
        return root;
    }

    /**
     * 非递归算法 使用队列 进行辅助
     *
     * @param root
     * @return
     */
    public TreeNode invertTree_nonRe(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (Objects.nonNull(left)) {
                queue.add(left);
            }
            if (Objects.nonNull(right)) {
                queue.add(right);
            }
            node.right = left;
            node.left = right;
        }
        return root;
    }
}

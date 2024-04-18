package com.mimu.simple.java.leetcode;

import java.util.Objects;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 * *          1
 * *         / \
 * *        2   5
 * *       / \   \
 * *      3   4   6
 * The flattened tree should look like:
 * *    1
 * *     \
 * *      2
 * *       \
 * *        3
 * *         \
 * *          4
 * *           \
 * *            5
 * *             \
 * *              6
 * click to show hints.
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order trave
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同
 */
public class LCTest_BinTreeNode_114_Flatten extends LC_TreeNode {

    /**
     * 非递归算法
     * 1.寻找当前节点 左节点的最右侧 节点 leftRight
     * 2.把当前节点的 右孩子节点 放到 leftRight 节点的右孩子上，把当前节点的 左孩子结点 放到 右孩子上，当前节点左孩子置空
     * 3.当前节点 向右孩子节点 移动
     * 重复上面的步骤 直到当前节点为空
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (Objects.nonNull(current)) {
            TreeNode leftRight = current.left;
            if (Objects.isNull(leftRight)) {
                current = current.right;
            } else {
                while (Objects.nonNull(leftRight.right)) {
                    leftRight = leftRight.right;
                }
                leftRight.right = current.right;
                current.right = current.left;
                current.left = null;
                current = current.right;
            }
        }
    }

    /**
     * 递归算法
     *
     * @param root
     */
    public void flatten_re(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        if (Objects.nonNull(root.left)) {
            flatten_re(root.left);
        }
        if (Objects.nonNull(root.right)) {
            flatten_re(root.right);
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (Objects.nonNull(root.right)) {
            root = root.right;
        }
        root.right = tmp;
    }

}

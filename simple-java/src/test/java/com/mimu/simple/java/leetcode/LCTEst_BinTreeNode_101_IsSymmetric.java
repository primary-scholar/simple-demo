package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.algorithm.bintree.ClassicTreeSerializedOperation;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 * *     1
 * *    / \
 * *   2   2
 * *  / \ / \
 * * 3  4 4  3
 * *
 * *
 * But the following is not:
 * *     1
 * *    / \
 * *   2   2
 * *    \   \
 * *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称
 * 注意：这里不能使用中序遍历判断，序列是回文的方式来处理；
 *
 * @see ClassicTreeSerializedOperation 中序序列；
 */
public class LCTEst_BinTreeNode_101_IsSymmetric extends LC_TreeNode {

    /**
     * 递归算法
     * 注意：这里不能使用中序遍历判断，序列是回文的方式来处理；
     * 对称二叉树要求：root 的左节点和右节点一致，左节点的左节点和右节点的右节点一致，以及 左节点的右节点和右节点的左节点一致；
     *
     * @param root
     * @return
     * @see ClassicTreeSerializedOperation 中序序列；
     */
    public boolean isSymmetric(TreeNode root) {
        if (Objects.isNull(root)) {
            return Boolean.TRUE;
        }
        return isSymmetricPro(root.left, root.right);
    }

    private boolean isSymmetricPro(TreeNode left, TreeNode right) {
        if (Objects.isNull(left) && Objects.isNull(right)) { // 左右节点是否一致
            return Boolean.TRUE;
        } else if (Objects.isNull(left) || Objects.isNull(right)) {
            return Boolean.FALSE;
        } else if (left.val != right.val) {
            return Boolean.FALSE;
        }
        // 左节点的左节点和右节点的右节点是否一致，以及 左节点的右节点和右节点的左节点是否一致；
        return isSymmetricPro(left.left, right.right) && isSymmetricPro(left.right, right.left);
    }


    /**
     * 非递归算法
     * 1.需要判断左右子树 是否相等，因此每次入队都是 左右两两成对的入队；
     * 2.对于左子树的左节点和右子树的右节点，以及左子树的右节点和右子树的左节点 其入队逻辑 不能错；
     *
     * @param root
     * @return
     */
    public boolean isSymmetric_nonRe(TreeNode root) {
        if (Objects.isNull(root)) {
            return Boolean.TRUE;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root.left); // 左右两两成对的入队
        queue.push(root.right); /// 左右两两成对的入队
        while (!queue.isEmpty()) {
            TreeNode left = queue.pop();
            TreeNode right = queue.pop();
            if (Objects.isNull(left) && Objects.isNull(right)) { // 这里如果双方都为空，只能说明其父节点的 左或右节点为空，不能确定全部子树为空，只有全部节点都入队，且全部一致 才是对称子树；
                continue;
            }
            if (Objects.isNull(left) || Objects.isNull(right)) {
                return Boolean.FALSE;
            }
            if (left.val != right.val) {
                return Boolean.FALSE;
            }
            // 对于左子树的左节点和右子树的右节点
            queue.push(left.left);
            queue.push(right.right);
            // 左子树的右节点和右子树的左节点
            queue.push(left.right);
            queue.push(right.left);
        }
        return Boolean.TRUE;
    }
}

package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_TreeNode;

import java.util.Objects;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of  every node never differ by more than 1.
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * *       0
 * *      / \
 * *    -3   9
 * *    /   /
 * *  -10  5
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树
 * <p>
 * 所谓二叉搜索树，是一种始终满足 左 < 根 < 右 特性的树，对二叉搜索树按中序遍历，可得到一个有序数组。
 * 反过来，我们可以得知，根节点应该是有序数组的中间点，从中间点分开为左右两个有序数组，在分别找出其中间点作为原中间点的左右两个子节点，
 * 即利用二分查找法的核心思想
 * 注意：
 * 给定一棵二叉树，其中序遍历是唯一的，但是给定一个中序序列的二叉树，构建的二叉树不唯一；
 */
public class LC_BinTreeNode_108_SortedArrayToBST extends LC_TreeNode {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (Objects.isNull(nums)) {
            return null;
        }
        return create(nums, 0, nums.length - 1);
    }

    /**
     * 根据 二叉搜索树的中序遍历 是一个有序列表的性质，采用中序遍历的方式，反序列化二叉树
     *
     * @param data
     * @param left
     * @param right
     * @return
     */
    private TreeNode create(int[] data, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2; // 取中间节点 一定是当前的 root
        TreeNode node = new TreeNode(data[mid]);
        node.left = create(data, left, mid - 1);  // 构造 左子树
        node.right = create(data, mid + 1, right); // 构造 右子树
        return node;
    }
}

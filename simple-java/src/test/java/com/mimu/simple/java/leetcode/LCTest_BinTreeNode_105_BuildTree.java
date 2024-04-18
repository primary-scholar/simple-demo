package com.mimu.simple.java.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * For example, given
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * *     3
 * *    / \
 * *   9  20
 * *     /  \
 * *    15   7
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点
 */
public class LCTest_BinTreeNode_105_BuildTree extends LC_TreeNode {

    /**
     * 对于任意一颗树而言
     * 先序遍历的形式总是
     * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 而中序遍历的形式总是
     * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (Objects.isNull(preorder) || Objects.isNull(inorder) || preorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    TreeNode process(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> inMap) {
        if (preLeft > preRight) {
            return null;
        }
        Integer data = preorder[preLeft]; // 先序的初始节点一定是 头结点
        Integer inRootIdx = inMap.get(data); // 找到中序遍历 头结点的下标
        int subTreeLen = inRootIdx - inLeft; // 找到左子树的长度
        TreeNode node = new TreeNode(data);
        // 当前节点的根：preorder[preLeft]，
        // 先序遍历左子树：preorder[preLeft+1,preLeft+subTreeLen],中序遍历左子树：inorder[inLeft,inRootIdx-1]
        node.left = process(preorder, preLeft + 1, preLeft + subTreeLen, inorder, inLeft, inRootIdx - 1, inMap);
        // 当前节点
        // 先序遍历右子树：preorder[preLeft+subTreeLen+1,preRight],中序遍历右子树：inorder[inRootIdx+1,inRight]
        node.right = process(preorder, preLeft + subTreeLen + 1, preRight, inorder, inRootIdx + 1, inRight, inMap);
        return node;
    }
}

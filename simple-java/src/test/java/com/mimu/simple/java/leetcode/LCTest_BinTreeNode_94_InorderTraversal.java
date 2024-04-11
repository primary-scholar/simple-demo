package com.mimu.simple.java.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 二叉树中序遍历
 * Given a binary tree, return the  inorder  traversal of its nodes' values.
 * <p>
 * Example:
 * Input: [1,null,2,3]
 * *    1
 * *     \
 * *      2
 * *     /
 * *    3
 * <p>
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class LCTest_BinTreeNode_94_InorderTraversal extends LC_TreeNode {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        inOrder(root, result);
        return result;
    }

    /**
     * 中序遍历递归算法
     *
     * @param node
     * @param result
     */
    public void inOrder(TreeNode node, List<Integer> result) {
        if (Objects.isNull(node)) {
            return;
        }
        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
    }

    /**
     * 中序遍历 非递归算法
     * 1。整个树的左边界全部入栈-即根节点非空 则入栈 然后根节点向左孩子前移一直循环
     * 2。如果1无法继续执行，则弹出栈中的第一个节点并收集，然后向弹出节点的右孩子节点前移 继续执行1；
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalAnother(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || Objects.nonNull(current)) {
            if (Objects.nonNull(current)) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                current = pop.right;
            }

        }
        return result;
    }

}

package com.mimu.simple.java.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the  zigzag level order  traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * *    3
 * *   / \
 * *  9  20
 * *    /  \
 * *   15   7
 * return its zigzag level order traversal as:
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 二叉树锯齿形访问
 * 二叉树的 按层遍历 不过每层的遍历顺序要相反
 */

public class LCTest_BinTreeNode_103_ZigzagLevelOrder extends LC_TreeNode {
    /**
     * 使用一个队列和一个双端队列进行数据转化，一个用于访问二叉树的层级节点，另一个双端队列根据层的奇偶来
     * 前插和后插数据
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        // 创建一个队列用于存放每一层的结点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);// 初始的时候添加根结点
        boolean sign = true;// 用于区分奇偶层
        while (!queue.isEmpty()) {
            // 获取队列的长度
            int size = queue.size();
            // 创建一个双端队列用于存储该层的结点值
            Deque<Integer> res = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                // 获取队头结点
                TreeNode curNode = queue.poll();
                // 根据层数来判断添加到队头还是队尾
                if (sign) {
                    res.offerLast(curNode.val); // 从双端队列的 尾部依次插入数据
                } else {
                    res.offerFirst(curNode.val); // 从双端队列的 头部依次插入数据
                }
                // 更新结点队列
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            // 添加到结果集里面
            lists.add(new LinkedList<>(res));
            // 改变层数状态
            sign = !sign;
        }
        return lists;
    }

}

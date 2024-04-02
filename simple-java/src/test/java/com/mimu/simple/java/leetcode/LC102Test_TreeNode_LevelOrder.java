package com.mimu.simple.java.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 二叉树按层遍历
 * 使用队列让节点入队，
 */
public class LC102Test_TreeNode_LevelOrder extends LC_TreeNode {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);// 头结点入队
        while (!queue.isEmpty()) {// 队列非空则循环
            int levelSize = queue.size();// 每一层节点个数
            ArrayList<Integer> levelResult = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();// 弹出队列 中的节点 并添加到list中
                levelResult.add(poll.val);
                if (Objects.nonNull(poll.left)) { // 当前节点左子树非空则，左子树入队
                    queue.add(poll.left);
                }
                if (Objects.nonNull(poll.right)) { // 当前节点右子树非空则，右子树入队
                    queue.add(poll.right);
                }
            }
            result.add(levelResult); // 收集每一层的数据
        }
        return result;
    }


    @Test
    public void levelOrder() {

    }
}

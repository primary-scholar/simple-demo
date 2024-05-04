package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Given a binary tree, imagine yourself standing on the  right  side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * For example:
 * Given the following binary tree,
 * *
 * *       1            <---
 * *     /   \
 * *    2     3         <---
 * *     \     \
 * *      5     4       <---
 * *
 * You should return [1, 3, 4].
 * <p>
 * 这里 同样按照 二叉树的 按层访问思路，只不过 在进行结果收集的时候 只收集每层的 最后一个元素即可；
 */
public class LC_BinTreeNode_199_RightSideView extends LC_TreeNode {

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        LinkedList<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);  // 首先头节点入队
        while (!levelQueue.isEmpty()) {  // 先添加头结点，队列非空循环，初始队列一定非空，头结点为空的情况提前返回了
            ArrayList<Integer> level = new ArrayList<>();
            int size = levelQueue.size(); // 根据队列中元素的个数，即每层的元素个数 进行 循环
            for (int i = 0; i < size; i++) {
                TreeNode node = levelQueue.pop();
                level.add(node.val); //收集 每一层的数据节点
                if (Objects.nonNull(node.left)) { // 当前节点的左子树 节点入队
                    levelQueue.add(node.left);
                }
                if (Objects.nonNull(node.right)) { // 当前节点的右子树 节点入队
                    levelQueue.add(node.right);
                }
            }
            /**
             * 结果收集时 ，只收集 每层最后一个元素 ，因为是按照 左、右子树的顺序 入得队列，所以每层最后一个元素一定是 最右边的那个节点数据
             */
            result.add(level.get(level.size() - 1));
        }
        return result;
    }
}

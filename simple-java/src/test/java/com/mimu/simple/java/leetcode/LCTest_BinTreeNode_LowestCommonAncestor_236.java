package com.mimu.simple.java.leetcode;

/**
 * 二叉树节点p，q的公共祖先节点
 * 公共祖先的定义为：
 * 对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 * 根据以上定义，若 root 是 p,q 的 最近公共祖先 ，则只可能为以下情况之一：
 * <p>
 * 1.p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
 * 2.p=root，且 q 在 root 的左或右子树中；
 * 3.q=root，且 p 在 root 的左或右子树中；
 * 思路
 * 考虑通过递归对二叉树进行先序遍历，当遇到节点 p 或 q 时返回。从底至顶回溯，当节点 p,q 在节点 root 的异侧时，节点 root 即为最近公共祖先，则向上返回 root;
 */
public class LCTest_BinTreeNode_LowestCommonAncestor_236 extends LC_TreeNode {

    /**
     * 递归解析：
     * * 1.终止条件：
     * *   a.当越过叶节点，则直接返回 null ；
     * *   b.当 root 等于 p,q ，则直接返回 root ；
     * * 2.递推工作：
     * *   a.开启递归左子节点，返回值记为 left ；
     * *   b.开启递归右子节点，返回值记为 right ；
     * * 3.返回值： 根据 left 和 right ，可展开为四种情况；
     * *   a.当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
     * *   b.当 left 和 right 同时不为空 ：说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ； 这里符合定义 1
     * *   c.当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：                         这里符合定义 3
     * *     a.当 p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
     * *     b.当 p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
     * *   d.当left 不为空 ， right 为空 ：与情况 3. 同理；                                                                    这里符合定义 2
     * *
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 递归终止条件
         */
        if (root == null || root == p || root == q) {
            return root;
        }
        // 左右子树 分别递归 即为 left 和 right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /**
         * 下面是返回值判断
         */
        if (left == null && right == null) {
            return null; // 3.a
        }
        if (left == null) { // 3.c 定义 3 q=root，且 p 在 root 的左或右子树中；
            return right;
        }
        if (right == null) {// 3.d 定义2 p=root，且 q 在 root 的左或右子树中；
            return left;
        }
        return root; //3.b 定义 1 p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
    }
}

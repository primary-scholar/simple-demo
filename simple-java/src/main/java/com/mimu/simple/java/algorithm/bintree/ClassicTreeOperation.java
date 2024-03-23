package com.mimu.simple.java.algorithm.bintree;


import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 任何递归都可以 改成非递归的方式
 */
public class ClassicTreeOperation {

    /**
     * 递归序
     * ***************    A
     * **************  /     \
     * ************  /        \
     * ***********  B          C
     * *********  /  \         /
     * ********  /    \       /
     * ******   D     E      F
     * <p>
     * 按照下面的递归序 上面的二叉树 的访问过程为
     * A(1)-B(1)-D(1)-D(2)-D(3)-B(2)-E(1)-E(2)-E(3)-B(3)-A(2)-C(1)-F(1)-F(2)-F(3)-C(2)-C(3)-A(3)
     * 经过 下面的递归序后 没有节点都访问了 3 次
     * 先序：A(1)-B(1)-D(1)-E(1)-C(1)-F(1)
     * 中序：D(2)-B(2)-E(2)-A(2)-F(2)-C(2)
     * 后续：D(3)-E(3)-B(3)-F(3)-C(3)-A(3)
     * <p>
     * 这说明每一个节点都有机会先访问该节点-再访问其左子树节点后返回该节点-然后再访问其右子树后返回该节点
     * 这就可以利用数结构 做动态规划
     * <p>
     * 所以先序中序后序只是递归序中的一种结果
     *
     * @param treeNode
     */
    public void recurSeque(SimpleTreeNode<Integer> treeNode) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        // 节点1
        recurSeque(treeNode.getLeft());
        // 节点2
        recurSeque(treeNode.getRight());
        // 节点3
    }


    protected void print(SimpleTreeNode<Integer> treeNode) {
        if (Objects.nonNull(treeNode)) {
            System.out.print(treeNode.getData().toString());
            System.out.print(" ");
        }
    }

}

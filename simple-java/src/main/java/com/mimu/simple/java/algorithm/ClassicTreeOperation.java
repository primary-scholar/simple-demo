package com.mimu.simple.java.algorithm;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.jmx.RingBufferAdmin;

import java.sql.Statement;
import java.util.Objects;
import java.util.Stack;

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

    /**
     * 先序遍历 头-左-右
     *
     * @param treeNode
     */
    public void pre(SimpleTreeNode<Integer> treeNode) {
        print(treeNode);
        pre(treeNode.getLeft());
        pre(treeNode.getRight());
    }

    /**
     * 先序非递归
     * 1.出栈就打印
     * 2。如果有右孩子先入栈右孩子
     * 3。如果有左孩子入栈左孩子
     *
     * @param treeNode
     */
    public void preNonRecur(SimpleTreeNode<Integer> treeNode) {
        if (Objects.nonNull(treeNode)) {
            //先把根节点入栈
            Stack<SimpleTreeNode<Integer>> stack = new Stack<>();
            stack.push(treeNode);
            while (!stack.isEmpty()) {//栈非空
                SimpleTreeNode<Integer> node = stack.pop();
                print(node);//出栈并打印
                if (Objects.nonNull(node.getRight())) {
                    stack.push(node.getRight());//如果有右孩子，先入栈右孩子
                }
                if (Objects.nonNull(node.getLeft())) {
                    stack.push(node.getLeft());//如果右左孩子，入栈左孩子
                }
            }
        }
    }

    /**
     * 中序遍历 左-头-右
     *
     * @param treeNode
     */
    public void in(SimpleTreeNode<Integer> treeNode) {
        pre(treeNode.getLeft());
        print(treeNode);
        pre(treeNode.getRight());
    }

    /**
     * 1。整个数的左边界全部入栈-即根节点非空 则入栈 然后根节点向左孩子前移一直循环
     * 2。如果1无法继续执行，则弹出栈中的第一个节点并打印，然后向弹出节点的右孩子节点前移 继续执行1；
     *
     * @param treeNode
     */
    public void inNonRecur(SimpleTreeNode<Integer> treeNode) {
        if (Objects.nonNull(treeNode)) {
            Stack<SimpleTreeNode<Integer>> stack = new Stack<>();
            while (!stack.isEmpty() || Objects.nonNull(treeNode)) {//根节点非空
                if (Objects.nonNull(treeNode)) {//根节点非空
                    stack.push(treeNode);//根节点入栈
                    treeNode = treeNode.getLeft();//根节点向左孩子前移 直到根节点为空
                } else {//根节点为空了
                    treeNode = stack.pop();//出栈
                    print(treeNode);//并打印
                    treeNode = treeNode.getRight();//根节点向右孩子节点前移,继续在大循环中执行直到栈为空或者根节点为空
                }
            }
        }
    }

    /**
     * 后序遍历 左-右-头
     *
     * @param treeNode
     */
    public void pos(SimpleTreeNode<Integer> treeNode) {
        pre(treeNode.getLeft());
        pre(treeNode.getRight());
        print(treeNode);
    }

    /**
     * 后续 遍历非递归:先序遍历为 头-左-右，即出栈即打印，然后入栈右节点 在入栈左节点；
     * 如果依然保持先序的非递归序，只不过入栈时改成 先入左节点，再如有节点 则遍历序为 头-右-左
     * <p>
     * 而 头-右-左的逆序 即为 左-右-头 即为 后续遍历序
     * 因此可以可以根据 先序的整体序，进行调整后 放到一个栈中，等节点全部访问完毕后，在出栈打印即可
     *
     * @param treeNode
     */
    public void posNonRecur(SimpleTreeNode<Integer> treeNode) {
        if (Objects.nonNull(treeNode)) {
            //先把根节点入栈
            Stack<SimpleTreeNode<Integer>> stack = new Stack<>();//先序栈
            Stack<SimpleTreeNode<Integer>> help = new Stack<>();//辅助栈
            stack.push(treeNode);//先序栈入栈
            while (!stack.isEmpty()) {//栈非空
                SimpleTreeNode<Integer> node = stack.pop();
                help.push(node);//先序栈出栈放到 辅助栈中
                if (Objects.nonNull(node.getLeft())) {
                    stack.push(node.getLeft());//先入栈左孩子
                }
                if (Objects.nonNull(node.getRight())) {
                    stack.push(node.getRight());//在入栈右孩子
                }
            }
            //先序访问节点完毕后，辅助栈逐个出栈并打印即可
            while (!help.isEmpty()) {
                print(help.pop());
            }
        }
    }


    private void print(SimpleTreeNode<Integer> treeNode) {
        if (Objects.nonNull(treeNode)) {
            System.out.println(treeNode.getData());
        }
    }

    @Setter
    @Getter
    public static class SimpleTreeNode<T> {
        private T data;
        private SimpleTreeNode<T> left;
        private SimpleTreeNode<T> right;
    }
}

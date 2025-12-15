package com.mimu.simple.java.algorithm.bintree;

import java.util.*;

public class ClassicTreeVisitOperation extends ClassicTreeOperation {

    /**
     * 先序遍历 头-左-右
     *
     * @param treeNode
     */
    public void pre(CustomTreeNode<Integer> treeNode) {
        if (Objects.nonNull(treeNode)) {
            print(treeNode);
            pre(treeNode.getLeft());
            pre(treeNode.getRight());
        }
    }

    /**
     * 先序非递归
     * 1.出栈就打印
     * 2。如果有右孩子先入栈右孩子
     * 3。如果有左孩子入栈左孩子
     *
     * @param treeNode
     */
    public void preNonRecur(CustomTreeNode<Integer> treeNode) {
        if (Objects.nonNull(treeNode)) {
            //先把根节点入栈
            Stack<CustomTreeNode<Integer>> stack = new Stack<>();
            stack.push(treeNode);
            while (!stack.isEmpty()) {//栈非空
                CustomTreeNode<Integer> node = stack.pop();
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
    public void in(CustomTreeNode<Integer> treeNode) {
        if (Objects.nonNull(treeNode)) {
            in(treeNode.getLeft());
            print(treeNode);
            in(treeNode.getRight());
        }
    }

    /**
     * 1。整个树的左边界全部入栈-即根节点非空 则入栈 然后根节点向左孩子前移一直循环
     * 2。如果1无法继续执行，则弹出栈中的第一个节点并打印，然后向弹出节点的右孩子节点前移 继续执行1；
     *
     * @param treeNode
     */
    public void inNonRecur(CustomTreeNode<Integer> treeNode) {
        if (Objects.nonNull(treeNode)) {
            Stack<CustomTreeNode<Integer>> stack = new Stack<>();
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
    public void pos(CustomTreeNode<Integer> treeNode) {
        if (Objects.nonNull(treeNode)) {
            pos(treeNode.getLeft());
            pos(treeNode.getRight());
            print(treeNode);
        }
    }

    /**
     * 后续 遍历非递归:先序遍历为 头-左-右，即出栈即打印，然后入栈右节点 再入栈左节点；
     * 如果依然保持先序的非递归序，只不过入栈时改成 先入左节点，再入右节点 则遍历序为 头-右-左
     * <p>
     * 而 头-右-左的逆序 即为 左-右-头 即为 后续遍历序
     * 因此可以可以根据 先序的整体序，进行调整后 放到一个栈中，等节点全部访问完毕后，在出栈打印即可
     *
     * @param treeNode
     */
    public void posNonRecur(CustomTreeNode<Integer> treeNode) {
        if (Objects.nonNull(treeNode)) {
            //先把根节点入栈
            Stack<CustomTreeNode<Integer>> stack = new Stack<>();//先序栈
            Stack<CustomTreeNode<Integer>> help = new Stack<>();//辅助栈
            stack.push(treeNode);//先序栈入栈
            while (!stack.isEmpty()) {//栈非空
                CustomTreeNode<Integer> node = stack.pop();
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

    /**
     * 后续非递归遍历 另一个版本，这里只需一个临时辅助栈，这里和对比上一个非递归算法
     *
     * @param
     */
    public void posNoRecurAnother(CustomTreeNode<Integer> rootNode) {
        if (Objects.nonNull(rootNode)) {
            Stack<CustomTreeNode<Integer>> stack = new Stack<>();//辅助栈
            stack.push(rootNode);
            CustomTreeNode<Integer> currentNode;
            while (!stack.isEmpty()) {
                currentNode = stack.peek();
                if (currentNode.getLeft() != null && currentNode.getLeft() != rootNode && currentNode.getRight() != rootNode) {
                    stack.push(currentNode.getLeft());
                } else if (currentNode.getRight() != null && currentNode.getRight() != rootNode) {
                    stack.push(currentNode.getRight());
                } else {
                    print(stack.pop());
                    rootNode = currentNode;
                }
            }
        }
    }

    /**
     * 水平访问 - 按层打印
     * 首先把根节点入队
     * 对于队列中的任何一个节点，弹出并打印，同时只要该节点的左右子节点非空，就把该节点的左右子节点入队；
     * 队列非空 循环执行上一步操作
     *
     * @param treeNode
     */
    public void level(CustomTreeNode<Integer> treeNode) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        Queue<CustomTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(treeNode);//头结点入队
        while (!queue.isEmpty()) {//队列非空 循环
            CustomTreeNode<Integer> node = queue.poll();//弹出
            print(node);//并打印
            CustomTreeNode<Integer> left = node.getLeft();
            if (Objects.nonNull(left)) {//左子结点非空入队
                queue.add(left);
            }
            CustomTreeNode<Integer> right = node.getRight();
            if (Objects.nonNull(right)) {//右子节点非空入队
                queue.add(right);
            }
        }
    }

    /**
     * 二叉树的 最宽层
     *
     * @param treeNode
     */
    public Integer maxWidthUseMap(CustomTreeNode<Integer> treeNode) {
        if (Objects.isNull(treeNode)) {
            return 0;
        }
        Queue<CustomTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(treeNode);
        HashMap<CustomTreeNode<Integer>, Integer> levelMap = new HashMap<>();
        levelMap.put(treeNode, 1);
        int currLevel = 1, currLevelNodes = 0, max = 0;
        while (!queue.isEmpty()) {
            CustomTreeNode<Integer> curr = queue.poll();
            Integer currNodeLevel = levelMap.get(curr);
            CustomTreeNode<Integer> left = curr.getLeft();
            if (Objects.nonNull(left)) {
                levelMap.put(left, currNodeLevel + 1);
                queue.add(left);
            }
            CustomTreeNode<Integer> right = curr.getRight();
            if (Objects.nonNull(right)) {
                levelMap.put(right, currNodeLevel + 1);
                queue.add(right);
            }
            if (currLevel == currNodeLevel) {
                currLevelNodes++;
            } else {
                max = Math.max(max, currLevelNodes);
                currLevel++;
                currLevelNodes = 1;
            }
        }
        max = Math.max(max, currLevelNodes);
        return max;
    }

}

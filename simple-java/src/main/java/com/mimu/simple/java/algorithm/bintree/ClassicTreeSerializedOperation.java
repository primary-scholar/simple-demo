package com.mimu.simple.java.algorithm.bintree;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;


/**
 * 可以通过扩展的 二叉树的先序序列，和后续序列重新还原一颗二叉树，中序序列的不行；
 * <p>
 * 二叉树的序列化和反序列化-把内存中的二叉树 序列化到文件中
 * 1.可以使用先序，中序，后序或者按层遍历，来实现二叉树的序列化
 * <p>
 * <p>
 * <p>
 * 对于这两颗二叉树，不管哪种顺序，其打印的结构都是一样的，所以不能仅仅通过先序，中序，后续的节点的打印顺序来进行序列化
 * 我们需要把每颗树中的非空节点的左右子节点补齐；
 * ***        A                  A
 * ***       /                     \
 * ***      A                       A
 * ***       \                    /
 * ***        A                  A
 * 补齐数据如下
 * ***         A                 A
 * ***       /  \              /  \
 * ***      A   null        null   A
 * ***    /  \                   /   \
 * *** null   A                 A    null
 * ***      /  \              /  \
 * ***    null  null       null  null
 * <p>
 * 序列化时使用的是哪种顺序，反序列化时也要同样使用该顺序
 * 先序
 * 第一个棵树先序[A,A,null,A,null,null,null]
 * 第二个树先序[A,null,A,A,null,null,null]
 * 中序
 * 第一个棵树中序[null,A,null,A,null,A,null] 这里 两棵不同树的中序扩展遍历是一样的，
 * 第二个棵树中序[null,A,null,A,null,A,null] 所以通过中序扩展遍历序列无法重建一个二叉树
 * 后序 这里的顺序和先序的逆序是一样的，所以可以把先序中的队列换成堆栈，然后分别创建右子树，和左子树即可
 * 第一棵树后序序列[null,null,null,A,A,null,A]
 * 第二棵树后序序列[null,null,null,A,null,A,A]
 */

public class ClassicTreeSerializedOperation extends ClassicTreeOperation {

    /**
     * 先序序列化
     *
     * @param tree
     * @return
     */
    public Queue<Integer> preEncode(CustomTreeNode<Integer> tree) {
        LinkedList<Integer> queue = new LinkedList<>();
        preEncodeSer(tree, queue);
        return queue;
    }

    /**
     * 先序序列化 递归方法
     *
     * @param node
     * @param queue
     */
    private void preEncodeSer(CustomTreeNode<Integer> node, Queue<Integer> queue) {
        if (Objects.isNull(node)) {
            queue.add(null);
        } else {
            queue.add(node.getData());//第一个非空的节点必然是头结点
            preEncodeSer(node.getLeft(), queue);//后续的节点分别是 头结点的左子树
            preEncodeSer(node.getRight(), queue);//后续的节点分别是 头结点的右子树
        }
    }

    /**
     * 后续序列化
     *
     * @param tree
     * @return
     */
    public Queue<Integer> posEncode(CustomTreeNode<Integer> tree) {
        LinkedList<Integer> queue = new LinkedList<>();
        posEncodeSer(tree, queue);
        return queue;
    }

    /**
     * 后续序列化 递归算法
     *
     * @param node
     * @param queue
     */
    private void posEncodeSer(CustomTreeNode<Integer> node, Queue<Integer> queue) {
        if (Objects.isNull(node)) {
            queue.add(null);
        } else {
            posEncodeSer(node.getLeft(), queue);
            posEncodeSer(node.getRight(), queue);
            queue.add(node.getData());
        }
    }

    /**
     * 水平序列化
     *
     * @param treeNode
     */
    public Queue<Integer> levelEncode(CustomTreeNode<Integer> treeNode) {
        LinkedList<Integer> levelQueue = new LinkedList<>();
        if (Objects.isNull(treeNode)) {
            levelQueue.add(null);
        } else {
            levelQueue.add(treeNode.getData());
            Queue<CustomTreeNode<Integer>> queue = new LinkedList<>();
            queue.add(treeNode);//头结点入队
            while (!queue.isEmpty()) {//队列非空 循环
                CustomTreeNode<Integer> current = queue.poll();//弹出
                if (Objects.nonNull(current.getLeft())) {
                    levelQueue.add(current.getLeft().getData());
                    queue.add(current.getLeft());
                } else {
                    levelQueue.add(null);
                }
                if (Objects.nonNull(current.getRight())) {//左子结点非空入队
                    levelQueue.add(current.getRight().getData());
                    queue.add(current.getRight());
                } else {
                    levelQueue.add(null);
                }
            }
        }
        return levelQueue;
    }


    /**
     * 先序 反序列化
     *
     * @param queueTreeNode
     * @return
     */
    public CustomTreeNode<Integer> preDecode(Queue<Integer> queueTreeNode) {
        if (CollectionUtils.isEmpty(queueTreeNode)) {
            return null;
        }
        LinkedList<Integer> copy = new LinkedList<>(queueTreeNode);
        return preDecodeSer(copy);
    }

    /**
     * 先序 反序列化 递归方法
     *
     * @param queueTreeNode
     * @return
     */
    private CustomTreeNode<Integer> preDecodeSer(Queue<Integer> queueTreeNode) {
        Integer poll = queueTreeNode.poll();
        if (Objects.isNull(poll)) {
            return null;
        }
        CustomTreeNode<Integer> treeNode = new CustomTreeNode<>(poll);
        treeNode.setLeft(preDecodeSer(queueTreeNode));
        treeNode.setRight(preDecodeSer(queueTreeNode));
        return treeNode;
    }

    /**
     * 后序 反序列化
     *
     * @param queueTreeNode
     * @return
     */
    public CustomTreeNode<Integer> posDecode(Queue<Integer> queueTreeNode) {
        if (CollectionUtils.isEmpty(queueTreeNode)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        queueTreeNode.forEach(stack::push);
        return posDecodeSer(stack);
    }

    /**
     * 后序 反序列化 递归方法
     *
     * @param stackTreeNode
     * @return
     */
    private CustomTreeNode<Integer> posDecodeSer(Stack<Integer> stackTreeNode) {
        Integer pop = stackTreeNode.pop();
        if (Objects.isNull(pop)) {
            return null;
        }
        CustomTreeNode<Integer> treeNode = new CustomTreeNode<>(pop);
        treeNode.setRight(posDecodeSer(stackTreeNode));
        treeNode.setLeft(posDecodeSer(stackTreeNode));
        return treeNode;
    }

    /**
     * 水平反序列化
     *
     * @param levelQueue
     * @return
     */
    public CustomTreeNode<Integer> levelDecode(Queue<Integer> levelQueue) {
        if (CollectionUtils.isEmpty(levelQueue)) {
            return null;
        }
        CustomTreeNode<Integer> treeNode = createTreeNode(levelQueue.poll());
        Queue<CustomTreeNode<Integer>> queue = new LinkedList<>();
        if (Objects.nonNull(treeNode)) {
            queue.add(treeNode);//头结点入队
        }
        CustomTreeNode<Integer> current = null;
        while (!queue.isEmpty()) {//队列非空 循环
            current = queue.poll();//弹出
            current.setLeft(createTreeNode(levelQueue.poll()));
            current.setRight(createTreeNode(levelQueue.poll()));
            if (Objects.nonNull(current.getLeft())) {
                queue.add(current.getLeft());
            }
            if (Objects.nonNull(current.getRight())) {
                queue.add(current.getRight());
            }
        }
        return treeNode;
    }

    private CustomTreeNode<Integer> createTreeNode(Integer data) {
        if (Objects.isNull(data)) {
            return null;
        }
        return new CustomTreeNode<>(data);
    }

}

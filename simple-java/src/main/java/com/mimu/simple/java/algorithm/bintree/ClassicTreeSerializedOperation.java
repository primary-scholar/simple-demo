package com.mimu.simple.java.algorithm.bintree;

import org.apache.commons.collections4.CollectionUtils;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class ClassicTreeSerializedOperation extends ClassicTreeOperation {
    /**
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
     * 第一个棵树先序[A,A,null,A,null,null,null]
     * 第二个树先序[A,null,A,A,null,null,null]
     * <p>
     * 第一个棵树中序[null,A,null,A,null,A,null]
     * 第二个棵树中序[null,A,null,A,null,A,null]
     *
     * @param rootNode
     */
    public Queue<Integer> preEncode(SimpleTreeNode<Integer> rootNode) {
        LinkedList<Integer> queue = new LinkedList<>();
        preEncodeSer(rootNode, queue);
        return queue;
    }

    /**
     * 先序序列化 递归方法
     *
     * @param node
     * @param queue
     */
    private void preEncodeSer(SimpleTreeNode<Integer> node, Queue<Integer> queue) {
        if (Objects.isNull(node)) {
            queue.add(null);
        } else {
            queue.add(node.getData());
            preEncodeSer(node.getLeft(), queue);
            preEncodeSer(node.getRight(), queue);
        }
    }

    /**
     * 中序序列化
     *
     * @param rootNode
     * @return
     */
    public Queue<Integer> inEncode(SimpleTreeNode<Integer> rootNode) {
        LinkedList<Integer> queue = new LinkedList<>();
        inEncodeSer(rootNode, queue);
        return queue;
    }

    /**
     * 中序序列化 递归方法
     *
     * @param node
     * @param queue
     */
    private void inEncodeSer(SimpleTreeNode<Integer> node, Queue<Integer> queue) {
        if (Objects.isNull(node)) {
            queue.add(null);
        } else {
            inEncodeSer(node.getLeft(), queue);
            queue.add(node.getData());
            inEncodeSer(node.getRight(), queue);
        }
    }

    /**
     * 反序列化
     *
     * @param queueTreeNode
     * @return
     */
    public SimpleTreeNode<Integer> preDecode(Queue<Integer> queueTreeNode) {
        if (CollectionUtils.isEmpty(queueTreeNode)) {
            return null;
        }
        return preDecodeSer(queueTreeNode);
    }

    /**
     * 递归方法
     *
     * @param queueTreeNode
     * @return
     */
    private SimpleTreeNode<Integer> preDecodeSer(Queue<Integer> queueTreeNode) {
        Integer poll = queueTreeNode.poll();
        if (Objects.isNull(poll)) {
            return null;
        }
        SimpleTreeNode<Integer> treeNode = new SimpleTreeNode<>(poll);
        treeNode.setLeft(preDecodeSer(queueTreeNode));
        treeNode.setRight(preDecodeSer(queueTreeNode));
        return treeNode;
    }

    /**
     * 反序列化
     *
     * @param queueTreeNode
     * @return
     */
    public SimpleTreeNode<Integer> inDecode(Queue<Integer> queueTreeNode) {
        if (CollectionUtils.isEmpty(queueTreeNode)) {
            return null;
        }
        return inDecodeSer(queueTreeNode);
    }

    /**
     * 递归方法
     *
     * @param queueTreeNode
     * @return
     */
    private SimpleTreeNode<Integer> inDecodeSer(Queue<Integer> queueTreeNode) {
        Integer poll = queueTreeNode.poll();
        if (Objects.isNull(poll)) {
            return null;
        }
        SimpleTreeNode<Integer> treeNode = new SimpleTreeNode<>(poll);
        treeNode.setLeft(preDecodeSer(queueTreeNode));
        treeNode.setRight(preDecodeSer(queueTreeNode));
        return treeNode;
    }

}

package com.mimu.simple.java.algorithm.bintree;

import java.util.LinkedList;
import java.util.Queue;


public class ClassicTreeOperationTest {

    /**
     * **                   1
     * **                /      \
     * **               3         5
     * **             /   \     /   \
     * **           7   null  null   9
     * **         /   \             /  \
     * **        2      4          6   null
     * **      /  \    /  \       /  \
     * **   null   8 null null  null  10
     * **        /  \                /  \
     * **      null null           null null
     * **
     *
     * @return
     */
    public Queue<Integer> initSimpleTree() {
        LinkedList<Integer> queueTreeNode = new LinkedList<>();
        queueTreeNode.add(1);
        queueTreeNode.add(3);
        queueTreeNode.add(7);
        queueTreeNode.add(2);
        queueTreeNode.add(null);
        queueTreeNode.add(8);
        queueTreeNode.add(null);
        queueTreeNode.add(null);
        queueTreeNode.add(4);
        queueTreeNode.add(null);
        queueTreeNode.add(null);
        queueTreeNode.add(null);
        queueTreeNode.add(5);
        queueTreeNode.add(null);
        queueTreeNode.add(9);
        queueTreeNode.add(6);
        queueTreeNode.add(null);
        queueTreeNode.add(10);
        queueTreeNode.add(null);
        queueTreeNode.add(null);
        queueTreeNode.add(null);
        return queueTreeNode;
    }


}
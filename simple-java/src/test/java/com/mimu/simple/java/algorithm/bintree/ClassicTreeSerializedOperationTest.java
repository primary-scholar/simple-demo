package com.mimu.simple.java.algorithm.bintree;

import org.junit.Test;

import java.util.Queue;


public class ClassicTreeSerializedOperationTest extends ClassicTreeOperationTest {

    ClassicTreeVisitOperation visitOperation = new ClassicTreeVisitOperation();
    ClassicTreeSerializedOperation serializedOperation = new ClassicTreeSerializedOperation();


    @Test
    public void pre() {
        Queue<Integer> queueFirst = initSimpleTree();
        CustomTreeNode<Integer> tree = serializedOperation.preDecode(queueFirst);
        visitOperation.level(tree);

        Queue<Integer> preEnTreeFirstQueue = serializedOperation.preEncode(tree);
        assert queueFirst.equals(preEnTreeFirstQueue);
    }

    @Test
    public void pos() {
        Queue<Integer> queueFirst = initSimpleTree();
        CustomTreeNode<Integer> tree = serializedOperation.preDecode(queueFirst);
        visitOperation.level(tree);

        Queue<Integer> inEnTreeSecondQueue = serializedOperation.posEncode(tree);
        CustomTreeNode<Integer> dTreeSecond = serializedOperation.posDecode(inEnTreeSecondQueue);
        Queue<Integer> inEnTreeSecondQueueAgain = serializedOperation.posEncode(dTreeSecond);
        assert inEnTreeSecondQueue.equals(inEnTreeSecondQueueAgain);
    }

    @Test
    public void level() {
        Queue<Integer> queueFirst = initSimpleTree();
        CustomTreeNode<Integer> tree = serializedOperation.preDecode(queueFirst);
        visitOperation.level(tree);

        Queue<Integer> levelEncode = serializedOperation.levelEncode(tree);
        CustomTreeNode<Integer> treeNode = serializedOperation.levelDecode(levelEncode);
        visitOperation.level(treeNode);
    }
}
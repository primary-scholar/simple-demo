package com.mimu.simple.java.algorithm.bintree;

import org.junit.Test;

import java.util.Queue;

public class ClassicTreeVisitOperationTest extends ClassicTreeOperationTest {

    ClassicTreeVisitOperation visitOperation = new ClassicTreeVisitOperation();
    ClassicTreeSerializedOperation serializedOperation = new ClassicTreeSerializedOperation();

    @Test
    public void buildTree() {
        Queue<Integer> treeQueue = initSimpleTree();
        SimpleTreeNode<Integer> serTree = serializedOperation.preDecode(treeQueue);
        visitOperation.pre(serTree);
        System.out.println();
        visitOperation.level(serTree);
    }
}
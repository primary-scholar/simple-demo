package com.mimu.simple.java.algorithm.bintree;

import org.junit.Test;

import java.util.Queue;

public class ClassicTreeVisitOperationTest extends ClassicTreeOperationTest {

    ClassicTreeVisitOperation visitOperation = new ClassicTreeVisitOperation();
    ClassicTreeSerializedOperation serializedOperation = new ClassicTreeSerializedOperation();

    @Test
    public void visitTree() {
        Queue<Integer> treeQueue = initSimpleTree();
        SimpleTreeNode<Integer> serTree = serializedOperation.preDecode(treeQueue);
        visitOperation.pre(serTree);
        System.out.print(" ");
        visitOperation.preNonRecur(serTree);
        System.out.println();
        visitOperation.in(serTree);
        System.out.print(" ");
        visitOperation.inNonRecur(serTree);
        System.out.println();
        visitOperation.pos(serTree);
        System.out.print(" ");
        visitOperation.posNonRecur(serTree);
        System.out.println();
        visitOperation.level(serTree);
        System.out.println();
    }
}
package com.mimu.simple.java.algorithm.linkstackqueue.link;

import org.junit.Test;

public class ClassicSlowFastNodeOperationTest extends NodeTest {

    ClassicSlowFastNodeOperation operation = new ClassicSlowFastNodeOperation();

    @Test
    public void midOrUpMidNode() {
        for (int i = 0; i < loop; i++) {
            CustomSingleNode<Integer> nodeLink = initSingleNodeLink();
            CustomSingleNode<Integer> customSingleNode = operation.midOrUpMidNodeAnother(nodeLink);
            CustomSingleNode<Integer> midNode = operation.midOrUpMidNode(nodeLink);
            assert customSingleNode.equals(midNode);
        }
    }

    @Test
    public void midOrDownMidNode() {
        for (int i = 0; i < loop; i++) {
            CustomSingleNode<Integer> nodeLink = initSingleNodeLink();
            CustomSingleNode<Integer> customSingleNode = operation.midOrDownMidNodeAnother(nodeLink);
            CustomSingleNode<Integer> midNode = operation.midOrDownMidNode(nodeLink);
            assert customSingleNode.equals(midNode);
        }
    }

    @Test
    public void midOrUpMidPreNode() {
        for (int i = 0; i < loop; i++) {
            CustomSingleNode<Integer> nodeLink = initSingleNodeLink();
            CustomSingleNode<Integer> customSingleNode = operation.midOrUpMidPrNodeAnother(nodeLink);
            CustomSingleNode<Integer> midPrNode = operation.midOrUpMidPrNode(nodeLink);
            assert customSingleNode.equals(midPrNode);
        }
    }

    @Test
    public void midOrDownMidPreNode() {
        for (int i = 0; i < loop; i++) {
            CustomSingleNode<Integer> nodeLink = initSingleNodeLink();
            CustomSingleNode<Integer> customSingleNode = operation.midOrDownMidPreNodeAnother(nodeLink);
            CustomSingleNode<Integer> midPreNode = operation.midOrDownMidPreNode(nodeLink);
            assert customSingleNode.equals(midPreNode);
        }
    }
}

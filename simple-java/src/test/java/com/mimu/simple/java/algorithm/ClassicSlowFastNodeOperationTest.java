package com.mimu.simple.java.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassicSlowFastNodeOperationTest extends NodeTest {

    ClassicSlowFastNodeOperation operation = new ClassicSlowFastNodeOperation();

    @Test
    public void midOrUpMidNode() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> nodeLink = initSingleNodeLink();
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> singleNode = operation.midOrUpMidNodeAnother(nodeLink);
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> midNode = operation.midOrUpMidNode(nodeLink);
            assert singleNode.equals(midNode);
        }
    }

    @Test
    public void midOrDownMidNode() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> nodeLink = initSingleNodeLink();
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> singleNode = operation.midOrDownMidNodeAnother(nodeLink);
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> midNode = operation.midOrDownMidNode(nodeLink);
            assert singleNode.equals(midNode);
        }
    }

    @Test
    public void midOrUpMidPreNode() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> nodeLink = initSingleNodeLink();
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> singleNode = operation.midOrUpMidPrNodeAnother(nodeLink);
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> midPrNode = operation.midOrUpMidPrNode(nodeLink);
            assert singleNode.equals(midPrNode);
        }
    }

    @Test
    public void midOrDownMidPreNode() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> nodeLink = initSingleNodeLink();
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> singleNode = operation.midOrDownMidPreNodeAnother(nodeLink);
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> midPreNode = operation.midOrDownMidPreNode(nodeLink);
            assert singleNode.equals(midPreNode);
        }
    }
}
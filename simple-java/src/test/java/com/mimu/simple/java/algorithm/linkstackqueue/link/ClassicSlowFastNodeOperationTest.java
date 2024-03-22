package com.mimu.simple.java.algorithm.linkstackqueue.link;

import org.junit.Test;

public class ClassicSlowFastNodeOperationTest extends NodeTest {

    ClassicSlowFastNodeOperation operation = new ClassicSlowFastNodeOperation();

    @Test
    public void midOrUpMidNode() {
        for (int i = 0; i < loop; i++) {
            SingleNode<Integer> nodeLink = initSingleNodeLink();
            SingleNode<Integer> singleNode = operation.midOrUpMidNodeAnother(nodeLink);
            SingleNode<Integer> midNode = operation.midOrUpMidNode(nodeLink);
            assert singleNode.equals(midNode);
        }
    }

    @Test
    public void midOrDownMidNode() {
        for (int i = 0; i < loop; i++) {
            SingleNode<Integer> nodeLink = initSingleNodeLink();
            SingleNode<Integer> singleNode = operation.midOrDownMidNodeAnother(nodeLink);
            SingleNode<Integer> midNode = operation.midOrDownMidNode(nodeLink);
            assert singleNode.equals(midNode);
        }
    }

    @Test
    public void midOrUpMidPreNode() {
        for (int i = 0; i < loop; i++) {
            SingleNode<Integer> nodeLink = initSingleNodeLink();
            SingleNode<Integer> singleNode = operation.midOrUpMidPrNodeAnother(nodeLink);
            SingleNode<Integer> midPrNode = operation.midOrUpMidPrNode(nodeLink);
            assert singleNode.equals(midPrNode);
        }
    }

    @Test
    public void midOrDownMidPreNode() {
        for (int i = 0; i < loop; i++) {
            SingleNode<Integer> nodeLink = initSingleNodeLink();
            SingleNode<Integer> singleNode = operation.midOrDownMidPreNodeAnother(nodeLink);
            SingleNode<Integer> midPreNode = operation.midOrDownMidPreNode(nodeLink);
            assert singleNode.equals(midPreNode);
        }
    }
}

package com.mimu.simple.java.algorithm.linkstackqueue.link;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassLinkNodeDoublePointOperationTest extends NodeTest {

    ClassLinkNodeDoublePointOperation operation = new ClassLinkNodeDoublePointOperation();

    @Test
    public void getKthFromEnd() {
        CustomSingleNode<Integer> nodeLink = initSingleNodeLink();
        printSingleNodeLink(nodeLink);
        int min = Math.min(4, nodeLinkLength);
        CustomSingleNode<Integer> kthFromEnd = operation.getKthFromEnd(nodeLink, min);
        System.out.println(min);
        printSingleNodeLink(kthFromEnd);
    }
}
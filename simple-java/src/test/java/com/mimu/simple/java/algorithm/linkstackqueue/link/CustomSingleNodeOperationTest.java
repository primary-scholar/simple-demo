package com.mimu.simple.java.algorithm.linkstackqueue.link;

import org.junit.Test;

public class CustomSingleNodeOperationTest extends NodeTest {
    SingleNodeOperation<Integer> singleNodeOperation = new SingleNodeOperation<>();

    @Test
    public void revertSingleNodeListTest() {
        for (int i = 0; i < loop; i++) {
            CustomSingleNode<Integer> head = initSingleNodeLink();
            CustomSingleNode<Integer> origin = singleNodeOperation.revertSingleNodeList(singleNodeOperation.revertSingleNodeList(head));
            if (!dataToStringWithSingleNodeList(head).equals(dataToStringWithSingleNodeList(origin))) {
                printSingleNodeLink(head);
                return;
            }
        }

    }

    @Test
    public void deleteSingleNodeList() {
        for (int i = 0; i < loop; i++) {
            CustomSingleNode<Integer> head = initSingleNodeLink();
            int data = (int) (Math.random() * 100);
            CustomSingleNode<Integer> customSingleNode = singleNodeOperation.deleteSingleNodeList(head, data);
            Integer singleNodeNum = countSingleNodeNum(customSingleNode);
            CustomSingleNode<Integer> revertCustomSingleNode = singleNodeOperation.revertSingleNodeList(customSingleNode);
            Integer revertSingleNodeNum = countSingleNodeNum(revertCustomSingleNode);
            if (isExistDataInSingleNodeList(customSingleNode, data) || !singleNodeNum.equals(revertSingleNodeNum)) {
                printSingleNodeLink(customSingleNode);
                System.out.println(data);
                return;
            }
        }
    }
}

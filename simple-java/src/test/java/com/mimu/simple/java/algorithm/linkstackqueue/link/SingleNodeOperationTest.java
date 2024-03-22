package com.mimu.simple.java.algorithm.linkstackqueue.link;

import org.junit.Test;

public class SingleNodeOperationTest extends NodeTest {
    SingleNodeOperation<Integer> singleNodeOperation = new SingleNodeOperation<>();

    @Test
    public void revertSingleNodeListTest() {
        for (int i = 0; i < loop; i++) {
            SingleNode<Integer> head = initSingleNodeLink();
            SingleNode<Integer> origin = singleNodeOperation.revertSingleNodeList(singleNodeOperation.revertSingleNodeList(head));
            if (!dataToStringWithSingleNodeList(head).equals(dataToStringWithSingleNodeList(origin))) {
                printSingleNodeLink(head);
                return;
            }
        }

    }

    @Test
    public void deleteSingleNodeList() {
        for (int i = 0; i < loop; i++) {
            SingleNode<Integer> head = initSingleNodeLink();
            int data = (int) (Math.random() * 100);
            SingleNode<Integer> singleNode = singleNodeOperation.deleteSingleNodeList(head, data);
            Integer singleNodeNum = countSingleNodeNum(singleNode);
            SingleNode<Integer> revertSingleNode = singleNodeOperation.revertSingleNodeList(singleNode);
            Integer revertSingleNodeNum = countSingleNodeNum(revertSingleNode);
            if (isExistDataInSingleNodeList(singleNode, data) || !singleNodeNum.equals(revertSingleNodeNum)) {
                printSingleNodeLink(singleNode);
                System.out.println(data);
                return;
            }
        }
    }
}

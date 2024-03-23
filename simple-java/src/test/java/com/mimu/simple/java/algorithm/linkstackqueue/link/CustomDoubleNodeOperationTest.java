package com.mimu.simple.java.algorithm.linkstackqueue.link;

import org.junit.Test;

public class CustomDoubleNodeOperationTest extends NodeTest {
    DoubleNodeOperation<Integer> doubleNodeOperation = new DoubleNodeOperation<>();

    @Test
    public void revertDoubleNodeListTest() {
        for (int i = 0; i < loop; i++) {
            CustomDoubleNode<Integer> head = initDoubleNodeList();
            CustomDoubleNode<Integer> origin = doubleNodeOperation.revertDoubleNodeList(doubleNodeOperation.revertDoubleNodeList(head));
            if (!dataToStringWithDoubleNodeList(head).equals(dataToStringWithDoubleNodeList(origin))) {
                printDoubleNodeList(head);
                return;
            }
        }
    }

    @Test
    public void deleteDoubleNodeList() {
        for (int i = 0; i < loop; i++) {
            CustomDoubleNode<Integer> head = initDoubleNodeList();
            int data = (int) (Math.random() * 100);
            CustomDoubleNode<Integer> customDoubleNode = doubleNodeOperation.deleteDoubleNodeLink(head, data);
            Integer doubleNodeNum = countDoubleNodeNum(customDoubleNode);
            CustomDoubleNode<Integer> revertCustomDoubleNode = doubleNodeOperation.revertDoubleNodeList(customDoubleNode);
            Integer revertDoubleNodeNum = countDoubleNodeNum(revertCustomDoubleNode);
            if (isExistDataInDoubleNodeList(customDoubleNode, data) || !doubleNodeNum.equals(revertDoubleNodeNum)) {
                printDoubleNodeList(customDoubleNode);
                System.out.println(data);
                return;
            }
        }
    }
}

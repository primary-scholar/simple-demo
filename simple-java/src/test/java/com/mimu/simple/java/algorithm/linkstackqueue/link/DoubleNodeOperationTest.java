package com.mimu.simple.java.algorithm.linkstackqueue.link;

import org.junit.Test;

public class DoubleNodeOperationTest extends NodeTest {
    DoubleNodeOperation<Integer> doubleNodeOperation = new DoubleNodeOperation<>();

    @Test
    public void revertDoubleNodeListTest() {
        for (int i = 0; i < loop; i++) {
            DoubleNode<Integer> head = initDoubleNodeList();
            DoubleNode<Integer> origin = doubleNodeOperation.revertDoubleNodeList(doubleNodeOperation.revertDoubleNodeList(head));
            if (!dataToStringWithDoubleNodeList(head).equals(dataToStringWithDoubleNodeList(origin))) {
                printDoubleNodeList(head);
                return;
            }
        }
    }

    @Test
    public void deleteDoubleNodeList() {
        for (int i = 0; i < loop; i++) {
            DoubleNode<Integer> head = initDoubleNodeList();
            int data = (int) (Math.random() * 100);
            DoubleNode<Integer> doubleNode = doubleNodeOperation.deleteDoubleNodeLink(head, data);
            Integer doubleNodeNum = countDoubleNodeNum(doubleNode);
            DoubleNode<Integer> revertDoubleNode = doubleNodeOperation.revertDoubleNodeList(doubleNode);
            Integer revertDoubleNodeNum = countDoubleNodeNum(revertDoubleNode);
            if (isExistDataInDoubleNodeList(doubleNode, data) || !doubleNodeNum.equals(revertDoubleNodeNum)) {
                printDoubleNodeList(doubleNode);
                System.out.println(data);
                return;
            }
        }
    }
}

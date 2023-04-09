package com.mimu.simple.java.algorithm;

import org.junit.Test;

import java.util.Objects;


public class ClassicNodeOperationTest extends NodeTest {
    ClassicNodeOperation.SingleNodeOP<Integer> singleNodeOP = new ClassicNodeOperation.SingleNodeOP<>();

    ClassicNodeOperation.DoubleNodeOP<Integer> doubleNodeOP = new ClassicNodeOperation.DoubleNodeOP<>();


    @Test
    public void revertSingleNodeListTest() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> head = initSingleNodeLink();
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> origin = singleNodeOP.revertSingleNodeList(singleNodeOP.revertSingleNodeList(head));
            if (!dataToStringWithSingleNodeList(head).equals(dataToStringWithSingleNodeList(origin))) {
                printSingleNodeLink(head);
                return;
            }
        }

    }

    @Test
    public void deleteSingleNodeList() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> head = initSingleNodeLink();
            int data = (int) (Math.random() * 100);
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> singleNode = singleNodeOP.deleteSingleNodeList(head, data);
            Integer singleNodeNum = countSingleNodeNum(singleNode);
            ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> revertSingleNode = singleNodeOP.revertSingleNodeList(singleNode);
            Integer revertSingleNodeNum = countSingleNodeNum(revertSingleNode);
            if (isExistDataInSingleNodeList(singleNode, data) || !singleNodeNum.equals(revertSingleNodeNum)) {
                printSingleNodeLink(singleNode);
                System.out.println(data);
                return;
            }
        }
    }

    @Test
    public void revertDoubleNodeListTest() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> head = initDoubleNodeList();
            ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> origin = doubleNodeOP.revertDoubleNodeList(doubleNodeOP.revertDoubleNodeList(head));
            if (!dataToStringWithDoubleNodeList(head).equals(dataToStringWithDoubleNodeList(origin))) {
                printDoubleNodeList(head);
                return;
            }
        }
    }

    @Test
    public void deleteDoubleNodeList() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> head = initDoubleNodeList();
            int data = (int) (Math.random() * 100);
            ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> doubleNode = doubleNodeOP.deleteDoubleNodeLink(head, data);
            Integer doubleNodeNum = countDoubleNodeNum(doubleNode);
            ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> revertDoubleNode = doubleNodeOP.revertDoubleNodeList(doubleNode);
            Integer revertDoubleNodeNum = countDoubleNodeNum(revertDoubleNode);
            if (isExistDataInDoubleNodeList(doubleNode, data) || !doubleNodeNum.equals(revertDoubleNodeNum)) {
                printDoubleNodeList(doubleNode);
                System.out.println(data);
                return;
            }
        }
    }
}
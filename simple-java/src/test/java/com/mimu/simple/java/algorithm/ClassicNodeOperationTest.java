package com.mimu.simple.java.algorithm;

import org.junit.Test;

import java.util.Objects;


public class ClassicNodeOperationTest {
    public int loop = (int) (Math.random() * 99999) + 1;
    public int nodeLinkLength = (int) (Math.random() * 20);
    ClassicNodeOperation.SingleNodeOP<Integer> singleNodeOP = new ClassicNodeOperation.SingleNodeOP<>();

    ClassicNodeOperation.DoubleNodeOP<Integer> doubleNodeOP = new ClassicNodeOperation.DoubleNodeOP<>();

    public ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> initSingleNodeLink() {
        ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> head = null;
        ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new ClassicNodeOperation.SingleNodeOP.SingleNode<>((int) (Math.random() * 100));
                head.setNext(null);
                curr = head;
            } else {
                ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> element = new ClassicNodeOperation.SingleNodeOP.SingleNode<>((int) (Math.random() * 100));
                element.setNext(null);
                curr.setNext(element);
                curr = element;
            }
        }
        return head;
    }

    public void printSingleNodeLink(ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> head) {
        ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    public Boolean isExistDataInSingleNodeList(ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> head, Integer data) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> curr = head;
        while (Objects.nonNull(curr) && !curr.getData().equals(data)) {
            curr = curr.getNext();
        }
        return Objects.nonNull(curr) ? Boolean.TRUE : Boolean.FALSE;
    }

    public Integer countSingleNodeNum(ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> head) {
        int num = 0;
        if (Objects.isNull(head)) {
            return num;
        }
        ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            curr = curr.getNext();
            num++;
        }
        return num;
    }

    public String dataToStringWithSingleNodeList(ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> head) {
        ClassicNodeOperation.SingleNodeOP.SingleNode<Integer> curr = head;
        StringBuilder builder = new StringBuilder();
        while (Objects.nonNull(curr)) {
            builder.append(curr.getData());
            curr = curr.getNext();
        }
        return builder.toString();
    }

    public ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> initDoubleNodeList() {
        ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> head = null;
        ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new ClassicNodeOperation.DoubleNodeOP.DoubleNode<>((int) (Math.random() * 100));
                head.setPre(null);
                head.setNext(null);
                curr = head;
            } else {
                ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> element = new ClassicNodeOperation.DoubleNodeOP.DoubleNode<>((int) (Math.random() * 100));
                curr.setNext(element);
                element.setPre(curr);
                element.setNext(null);
                curr = element;
            }
        }
        return curr;
    }

    private void printDoubleNodeList(ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> head) {
        ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    public Boolean isExistDataInDoubleNodeList(ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> head, Integer data) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> curr = head;
        while (Objects.nonNull(curr) && !curr.getData().equals(data)) {
            curr = curr.getNext();
        }
        return Objects.nonNull(curr) ? Boolean.TRUE : Boolean.FALSE;
    }

    public String dataToStringWithDoubleNodeList(ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> head) {
        ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> curr = head;
        StringBuilder builder = new StringBuilder();
        while (Objects.nonNull(curr)) {
            builder.append(curr.getData());
            curr = curr.getNext();
        }
        return builder.toString();
    }

    public Integer countDoubleNodeNum(ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> head) {
        int num = 0;
        if (Objects.isNull(head)) {
            return num;
        }
        ClassicNodeOperation.DoubleNodeOP.DoubleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            curr = curr.getNext();
            num++;
        }
        return num;
    }

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
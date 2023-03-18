package com.mimu.simple.java.algorithm;

import org.junit.Test;

import java.util.Objects;


public class ClassicNodeRelevantTest {
    public int loop = (int) (Math.random() * 99999) + 1;
    public int nodeLinkLength = (int) (Math.random() * 20);
    ClassicNodeRelevant nodeRelevant = new ClassicNodeRelevant();

    public ClassicNodeRelevant.SingleNode<Integer> initSingleNodeLink() {
        ClassicNodeRelevant.SingleNode<Integer> head = null;
        ClassicNodeRelevant.SingleNode<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new ClassicNodeRelevant.SingleNode<>((int) (Math.random() * 100));
                head.setNext(null);
                curr = head;
            } else {
                ClassicNodeRelevant.SingleNode<Integer> element = new ClassicNodeRelevant.SingleNode<>((int) (Math.random() * 100));
                element.setNext(null);
                curr.setNext(element);
                curr = element;
            }
        }
        return head;
    }

    public ClassicNodeRelevant.DoubleNode<Integer> initDoubleNodeList() {
        ClassicNodeRelevant.DoubleNode<Integer> head = null;
        ClassicNodeRelevant.DoubleNode<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new ClassicNodeRelevant.DoubleNode<>((int) (Math.random() * 100));
                head.setPre(null);
                head.setNext(null);
                curr = head;
            } else {
                ClassicNodeRelevant.DoubleNode<Integer> element = new ClassicNodeRelevant.DoubleNode<>((int) (Math.random() * 100));
                curr.setNext(element);
                element.setPre(curr);
                element.setNext(null);
                curr = element;
            }
        }
        return curr;
    }


    public void printSingleNodeLink(ClassicNodeRelevant.SingleNode<Integer> head) {
        ClassicNodeRelevant.SingleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    private void printDoubleNodeList(ClassicNodeRelevant.DoubleNode<Integer> head) {
        ClassicNodeRelevant.DoubleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    public Boolean isExistDataInSingleNodeList(ClassicNodeRelevant.SingleNode<Integer> head, Integer data) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        ClassicNodeRelevant.SingleNode<Integer> curr = head;
        while (Objects.nonNull(curr) && !curr.getData().equals(data)) {
            curr = curr.getNext();
        }
        return Objects.nonNull(curr) ? Boolean.TRUE : Boolean.FALSE;
    }

    public Boolean isExistDataInDoubleNodeList(ClassicNodeRelevant.DoubleNode<Integer> head, Integer data) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        ClassicNodeRelevant.DoubleNode<Integer> curr = head;
        while (Objects.nonNull(curr) && !curr.getData().equals(data)) {
            curr = curr.getNext();
        }
        return Objects.nonNull(curr) ? Boolean.TRUE : Boolean.FALSE;
    }

    public String dataToStringWithSingleNodeList(ClassicNodeRelevant.SingleNode<Integer> head) {
        ClassicNodeRelevant.SingleNode<Integer> curr = head;
        StringBuilder builder = new StringBuilder();
        while (Objects.nonNull(curr)) {
            builder.append(curr.getData());
            curr = curr.getNext();
        }
        return builder.toString();
    }

    public String dataToStringWithDoubleNodeList(ClassicNodeRelevant.DoubleNode<Integer> head) {
        ClassicNodeRelevant.DoubleNode<Integer> curr = head;
        StringBuilder builder = new StringBuilder();
        while (Objects.nonNull(curr)) {
            builder.append(curr.getData());
            curr = curr.getNext();
        }
        return builder.toString();
    }

    public Integer countSingleNodeNum(ClassicNodeRelevant.SingleNode<Integer> head) {
        int num = 0;
        if (Objects.isNull(head)) {
            return num;
        }
        ClassicNodeRelevant.SingleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            curr = curr.getNext();
            num++;
        }
        return num;
    }

    public Integer countDoubleNodeNum(ClassicNodeRelevant.DoubleNode<Integer> head) {
        int num = 0;
        if (Objects.isNull(head)) {
            return num;
        }
        ClassicNodeRelevant.DoubleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            curr = curr.getNext();
            num++;
        }
        return num;
    }


    @Test
    public void revertSingleNodeListTest() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.SingleNode<Integer> head = initSingleNodeLink();
            ClassicNodeRelevant.SingleNode<Integer> origin = nodeRelevant.revertSingleNodeList(nodeRelevant.revertSingleNodeList(head));
            if (!dataToStringWithSingleNodeList(head).equals(dataToStringWithSingleNodeList(origin))) {
                printSingleNodeLink(head);
                return;
            }
        }

    }

    @Test
    public void revertDoubleNodeListTest() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.DoubleNode<Integer> head = initDoubleNodeList();
            ClassicNodeRelevant.DoubleNode<Integer> origin = nodeRelevant.revertDoubleNodeList(nodeRelevant.revertDoubleNodeList(head));
            if (!dataToStringWithDoubleNodeList(head).equals(dataToStringWithDoubleNodeList(origin))) {
                printDoubleNodeList(head);
                return;
            }
        }
    }

    @Test
    public void deleteSingleNodeList() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.SingleNode<Integer> head = initSingleNodeLink();
            int data = (int) (Math.random() * 100);
            ClassicNodeRelevant.SingleNode<Integer> singleNode = nodeRelevant.deleteSingleNodeList(head, data);
            Integer singleNodeNum = countSingleNodeNum(singleNode);
            ClassicNodeRelevant.SingleNode<Integer> revertSingleNode = nodeRelevant.revertSingleNodeList(singleNode);
            Integer revertSingleNodeNum = countSingleNodeNum(revertSingleNode);
            if (isExistDataInSingleNodeList(singleNode, data) || !singleNodeNum.equals(revertSingleNodeNum)) {
                printSingleNodeLink(singleNode);
                System.out.println(data);
                return;
            }
        }
    }

    @Test
    public void deleteDoubleNodeList() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.DoubleNode<Integer> head = initDoubleNodeList();
            int data = (int) (Math.random() * 100);
            ClassicNodeRelevant.DoubleNode<Integer> doubleNode = nodeRelevant.deleteDoubleNodeLink(head, data);
            Integer doubleNodeNum = countDoubleNodeNum(doubleNode);
            ClassicNodeRelevant.DoubleNode<Integer> revertDoubleNode = nodeRelevant.revertDoubleNodeList(doubleNode);
            Integer revertDoubleNodeNum = countDoubleNodeNum(revertDoubleNode);
            if (isExistDataInDoubleNodeList(doubleNode, data) || !doubleNodeNum.equals(revertDoubleNodeNum)) {
                printDoubleNodeList(doubleNode);
                System.out.println(data);
                return;
            }
        }
    }
}
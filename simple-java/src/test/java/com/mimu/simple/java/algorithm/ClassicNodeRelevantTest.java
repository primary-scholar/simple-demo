package com.mimu.simple.java.algorithm;

import org.junit.Test;

import java.util.Objects;


public class ClassicNodeRelevantTest {
    public int loop = (int) (Math.random() * 99999) + 1;
    public int nodeLinkLength = (int) (Math.random() * 20);
    ClassicNodeRelevant nodeRelevant = new ClassicNodeRelevant();

    public ClassicNodeRelevant.SingleNodeLink<Integer> initSingleNodeLink() {
        ClassicNodeRelevant.SingleNodeLink<Integer> head = null;
        ClassicNodeRelevant.SingleNodeLink<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new ClassicNodeRelevant.SingleNodeLink<>((int) (Math.random() * 100));
                head.setNext(null);
                curr = head;
            } else {
                ClassicNodeRelevant.SingleNodeLink<Integer> element = new ClassicNodeRelevant.SingleNodeLink<>((int) (Math.random() * 100));
                element.setNext(null);
                curr.setNext(element);
                curr = element;
            }
        }
        return head;
    }

    public ClassicNodeRelevant.DoubleNodeLink<Integer> initDoubleNodeList() {
        ClassicNodeRelevant.DoubleNodeLink<Integer> head = null;
        ClassicNodeRelevant.DoubleNodeLink<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new ClassicNodeRelevant.DoubleNodeLink<>((int) (Math.random() * 100));
                head.setPre(null);
                head.setNext(null);
                curr = head;
            } else {
                ClassicNodeRelevant.DoubleNodeLink<Integer> element = new ClassicNodeRelevant.DoubleNodeLink<>((int) (Math.random() * 100));
                curr.setNext(element);
                element.setPre(curr);
                element.setNext(null);
                curr = element;
            }
        }
        return curr;
    }


    public void printSingleNodeLink(ClassicNodeRelevant.SingleNodeLink<Integer> head) {
        ClassicNodeRelevant.SingleNodeLink<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    private void printDoubleNodeList(ClassicNodeRelevant.DoubleNodeLink<Integer> head) {
        ClassicNodeRelevant.DoubleNodeLink<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    public Boolean isExistDataInSingleNodeList(ClassicNodeRelevant.SingleNodeLink<Integer> head, Integer data) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        ClassicNodeRelevant.SingleNodeLink<Integer> curr = head;
        while (Objects.nonNull(curr) && !curr.getData().equals(data)) {
            curr = curr.getNext();
        }
        return Objects.nonNull(curr) ? Boolean.TRUE : Boolean.FALSE;
    }

    public Boolean isExistDataInDoubleNodeList(ClassicNodeRelevant.DoubleNodeLink<Integer> head, Integer data) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        ClassicNodeRelevant.DoubleNodeLink<Integer> curr = head;
        while (Objects.nonNull(curr) && !curr.getData().equals(data)) {
            curr = curr.getNext();
        }
        return Objects.nonNull(curr) ? Boolean.TRUE : Boolean.FALSE;
    }

    public String dataToStringWithSingleNodeList(ClassicNodeRelevant.SingleNodeLink<Integer> head) {
        ClassicNodeRelevant.SingleNodeLink<Integer> curr = head;
        StringBuilder builder = new StringBuilder();
        while (Objects.nonNull(curr)) {
            builder.append(curr.getData());
            curr = curr.getNext();
        }
        return builder.toString();
    }

    public String dataToStringWithDoubleNodeList(ClassicNodeRelevant.DoubleNodeLink<Integer> head) {
        ClassicNodeRelevant.DoubleNodeLink<Integer> curr = head;
        StringBuilder builder = new StringBuilder();
        while (Objects.nonNull(curr)) {
            builder.append(curr.getData());
            curr = curr.getNext();
        }
        return builder.toString();
    }

    public Integer countSingleNodeNum(ClassicNodeRelevant.SingleNodeLink<Integer> head) {
        int num = 0;
        if (Objects.isNull(head)) {
            return num;
        }
        ClassicNodeRelevant.SingleNodeLink<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            curr = curr.getNext();
            num++;
        }
        return num;
    }

    public Integer countDoubleNodeNum(ClassicNodeRelevant.DoubleNodeLink<Integer> head) {
        int num = 0;
        if (Objects.isNull(head)) {
            return num;
        }
        ClassicNodeRelevant.DoubleNodeLink<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            curr = curr.getNext();
            num++;
        }
        return num;
    }


    @Test
    public void revertSingleNodeListTest() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.SingleNodeLink<Integer> head = initSingleNodeLink();
            ClassicNodeRelevant.SingleNodeLink<Integer> origin = nodeRelevant.revertSingleNodeList(nodeRelevant.revertSingleNodeList(head));
            if (!dataToStringWithSingleNodeList(head).equals(dataToStringWithSingleNodeList(origin))) {
                printSingleNodeLink(head);
                return;
            }
        }

    }

    @Test
    public void revertDoubleNodeListTest() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.DoubleNodeLink<Integer> head = initDoubleNodeList();
            ClassicNodeRelevant.DoubleNodeLink<Integer> origin = nodeRelevant.revertDoubleNodeList(nodeRelevant.revertDoubleNodeList(head));
            if (!dataToStringWithDoubleNodeList(head).equals(dataToStringWithDoubleNodeList(origin))) {
                printDoubleNodeList(head);
                return;
            }
        }
    }

    @Test
    public void deleteSingleNodeList() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.SingleNodeLink<Integer> head = initSingleNodeLink();
            int data = (int) (Math.random() * 100);
            ClassicNodeRelevant.SingleNodeLink<Integer> singleNodeLink = nodeRelevant.deleteSingleNodeList(head, data);
            Integer singleNodeNum = countSingleNodeNum(singleNodeLink);
            ClassicNodeRelevant.SingleNodeLink<Integer> revertSingleNodeLink = nodeRelevant.revertSingleNodeList(singleNodeLink);
            Integer revertSingleNodeNum = countSingleNodeNum(revertSingleNodeLink);
            if (isExistDataInSingleNodeList(singleNodeLink, data) || !singleNodeNum.equals(revertSingleNodeNum)) {
                printSingleNodeLink(singleNodeLink);
                System.out.println(data);
                return;
            }
        }
    }

    @Test
    public void deleteDoubleNodeList() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.DoubleNodeLink<Integer> head = initDoubleNodeList();
            int data = (int) (Math.random() * 100);
            ClassicNodeRelevant.DoubleNodeLink<Integer> doubleNodeLink = nodeRelevant.deleteDoubleNodeLink(head, data);
            Integer doubleNodeNum = countDoubleNodeNum(doubleNodeLink);
            ClassicNodeRelevant.DoubleNodeLink<Integer> revertDoubleNodeLink = nodeRelevant.revertDoubleNodeList(doubleNodeLink);
            Integer revertDoubleNodeNum = countDoubleNodeNum(revertDoubleNodeLink);
            if (isExistDataInDoubleNodeList(doubleNodeLink, data) || !doubleNodeNum.equals(revertDoubleNodeNum)) {
                printDoubleNodeList(doubleNodeLink);
                System.out.println(data);
                return;
            }
        }
    }
}
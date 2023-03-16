package com.mimu.simple.java.algorithm;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Objects;


public class ClassicNodeRelevantTest {
    public int loop = (int) (Math.random() * 99999) + 1;
    public int nodeLinkLength = (int) (Math.random() * 20);
    ClassicNodeRelevant nodeRelevant = new ClassicNodeRelevant();

    public ClassicNodeRelevant.SingleNodeList<Integer> initSingleNodeLink() {

        ClassicNodeRelevant.SingleNodeList<Integer> head = null;
        ClassicNodeRelevant.SingleNodeList<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new ClassicNodeRelevant.SingleNodeList<>();
                head.setData((int) (Math.random() * 100));
                head.setNext(null);
                curr = head;
            } else {
                ClassicNodeRelevant.SingleNodeList<Integer> element = new ClassicNodeRelevant.SingleNodeList<>();
                element.setData((int) (Math.random() * 100) + i);
                element.setNext(null);
                curr.setNext(element);
                curr = element;
            }
        }
        return head;
    }

    public ClassicNodeRelevant.DoubleNodeList<Integer> initDoubleNodeList() {
        ClassicNodeRelevant.DoubleNodeList<Integer> head = null;
        ClassicNodeRelevant.DoubleNodeList<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new ClassicNodeRelevant.DoubleNodeList<>();
                head.setData((int) (Math.random() * 100));
                head.setPre(null);
                head.setNext(null);
                curr = head;
            } else {
                ClassicNodeRelevant.DoubleNodeList<Integer> element = new ClassicNodeRelevant.DoubleNodeList<>();
                curr.setNext(element);
                element.setData((int) (Math.random() * 100) + i);
                element.setPre(curr);
                element.setNext(null);
                curr = element;
            }
        }
        return curr;
    }


    public void printSingleNodeLink(ClassicNodeRelevant.SingleNodeList<Integer> head) {
        ClassicNodeRelevant.SingleNodeList<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    private void printDoubleNodeList(ClassicNodeRelevant.DoubleNodeList<Integer> head) {
        ClassicNodeRelevant.DoubleNodeList<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    public Boolean isExistDataInSingleNodeList(ClassicNodeRelevant.SingleNodeList<Integer> head, Integer data) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        if (head.getData().equals(data)) {
            return Boolean.TRUE;
        }
        ClassicNodeRelevant.SingleNodeList<Integer> next = head.getNext();
        while (Objects.nonNull(next)) {
            if (next.getData().equals(data)) {
                return Boolean.TRUE;
            } else {
                next = next.getNext();
            }
        }
        return Boolean.FALSE;
    }

    public String dataToStringWithSingleNodeList(ClassicNodeRelevant.SingleNodeList<Integer> head) {
        ClassicNodeRelevant.SingleNodeList<Integer> curr = head;
        StringBuilder builder = new StringBuilder();
        while (Objects.nonNull(curr)) {
            builder.append(curr.getData());
            curr = curr.getNext();
        }
        return builder.toString();
    }

    public String dataToStringWithDoubleNodeList(ClassicNodeRelevant.DoubleNodeList<Integer> head) {
        ClassicNodeRelevant.DoubleNodeList<Integer> curr = head;
        StringBuilder builder = new StringBuilder();
        while (Objects.nonNull(curr)) {
            builder.append(curr.getData());
            curr = curr.getNext();
        }
        return builder.toString();
    }


    @Test
    public void revertSingleNodeListTest() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.SingleNodeList<Integer> head = initSingleNodeLink();
            ClassicNodeRelevant.SingleNodeList<Integer> origin = nodeRelevant.revertSingleNodeList(nodeRelevant.revertSingleNodeList(head));
            if (!dataToStringWithSingleNodeList(head).equals(dataToStringWithSingleNodeList(origin))) {
                printSingleNodeLink(head);
                return;
            }
        }

    }

    @Test
    public void revertDoubleNodeListTest() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.DoubleNodeList<Integer> head = initDoubleNodeList();
            ClassicNodeRelevant.DoubleNodeList<Integer> origin = nodeRelevant.revertDoubleNodeList(nodeRelevant.revertDoubleNodeList(head));
            if (!dataToStringWithDoubleNodeList(head).equals(dataToStringWithDoubleNodeList(origin))) {
                printDoubleNodeList(head);
                return;
            }
        }
    }

    @Test
    public void oneLinkNodeDelete() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.SingleNodeList<Integer> head = initSingleNodeLink();
            int data = (int) (Math.random() * 100);
            ClassicNodeRelevant.SingleNodeList<Integer> singleNodeList = nodeRelevant.deleteSingleNodeList(head, data);
            if (isExistDataInSingleNodeList(singleNodeList, data)) {
                printSingleNodeLink(singleNodeList);
                System.out.println(data);
                return;
            }
        }
    }
}
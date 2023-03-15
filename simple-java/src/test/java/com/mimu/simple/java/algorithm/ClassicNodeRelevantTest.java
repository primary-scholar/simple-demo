package com.mimu.simple.java.algorithm;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Objects;


public class ClassicNodeRelevantTest {
    public int loop = (int) (Math.random() * 99999) + 1;
    ClassicNodeRelevant nodeRelevant = new ClassicNodeRelevant();

    public ClassicNodeRelevant.OneLinkNode<Integer> initOneNodeLink() {
        int nodeLinkLength = (int) (Math.random() * 20);
        ClassicNodeRelevant.OneLinkNode<Integer> head = null;
        ClassicNodeRelevant.OneLinkNode<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new ClassicNodeRelevant.OneLinkNode<>();
                head.setData((int) (Math.random() * 100));
                head.setNext(null);
                curr = head;
            } else {
                Integer data = (int) (Math.random() * 100) + i;
                ClassicNodeRelevant.OneLinkNode<Integer> element = new ClassicNodeRelevant.OneLinkNode<>();
                element.setData(data);
                element.setNext(null);
                curr.setNext(element);
                curr = element;
            }
        }
        return head;
    }


    public void printOneNodeLink(ClassicNodeRelevant.OneLinkNode<Integer> head) {
        ClassicNodeRelevant.OneLinkNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    public Boolean isExistData(ClassicNodeRelevant.OneLinkNode<Integer> head, Integer data) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        if (head.getData().equals(data)) {
            return Boolean.TRUE;
        }
        ClassicNodeRelevant.OneLinkNode<Integer> next = head.getNext();
        while (Objects.nonNull(next)) {
            if (next.getData().equals(data)) {
                return Boolean.TRUE;
            } else {
                next = next.getNext();
            }
        }
        return Boolean.FALSE;
    }

    public String nodeDataToString(ClassicNodeRelevant.OneLinkNode<Integer> head) {
        if (Objects.isNull(head)) {
            return StringUtils.EMPTY;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(head.getData());
        ClassicNodeRelevant.OneLinkNode<Integer> next = head.getNext();
        while (Objects.nonNull(next)) {
            builder.append(next.getData());
            next = next.getNext();
        }
        return builder.toString();
    }


    @Test
    public void oneLinkNodeRevert() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.OneLinkNode<Integer> head = initOneNodeLink();
            ClassicNodeRelevant.OneLinkNode<Integer> origin = nodeRelevant.oneLinkNodeRevert(nodeRelevant.oneLinkNodeRevert(head));
            if (!nodeDataToString(head).equals(nodeDataToString(origin))) {
                printOneNodeLink(head);
                return;
            }
        }

    }

    @Test
    public void oneLinkNodeDelete() {
        for (int i = 0; i < loop; i++) {
            ClassicNodeRelevant.OneLinkNode<Integer> head = initOneNodeLink();
            int data = (int) (Math.random() * 100);
            ClassicNodeRelevant.OneLinkNode<Integer> oneLinkNode = nodeRelevant.oneLinkNodeDelete(head, data);
            if (isExistData(oneLinkNode, data)) {
                printOneNodeLink(oneLinkNode);
                System.out.println(data);
                return;
            }
        }
    }
}
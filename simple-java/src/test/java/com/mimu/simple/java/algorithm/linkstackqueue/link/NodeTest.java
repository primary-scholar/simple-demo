package com.mimu.simple.java.algorithm.linkstackqueue.link;

import com.mimu.simple.java.algorithm.BaseTest;

import java.util.Objects;

public class NodeTest extends BaseTest {
    public static int nodeLinkLength = (int) (Math.random() * 20);

    public CustomSingleNode<Integer> initSingleNodeLink() {
        CustomSingleNode<Integer> head = null;
        CustomSingleNode<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new CustomSingleNode<>((int) (Math.random() * 100));
                head.setNext(null);
                curr = head;
            } else {
                CustomSingleNode<Integer> element = new CustomSingleNode<>((int) (Math.random() * 100));
                element.setNext(null);
                curr.setNext(element);
                curr = element;
            }
        }
        return head;
    }

    public void printSingleNodeLink(CustomSingleNode<Integer> head) {
        CustomSingleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    public Boolean isExistDataInSingleNodeList(CustomSingleNode<Integer> head, Integer data) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        CustomSingleNode<Integer> curr = head;
        while (Objects.nonNull(curr) && !curr.getData().equals(data)) {
            curr = curr.getNext();
        }
        return Objects.nonNull(curr) ? Boolean.TRUE : Boolean.FALSE;
    }

    public Integer countSingleNodeNum(CustomSingleNode<Integer> head) {
        int num = 0;
        if (Objects.isNull(head)) {
            return num;
        }
        CustomSingleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            curr = curr.getNext();
            num++;
        }
        return num;
    }

    public String dataToStringWithSingleNodeList(CustomSingleNode<Integer> head) {
        CustomSingleNode<Integer> curr = head;
        StringBuilder builder = new StringBuilder();
        while (Objects.nonNull(curr)) {
            builder.append(curr.getData());
            curr = curr.getNext();
        }
        return builder.toString();
    }

    public CustomDoubleNode<Integer> initDoubleNodeList() {
        CustomDoubleNode<Integer> head = null;
        CustomDoubleNode<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new CustomDoubleNode<>((int) (Math.random() * 100));
                head.setPre(null);
                head.setNext(null);
                curr = head;
            } else {
                CustomDoubleNode<Integer> element = new CustomDoubleNode<>((int) (Math.random() * 100));
                curr.setNext(element);
                element.setPre(curr);
                element.setNext(null);
                curr = element;
            }
        }
        return curr;
    }

    public void printDoubleNodeList(CustomDoubleNode<Integer> head) {
        CustomDoubleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    public Boolean isExistDataInDoubleNodeList(CustomDoubleNode<Integer> head, Integer data) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        CustomDoubleNode<Integer> curr = head;
        while (Objects.nonNull(curr) && !curr.getData().equals(data)) {
            curr = curr.getNext();
        }
        return Objects.nonNull(curr) ? Boolean.TRUE : Boolean.FALSE;
    }

    public String dataToStringWithDoubleNodeList(CustomDoubleNode<Integer> head) {
        CustomDoubleNode<Integer> curr = head;
        StringBuilder builder = new StringBuilder();
        while (Objects.nonNull(curr)) {
            builder.append(curr.getData());
            curr = curr.getNext();
        }
        return builder.toString();
    }

    public Integer countDoubleNodeNum(CustomDoubleNode<Integer> head) {
        int num = 0;
        if (Objects.isNull(head)) {
            return num;
        }
        CustomDoubleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            curr = curr.getNext();
            num++;
        }
        return num;
    }
}

package com.mimu.simple.java.algorithm.linkstackqueue.link;

import com.mimu.simple.java.algorithm.BaseTest;
import com.mimu.simple.java.algorithm.linkstackqueue.link.DoubleNode;
import com.mimu.simple.java.algorithm.linkstackqueue.link.SingleNode;

import java.util.Objects;

public class NodeTest extends BaseTest {
    public static int nodeLinkLength = (int) (Math.random() * 20);

    public SingleNode<Integer> initSingleNodeLink() {
        SingleNode<Integer> head = null;
        SingleNode<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new SingleNode<>((int) (Math.random() * 100));
                head.setNext(null);
                curr = head;
            } else {
                SingleNode<Integer> element = new SingleNode<>((int) (Math.random() * 100));
                element.setNext(null);
                curr.setNext(element);
                curr = element;
            }
        }
        return head;
    }

    public void printSingleNodeLink(SingleNode<Integer> head) {
        SingleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    public Boolean isExistDataInSingleNodeList(SingleNode<Integer> head, Integer data) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        SingleNode<Integer> curr = head;
        while (Objects.nonNull(curr) && !curr.getData().equals(data)) {
            curr = curr.getNext();
        }
        return Objects.nonNull(curr) ? Boolean.TRUE : Boolean.FALSE;
    }

    public Integer countSingleNodeNum(SingleNode<Integer> head) {
        int num = 0;
        if (Objects.isNull(head)) {
            return num;
        }
        SingleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            curr = curr.getNext();
            num++;
        }
        return num;
    }

    public String dataToStringWithSingleNodeList(SingleNode<Integer> head) {
        SingleNode<Integer> curr = head;
        StringBuilder builder = new StringBuilder();
        while (Objects.nonNull(curr)) {
            builder.append(curr.getData());
            curr = curr.getNext();
        }
        return builder.toString();
    }

    public DoubleNode<Integer> initDoubleNodeList() {
        DoubleNode<Integer> head = null;
        DoubleNode<Integer> curr = null;
        for (int i = 0; i < nodeLinkLength; i++) {
            if (Objects.isNull(head)) {
                head = new DoubleNode<>((int) (Math.random() * 100));
                head.setPre(null);
                head.setNext(null);
                curr = head;
            } else {
                DoubleNode<Integer> element = new DoubleNode<>((int) (Math.random() * 100));
                curr.setNext(element);
                element.setPre(curr);
                element.setNext(null);
                curr = element;
            }
        }
        return curr;
    }

    public void printDoubleNodeList(DoubleNode<Integer> head) {
        DoubleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            System.out.print(curr.getData());
            System.out.print("  ");
            curr = curr.getNext();
        }
        System.out.println("");
    }

    public Boolean isExistDataInDoubleNodeList(DoubleNode<Integer> head, Integer data) {
        if (Objects.isNull(head)) {
            return Boolean.FALSE;
        }
        DoubleNode<Integer> curr = head;
        while (Objects.nonNull(curr) && !curr.getData().equals(data)) {
            curr = curr.getNext();
        }
        return Objects.nonNull(curr) ? Boolean.TRUE : Boolean.FALSE;
    }

    public String dataToStringWithDoubleNodeList(DoubleNode<Integer> head) {
        DoubleNode<Integer> curr = head;
        StringBuilder builder = new StringBuilder();
        while (Objects.nonNull(curr)) {
            builder.append(curr.getData());
            curr = curr.getNext();
        }
        return builder.toString();
    }

    public Integer countDoubleNodeNum(DoubleNode<Integer> head) {
        int num = 0;
        if (Objects.isNull(head)) {
            return num;
        }
        DoubleNode<Integer> curr = head;
        while (Objects.nonNull(curr)) {
            curr = curr.getNext();
            num++;
        }
        return num;
    }
}

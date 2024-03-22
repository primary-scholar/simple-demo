package com.mimu.simple.java.algorithm.bintree;


import com.mimu.simple.java.algorithm.BaseTest;

import java.util.Objects;

public class TreeTest extends BaseTest {

    private static Integer treeNodeNum = (int) (Math.random() * 20);

    public SimpleTreeNode<Integer> initTree() {
        SimpleTreeNode<Integer> root = null;
        SimpleTreeNode<Integer> curr = null;
        for (int i = 0; i < treeNodeNum; ) {
            if (Objects.isNull(root)) {
                root = new SimpleTreeNode<>();
                root.setData(getRandom());
                root.setLeft(null);
                root.setRight(null);
                curr = root;
                i++;
            }
            if (i % 2 == 1) {
                SimpleTreeNode<Integer> left = new SimpleTreeNode<Integer>();
                left.setData(getRandom());
                left.setLeft(null);
                left.setRight(null);
                curr.setLeft(left);
                i++;
            }
            if (i % 2 == 0) {
                SimpleTreeNode<Integer> right = new SimpleTreeNode<Integer>();
                right.setData(getRandom());
                right.setLeft(null);
                right.setRight(null);
                curr.setRight(right);
                i++;
            }
        }
        return root;
    }
}

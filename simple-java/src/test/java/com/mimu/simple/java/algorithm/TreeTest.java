package com.mimu.simple.java.algorithm;


import java.util.Objects;

public class TreeTest extends BaseTest {

    private static Integer treeNodeNum = (int) (Math.random() * 20);

    public ClassicTreeOperation.SimpleTreeNode<Integer> initTree() {
        ClassicTreeOperation.SimpleTreeNode<Integer> root = null;
        ClassicTreeOperation.SimpleTreeNode<Integer> curr = null;
        for (int i = 0; i < treeNodeNum; ) {
            if (Objects.isNull(root)) {
                root = new ClassicTreeOperation.SimpleTreeNode<>();
                root.setData(getRandom());
                root.setLeft(null);
                root.setRight(null);
                curr = root;
                i++;
            }
            if (i % 2 == 1) {
                ClassicTreeOperation.SimpleTreeNode<Integer> left = new ClassicTreeOperation.SimpleTreeNode<Integer>();
                left.setData(getRandom());
                left.setLeft(null);
                left.setRight(null);
                curr.setLeft(left);
                i++;
            }
            if (i % 2 == 0) {
                ClassicTreeOperation.SimpleTreeNode<Integer> right = new ClassicTreeOperation.SimpleTreeNode<Integer>();
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

package com.mimu.simple.java.algorithm.bintree;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomTreeNode<T> {
    private T data;
    private CustomTreeNode<T> left;
    private CustomTreeNode<T> right;

    public CustomTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

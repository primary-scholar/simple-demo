package com.mimu.simple.java.algorithm.bintree;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SimpleTreeNode<T> {
    private T data;
    private SimpleTreeNode<T> left;
    private SimpleTreeNode<T> right;
}

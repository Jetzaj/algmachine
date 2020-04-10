package com.algmachine.service.data_structure.tree;

public class BTreeNode<T> {
    public int val;
    public BTreeNode<T> left;
    public BTreeNode<T> right;

    public BTreeNode(int val) {
        this.val = val;
    }
}

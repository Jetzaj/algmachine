package com.algmachine.service.data_structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTree<T> {
    public BTreeNode<T> root;

    public BTree(BTreeNode<T> root) {
        this.root = root;
    }

    public List<List<Integer>> breadthFirstTravel(BTreeNode<T> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Queue<BTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> arrays = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                BTreeNode<T> node = queue.poll();
                arrays.add(node.val);
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
            }
            result.add(0, arrays);
        }
        return result;
    }

    public int minDepth(BTreeNode<T> root) {
        int minDepth = 0;
        if (null == root) return minDepth;
        
        Queue<BTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            minDepth++;
            BTreeNode<T> node = queue.poll();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                if (node.left != null && node.right != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return minDepth;
    }
}

package com.algmachine.service.data_structure.tree;

import java.util.concurrent.atomic.AtomicLong;

public class RBTree<T extends Comparable<T>> {
    private final RBTreeNode<T> root;

    //node number
    private AtomicLong size = new AtomicLong(0);

    //in overwrite mode,all node's value can not has same value
    //in non-overwrite mode,node can have the same value,suggest don't use non-overwrite mode.
    private volatile boolean overrideMode = true;

    public RBTree() {
        this.root = new RBTreeNode<>();
    }

    public RBTree(boolean overrideMode) {
        this();
        this.overrideMode = overrideMode;
    }

    public boolean isOverrideMode() {
        return overrideMode;
    }

    public void setOverrideMode(boolean overrideMode) {
        this.overrideMode = overrideMode;
    }

    public long getSize() {
        return size.get();
    }

    private RBTreeNode<T> getRoot() {
        return root.getLeft();
    }

    public T addNode(T value) {
        RBTreeNode<T> t = new RBTreeNode<>(value);
        return addNode(t);
    }

    public RBTreeNode<T> findNode(RBTreeNode<T> node) {
        T key = node.getValue();
        RBTreeNode<T> root = getRoot();

        while (true) {
            if (null == root) {
                break;
            }
            if (root.getValue().equals(key)) {
                return root;
            } else if (key.compareTo(root.getValue()) < 0) {
                root = root.getLeft();
            } else {
                root = root.getRight();
            }
        }
        return null;
    }


    public T addNode(RBTreeNode<T> node) {
        node.setLeft(null);
        node.setRight(null);
        node.setRed(true);
        setParent(node, null);
        if (root.getLeft() == null) {
            root.setLeft(node);

            //root node is black
            node.setRed(false);
            size.incrementAndGet();
        } else {
            RBTreeNode<T> x = findParentNode(node);
            int cmp = x.getValue().compareTo(node.getValue());

            if (this.overrideMode && cmp == 0) {
                T v = x.getValue();
                x.setValue(node.getValue());
                return v;
            } else if (cmp == 0) {
                //value exists,ignore this node
                return x.getValue();
            }

            setParent(node, x);

            if (cmp > 0) {
                x.setLeft(node);
            } else {
                x.setRight(node);
            }
        }

        fixInsert(node);
        size.incrementAndGet();
        return null;
    }

    private RBTreeNode<T> findParentNode(RBTreeNode<T> x) {
        RBTreeNode<T> dataRoot = getRoot();
        RBTreeNode child = dataRoot;

        while (child != null) {
            int cmp = child.getValue().compareTo(x.getValue());
            if (cmp == 0) {
                return child;
            }
            else if (cmp > 0) {
                dataRoot = child;
                child = child.getLeft();
            } else {
                dataRoot = child;
                child = child.getRight();
            }
        }
        return dataRoot;
    }

    private RBTreeNode<T> getUncle(RBTreeNode<T> node) {
        RBTreeNode<T> parent = node.getParent();
        RBTreeNode<T> ancestor = parent.getParent();
        if (null == ancestor) {
            return null;
        }
        if (parent == ancestor.getLeft()) {
            return ancestor.getRight();
        } else {
            return ancestor.getLeft();
        }
    }

    /**
     * red black tree insert fix
     *
     * @param x
     */
    private void fixInsert(RBTreeNode<T> x) {
        RBTreeNode<T> parent = x.getParent();

        while (parent != null && parent.isRed()) {
            RBTreeNode<T> uncle = getUncle(x);
            if (null == uncle) {//need to rotate
                RBTreeNode<T> ancestor = parent.getParent();
                //ancestor is not null due to before adding, tree color is balance
                if (parent == ancestor.getLeft()) {
                    boolean isRight = x == parent.getRight();
                    if (isRight) {
                        rotateLeft(parent);
                    }
                    rotateRight(ancestor);

                    if (isRight) {
                        x.setRed(false);
                        parent = null;//end loop
                    } else {
                        parent.setRed(false);
                    }
                    ancestor.setRed(true);
                } else {
                    boolean isLeft = x == parent.getLeft();
                    if (isLeft) {
                        rotateRight(parent);
                    }
                    rotateLeft(ancestor);

                    if (isLeft) {
                        x.setRed(false);
                        parent = null;//end loop
                    } else {
                        parent.setRed(false);
                    }
                    ancestor.setRed(true);
                }
            } else {//uncle is red
                parent.setRed(false);
                uncle.setRed(false);
                parent.getParent().setRed(true);
                x = parent.getParent();
                parent = x.getParent();
            }
        }
        getRoot().makeBlack();
        getRoot().setParent(null);
    }


    private void rotateLeft(RBTreeNode<T> node) {
        RBTreeNode<T> right = node.getRight();
        if (null == right) {
            throw new IllegalStateException("right node is null");
        }
        RBTreeNode<T> parent = node.getParent();
        node.setRight(right.getLeft());
        setParent(right.getLeft(), node);

        right.setLeft(node);
        setParent(node, right);

        if (null == parent) {//node pointer to root
            //right raise to root node
            root.setLeft(right);
            setParent(right, null);
        } else {
            if (parent.getLeft() == node) {
                parent.setLeft(right);
                setParent(right, null);
            } else {
                parent.setRight(right);
            }
            setParent(right, parent);
        }
    }

    private void rotateRight(RBTreeNode<T> node) {
        RBTreeNode<T> left = node.getLeft();
        if (null == left) {
            throw new IllegalStateException("left node is null");
        }

        RBTreeNode<T> parent = node.getParent();
        node.setLeft(left.getRight());
        setParent(left.getRight(), node);

        left.setRight(node);
        setParent(node, left);

        if (null == parent) {
            root.setLeft(left);
            setParent(left, null);
        } else {
            if (parent.getLeft() == node) {
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }
            setParent(left, parent);
        }
    }


    private void setParent(RBTreeNode<T> node, RBTreeNode<T> parent) {
        if (node != null) {
            node.setParent(parent);
            if (parent == root) {
                node.setParent(null);
            }
        }
    }

}

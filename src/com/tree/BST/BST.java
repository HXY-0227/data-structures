package com.tree.BST;

public class BST<E extends Comparable<E>> {

    private class Node {
        E e;
        Node right;
        Node left;

        public Node(E e) {
            this.e = e;
            this.right = null;
            this.left = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    private int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 递归添加元素
     * @param node
     * @param e
     * @return 返回插入新节后二叉搜索树的根
     */
    private Node add(Node node, E e) {
        if (null == node) {
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            // 添加返回值将new出来的节点挂载到树上
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * 是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 以node为根的二叉搜索树是否包含元素e
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (null == node) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else  {
            return contains(node.right, e);
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Integer[] arr = new Integer[] {16, 8, 22, 1, 9, 17, 30};
        for (int i = 0; i < arr.length; i ++) {
            bst.add(arr[i]);
        }

        if (bst.contains(88)) {
            System.out.println("----");
        }
    }
}

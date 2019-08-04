package com.tree.AVLTree;


public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getHeight(Node node) {
        if (null == node) {
            return 0;
        }

        return node.height;
    }

    /**
     * 计算节点的平衡因子
     * @param node
     * @return
     */
    public int getBalanceFactor(Node node) {
        if (null == node) {
            return 0;
        }

        return Math.abs(getHeight(node.left) - getHeight(node.right));
    }

    /**
     * 添加元素
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        add(root, key, value);
    }

    /**
     * 向以node为根的树中添加元素
     * @param node
     * @param key
     * @param value
     * @return 插入元素后新的树结构
     */
    private Node add(Node node, K key, V value) {
        if (null == node) {
            size ++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        // 维护每一个节点的height
        node.height = 1 + Math.max(node.left.height, node.right.height);

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        return node;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    /**
     * 左旋转
     * @param y
     * @return
     */
    private Node leftRotate(Node y) {
        // 使x和T2脱离
        Node x = y.right;
        Node T2 = x.left;

        // 左旋转过程
        x.left = y;
        y.right = T2;

        // 更新高度
        y.height = Math.max(y.left.height, y.right.height) + 1;
        x.height = Math.max(x.left.height, x.right.height) + 1;

        return x;
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    /**
     * 右旋转
     * @param y
     * @return
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        // 旋转过程
        x.right = y;
        y.left = T3;

        // 更新高度
        y.height = Math.max(y.left.height, y.right.height) + 1;
        x.height = Math.max(x.left.height, x.right.height) + 1;

        return x;
    }


}

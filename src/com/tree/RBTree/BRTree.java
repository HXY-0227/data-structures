package com.tree.RBTree;

/**
 * 红黑树
 * @param <K>
 * @param <V>
 */
public class BRTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int size;

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    public BRTree() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断节点是否红色
     * @param node
     * @return
     */
    private boolean isRed(Node node) {
        if (null == node) {
            return BLACK;
        }

        return node.color;
    }

    //   node                       rotateNode
    //   /  \           左旋转         /   \
    // T1 rotateNode  --------->    node   T3
    //     / \                      /  \
    //    T2 T3                    T1   T2
    /**
     * 左旋转
     * @param node 需要旋转的节点
     * @return 旋转后的节点
     */
    private Node leftRotate(Node node) {
        Node rotateNode = node.right;
        node.right = rotateNode.left;
        rotateNode.left = node;
        rotateNode.color = BLACK;
        node.color = RED;
        return rotateNode;
    }

    //          node                  rotateNode
    //         /   \        右旋转       /  \
    // rotateNode    T2   ------->      y   node
    //     / \                        /  \
    //     y  T1                     T1  T2

    /**
     * 右旋转
     * @param node 需要旋转的节点
     * @return 旋转后的节点
     */
    private Node rightRotate(Node node) {
        Node rotateNode = node.left;
        node.left = rotateNode.right;
        rotateNode.right = node;
        rotateNode.color = node.color;
        // 等价的2-3树中，该节点会向上融合，颜色设置为红色
        node.color = RED;
        return rotateNode;
    }

    //     42       插入66        42
    //     /      ---------->    / \
    //    37                    37 66
    //
    /**
     * 颜色翻转  当向一个类似于2-3树中的三节点插入元素的时候，
     * 根节点要向上融合，所以要进行颜色的转换
     * @param node
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 添加元素
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK;
    }

    /**
     * 采用递归算法向以node为根的红黑树中插入元素
     * @param node 根节点
     * @param key
     * @param value
     * @return 插入新节点后的红黑树的根节点
     */
    private Node add(Node node, K key, V value) {
        // 根节点为空
        if (null == node) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        // 是否需要左旋转
        if (isRed(node.left) && !isRed(node.right)) {
            leftRotate(node);
        }

        // 是否需要右旋转
        if (isRed(node.left) && isRed(node.left.left)) {
            rightRotate(node);
        }

        // 是否需要颜色翻转
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

}

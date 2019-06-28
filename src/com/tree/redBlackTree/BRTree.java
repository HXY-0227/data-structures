package com.tree.redBlackTree;

public class BRTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

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
}

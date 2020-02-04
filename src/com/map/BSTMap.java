package com.map;

/**
 * 二叉搜索树实现Map
 *
 * @author HXY
 * @since 2020-2-4 希望疫情早点结束
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    public class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    // 获取key对应的节点
    private Node getNode(Node node, K key) {
        if (null == node) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
           return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    /**
     * 添加元素
     *
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
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

        return node;
    }

    /**
     * 删除key对应的元素
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        Node delNode = getNode(root, key);
        if (null != delNode) {
            root = remove(root, key);
            return delNode.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (null == node) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (null == node.left) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (null == node.right) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minNum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.right = null;
            node.left = null;
            size--;
            return successor;
        }
    }

    // 获取最小接地那
    private Node minNum(Node node) {
        if (null == node.left) {
            return node;
        }
        return minNum(node.left);
    }

    // 删除最小节点
    private Node removeMin(Node node) {
        if (null == node.left) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 是否包含key对应的元素
     *
     * @param key
     * @return 是否包含key
     */
    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * 获取key对应的value
     *
     * @param key
     * @return value
     */
    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    /**
     * 更新key对应的value
     *
     * @param key
     * @param newValue
     */
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (null == node) {
            throw new IllegalArgumentException(key + " does not exists");
        }
        node.value = newValue;
    }

    /**
     * 获取map中元素的个数
     *
     * @return size
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断map是否为空
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        BSTMap map = new BSTMap();
        map.add(15, "0227");
        map.add(10, "0504");
        map.add(20, "0624");
        map.add(5, "0618");
        map.add(13, "0118");
        map.add(29, "0118");
        map.remove(20);
        System.out.println(map.getSize() + "--" + map.isEmpty() + "--" + map.contains("20"));
    }
}

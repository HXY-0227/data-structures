package com.tree.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BST<K extends Comparable<K>, V extends Comparable<V>> {

    private class Node {
        K key;
        V value;
        Node right;
        Node left;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 递归添加元素
     * @param node
     * @param key
     * @param value
     * @return 返回插入新节后二叉搜索树的根
     */
    private Node add(Node node, K key, V value) {
        if (null == node) {
            size ++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            // 添加返回值将new出来的节点挂载到树上
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return null == node ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (null == node) {
            throw new IllegalArgumentException(key + "does not exists");
        }

        node.value = newValue;
    }

    /**
     * 是否包含元素e
     * @param key
     * @return
     */
    public boolean contains(K key) {
        return contains(root, key);
    }

    /**
     * 以node为根的二叉搜索树是否包含元素e
     * @param node
     * @param key
     * @return
     */
    private boolean contains(Node node, K key) {
        if (null == node) {
            return false;
        }

        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contains(node.left, key);
        } else  {
            return contains(node.right, key);
        }
    }

    /**
     * 返回key所在的节点
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {
        if (null == node) {
            return null;
        }

        if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return node;
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历 先访问根节点，在访问左右子树, 递归算法
     * @param node
     */
    private void preOrder(Node node) {
        if (null == node) {
            return;
        }
        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历 先访问左子树，在访问根节点和右子树, 递归算法
     * @param node
     */
    private void inOrder(Node node) {
        if (null == node) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历 先访问左子树，在访问右子树和根节点, 递归算法
     * @param node
     */
    private void postOrder(Node node) {
        if (null == node) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        if (null == root) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Queue<Node> levelQueue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.print(cur.key + " ");
            if (null != cur.left) {
                queue.add(cur.left);
            }
            if (null != cur.right) {
                queue.add(cur.right);
            }
            if(queue.isEmpty()){
                System.out.println();
                queue.addAll(levelQueue);
                levelQueue.clear();
            }
        }
    }

    /**
     * 获取二叉搜索树的最大节点
     */
    public V maxNum() {
        if (size == 0) {
            throw new IllegalArgumentException("BSI is empty");
        }

        return maxNum(root).value;
    }

    /**
     * 递归获取最大元素，从树的右边遍历
     * @param node
     * @return
     */
    private Node maxNum(Node node) {
        if (null == node.right) {
            return node;
        }

        return maxNum(node.right);
    }

    /**
     * 获取二叉搜索树的最小节点
     */
    public V minNum() {
        if (size == 0) {
            throw new IllegalArgumentException("BSI is empty");
        }

        return minNum(root).value;
    }

    /**
     * 递归获取最小元素，从树的左边遍历
     * @param node 根节点
     * @return 以node为根的最小节点
     */
    private Node minNum(Node node) {
        if (null == node.left) {
            return node;
        }

        return minNum(node.left);
    }

    /**
     * 移除最大元素
     * @return 最大元素值
     */
    public V removeMax() {
        V value = maxNum();
        removeMax(root);
        return value;
    }

    /**
     * 移除最大元素
     * @param node 根节点
     * @return 移除后根节点
     */
    private Node removeMax(Node node) {
        // 如果右子树为空，则根节点为最大节点，删除根节点
        if (null == node.right) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除最小元素
     * @return 最小元素的值
     */
    public V removeMin() {
        V value = minNum();
        removeMin(root);
        return value;
    }

    /**
     * 删除最小元素
     * @param node
     * @return 删除最小节点后的新的二叉搜索树
     */
    private Node removeMin(Node node) {
        // 如果左子树为空，则根节点为最小节点，删除根节点
        if (null == node.left) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除指定元素
     * @param key
     */
    public void remove(K key) {
        root = remove(root, key);
    }

    /**
     * 删除指定元素
     * @param node 节点
     * @param key 待删除的key
     * @return 删除后的根节点
     */
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

            // 左子树为空
            if (null == node.left) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 右子树为空
            if (null == node.right) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树都不为空
            // 找到待删除元素的右子树的最小节点，替换待删除元素
            Node successor = minNum(node.right);
            // successor现在替换了node的位置，就要将successor从原来的位置删除
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = null;
            node.right = null;
            return successor;
        }
    }

    /**
     * 查找key的floor值
     * @param key
     * @return
     */
    public V floor(K key) {
        V value = get(key);
        if (value.compareTo(minNum()) < 0) {
            return null;
        }

        return floor(root, key);
    }

    /**
     * 查找key的floor值
     * @param node
     * @param key
     * @return
     */
    private V floor(Node node, K key) {
        if (null == node) {
            return null;
        }

        // 如果key和当前node的key值相等，node就是key对应的floor节点
        if (key.compareTo(node.key) == 0) {
            return node.value;
        }

        // 如果key比当前node的key值小，那么对应的floor节点肯定在node的左子树
        if (key.compareTo(node.key) < 0) {
            return floor(node.left, key);
        }

        // 如果key比当前node的key值大，node有可能是key对应的floor节点，也有可能不是
        V floor = floor(node.right, key);
        if (floor != null) {
            return floor;
        }

        return node.value;
    }

    /**
     * 查找key的ceil值
     * @param key
     * @return
     */
    public V ceil(K key) {
        V value = get(key);
        if (value.compareTo(maxNum()) > 0) {
            return null;
        }

        return ceil(root, key);
    }

    /**
     * 查找key的ceil值
     * @param node
     * @param key
     * @return
     */
    private V ceil(Node node, K key) {
        if (null == node) {
            return null;
        }

        // 如果key和node值相等，node就是key对应的ceil节点
        if (key.compareTo(node.key) == 0) {
            return node.value;
        }

        // 如果key比node的值大，那么对应的ceil节点肯定在node的右子树
        if (key.compareTo(node.key) > 0) {
            return ceil(node.right, key);
        }

        // 如果key比node的值小，node有可能是key对应的ceil节点，也有可能不是
        V ceil = ceil(node.left, key);
        if (ceil != null) {
            return ceil;
        }

        return node.value;
    }

    /**
     * 求树的深度
     * @return 树的深度
     */
    public int depth() {
        return depth(root);
    }

    /**
     * 求树的深度
     * @return node为节点的书的树的深度
     */
    private int depth(Node node){
        if (null == node) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}

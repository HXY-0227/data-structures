package com.map;

public class LinkedListMap<K, V> implements Map<K, V>{

    public class Node {
        public K key;
        public V value;
        public Node next;

        public Node() {
            this(null, null, null);
        }

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyNode;
    private int size;

    public LinkedListMap() {
        dummyNode = new Node();
        this.size = 0;
    }

    // 获取key对应的节点
    private Node getNode(K key) {
        Node curr = dummyNode.next;
        while (null != curr) {
            if (key.equals(curr.key)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    /**
     * 添加元素
     *
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (null == node) {
            dummyNode.next = new Node(key, value, dummyNode.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyNode;
        while (null != prev.next) {
            if (key.equals(prev.next.key)) {
                break;
            }
            prev = prev.next;
        }

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.value;
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    /**
     * 根据key获取value
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    /**
     * 更新
     *
     * @param key
     * @param newValue
     */
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (null == node) {
            throw new IllegalArgumentException(key + " does not exist");
        }
        node.value = newValue;
    }

    /**
     * 返回map元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        LinkedListMap map = new LinkedListMap();
        map.add("hanixngyu", "0227");
        map.add("limiaomiao", "0504");
        map.add("fengxiao", "0624");
        map.add("yangdan", "0618");
        map.add("qiuyu", "0118");
        map.remove("qiuyu");
        System.out.println(map.getSize() + "--" + map.isEmpty() + "--" + map.contains("qiuyu"));
    }
}

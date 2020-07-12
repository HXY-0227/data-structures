package com.list;

import java.util.HashMap;

/**
 * LRU缓存淘汰策略
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author HXY
 * @date 2020-07-20
 */
public class LRUCache {
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 是否存在
     *      否：值返回-1
     *      是：将原来的节点删除，然后放到链表头，返回数据
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addFirst(node);
            return node.value;
        } else {
            return -1;
        }
    }

    /**
     * 是否存在：
     *     否：创建新节点，并且判断是否超过容量
     *         否：景新节点加到链表头
     *         是：删除队尾节点，插入到链表头
     *     是：更新数据，然后从原来的位置移除，放到头结点
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node node = map.get(key);
        if (null == node) {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addFirst(newNode);
            size++;
            if (capacity < size) {
                map.remove(tail.prev.key);
                removeLast();
                size--;
            }
        } else {
            node.value = value;
            remove(node);
            addFirst(node);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addFirst(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeLast() {
        Node lastNode = tail.prev;
        tail.prev = lastNode.prev;
        lastNode.prev.next =tail;
    }
}

package com.list;

/**
 * 链表
 *
 * @author HXY
 * @since 2020-1-27
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向指定位置添加元素 O(n)
     *
     * @param index 指定索引
     * @param e 新添加元素
     */
    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index is Illegal");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 向链表头部添加元素  O(1)
     *
     * @param e 新元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向链表尾部添加元素 O(n)
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表指定位置的数据
     *
     * @param index 索引
     * @return 取到的值
     */
    public E get(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index is Illegal");
        }

        Node currentNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.e;
    }

    /**
     * 获取链表第一个节点的数据
     *
     * @return 取到的值
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表最后一个节点的数据
     *
     * @return 取到的值
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 更新链表的某个位置的数据 O(n)
     *
     * @param index 索引
     * @param e 更新的值
     */
    public void set(int index, E e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index is Illegal");
        }

        Node currentNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.e = e;
    }

    /**
     * 查找链表中是否包含指定元素  O(n)
     *
     * @param e 待查找的元素
     * @return 查询结果
     */
    public boolean contains(E e) {
        Node currentNode = dummyHead.next;
        while (currentNode != null) {
            if (e.equals(currentNode.e)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * 删除指定索引的元素
     *
     * @param index 索引
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index Illegal");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node deleteNode = prev.next;
        prev.next = deleteNode.next;
        deleteNode.next = null;
        size--;

        return deleteNode.e;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除元素
     *
     * @param e 待删除元素
     */
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (e.equals(prev.next.e)) {
                break;
            }
            prev = prev.next;
        }
        Node deleteNode = prev.next;
        prev.next = deleteNode.next;
        deleteNode.next = null;
        size--;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}

package com.list;

import java.util.NoSuchElementException;

/**
 * 链表：https://gitee.com/hxy-0227/learn-note/blob/master/数据结构/线性表/链表/链表.md
 *
 * @author HXY
 * @since 2020-1-27
 */
public class LinkedList<E> implements List<E>{

    private static class Node<E> {
        E e;
        Node<E> next;

        Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public LinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向链表中添加元素，默认向尾部添加
     *
     * @param e e
     */
    @Override
    public void add(E e) {
        linkLast(e);
    }

    private void linkLast(E e) {
        final Node<E> currNode = tail;
        final Node<E> newNode = new Node<>(e, null);
        tail = newNode;
        if (null == head) {
            head = newNode;
        } else {
            currNode.next = newNode;
        }
        size++;
    }

    /**
     * 向链表头部添加元素
     *
     * @param e e
     */
    @Override
    public void addFirst(E e) {
        linkFirst(e);
    }

    private void linkFirst(E e) {
        final Node<E> newNode = new Node<>(e, head);
        head = newNode;
        if (null == tail) {
            tail = newNode;
        }
        size++;
    }

    /**
     * 向指定位置添加元素
     *
     * @param index index
     * @param e e
     */
    @Override
    public void add(int index, E e) {
        checkIndex(index);
        if (index == 0) {
            linkFirst(e);
        } else if (index == size) {
            linkLast(e);
        } else {
            linkAfter(index, e);
        }
        size++;
    }

    private void linkAfter(int index, E e) {
        Node<E> helpNode = head;
        for (int i = 0; i < index - 1; i++) {
            helpNode = helpNode.next;
        }
        helpNode.next = new Node(e, helpNode.next);
    }

    /**
     * 查找元素
     *
     * @param index index
     * @return E e
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode.e;
    }

    /**
     * 获取第一个元素
     *
     * @return E e
     */
    @Override
    public E getFirst() {
        return null == head ? null : head.e;
    }

    /**
     * 获取最后一个元素
     *
     * @return E e
     */
    @Override
    public E getLast() {
        return null == tail ? null : tail.e;
    }

    /**
     * 判断链表是否包含指定元素
     *
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        for (Node<E> x = head; x != null; x = x.next) {
            if (x.e == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    @Override
    public E removeFirst() {
        if (null == head) {
            throw new NoSuchElementException("List is empty");
        }
        return unlinkFirst();
    }

    private E unlinkFirst() {
        final Node<E> helpNode = head;
        E e = helpNode.e;
        head = helpNode.next;
        if (null == head) {
            tail = null;
        }
        helpNode.next = null;
        helpNode.e = null;
        size--;
        return e;
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    @Override
    public E removeLast() {
        return unlink(size - 2);
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        return unlink(index - 2);
    }

    private E unlink(int index) {
        checkIndex(index);

        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        Node<E> deleteNode = node.next;
        E deleteElement = deleteNode.e;
        node.next = deleteNode.next;

        deleteNode.next = null;
        deleteNode.e = null;
        size--;
        return deleteElement;
    }

    /**
     * 删除指定元素
     *
     * @param e
     * @return
     */
    @Override
    public boolean remove(E e) {
        return removeElement(e);
    }

    private boolean removeElement(E e) {
        if (head != null && head.e == e) {
            removeFirst();
            return true;
        } else {
            Node<E> helpNode = head;
            while (helpNode != null && helpNode.next != null) {
                if (e.equals(helpNode.next.e)) {
                    break;
                }
                helpNode = helpNode.next;
            }
            if (null != helpNode && null != helpNode.next) {
                Node<E> deleteNode = helpNode.next;
                if (deleteNode.e == tail.e) {
                    tail = helpNode;
                }
                helpNode.next = deleteNode.next;
                deleteNode.next = null;
                deleteNode.e = null;
                size--;
                return true;
            }
            return false;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is invalid");
        }
    }
}

package com.queue;

/**
 * 用链表实现队列，只在队首出队，在队尾入队，这样保证出队和入队都能保证O(1)的时间复杂度
 * https://gitee.com/hxy-0227/learn-note/blob/master/数据结构/线性表/队列/队列.md
 *
 * @author HXY
 * @since 2020-1-27 抗击病毒第三天
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        this.tail = null;
        this.head = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }

        Node node = head;
        head = head.next;
        node.next = null;

        if (head == null) {
            tail = null;
        }
        size--;
        return node.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }

        return head.e;
    }
}

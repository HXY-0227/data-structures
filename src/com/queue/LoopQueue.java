package com.queue;

/**
 * 循环队列对数组的实现方式做了优化，出队和入队时间复杂度为O(1)
 *
 * @author HXY
 * @since 2020-1-28
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int rear;
    private int size;

    public LoopQueue(int capacity) {
        // 因为用了front = size - 1判断队列满，
        // 所以实际初始化capacity的队列只能放capacity - 1个元素
        data = (E[]) new Object[capacity + 1];
        front = 0;
        rear = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public void enqueue(E e) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("queue is full");
        }
        data[rear] = e;
        rear = (rear + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }

        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return result;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }

    // 队列是否满
    private boolean isFull() {
        if (size == 0) {
            return false;
        }
        return (rear + 1) % data.length == front;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, data.length - 1));
        res.append("front [");
        for(int i = front ; i != rear ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != rear) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}

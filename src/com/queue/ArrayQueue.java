package com.queue;

import com.array.Array;

/**
 * 动态数组实现队列：https://gitee.com/hxy-0227/learn-note/blob/master/数据结构/线性表/队列/队列.md
 *
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("com.queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}

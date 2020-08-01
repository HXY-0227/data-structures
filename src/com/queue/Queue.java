package com.queue;

/**
 * 队列接口
 *
 * @author HXY
 * @date 2020-08-01
 * @param <E>
 */
public interface Queue<E> {

    /**
     * 队列中元素的个数
     *
     * @return size
     */
    int getSize();

    /**
     * 队列是否为空
     *
     * @return e
     */
    boolean isEmpty();

    /**
     * 入队
     *
     * @param e e
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return e
     */
    E dequeue();

    /**
     * 查看对头元素
     *
     * @return e
     */
    E getFront();
}

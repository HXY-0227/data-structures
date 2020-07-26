package com.stack;

/**
 * 栈的接口设计
 *
 * @author HXY
 * @date 2020-07-25
 * @param <E>
 */
public interface Stack<E> {

    /**
     * 获取栈中元素的个数
     *
     * @return e
     */
    int getSize();

    /**
     * 是否空栈
     *
     * @return e
     */
    boolean isEmpty();

    /**
     * 入栈操作
     *
     * @param e e
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return e
     */
    E pop();

    /**
     * 读取栈顶元素。不出栈
     *
     * @return e
     */
    E peek();
}

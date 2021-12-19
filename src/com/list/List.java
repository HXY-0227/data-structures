package com.list;

/**
 * 通过添加头结点和尾结点的指针。优化尾插法的时间复杂度
 *
 * @author HXY
 * @date 2020-07-11
 * @param <E>
 */
public interface List<E> {
    /**
     * 向链表中添加元素，默认向尾部添加
     *
     * @param e e
     */
    void add(E e);

    /**
     * 向链表头部添加元素
     *
     * @param e e
     */
    void addFirst(E e);

    /**
     * 向指定位置添加元素
     *
     * @param index index
     * @param e e
     */
    void add(int index, E e);

    /**
     * 查找元素
     *
     * @param index index
     * @return E e
     */
    E get(int index);

    /**
     * 获取第一个元素
     *
     * @return E e
     */
    E getFirst();

    /**
     * 获取最后一个元素
     *
     * @return E e
     */
    E getLast();

    /**
     * 判断链表是否包含指定元素
     *
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 删除第一个元素
     *
     * @return
     */
    E removeFirst();

    /**
     * 删除最后一个元素
     *
     * @return
     */
    E removeLast();

    /**
     * 删除指定位置的元素
     *
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 删除指定元素
     *
     * @param e
     * @return
     */
    boolean remove(E e);
}

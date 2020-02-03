package com.set;

import com.list.LinkedList;

/**
 * 链表实现set集合
 *
 * @author HXY
 * @since 2020-2-3 武汉加油
 *
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList list;

    public LinkedListSet() {
        list = new LinkedList();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {   // 时间复杂度O(N)
            list.addFirst(e);      // O(1)
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);   // O(N)
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);   // O(N)
    }
}

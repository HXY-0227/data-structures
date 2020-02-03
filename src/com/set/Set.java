package com.set;

public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean isEmpty();
    int getSize();
    boolean contains(E e);
}

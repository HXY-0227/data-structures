package com.stack;

import com.list.LinkedList;

/**
 * 链式栈的实现
 *
 * @author HXY
 * @date 2020-07-25
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for (int i = getSize() - 1; i >= 0; i--) {
            res.append(list.get(i));
            res.append(i != 0 ? ", " : "");
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        System.out.println(stack);
        for (int i = 0; i < 3; i++) {
            System.out.println(stack.pop());
        }
        System.out.println(stack);
    }
}

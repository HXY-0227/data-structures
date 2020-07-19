package com.list;

public class JosephProblem {
    private static class Node {
        int item;
        Node next;
        public Node(int item) {
            this.item = item;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    public void add(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        tail.next = head;
        size++;
    }

    public int remove(int M) {
        Node currNode = head;
        for (int i = 1; i < M - 1; i++) {
            currNode = currNode.next;
        }
        Node deleteNode = currNode.next;
        currNode.next = deleteNode.next;
        head = deleteNode.next;
        size--;
        return deleteNode.item;
    }

    public int get() {
        return head.item;
    }

    public static void main(String[] args) {
        JosephProblem jp = new JosephProblem();
        jp.add(1);
        jp.add(2);
        jp.add(3);
        jp.add(4);
        jp.add(5);
        jp.add(6);

        while (jp.size() != 1) {
            System.out.printf("the ID %d is killed \n", jp.remove(4));
            if (jp.size == 1) {
                break;
            }
        }
        System.out.printf("the remainder number is %d and the survivor ID is %d", jp.get(), jp.get());
    }
}

package com.skipList;

/**
 * 跳跃表的节点的构成
 * @param <E>
 */
public class SkipNode<E> {

    //存储的数据
    private E val;

    //分值，排序用
    private double score;

    //指向下一个节点的指针
    private SkipNode<E> next;

    //指向下一个层的指针
    private SkipNode<E> down;

    public SkipNode() {

    }

    public SkipNode(E val, double score) {
        this.val = val;
        this.score = score;
    }

    public E getVal() {
        return val;
    }

    public void setVal(E val) {
        this.val = val;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public SkipNode<E> getNext() {
        return next;
    }

    public void setNext(SkipNode<E> next) {
        this.next = next;
    }

    public SkipNode<E> getDown() {
        return down;
    }

    public void setDown(SkipNode<E> down) {
        this.down = down;
    }
}

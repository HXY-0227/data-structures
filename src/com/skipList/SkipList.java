package com.skipList;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * 跳跃表
 *
 * @author HXY
 * date 2020-08-09
 */
public class SkipList<T> {
    // 最大层数
    private static final int MAX_LEVEL = 1 << 5;

    // 用来计算层级是平衡概率
    private static final double SKIPLIST_P = 0.25;

    private class Node<E> {
        // 存储的数据
        E val;

        // 分值，排序用
        double score;

        // 层
        Node<E>[] level;

        public Node(E val, double score, int level) {
            this.val = val;
            this.score = score;
            this.level = new Node[level];
        }
    }

    private int level = 1;
    private int size = 0;
    private Node header;
    private Node tail;

    /**
     * 跳跃表的初始化
     */
    public SkipList(){
        header = new Node(null, 0, MAX_LEVEL);
        tail = null;
        for (int i = 0; i < MAX_LEVEL; i++) {
            header.level[i] = null;
        }
    }

    /**
     * 插入节点
     *
     * @param score score
     * @param val val
     */
    public void put(double score, T val) {

    }

    

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        System.out.println("------");
    }
}
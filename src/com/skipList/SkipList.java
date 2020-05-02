package com.skipList;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * 实现跳跃表：能够对递增链表实现logN的查询时间
 * @param <T>
 */
public class SkipList<T> {
    private class Node<E> {
        //存储的数据
        E val;

        //分值，排序用
        double score;

        //指向下一个节点的指针
        Node next;

        //指向下一个层的指针
        Node down;

        public Node(E val, double score) {
            this.val = val;
            this.score = score;
        }
    }

    private static final int MAX_LEVEL = 1 << 6;

    private Node<T> top;
    private int level = 0;
    private Random random = new Random();

    /**
     * 跳跃表的初始化
     * @param level
     */
    public SkipList(int level){
        this.level = level;
        int i = level;
        Node<T> temp = null;
        Node<T> prev = null;
        while (i-- != 0) {
            temp = new Node<T>(null, Double.MIN_VALUE);
            temp.down = prev;
            prev = temp;
        }

        top = temp;
    }

    /**
     * 产生节点的高度。使用抛硬币
     * @return lev
     */
    public int getRandomLevel() {
        int lev = 1;
        while (random.nextInt() % 2 == 0) {
            lev ++;
        }
        return lev > MAX_LEVEL ? MAX_LEVEL : lev;
    }

    /**
     * 查找
     * @param score
     * @return T
     */
    public T get(double score) {

        Node<T> t = top;
        while (t != null) {
            if (t.score == score) {
                return t.val;
            }

            if (t.next == null) {
                if (t.down != null) {
                    t = t.down;
                    continue;
                }else {
                    return null;
                }
            }

            if (t.next.score > score) {
                t = t.down;
            } else {
                t = t.next;
            }

        }

        return null;
    }

    /**
     * 插入节点
     * @param score
     * @param val
     */
    public void put(double score, T val) {
        Node<T> t = top, cur = null;
        //记录每一层当前节点的前驱结点
        List<Node<T>> path = new ArrayList<>();
        while (t != null) {
            if (score == t.score) {
                cur = t;
                break;//表示存在该值的点，表示需要更新该节点
            }
            if (t.next == null) {
                path.add(t);//需要向下查找，先记录该节点
                if (t.down != null) {
                    t = t.down;
                    continue;
                } else {
                    break;
                }
            }
            if (t.next.score > score) {
                path.add(t);//需要向下查找，先记录该节点
                if (t.down == null) {
                    break;
                }
                t = t.down;
            } else
                t = t.next;
        }
        if (cur != null) {
            while (cur != null) {
                cur.val = val;
                cur = cur.down;
            }
        } else {//当前表中不存在score值的节点，需要从下到上插入
            int lev = getRandomLevel();
            if (lev > level) {//需要更新top这一列的节点数量，同时需要在path中增加这些新的首节点
                Node<T> temp = null;
                Node<T> prev = top;//前驱节点现在是top了
                while (level++ != lev) {
                    temp = new Node<T>(null, Double.MIN_VALUE);
                    path.add(0, temp);//加到path的首部
                    temp.down = prev;
                    prev = temp;
                }
                top = temp;//头节点
                level = lev;//level长度增加到新的长度
            }
            //从后向前遍历path中的每一个节点，在其后面增加一个新的节点
            Node<T> downTemp = null, temp = null, prev = null;
//            System.out.println("当前深度为"+level+",当前path长度为"+path.size());
            for (int i = level - 1; i >= level - lev; i--) {
                temp = new Node<T>(val, score);
                prev = path.get(i);
                temp.next= prev.next;
                prev.next = temp;
                temp.down = downTemp;
                downTemp = temp;
            }
        }
    }

    /**
     * 删除节点
     * @param score
     */
    public void remove(double score) {
        //1,查找到节点列的第一个节点的前驱
        Node<T> t = top;
        while (t != null) {
            if (t.next == null) {
                t = t.down;
                continue;
            }
            //此处应当随着每一层的查找，删除其对应的节点，因为不同层链表之间的数目是不确定的
            if (t.next.score == score) {
                t.next = t.next.next;
                t = t.down;
                continue;
            }
            if (t.next.score > score) {
                t = t.down;
            } else {
                t = t.next;
            }
        }
    }
}
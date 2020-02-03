package com.set;

/**
 * 二叉搜索树实现set集合
 *
 * @author HXY
 * @since 2020-2-3 武汉加油
 *
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST();
    }

    @Override
    public void add(E e) {
        bst.add(e);  //时间复杂度 O(logN) 平均，最差会退化成链表
    }

    @Override
    public void remove(E e) {
        bst.remove(e);  //时间复杂度 O(logN) 平均
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);   //时间复杂度 O(logN) 平均
    }

    public static void main(String[] args) {
        BSTSet set = new BSTSet();
        set.add(16);
        set.add(8);
        set.add(20);
        set.add(3);
        set.add(9);
        set.add(18);
        set.add(21);
        set.remove(16);
        System.out.println(set.getSize() + "----" + set.contains(16) + "----" + set.isEmpty());
    }
}

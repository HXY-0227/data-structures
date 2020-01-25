package com.heap;

import com.array.Array;

import java.util.Random;

/**
 * 最大堆
 *
 * @author HXY
 * @since 2020-1-18
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    /**
     * 构造固定容量的最大堆
     *
     * @param capacity 容量
     */
    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * 默认构造函数
     */
    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 将任意一个数组转化成最大堆的构造函数，时间复杂度O(N), 遍历构造的时间复杂度为O(nlogN)
     *
     * @param arr 数组
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = getParentIndex(arr.length - 1); i >=0; i--) {
            siftDown(i);
        }
    }

    /**
     * 返回堆中元素的个数
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 判断堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 获取父元素的索引
     *
     * @param index
     * @return
     */
    private int getParentIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 does not hava parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 获取左孩子的索引
     *
     * @param index
     * @return
     */
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * 获取右孩子的索引
     *
     * @param index
     * @return
     */
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 堆中元素的上浮
     *
     * @param index 要上浮元素的索引
     */
    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo
                (data.get(getParentIndex(index))) > 0) {
            data.swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    /**
     * 发现堆中的最大元素
     *
     * @return
     */
    public E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Can not find max because the heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {
        E maxItem = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return maxItem;
    }

    /**
     * 堆中元素的下沉
     *
     * @param index
     */
    private void siftDown(int index) {
        int childIndex = 0;
        while (getLeftChildIndex(index) < data.getSize()) {
            childIndex = getLeftChildIndex(index);
            // 找到两个孩子中最大的节点
            if (childIndex + 1 < data.getSize() &&
                    data.get(childIndex + 1).compareTo(data.get(childIndex)) > 0) {
                childIndex = getRightChildIndex(index);
            }
            if (data.get(index).compareTo(data.get(childIndex)) >= 0) {
                break;
            }
            data.swap(index, childIndex);
            index = childIndex;
        }
    }

    /**
     * 取出堆中最大元素，并替换
     *
     * @param e
     * @return 堆中的最大元素
     */
    public E replace(E e) {
        E maxItem = findMax();
        data.set(0, e);
        siftDown(0);
        return maxItem;
    }

    public static void main(String[] args) {
        int n = 10000;
        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i-1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }

        }
        System.out.println("OK");
    }

}

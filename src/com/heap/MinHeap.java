package com.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小堆
 *
 * @author HXY
 * @param <E>
 */
public class MinHeap<E extends Comparable<E>> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_INDEX = 1;
    private int size;
    private E[] array;

    /**
     * 构造函数，构造指定容量的最小堆
     */
    public MinHeap(int capacity) {
        array = (E[]) new Comparable[capacity];
        size = 0;
    }

    /**
     * 构造函数，构造容量为10的最小堆
     */
    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 构造函数，将一个数组转化为最小堆
     *
     * @param items 数组
     */
    public MinHeap(E[] items) {
        this(items.length);
        for (int i = 1; i <= items.length; i++) {
            array[i] = items[i];
        }
        buildHeap();
        size = items.length;
    }

    private void buildHeap() {
        for (int i = size / 2; i > 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 查找最大元素
     *
     * @return 堆顶元素
     */
    public E findMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not find max because the heap is empty.");
        }

        return array[0];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Comparable[newCapacity];
        System.arraycopy(array, 0, newData, 0, array.length);
        array = newData;
    }

    /**
     * 添加元素
     *
     * @param e e
     */
    public void insert(E e) {

        if (array.length - 1 == size) {
            resize(2 * array.length + 1);
        }

        // 如果使用交换的方法，需要三次赋值，一个元素上浮d层，就需要3d次赋值，我们这个方法优化可以只用d+1次赋值
        int hole = ++size;
        for (array[0] = e; e.compareTo(array[hole / 2]) > 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = e;
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     */
    public E deleteMax() {
        E minItem = findMax();
        array[1] = array[size];
        array[size--] = null;
        siftDown(MAX_INDEX);

        // 当元素个数变成总容量的1/4的时候，释放内存到
        if (size == array.length / 4 && array.length / 2 != 0) {
            resize(array.length / 2);
        }
        return minItem;
    }

    /**
     * 下沉操作
     *
     * @param hole 开始下沉的位置
     */
    private void siftDown(int hole) {
        int child = 0;
        E tmp = array[hole];
        for (; hole * 2 <= size; hole = child) {
            child = hole * 2;
            if (child != size && array[child + 1].compareTo(array[child]) > 0) {
                child++;
            }
            if (array[child].compareTo(tmp) > 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }

//    public static void main(String[] args) {
//        int[] arr = new int[] {99, 71, 56, 45, 31, 21, 30, 15, 18};
//
//        MinHeap<Integer> heap = new MinHeap<>();
//        for (int value : arr) {
//            heap.insert(value);
//        }
//        heap.insert(80);
//        heap.deleteMax();
//    }

}

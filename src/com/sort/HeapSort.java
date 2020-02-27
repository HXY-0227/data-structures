package com.sort;

/**
 * 堆排序
 *
 * @Author HXY
 * @Date 2020/2/27
 */
public class HeapSort {

    // 下沉操作调整堆 O(logN)
    private static void siftDown(int[] arr, int index, int size) {
        int child = 0;
        int tmp = arr[index];
        for (; getLeft(index) < size; index = child) {
            // 找到左右孩子中较大的元素
            child = getLeft(index);
            if (child != size - 1 &&
                    arr[getLeft(index)] < arr[getRight(index)]) {
                child = getRight(index);
            }
            if (tmp < arr[child]) {
                arr[index] = arr[child];
            } else {
                break;
            }
        }
        arr[index] = tmp;
    }

    // 构建堆
    private static void buildHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }
    }

    // 获取节点的左孩子索引
    private static int getLeft(int index) {
        return 2 * index + 1;
    }

    // 获取节点的右孩子索引
    private static int getRight(int index) {
        return 2 * index + 2;
    }

    private static void swapReference(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     *
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swapReference(arr, 0, i);
            siftDown(arr,0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{150, 80, 40, 30, 10, 70, 110, 100, 20, 90, 60, 50, 120, 140};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

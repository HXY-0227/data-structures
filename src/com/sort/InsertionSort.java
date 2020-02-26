package com.sort;

/**
 * 插入排序
 *
 * @Author HXY
 * @Date 2020/2/25
 */
public class InsertionSort {


    /*
    方案1
    public static void sort(int[] arr) {

        int j = 0;
        for (int i = 1; i < arr.length; i++) {

            for (j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }*/

    // 直接插入排序 方案1的优化 没有明显的使用交换方法
    public static void insertSort(int[] arr) {
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for (j = i; j > 0 && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    // 折半插入排序
    public static void binaryInsertSort(int[] arr) {
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            int low = 0, high = i - 1, mid = 0;
            int tmp = arr[i];
            while (low <= high) {
                mid = (low + high) / 2;
                if (arr[i] < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (j = i; j > high + 1; j--) {
                arr[j] = arr[j - 1];
            }
            arr[high + 1] = tmp;
        }
    }

    // 希尔排序
    public static void shellSort(int[] arr) {
        int j = 0;
        // 1. 分组
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 2. 对每个组进行插入排序
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                for (j = i; j >= gap && tmp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8, 1, 4, 9, 6, 3, 5, 2, 7, 0};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

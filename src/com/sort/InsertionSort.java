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

    // 方案1的优化 没有明显的使用交换方法
    public static void sort(int[] arr) {
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for (j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {34, 8, 64, 51, 32, 21};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

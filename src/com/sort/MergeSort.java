package com.sort;

/**
 * 归并排序: https://gitee.com/hxy-0227/learn-note/blob/master/数据结构/排序/归并排序.md
 *
 * @author HXY
 * @Date 2020/2/28
 */
public class MergeSort {

    /**
     * 归并两个数组到一个数组，分而治之的治
     *
     * @param arr 原始数组
     * @param tmpArr 存放合并结果的数组
     * @param leftPos 子数组最左边的索引
     * @param rightPos 第二部分数组的开始位置
     * @param rightEnd
     */
    private static void merge(int[] arr, int[] tmpArr, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] <= arr[rightPos]) {
                tmpArr[tmpPos++] = arr[leftPos++];
            } else {
                tmpArr[tmpPos++] = arr[rightPos++];
            }
        }
        // 拷贝左边数组的剩余元素到临时数组
        while (leftPos <= leftEnd) {
            tmpArr[tmpPos++] = arr[leftPos++];
        }
        // 拷贝右边数组的剩余元素到临时数组
        while (rightPos <= rightEnd) {
            tmpArr[tmpPos++] = arr[rightPos++];
        }
        // 拷贝临时数组的元素到给定数组，实现排序
        for (int i = 0; i < numElements; i++, rightEnd--) {
            arr[rightEnd] = tmpArr[rightEnd];
        }
    }

    /**
     * 归并排序，分而治之的分
     *
     * @param arr 原始数组
     * @param tmpArr 存放合并结果的临时数组
     * @param left 最左边索引
     * @param right 最右边索引
     */
    private static void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, tmpArr, left, center);
            mergeSort(arr, tmpArr, center + 1, right);
            merge(arr, tmpArr, left, center + 1, right);
        }
    }

    public static void mergeSort(int[] arr) {
        int[] tmpArr = new int[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length - 1);
    }
}

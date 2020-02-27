package com.sort;

/**
 * 快速排序
 *
 * @Author HXY
 * @Date 2020/2/26
 */
public class QuickSort {

    // 当序列元素个数少于这个界限则使用快速排序
    // 小规模数据用插入排序效率更高
    private static final int CUTOFF = 10;

    /**
     * 快速排序
     *
     * @param arr 待排序的数组
     * @param left 数组最左边的元素索引
     * @param right 数组最右边的元素索引
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left + CUTOFF < right) {
            int pivot = media3(arr, left, right);
            int i = left, j = right - 1;
            for ( ; ;) {
                // ++i，--j 实际上是在24行后，已经将left, right, (left + right) / 2中最小的放到了0位，
                // 最大的放到了最后一位，将中值放到了倒数第二位，所以分割的时候i从left+1开始，j从right-2开始
                while (arr[++i] < pivot) {}
                while (arr[--j] > pivot) {}
                if (i < j) {
                    swapReferences(arr, i, j);
                } else {
                    break;
                }

            }
            swapReferences(arr, i , right - 1);
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        } else {
            insertSort(arr, left, right);
        }
    }

    private static void insertSort(int[] arr, int left, int right) {
        int j = 0;
        for (int i = left + 1; i <= right; i++) {
            int tmp = arr[i];
            for (j = i; j > 0 && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    /**
     * 三数中值法选定枢纽元,取left，right, (left + right) / 2三数的中间值，并将三数中最小的放到arr[left]
     * 最大的放到arr[right]，枢纽元放到arr[right - 1]
     *
     * @param arr 待排序数组
     * @param left 数组的第一位元素索引
     * @param right 数组的最后一位元素索引
     * @return 枢纽元 pivot
     */
    private static int media3(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[center] < arr[left]) {
            swapReferences(arr, left, center);
        }
        if (arr[right] < arr[left]) {
            swapReferences(arr, left, right);
        }
        if (arr[right] < arr[center]) {
            swapReferences(arr, center, right);
        }
        swapReferences(arr, center, right - 1);
        return arr[right - 1];
    }

    private static void swapReferences(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8, 1, 4, 9, 6, 3, 5, 2, 7, 0};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

package com.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : HXY
 * @date : 2020-10-18 16:08
 **/
public class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (Integer num : arr) {
            queue.add(num);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] arr = new int[]{3, 2, 1};
        int k = 2;
        int[] leastNumbers = solution40.getLeastNumbers(arr, k);
        for (int i = 0; i < leastNumbers.length; i++) {
            System.out.println(leastNumbers[i]);
        }
    }
}

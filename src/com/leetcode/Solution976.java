package com.leetcode;

import com.array.Array;

import java.util.Arrays;

/**
 * @Author HXY
 * @Date 2020/2/29
 */
public class Solution976 {
    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i - 2 >= 0; i--) {
            if (A[i - 1] + A[i - 2] > A[i]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,2};
        System.out.println(largestPerimeter(arr));
    }
}

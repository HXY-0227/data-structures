package com.leetcode;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 求最大子序列的和
 * @author HXY
 * @since 2020-6-30
 */
public class Solution53 {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2,1};
        System.out.println(maxSubArray(nums));
    }
}

package com.leetcode;

import java.util.Arrays;

/**
 * @Author HXY
 * @Date 2020/2/29
 */
public class Solution220 {
    // nums = [1,0,1,1], k = 1, t = 2   nums [j] - nums [i] <= t, j - i <= k
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i - k >= 0 && nums[i] - nums[i - k] <= t) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1};
        System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));
    }
}

package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 给定 nums = [2, 7, 11, 15], target = 9  返回 [0, 1]
 */
public class Solution1 {

    /**
     * 暴力破解
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        // int[] index = new int[2];  没必要new数组

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                    // break;
                }
            }
        }

        throw new IllegalArgumentException("No answer");
    }

    /**
     * 两遍哈希法，时间复杂度降低为O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement)  != i) {
                return new int[] {i, map.get(complement)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        twoSum(nums, target);
    }
}

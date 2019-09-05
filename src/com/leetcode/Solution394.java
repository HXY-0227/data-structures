package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * nums1 = [1,2,2,1], nums2 = [2,2]   ---->  [2]
 */
public class Solution394 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        // 也可以用retainAll方法，求交集
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,2,1};
        int[] arr2 = new int[]{2,2};

        int[] result = intersection(arr1, arr2);

        for (int num : result) {
            System.out.println(num + " ");
        }

    }
}

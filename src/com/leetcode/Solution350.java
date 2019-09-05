package com.leetcode;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * nums1 = [1,2,2,1], nums2 = [2,2]   ---->  [2]
 */
public class Solution350 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num,map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4,9,5};
        int[] arr2 = new int[]{9,4,9,8,4};

        int[] result = intersect(arr1, arr2);

        for (int num : result) {
            System.out.print(num + " ");
        }

    }
}

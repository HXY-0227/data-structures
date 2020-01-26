package com.leetcode;

import java.util.*;

/**
 * leetcode347 https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class Solution347 {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );

        for (int key: map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }

        LinkedList<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.add(queue.remove());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,1,2,2,3,3,3};
//        topKFrequent(arr,2);
        System.out.println(topKFrequent(arr, 2));
    }
}

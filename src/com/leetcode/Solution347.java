package com.leetcode;

import java.util.*;

/**
 * leetcode347 https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class Solution347 {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        // 第一步，建立一个key：元素值----value：出现频率的哈希表
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

        // 维护一个大小为k的最小堆，每次新加元素和堆顶元素进行比较，如果新元素的频率大于堆顶元素，则将堆顶元素
        // 替换为新加入的元素，
        for (int key: map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }

        // 输出堆
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

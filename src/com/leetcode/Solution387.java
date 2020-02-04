package com.leetcode;

import com.map.Map;

import java.util.HashMap;

public class Solution387 {
    public int firstUniqChar(String s) {
        // 方案1
        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (result[s.charAt(i) -'a'] == 1) {
                return i;
            }
        }
        return -1;

        // 方案2
        /*HashMap<Character, Integer> result = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (result.containsKey(s.charAt(i))) {
                result.put(s.charAt(i), result.get(s.charAt(i)) + 1);
            } else {
                result.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (result.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;*/
    }

    public static void main(String[] args) {
        Solution387 solution = new Solution387();
        System.out.println(solution.firstUniqChar(""));
    }
}

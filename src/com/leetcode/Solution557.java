package com.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution557 {
    public static String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String str : strArr ) {
            result.append(new StringBuilder(str).reverse() + " ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}

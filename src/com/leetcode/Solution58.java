package com.leetcode;

/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class Solution58 {

    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        if (arr.length > 0) {
            return arr[arr.length - 1].length();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello world "));
    }
}

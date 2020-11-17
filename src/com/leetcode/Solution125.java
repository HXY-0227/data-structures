package com.leetcode;

/**
 * leetcode 125. 验证回文串
 *
 * @author : HXY
 * @since  : 2020-11-17 23:48
 **/
public class Solution125 {

    public static boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "race a car";
        System.out.println(isPalindrome(str));
    }
}

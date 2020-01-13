package com.leetcode;

import java.util.Arrays;

public class Solution820 {

    public static int minimumLengthEncoding(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
        }
        Arrays.sort(words);
        for (int i = 0; i <words.length - 1; i++) {
            if (!words[i+1].startsWith(words[i])) {
                count += words[i].length() + 1;
            }
        }
        count += words[words.length-1].length() + 1;
        return count;
    }

    public static String reverse(String param) {
        StringBuffer sb = new StringBuffer(param);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String[] words = new String[]{"time"};
        System.out.println(minimumLengthEncoding(words));
    }
}

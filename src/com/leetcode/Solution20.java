package com.leetcode;

import java.util.Stack;

public class Solution20 {
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character pop = stack.pop();
                if ('(' == pop && ')' != c) {
                    return false;
                } else if ('[' == pop && ']' != c) {
                    return false;
                } else if ('{' == pop && '}' != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String param = "(]";
        boolean valid = isValid(param);
        System.out.println(valid);
    }
}

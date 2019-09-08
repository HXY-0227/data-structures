package com.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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

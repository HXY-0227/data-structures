package com.leetcode;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/submissions/
 */
public class Solution509 {
    public static int fib(int N) {
        if (N <= 1) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}

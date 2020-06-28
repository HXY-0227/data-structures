package com.leetcode;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * 
 * 判断一个数是不是2的N次幂
 * 3 011  等于100取反 也等于4 - 1
 * 4 100  &
 * ---------
 *   000
 */
public class Solution231 {
    public static boolean isPowerOfTwo(int n) {
        if(n == 0) {
            return false;
        }
        long num = (long)n;
        return (num & (num - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }
}

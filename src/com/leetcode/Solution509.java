package com.leetcode;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/submissions/
 */
public class Solution509 {

    /**
     * 采用这种递归的方法，时间复杂度是2的N次方级别的，性能最差
     *
     * @param N
     * @return
     */
    public static int fib1(int N) {
        if (N <= 1) {
            return 1;
        }
        return fib1(N - 1) + fib1(N - 2);
    }

    /**
     * 通过一个辅助的数组去做，时间复杂度O(N),空间复杂度O(N)
     *
     * @param N
     * @return
     */
    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return memoize(N);
    }

    private static int memoize(int N) {
        int[] cache = new int[N + 1];
        cache[1] = 1;
        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[N];
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}

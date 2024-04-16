package com.mimu.simple.java.leetcode;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 * <p>
 * Example 1:
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * Example 2:
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * Example 3:
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * Note:
 * 0 ≤ N ≤ 30.
 * <p>
 * 斐波那契数字
 */
public class LCTest_DP_509_Fib {
    /**
     * 递归算法
     * F(N) = F(N - 1) + F(N - 2)
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
     * 根据定义，计算当前数值时，只需要其 前两个 数字 并相加 即可；
     * 因此 我们可以使用 三个 数 来记录 前两个 数字 和当前的 和，并同时 后--> 前；和-->后 即可
     * F(N) = F(N - 1) + F(N - 2)
     *
     * @param n
     * @return
     */
    public int fibAnother(int n) {
        if (n < 2) {
            return n;
        }
        int first = 0, last = 1, result = 0; // 使用三个数字 记录 前 后 和结果
        for (int i = 2; i <= n; i++) {
            result = first + last; // 计算结果
            first = last; // 后 ---赋值---> 前
            last = result; // 结果 ---赋值--->后
        }
        return result; // 返回结果
    }

}

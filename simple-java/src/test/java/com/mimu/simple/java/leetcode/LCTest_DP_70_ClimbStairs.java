package com.mimu.simple.java.leetcode;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * Constraints:
 * 1 <= n <= 45
 * <p>
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
 */
public class LCTest_DP_70_ClimbStairs {

    /**
     * F(N) = F(N - 1) + F(N - 2),
     * 我们可以使用 三个 数 来记录 前两个 数字 和当前的 和，并同时 后--> 前；和-->后 即可
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1, last = 2, result = 0;
        for (int i = 3; i <= n; i++) {
            result = first + last;
            first = last;
            last = result;
        }
        return result;
    }

    /**
     * 动态规划
     * 1.定义 int[] dp 数组：dp[i] 表示 爬第i阶楼梯 的方法数
     * 2.明确递推公式：dp[i] = dp[i - 1] + dp[i - 2];
     * 3.初始化 对于 n>2 的 情形：dp[0] = 1;dp[1] = 2;
     * 4.循环递推：从i=2 开始递推：
     * 5.明确返回结果：dp[n - 1] 即为结果
     *
     * @param n
     * @return
     */
    public int climbStairs_dp(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * 递归方法
     * F(N) = F(N - 1) + F(N - 2),
     *
     * @param n
     * @return
     */
    public int climbStairs_re(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

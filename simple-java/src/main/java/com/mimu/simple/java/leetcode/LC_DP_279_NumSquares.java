package com.mimu.simple.java.leetcode;

/**
 * Given a positive integer  n , find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to  n.
 * Example 1
 * Input: _n_ = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * Input: _n_ = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * <p>
 * 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class LC_DP_279_NumSquares {

    /**
     * 动态规划
     * 1.定义dp数组：int[n+1] dp，dp[i] 表示 和为 i 的完全平方数的最少数量
     * 2.明确递推公式：dp[i]= min = Math.min(min, dp[i - j * j])+1;
     * 3.初始化：int[] dp = new int[n + 1] 全 0 的数组
     * 4.循环递推：
     * 5 确认结果：
     * <p>
     * 我们可以依据题目的要求写出状态表达式：dp[i] 表示最少需要多少个数的平方来表示整数i。这些数必然落在区间 [1,n^1/2],我们可以枚举这些数，
     * 假设当前枚举到 j，那么我们还需要取若干数的平方，构成 i−j^2; 此时我们发现该子问题和原问题类似，只是规模变小了。
     * 这符合了动态规划的要求，于是我们可以写出状态转移方程。
     * *         [i^1/2]
     * * dp[i]=1 + min dp[i-j^2]
     * *           j=1
     * 其中 dp[0]=0 为边界条件，实际上我们无法表示数字 0，只是为了保证状态转移过程中遇到 j 恰为 i^1/2 的情况合法。
     * 同时因为计算 dp[i] 时所需要用到的状态仅有 dp[i-j^2],必然小于 i，因此我们只需要从小到大地枚举 i 来计算 dp[i]即可；
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}

package com.mimu.simple.java.leetcode;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * Example 1:
 * **Input:** coins = [1,2,5], amount = 11
 * **Output:** 3
 * **Explanation:** 11 = 5 + 5 + 1
 * Example 2:
 * **Input:** coins = [2], amount = 3
 * **Output:** -1
 * Example 3:
 * **Input:** coins = [1], amount = 0
 * **Output:** 0
 * Constraints:
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的
 */
public class LC_DP_322_CoinChange {

    /**
     * 动态规划
     * 1.定义dp数组：int[amount+1] dp，dp[i] 表示兑换的钱数为i时所需的最少硬币数；
     * 2.明确递推公式 ：dp[i] = Math.min(dp[i], dp[i - coin] + 1); 这里 coin 要取遍数组 coins中的所有值；
     * 3.初始化：dp[i] = int[]{amount+1}
     * 4.循环递推：
     * 5.确认结果：
     * <p>
     * <p>
     * 以实例说明：coins 中有1，2，5三种硬币；dp[0]=0;dp[1]=1 使用一个1角的硬币即可；dp[2]=1 使用一个2角的硬币即可；dp[5]=1 使用一个5角的硬币即可；
     * dp[3]=Math.min(dp[3-1],dp[3-2],dp[3-5])+1=2 这里dp[3-1],dp[3-2],dp[3-5]分别表示dp[3]可以使用1，2，5 这三种硬币来组合获得，同理
     * dp[4]=Math.min(dp[4-1]，dp[4-2],dp[4-5])+1=2;
     * dp[5]=Math.min(dp[5-1],dp[5-2],dp[5-5])+1=1;
     * dp[i] = Math.main(dp[i-1],dp[i-2],dp[i-5])+1;
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) { // 这里1,2,3...amount 表示dp[1],dp[2],dp[3],dp[amount] 的组合结果
            for (int coin : coins) { // 这里使用循环 就表示 dp[i - coin] 这部分值，整体dp[i]=
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

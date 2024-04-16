package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.generic.Fruit;
import org.apache.tools.ant.types.resources.First;

import javax.swing.*;
import java.util.Objects;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * Example 1:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
 */
public class LCTest_DP_198_Rob {

    /**
     * 下面算法的 一个优化
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return 0;
        }
        int roomNum = nums.length;
        if (roomNum <= 1) {
            return nums[0];
        }
        int first = nums[0];
        int last = Math.max(nums[0], nums[1]);
        int result = last;
        for (int i = 2; i < roomNum; i++) {
            result = Math.max(first + nums[i], last);
            first = last;
            last = result;
        }
        return result;
    }

    /**
     * 动态规划
     * 状态定义：
     * 设 dp[i] 为前 i 间房子可以偷到的最高金额。
     * 转移方程
     * dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
     * * 这里如果要偷 第 nums[i] 间房子的金额，则此时 最大金额为 dp[i-2]+nums[i] 因为相邻房子不能偷，
     * *    如果不偷 第 nums[i] 间房子的金额，则此时 最大金额为 dp[i-1]  所以选两者最大的即可
     *
     * @param nums
     * @return
     */
    public int rob_another(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return 0;
        }
        int roomNum = nums.length;
        if (roomNum <= 1) {
            return nums[0];
        }
        int[] dp = new int[roomNum];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < roomNum; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[roomNum - 1];
    }
}

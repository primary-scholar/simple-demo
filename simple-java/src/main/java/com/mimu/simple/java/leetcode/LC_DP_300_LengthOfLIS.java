package com.mimu.simple.java.leetcode;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O( n2 ) complexity.
 * Follow up: Could you improve it to O( n  log  n ) time complexity?
 * <p>
 * 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
 * 子序列
 */
public class LC_DP_300_LengthOfLIS {

    /**
     * 动态规划
     * 1.定义dp[] 数组；dp[i] 表示 以第 i 个数字结尾的最长上升子序列的长度
     * 2.明确递推公式；
     * * dp[i] = max(dp[j])+1,其中0≤j<i且num[j]<num[i]
     * 3.初始化
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // 这里 nums[i] > nums[j],因此只需要
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}

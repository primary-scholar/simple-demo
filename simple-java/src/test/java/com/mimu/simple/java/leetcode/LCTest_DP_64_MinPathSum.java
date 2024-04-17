package com.mimu.simple.java.leetcode;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * Example 1:
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 * <p>
 * 最小路径之和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步
 */
public class LCTest_DP_64_MinPathSum {

    /**
     * 动态规划
     * 状态定义：
     * 设 dp 为大小 m×n矩阵，其中 dp[i][j] 的值代表直到走到 (i,j) 的最小路径和。
     * 转移方程
     * dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+dp[i,j]
     * 对于转移方程 细分为4中情况
     * 1.当左边和上边都不是矩阵边界时： 即当i≠0i，j≠0j时 dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j]；
     * 2.当只有左边是矩阵边界时： 只能从上面来，即当i=0,j≠0时， dp[i][j]=dp[i][j−1]+grid[i][j]
     * 3.当只有上边是矩阵边界时： 只能从左面来，即当i≠0,j=0时， dp[i][j]=dp[i−1][j]+grid[i][j]
     * 4.当左边和上边都是矩阵边界时： 即当i=0,j=0时，其实就是起点， dp[i][j]=grid[i][j]
     * <p>
     * 1.定义dp数组：dp[m][n],dp[i][j] 的值代表直到走到 (i,j) 的最小路径和
     * 2.确定递推公式 dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+dp[i,j]
     * 3.初始化：
     * 4.循环递推：
     * 5.确认结果：grid[grid.length - 1][grid[0].length - 1] 即为结果；
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                } else if (i == 0) { // 上边界 情况 只能从左边来
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) { // 左边界 情况 只能从上边来
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else { // 非边界情况 取左侧和上侧的最小值 加上当前位置；
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}

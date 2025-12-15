package com.mimu.simple.java.leetcode;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * Constraints:
 * 1 <= m, n <= 100
 * <p>
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径
 */
public class LC_DP_62_UniquePaths {

    /**
     * 动态规划
     * 状态定义：
     * 设 dp 为大小 m×n矩阵，其中 dp[i][j] 的值代表走到 (i,j) 的路径和
     * 转移方程 即走到 当前位置的路径和 是走到当前位置上侧位置的 路径和 + 走到当前位置 左侧位置的路径和；
     * dp[i][j] = dp[i-1][j]+dp[i][j-1]
     * 对于转移方程 细分为4中情况
     * 1.当左边和上边都不是矩阵边界时： 即当i≠0i，j≠0j时 dp[i][j] = dp[i-1][j]+dp[i][j-1]
     * 2.当只有左边是矩阵边界时： 只能从上面来，即当i=0,j≠0时， dp[i][j]=1
     * 3.当只有上边是矩阵边界时： 只能从左面来，即当i≠0,j=0时， dp[i][j]=1
     * 4.当左边和上边都是矩阵边界时： 即当i=0,j=0时，其实就是起点， dp[i][j]=1
     * <p>
     * 1.定义dp数组：dp[m][n] ,dp[i][j] 的值代表走到 (i,j) 的路径和
     * 2.明确递推公式： dp[i][j] = dp[i-1][j]+dp[i][j-1] 即走到 当前位置的路径和 是走到当前位置上侧位置的 路径和 + 走到当前位置 左侧位置的路径和
     * 3.初始化 dp：对于二维数组的 上边界和左边界 因为只有一条路径，所以都初始化为 1：
     * 4.循环递推：在二维矩阵的 边界 m,n 内 进行循环 对于上边界和左边界 需要特殊处理；
     * 5.明确结果：dp[m - 1][n - 1] 的值 即为路径结果；
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths_op(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}

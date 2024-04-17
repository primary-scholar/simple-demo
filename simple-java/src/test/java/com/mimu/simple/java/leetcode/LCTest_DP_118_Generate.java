package com.mimu.simple.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer  numRows , generate the first  numRows  of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * Example:
 * Input: 5
 * Output:
 * * [
 * *      [1],
 * *     [1,1],
 * *    [1,2,1],
 * *   [1,3,3,1],
 * *  [1,4,6,4,1]
 * * ]
 */
public class LCTest_DP_118_Generate {

    /**
     * 杨辉三角
     * 每一行的首个和结尾一个数字都是1，
     * 从第三行开始，中间的每个数字都是上一行的左右两个数字之和
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) { // 每一行 收尾 都是 1
                    row.add(1);
                } else {  // 中间的 每个数字都是 上一行 的左右两个数字 之和
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }

    /**
     * 动态规划
     * 1.定义dp数组：int dp[][],dp[i][j] 表示 第i行，j列的数值；
     * 2.明确递推公式：1.每一行 头尾 都是 1；2.中间的 每个数字都是 上一行 的左右两个数字 之和；
     * 3.初始化
     * 4.循环递推：
     * 5.确定结果：对于 dp 数组中，非0的数字，按层进行 收集；
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate_dp(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        int dp[][] = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) { // 每一行 头尾 都是 1
                    dp[i][j] = 1;
                } else {  // 中间的 每个数字都是 上一行 的左右两个数字 之和
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int[] ints : dp) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int anInt : ints) {
                if (anInt != 0) {
                    row.add(anInt);
                }
            }
            result.add(row);
        }
        return result;
    }

}

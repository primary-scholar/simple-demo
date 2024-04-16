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

}

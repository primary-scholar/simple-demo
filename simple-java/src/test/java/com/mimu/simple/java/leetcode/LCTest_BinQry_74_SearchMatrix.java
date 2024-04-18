package com.mimu.simple.java.leetcode;

/**
 * You are given an m x n integer matrix matrix with the following two properties:
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 * <p>
 * 搜索二维矩阵
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false
 */
public class LCTest_BinQry_74_SearchMatrix {

    /**
     * 矩阵的二维查找
     * 这里可以把 矩阵的多行 当做一位的 长数组来搜索
     * * int mid = start + ((end - start) >> 1);
     * * int row = mid / matrix[0].length;
     * * int col = mid % matrix[0].length;
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length * matrix[0].length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            int num = matrix[row][col];
            if (num == target) {
                return Boolean.TRUE;
            } else if (num < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return Boolean.FALSE;
    }
}

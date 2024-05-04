package com.mimu.simple.java.leetcode;

import java.util.Objects;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * A  subsequence  of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A  common subsequence  of two strings is a subsequence that is common to both strings.
 * If there is no common subsequence, return 0.
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * Constraints:
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 * <p>
 * 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列
 */
public class LC_DP_1143_LongestCommonSubsequence {

    /**
     * 动态规划
     * 状态定义：
     * 设 dp 为大小 m+1×n+1矩阵，其中m,n表示 字符串的长度， 其中 dp[i][j] 表示 text1.substring(0,i)和 text2.substring(0,j)的最长公共子序列的长度
     * 转移方程
     * 如何来更新 dp[i][j]，
     * 若二者对应位置的字符相同，表示当前的 LCS 又增加了一位，所以可以用 dp[i-1][j-1] + 1 来更新 dp[i][j]。
     * 否则若对应位置的字符不相同，由于是子序列，还可以错位比较，可以分别从 text1 或者 text2 去掉一个当前字符，
     * 那么其 dp 值就是 dp[i-1][j] 和 dp[i][j-1]，取二者中的较大值来更新 dp[i][j] 即可，
     * <p>
     * *            dp[i-1][j-1]+1 :  text1[i-1]=text2[j-1]
     * * dp[i][j] =
     * *            Math.max(dp[i - 1][j], dp[i][j - 1])  :  text1[i-1]!=text2[j-1]
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (Objects.isNull(text1) || Objects.isNull(text2)) {
            return 0;
        }
        int ftl = text1.length();
        int stl = text2.length();
        int[][] dp = new int[ftl + 1][stl + 1];
        for (int i = 1; i <= ftl; i++) {
            char fc = text1.charAt(i - 1);
            for (int j = 1; j <= stl; j++) {
                char sc = text2.charAt(j - 1);
                if (fc == sc) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[ftl][stl];
    }
}

package com.mimu.simple.java.leetcode;

import org.junit.Test;

import java.util.Objects;

/**
 * 最长回文子串
 *
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * **Input:** s = "babad"
 * **Output:** "bab"
 * **Explanation:** "aba" is also a valid answer.
 * <p>
 * Example 2:
 * **Input:** s = "cbbd"
 * **Output:** "bb"
 */
public class LCTest_DP_LongestPalindrome_5 {

    public String longestPalindrome(String s) {
        if (Objects.isNull(s) || s.length() <= 0)
            return "";
        int start = 0;//最长回文子串的起始位置
        int end = 0;//最长会问子串的结束位置
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);//以单个字符为中心的回文长度,这里的数值一定是基数，且 i 在中心位置，左右长度相等
            int len2 = expandAroundCenter(s, i, i + 1);//以两个字符之间为中心的回文长度 这里的数值一定是 偶数，且 i 在中心 靠左的位置
            int len = Math.max(len1, len2);//当前找到的最长回文长度
            if (len > end - start) {
                /**
                 * 更新最长回文子串的位置，因为这里的回文串是以 i 为中心，向两端扩展的 字串 所以
                 * 左边界 为 i - (len - 1) / 2；例如：i=0，len=1，则s=0，e=0；i=1，len=3，则s=0，e=2；i=2，
                 * 右边界 为 i + len / 2；
                 */
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);//返回最长回文子串，substring 是前包含后不包含，所以这里 end+1；
    }

    /**
     * 中心扩展算法
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    public static int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {// 以left和right为左右边界，不断外扩 寻找最长回文字串的长度
            l--; // 不断左移
            r++; // 不断右移
        }
        return r - l - 1; // 返回最长回文字串的长度
    }

    @Test
    public void longestPalindromeResult() {
        System.out.println(longestPalindrome("babad"));
    }

}

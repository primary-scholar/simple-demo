package com.mimu.simple.java.leetcode;

import org.junit.Test;

import java.util.Objects;

/**
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
 * <p>
 * 最长回文子串
 */
public class LCTest_DP_5_LongestPalindrome {

    public String longestPalindrome(String s) {
        if (Objects.isNull(s) || s.length() <= 0)
            return "";
        int start = 0;//最长回文子串的起始位置
        int end = 0;//最长会问子串的结束位置
        for (int i = 0; i < s.length(); i++) {
            int singleLetterCenter = expandAroundCenter(s, i, i);//以单个字符为中心的回文长度,这里的数值一定是基数，且 i 在中心位置，左右长度相等
            int doubleLetterCenter = expandAroundCenter(s, i, i + 1);//以两个字符之间为中心的回文长度 这里的数值一定是 偶数，且 i 在中心 靠左的位置
            int len = Math.max(singleLetterCenter, doubleLetterCenter);//当前找到的最长回文长度
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
     * 中心扩展策略
     * 从每个可能的中心开始，尽可能向两边扩展，当两个方向的字母不再相同时，我们就找到了以该中心为起点的最长回文串
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


    /**
     * 动态规划 策略
     * <p>
     * 对于一个子串而言，如果它是回文串，并且长度大于 2，那么将它首尾的两个字母去除之后，它仍然是个回文串。例如对于字符串 “ababa”,如果我们已经知道 “bab” 是回文串，那么 “ababa” 一定是回文串，这是因为它的首尾两个字母都是 “a”。
     * 根据这样的思路，我们就可以用动态规划的方法解决本题。我们用 P(i,j) 表示字符串 s 的第 i 到 j 个字母组成的串（下文表示成 s[i:j]）是否为回文串：
     * * P(i,j)={
     * * 			true, 如果子串Si…Sj是回文串
     * * 			false,其它情况,
     * *        }
     * 这里的「其它情况」包含两种可能性：
     * s[i,j] 本身不是一个回文串；
     * i>j，此时 s[i,j] 本身不合法。
     * <p>
     * 那么我们就可以写出动态规划的状态转移方程：
     * P(i,j)=P(i+1,j−1)&&(Si==Sj)
     * 也就是说，只有 s[i+1:j−1] 是回文串，并且 s 的第 i 和 j 个字母相同时，s[i:j] 才会是回文串
     * <p>
     * 上文的所有讨论是建立在子串长度大于 2 的前提之上的，我们还需要考虑动态规划中的边界条件，
     * 即子串的长度为 1 或 2。
     * 对于长度为 1 的子串，它显然是个回文串；
     * 对于长度为 2 的子串，只要它的两个字母相同，它就是一个回文串。
     * 因此我们就可以写出动态规划的边界条件：
     * * {
     * * 	P(i,i)=true
     * * 	P(i,i+1)=(Si==Si+1)
     * *{
     * 根据这个思路，我们就可以完成动态规划了，最终的答案即为所有 P(i,j)=true中 j−i+1（即子串长度）的最大值。
     * <p>
     * 注意：在状态转移方程中，我们是从长度较短的字符串向长度较长的字符串进行转移的，因此一定要注意动态规划的循环顺序
     *
     * @param s
     * @return
     */
    public String longestPalindrome_Another(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[length][length];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // 递推开始
        // 从子串长度为 2 开始 判断 长度为2，3，一直到 length 的子串
        for (int len = 2; len <= length; len++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int l = 0; l < len; l++) {
                // 由 len 和 l 可以确定右边界，即 r - l + 1 = len
                int r = len + l - 1;
                // 如果右边界越界，就可以退出当前循环
                if (r >= len) {
                    break;
                }
                if (charArray[l] != charArray[r]) {
                    dp[l][r] = false;
                } else {
                    if (r - l < 3) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[l][r] && r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    begin = l;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    @Test
    public void longestPalindromeResult() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome_Another("babad"));
    }

}

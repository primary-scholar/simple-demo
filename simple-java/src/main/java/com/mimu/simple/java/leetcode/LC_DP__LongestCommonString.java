package com.mimu.simple.java.leetcode;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长公共子串
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * <p>
 * 输入："1AB2345CD","12345EF"
 * 输出："2345"
 */
public class LC_DP__LongestCommonString {

    /**
     * 动态规划
     *
     * @param str1
     * @param str2
     * @return
     */
    public String commonSubString(String str1, String str2) {
        int maxLenth = NumberUtils.INTEGER_ZERO;//记录最长公共子串的长度
        //记录最长公共子串最后一个元素在字符串str1中的位置
        int maxLastIndex = NumberUtils.INTEGER_ZERO;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                //递推公式，两个字符相等的情况
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    //如果遇到了更长的子串，要更新，记录最长子串的长度，
                    //以及最长子串最后一个元素的位置
                    if (dp[i + 1][j + 1] > maxLenth) {
                        maxLenth = dp[i + 1][j + 1];
                        maxLastIndex = i;
                    }
                } else {
                    //递推公式，两个字符不相等的情况
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        //最字符串进行截取，substring(a,b)中a和b分别表示截取的开始和结束位置
        return str1.substring(maxLastIndex - maxLenth + 1, maxLastIndex + 1);
    }

    /**
     * 最长公共子串循环匹配
     *
     * @param title
     * @param query
     * @return
     */
    public String multiSubLcs(String title, String query, Integer threshold) {
        String prefix = "<", suffix = ">";
        String result = title;
        int remainLength = title.length();
        for (String subString = commonSubString(title, query); subString.length() >= threshold && remainLength >= threshold; ) {
            remainLength = title.length() - subString.length();
            int resultStart = result.indexOf(subString);
            result =
                    new StringBuilder(result).insert(resultStart, prefix).insert(resultStart + subString.length() + NumberUtils.INTEGER_ONE,
                            suffix).toString();
            int begin = title.indexOf(subString);
            title = new StringBuilder(title).replace(begin, begin + subString.length(),
                    StringUtils.repeat(System.lineSeparator(), subString.length())).toString();
            subString = commonSubString(title, query);
        }
        return result;
    }

    /**
     * 循环进行最长公共子串的匹配
     *
     * @param title
     * @param query
     * @return
     */
    public List<String> multiLongestCommonString(String title, String query, Integer threshold) {
        int remainLength = title.length();
        List<String> result = new ArrayList<>();
        for (String subString = commonSubString(title, query); subString.length() >= threshold && remainLength >= threshold; ) {
            result.add(subString);
            remainLength = title.length() - subString.length();
            int begin = title.indexOf(subString);
            title = new StringBuilder(title).replace(begin, begin + subString.length(),
                    StringUtils.repeat(System.lineSeparator(), subString.length())).toString();
            subString = commonSubString(title, query);
        }
        return result;
    }
}

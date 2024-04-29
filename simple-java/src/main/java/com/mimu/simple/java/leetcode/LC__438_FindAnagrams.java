package com.mimu.simple.java.leetcode;

import java.util.*;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */
public class LC__438_FindAnagrams {

    /**
     * 滑动窗口 穷举法
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams_force(String s, String p) {
        if (Objects.isNull(s) || Objects.isNull(p) || s.length() < p.length()) {
            return new ArrayList<>();
        }
        int sl = s.length();
        int pl = p.length();
        int j;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= sl - pl; i++) {
            j = i + pl;
            String tmpStr = s.substring(i, j);
            if (isAnagramAnother(tmpStr, p)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isAnagramAnother(String s, String t) {
        if (Objects.isNull(s) || Objects.isNull(t)) {
            return Boolean.FALSE;
        }
        if (s.length() != t.length()) {
            return Boolean.FALSE;
        }
        int[] tmpResult = new int[26];
        for (int i = 0; i < s.length(); i++) {
            tmpResult[s.charAt(i) - 'a']++;
            tmpResult[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < tmpResult.length; i++) {
            if (tmpResult[i] != 0) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}

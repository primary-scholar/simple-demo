package com.mimu.simple.java.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * 有效字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 对于排序方法，如果字符串长度较短，则性能较好，否则下面的那个性能较好
 */
public class LCTest__242_IsAnagram {

    /**
     * 可以使用排序法
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (Objects.isNull(s) || Objects.isNull(t)) {
            return Boolean.FALSE;
        }
        if (s.length() != t.length()) {
            return Boolean.FALSE;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }

    /**
     * 使用长度为 26 的 数组来标记
     *
     * @param s
     * @param t
     * @return
     */
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

    @Test
    public void isAnagramTest() {
        System.out.println(isAnagram("eat", "tea"));
    }
}

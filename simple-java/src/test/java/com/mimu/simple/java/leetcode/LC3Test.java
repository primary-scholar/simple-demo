package com.mimu.simple.java.leetcode;

import org.junit.Test;

import java.util.HashSet;

/**
 * 无重复最长子串
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * **Input:** s = "abcabcbb"
 * **Output:** 3
 */
public class LC3Test {

    public int lengthOfLongestSubstring(String s) {
        int result = 0, left = 0, index = 0;
        // set 中保存字符串中当前元素
        HashSet<Character> hashSet = new HashSet<>();
        while (index < s.length()) {
            if (!hashSet.contains(s.charAt(index))) {// 按照字符串 循环遍历 如果字符不在set中则添加该字符
                hashSet.add(s.charAt(index++));// 添加字符
                result = Math.max(result, hashSet.size()); // 取当前结果和集合中元素个数的最大值
            } else {
                hashSet.remove(s.charAt(left++));//如果set中已经存在，则把集合中的元素从左到右依次删除，这里循环一次 删除一个 使用 left++控制
            }
        }
        return result;
    }

    @Test
    public void printResult() {
        LC3Test lc3Test = new LC3Test();
        assert lc3Test.lengthOfLongestSubstring("abcabcbb") == 3;
        assert lc3Test.lengthOfLongestSubstring("pwwkew") == 3;
    }
}

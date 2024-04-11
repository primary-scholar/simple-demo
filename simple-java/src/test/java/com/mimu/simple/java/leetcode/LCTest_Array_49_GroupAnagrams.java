package com.mimu.simple.java.leetcode;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * <p>
 * 字母异位词分组 - 字母异位词 即 字母相同，位置不同的 单词；如：eat，aet，tea ；
 * 由于字母异位词的 单词 中 出现的字母 都是一样的，所以这里有两个思路
 * 1.把字母异位词 按照字典序 排列，那么是字母异位词的 单词 其排序后的序列 都是一致的；
 * 2.把字母异位词 按照字母拆分，然后把字母iin行全排列，然后再 分别从数组里寻找；
 * 思路 2 这里 可以先放弃；
 */
public class LCTest_Array_49_GroupAnagrams {

    /**
     * 使用 hashMap 保存 按照 字典序排序后的 字母异位词
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> result = new ArrayList<>();
        if (Objects.isNull(strs)) {
            return result;
        }
        HashMap<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) { // 遍历 数组
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray); // 对字母异位词 进行排序
            List<String> stringValue = resultMap.get(key);
            if (Objects.isNull(stringValue)) {
                stringValue = new ArrayList<>();
                resultMap.put(key, stringValue);
                result.add(stringValue); // 最终结果的收集
            }
            stringValue.add(str); // 对 排序后相同的 字母异位词 进行结果收集
        }
        return result;
    }

}

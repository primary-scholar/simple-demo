package com.mimu.simple.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * 两数之和问题
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案
 */
public class LC_Map_1_AddTwoNumbers {

    /*
    把数组放到 map中遍历一遍数组，复杂度O(n)
     */
    public int[] addTwoNumbers(int[] nums, int target) {
        int[] result = new int[2];//定义要返回的长度为2的数组
        if (nums == null || nums.length < 2) {
            return result;
        }
        // 存放数组中当前元素的值和该值在数组中的下标
        Map<Integer, Integer> hash = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            int other = target - nums[idx];//计算当前元素和目标元素的差值
            if (hash.get(other) != null && hash.get(other) != idx) { // 如果差值在hashMap中并且不是当前下标则找到相关结果 可以返回
                result[0] = hash.get(other);
                result[1] = idx;
            }
            // 这一行 应该在 上面的 判断之后 即先判断 差值是否在 hashMap 中 然后再把 当前值和下标放入 hashMap 类似于 缓存的操作
            hash.put(nums[idx], idx);//把访问到元素值和该元素在数组中的下标存到到hashMap中
        }
        return result;
    }

}

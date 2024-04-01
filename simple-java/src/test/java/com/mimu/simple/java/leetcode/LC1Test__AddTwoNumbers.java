package com.mimu.simple.java.leetcode;

/**
 * author: mimu
 * date: 2019/9/30
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 两数之和问题
 * Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class LC1Test__AddTwoNumbers {

    /*
    把数组放到 map中遍历一遍数组，复杂度O(n)
     */
    public int[] addTwoNumbers(int[] nums, int target) {
        int[] result = new int[2];//定义要返回的长度为2的数组
        if (nums == null || nums.length < 2) {
            return result;
        }
        // 存放数组中当前元素的值和，该值在数组中的下标
        Map<Integer, Integer> hash = new HashMap<>();
        for (int start = 0; start < nums.length; start++) {
            int other = target - nums[start];//计算当前元素和目标元素的差值
            if (hash.get(other) != null && hash.get(other) != start) { // 如果差值在hashMap中并且不是当前下标则找到相关结果 可以返回
                result[0] = hash.get(other);
                result[1] = start;
            }
            hash.put(nums[start], start);//把访问到元素值和该元素在数组中的下标存到到hashMap中
        }
        return result;
    }

    @Test
    public void deal() {
        int[] ints = addTwoNumbers(new int[]{2, 7, 11, 12}, 14);
        int[] ints1 = addTwoNumbers(new int[]{3, 3}, 6);
        assert Arrays.equals(ints, new int[]{0, 3});
        assert Arrays.equals(ints1, new int[]{0, 1});
    }
}

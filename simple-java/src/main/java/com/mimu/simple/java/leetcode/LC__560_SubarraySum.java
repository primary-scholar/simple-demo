package com.mimu.simple.java.leetcode;

import java.util.HashMap;
import java.util.Objects;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * <p>
 * 和为k的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * 注意这里是连续子数组,以示例1来说k=2 的连续子数组为 [nums[0],nums[1]],[nums[1],nums[2]] 这两个
 * 对于 [nums[0],nums[2]] 这一组来说，虽然值=2但是不连续，所以不算；
 */
public class LC__560_SubarraySum {

    /**
     * 这里 确实不知为何
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0, pre = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (hashMap.containsKey(pre - k)) {
                result += hashMap.get(pre - k);
            }
            hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);
        }
        return result;
    }

    /**
     * 暴力 穷举 效率较低 但leetcode 可以过
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum_force(int[] nums, int k) {
        int result = 0;
        if (Objects.isNull(nums) || nums.length <= 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                result++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }
}

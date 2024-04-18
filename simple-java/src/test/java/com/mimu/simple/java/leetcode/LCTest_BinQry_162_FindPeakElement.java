package com.mimu.simple.java.leetcode;

import java.util.Objects;

/**
 * 寻找局部峰值数据
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * <p>
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5 or 1
 * Explanation: Your function can return either index number 1 where the peak element i
 */
public class LCTest_BinQry_162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int[] numCopy = new int[nums.length + 2];
        System.arraycopy(nums, 0, numCopy, 1, nums.length);
        numCopy[0] = Integer.MIN_VALUE;
        numCopy[numCopy.length - 1] = Integer.MIN_VALUE;
        for (int i = 1; i < numCopy.length - 1; ++i) {
            if (numCopy[i] > numCopy[i - 1] && numCopy[i] > numCopy[i + 1]) return i - 1;
        }
        return -1;
    }

    /**
     * 这里是使用否命题的思路 查找 取寻找局部最大值
     * <p>
     * 思路 寻找局部最大 可能存在的区域
     * 如果当前位置的 数字 比它左边的数字小 则局部最大 的数字 应该出现在 该位置左侧
     * 如果当前位置的 数字 比它右边的数字小 则局部最大 的数字 应该出现在 该位置右侧
     *
     * @param nums
     * @return
     */
    public int findPeakElement_1(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 1) {
            return -1;
        }
        if (nums.length == 1 || nums[0] == nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] < nums[nums.length - 2]) {
            return nums.length - 2;
        }
        int left = 1, right = nums.length - 2;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] < nums[mid - 1]) { // 当前 mid 位置的数字 比左边的数字小 则说明 局部最大值 在该位置 左侧
                right = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) { // 当前 mid 位置的数字 比右边的数字小 则说明 局部最大值 在该位置 右侧
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}

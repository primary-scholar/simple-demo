package com.mimu.simple.java.leetcode;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * Example 1:
 * **Input:** nums = [1,3,5,6], target = 5
 * **Output:** 2
 * Example 2:
 * **Input:** nums = [1,3,5,6], target = 2
 * **Output:** 1
 * Example 3:
 * **Input:** nums = [1,3,5,6], target = 7
 * **Output:** 4
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法
 */
public class LC_BinQry_35_SearchInsert {

    /**
     * 这里有要求 复杂度 所以只能是 二分查找
     * 这里如果 数组中有 target 则返回的 mid 一定是 数组中的下标；
     * 如果 数组中没有 target 则 这时的 start 一定是 > target 的 最小位置的下标；
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

}

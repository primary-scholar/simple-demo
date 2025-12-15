package com.mimu.simple.java.leetcode;


/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * Given the sorted rotated array nums of unique elements, return  the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 * Example 3:
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * All the integers of nums are unique.
 * nums is sorted and rotated between 1 and n times.
 * <p>
 * 寻找旋转数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题
 */
public class LC_BinQry_153_FindMin {

    /**
     * 使用 二分查找 思路
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (nums[end] > nums[mid]) {  //  如果 nums[end]>nums[mid]，则说明mid~end一定是有序递增的，最小值在mid左侧，因此end向mid收缩，此时nums[mid-1]和nums[mid]大小未知
                end = mid;
            } else { // 如果 nums[end]<=nums[mid]，则说明mid~end一定是先递减，再递增(递增可能没有)，最小值在mid右侧，因此start向mid+1靠拢,因为nums[mid+1]<nums[mid]的
                start = mid + 1;
            }
        }
        return nums[start];
    }
}

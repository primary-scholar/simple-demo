package com.mimu.simple.java.leetcode;


/**
 * Given an array, rotate the array to the right by  k  steps, where  k  is non-negative.
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and _k_ = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * Input: [-1,-100,3,99] and _k_ = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * Credits:
 * Special thanks to @Freezen for adding this problem and creating all test cases.
 * <p>
 * 旋转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数
 */
public class LC_Array_189_Rotate {

    /**
     * 使用额外数组 进行复制 时间复杂度 O(n)，空间复杂度O(n)
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] copy = new int[length];
        for (int i = 0; i < length; i++) {
            copy[(i + k) % length] = nums[i];
        }
        System.arraycopy(copy, 0, nums, 0, length);
    }


}

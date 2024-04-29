package com.mimu.simple.java.leetcode;

import java.util.Objects;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * <p>
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作
 */
public class LC__283_MoveZeroes {

    /**
     * 循环遍历数组，依次把不为零的数，从数组初始位置，向后放，然后把数组剩余的部分，置为零
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return;
        }
        int idx = 0; // 初始数组中不为0的下标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) { // 循环遍历数组，只要不为0就放置到 不为0的部分，同时不为0部分下标 ++
                nums[idx++] = nums[i];
            }
        }
        for (int i = idx; i < nums.length; i++) { // 剩余部分 置0
            nums[i] = 0;
        }
    }
}

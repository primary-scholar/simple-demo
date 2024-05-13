package com.mimu.simple.java.leetcode;

import java.util.Objects;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 * <p>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 进阶：你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class LC__75_SortColors {

    /**
     * 单指针法 - 需要扫描两次数组
     * 三种颜色 分成三个区域 因此只需 遍历两次 数组 把其中 两种颜色 放在一起，剩余的那一个 自然就自成一个区域了
     * 在第一次遍历中，我们将数组中所有的 0 交换到数组的头部。
     * 在第二次遍历中，我们将数组中所有的 1 交换到头部的 0 之后。此时，所有的 2 都出现在数组的尾部，这样我们就完成了排序。
     * 具体地，我们使用一个指针 posi 表示「头部」的范围，posi 中存储了一个整数，表示数组 nums 从位置 0 到位置 posi−1 都属于「头部」。
     * posi 的初始值为 0，表示还没有数处于「头部」
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 1) {
            return;
        }
        int posi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { // 把数组为 0 的部分交换到 数组头部
                swap(nums, posi, i);
                posi++; // 同时记录 数组为 0 的数组下标
            }
        }
        for (int i = posi; i < nums.length; i++) {  // 从数组为 0  的末尾下标开始，把数组为 1 的部分交换到 0 部分的后面
            if (nums[i] == 1) {
                swap(nums, posi, i);
                posi++;
            }
        }
    }

    /**
     * 双指针法
     * nums[0,left] 区域为 0
     * nums[right,numg.length-1] 为 2
     * 初始值 left=0，right=nums.length-1，在数组 0,right 内循环
     * 遍历数组 如果当前元素是 0 则 把他交换到 left 区域，如果是 2 把他交换到 right 区域 是 1 不交换
     *
     * @param nums
     */
    public void sortColorsDoublePtr(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) { // 在 i,right 内循环
            if (nums[i] == 0) { // 如果当前元素=0，则和left区域最后一个元素 交换 left区域 ++，同时 i++
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 1) { // 如果当前元素=1，则 i++
                i++;
            } else { // 如果当前元素=2，则和right区域第一个元素 交换 right区域 --
                swap(nums, right, i);
                right--;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        if (Objects.isNull(array) || array.length <= 1) {
            return;
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}

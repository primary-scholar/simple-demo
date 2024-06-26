package com.mimu.simple.java.leetcode;

import java.util.Objects;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] ( 0-indexed ). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index oftarget if it is innums , or-1 if it is not innums.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * **Input:** nums = [4,5,6,7,0,1,2], target = 0
 * **Output:** 4
 * <p>
 * Example 2:
 * **Input:** nums = [4,5,6,7,0,1,2], target = 3
 * **Output:** -1
 * <p>
 * Example 3:
 * **Input:** nums = [1], target = 0
 * **Output:** -1
 * <p>
 * 循环右移有序数组的 搜索
 * 将数组一分为二，其中一个一定是有序的，另一个可能是有序的，也可能是部分有序的；如果此时目标值在 有序部分内，则可使用二分查找无限收缩 查找目标值位置
 * 整体使用二分查找 算法思想
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class LC_BinQry_33_Search {

    /**
     * 将数组一分为二，其中一个一定是有序的，另一个可能是有序的，也可能是部分有序的。此时有序部分用二分法查找。其中一个一定有序，另一个可能有序，可能无序。就这样循环.
     * 循环右移数组不存在重复数字
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) { // 边界判断
            return -1;
        }
        int n = nums.length;
        if (n == 1) { // 边界判断
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1; // 在数组内部 进行 二分查找
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) { // 如果 左侧有序
                if (nums[l] <= target && target <= nums[mid]) { // 且 目标值在 左侧
                    r = mid - 1; // 无限收缩 左侧右边界 并靠近 目标值
                } else { // 目标值在 右侧
                    l = mid + 1; // 无限收缩 右侧左边界
                }
            } else { // 右侧有序
                if (nums[mid] <= target && target <= nums[n - 1]) { // 且目标值在 右侧
                    l = mid + 1; // 无限收缩 右侧侧左边界 并靠近 目标值
                } else {
                    r = mid - 1; // 无限收缩 左侧侧右边界 并靠近 目标值
                }
            }
        }
        return -1;
    }

    /**
     * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
     * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
     * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
     * 你必须尽可能减少整个操作步骤
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search_lc81(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return Boolean.FALSE;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return Boolean.TRUE;
            }
            /*
              对于具有重复元素的 旋转数组 对于 nums[left] == nums[mid] && nums[mid] == nums[right] 这种情形，无法
              判断那边是有序的，所以对于这种情况要 单独处理
             */
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) { // 如果 左侧有序
                if (nums[left] <= target && target <= nums[mid]) { // 且 目标值在 左侧
                    right = mid - 1; // 无限收缩 左侧右边界 并靠近 目标值
                } else { // 目标值在 右侧
                    left = mid + 1; // 无限收缩 右侧左边界
                }
            } else { // 右侧有序
                if (nums[mid] <= target && target <= nums[nums.length - 1]) { // 且目标值在 右侧
                    left = mid + 1; // 无限收缩 右侧侧左边界 并靠近 目标值
                } else {
                    right = mid - 1; // 无限收缩 左侧侧右边界 并靠近 目标值
                }
            }
        }
        return Boolean.FALSE;
    }
}

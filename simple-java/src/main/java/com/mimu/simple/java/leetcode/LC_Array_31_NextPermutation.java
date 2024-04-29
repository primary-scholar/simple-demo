package com.mimu.simple.java.leetcode;


import java.util.Objects;

/**
 *
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * The replacement must be in place and use only constant extra memory.
 * Example 1:
 * **Input:** nums = [1,2,3]
 * **Output:** [1,3,2]
 * Example 2:
 * **Input:** nums = [3,2,1]
 * **Output:** [1,2,3]
 * Example 3:
 * **Input:** nums = [1,1,5]
 * **Output:** [1,5,1]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * <p>
 下一个排列
 * 分析：
 * *  1.我们希望下一个数 比当前数大，这样才满足 “下一个排列” 的定义。因此只需要 将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
 * *  2.我们还希望下一个数 增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
 * *   a.在 尽可能靠右的低位 进行交换，需要 从后向前 查找
 * *   b.将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
 * *   c.将「大数」换到前面后，需要将「大数」后面的所有数 重置为升序，升序排列就是最小的排列。以 123465 为例：
 * *    首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
 * *  以上就是求 “下一个排列” 的分析过程
 */
public class LC_Array_31_NextPermutation {

    public void nextPermutation(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) { // 从右向左寻找 第一个 正序的位置 即nums[i]<nums[i+1] 的位置
            i--;
        }
        // 如果i>=0 说明 i的位置 并不是 数组第一个元素，这里需要再次寻找 右侧第一个大于 该位置的数，并进行交换
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) { // 从右向左寻找 第一个 大于 nums[i] 位置的数
                j--;
            }
            swap(nums, i, j); // 并进行交换
        }
        reverse(nums, i + 1); // 把 i+1 后面的数 进行 翻转，即使得 i+1 后面的数 升序排列
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums, int i, int k) {
        if (i < 0 || k < 0 || i >= nums.length || k >= nums.length) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }
}

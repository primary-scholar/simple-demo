package com.mimu.simple.java.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O( n ) complexity.
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * <p>
 * 最长连续序列
 * 要求 O(N)
 */
public class LCTest_Array_128_LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        if (Objects.isNull(nums)) {
            return result;
        }
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int num : nums) {
            if (numSet.remove(num)) {
                int pre = num - 1, next = num + 1;
                while (numSet.remove(pre)) {
                    --pre;
                }
                while (numSet.remove(next)) {
                    next++;
                }
                result = Math.max(result, next - pre - 1);
            }
        }
        return result;
    }

    /**
     * 从某个 起始数字 X 开始，不断尝试 X+1,X+2 是否存在，但是使用这种方式，其复杂度 为 O(n^2), 因为如果 当前起始数字是 X，则 X+1,X+2
     * 在 以 X 为起始数字的判断中，会循环判断；当 某次 起始数字 来到 X+1，或X+2时，其 X+2,X+3 等就会再次在循环中判断，
     * 因此 这里 我们 不能从 数组中 存在的 某个 X 开始，而应该从 数组中不存在的某个 X-1 处 开始；这样对于  序列 X，X+1,X+2 只会 在 X-1处开始
     * 循环一次，
     *
     * @param nums
     * @return
     */
    public int longestConsecutiveAnother(int[] nums) {
        int result = 0;
        if (Objects.isNull(nums)) {
            return result;
        }
        Set<Integer> numSet = new HashSet<>();
        // 初始时 把 数组元素 存放到 set 中
        for (int num : nums) {
            numSet.add(num);
        }
        for (int num : numSet) { // 遍历数组
            if (!numSet.contains(num - 1)) { // 从数组中某个 不存在的 X-1 处开始 进行最长序列的 判断
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) { // 累计判断 X,X+1,X+2 是否存在 如果存在则 累加长度
                    currentNum += 1;
                    currentStreak += 1;
                }
                result = Math.max(result, currentStreak); // 取当前结果 和最新累加结果的 最大值；
            }
        }
        return result;
    }
}

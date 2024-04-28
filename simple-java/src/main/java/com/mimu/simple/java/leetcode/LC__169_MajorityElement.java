package com.mimu.simple.java.leetcode;


import java.util.Objects;

/**
 * Given an array nums of size n, return  the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 * <p>
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class LC__169_MajorityElement {

    /**
     * 同归于尽 消杀法
     * 由于多数超过50%, 比如100个数，那么多数至少51个，剩下少数是49个。
     * 1.遍历数组
     * 2.第一个到来的士兵，直接插上自己阵营的旗帜占领这块高地，此时领主 winner 就是这个阵营的人，现存兵力 count = 1
     * 3.如果新来的士兵和前一个士兵是同一阵营，则集合起来占领高地，领主不变，winner 依然是当前这个士兵所属阵营，现存兵力 count 加一；
     * 4.如果新来到的士兵不是同一阵营，则前方阵营派一个士兵和它同归于尽。 此时前方阵营兵力-1, 即使双方都死光，这块高地的旗帜 winner 不变，没有可以去换上自己的新旗帜。
     * 5.当下一个士兵到来，发现前方阵营已经没有兵力，新士兵就成了领主，winner 变成这个士兵所属阵营的旗帜，现存兵力 count ++。
     * 6.就这样各路军阀一直厮杀以一敌一同归于尽的方式下去，直到少数阵营都死光，剩下几个必然属于多数阵营的，winner 是多数阵营。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return -1;
        }
        int winner = nums[0], count = 1; // 初始阵营为 数组第一个数字，且兵力为 1
        for (int i = 1; i < nums.length; i++) {
            if (winner == nums[i]) {
                count++; // 此后如果是 同一个 阵营的人 则兵力 ++
            } else { // 否则 进行 消杀
                if (count == 0) { // 判断当前阵营 兵力 是否 为 0 如果是，则新来者 成为新的 阵营 且 兵力 ++
                    winner = nums[i];
                    count++;
                } else { // 如果当前兵力 不为 0 则 进行消杀
                    count--;
                }
            }
        }
        return winner;
    }

}

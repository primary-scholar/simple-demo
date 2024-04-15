package com.mimu.simple.java.leetcode;

import java.util.Objects;

/**
 * Given a non-empty array of integers, every element appears  twice  except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 * <p>
 * 只出现一次的数字 此题如果没有空间复杂度要求，可使用 hashMap 进行数据的存储和判断
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间
 */
public class LCTest__136_SingleNumber {

    /**
     * 使用 异或 操作 进行数据查询
     * 异或的性质
     * 1.任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a
     * 2.任何数和其自身做异或运算，结果是 0，即 a⊕a=0
     * 3.异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return -1;
        }
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }
}

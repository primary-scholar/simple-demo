package com.mimu.simple.java.leetcode;

/**
 * Given two sorted integer arrays  nums1  and  nums2 , merge  nums2  into  nums1  as one sorted array.
 * <p>
 * The number of elements initialized in  nums1 and  nums2  are  m  and  n  respectively.
 * You may assume that  nums1  has enough space (size that is greater or equal to  m  +  n ) to hold additional elements from  nums2.
 * Example:
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 * <p>
 * 合并两个有序数组
 */
public class LCTest_Array_88_Merge {

    /**
     * 分别从两个数组的末尾 开始 进行比较，取较大值，并把较大值 放置在 [m+n-1]-- 的位置上
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int fi = m - 1; // 第一个数组 末尾位置 m-1
        int si = n - 1; // 第二个数组 末尾位置  n-1
        int ri = m + n - 1; // 结果数组 末尾位置 m+n-1
        int current;
        while (fi >= 0 || si >= 0) {
            if (fi <= -1) { // 第一个数组 已经为 空，则直接取 第二个数组 当前位置数字，当前位置--；
                current = nums2[si--];
            } else if (si <= -1) {// 第二个数组 已经为 空，则直接取 第一个数组 当前位置数字，当前位置--；
                current = nums1[fi--];
            } else if (nums1[fi] > nums2[si]) { // 两个数组 都非空 则比较 数组当前位置数组，取较大者 然后 较大位置数字的 数组 当前位置 --；
                current = nums1[fi--];
            } else {
                current = nums2[si--];
            }
            nums1[ri--] = current; // 为结果数组当前位置 赋值 当前位置 --；
        }
    }
}

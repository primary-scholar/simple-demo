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
public class LC_Array_88_Merge {

    /**
     * 分别从两个数组的末尾 开始 进行比较，取较大值，并把较大值 放置在 [m+n-1]-- 的位置上
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int fIdx = m - 1; // 第一个数组 末尾位置 m-1
        int lIdx = n - 1; // 第二个数组 末尾位置  n-1
        int rIdx = m + n - 1; // 结果数组 末尾位置 m+n-1
        int current;
        while (fIdx >= 0 || lIdx >= 0) {
            if (fIdx <= -1) { // 第一个数组 已经为 空，则直接取 第二个数组 当前位置数字，当前位置--；
                current = nums2[lIdx--];
            } else if (lIdx <= -1) {// 第二个数组 已经为 空，则直接取 第一个数组 当前位置数字，当前位置--；
                current = nums1[fIdx--];
            } else if (nums1[fIdx] > nums2[lIdx]) { // 两个数组 都非空 则比较 数组当前位置数组，取较大者 然后 较大位置数字的 数组 当前位置 --；
                current = nums1[fIdx--];
            } else {
                current = nums2[lIdx--];
            }
            nums1[rIdx--] = current; // 为结果数组当前位置 赋值 当前位置 --；
        }
    }
}

package com.mimu.simple.java.leetcode;


import com.mimu.simple.java.algorithm.linkstackqueue.link.ClassicLinkNodeSlowFastNodeOperation;
import com.mimu.simple.java.algorithm.linkstackqueue.link.CustomSingleNode;

import java.util.Objects;

/**
 * Given an array  nums  containing  n  + 1 integers where each integer is between 1 and  n  (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * Example 1:
 * Input: [1,3,2,4,2]
 * Output: 2
 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant,  O (1) extra space.
 * Your runtime complexity should be less than  O ( n 2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * <p>
 * 寻找重复数字 要求不改变数组，并且使用O(1) 额外空间，所以排序 hash就都可以放弃了；
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class LCTest__287_FindDuplicate {

    /**
     * 循环链表 快慢指针 思路
     * 1.单链表的构建
     * 以数组下标和数组的值 构建一个函数 f(idx)= nums[idx]; 以示例1为例
     * 0->1
     * 1->3
     * 2->4
     * 3->2                                        --<--
     * 4->2                                       |     |
     * 以上面这种前后顺序 构建 一个 单链表 0-->1-->3-->2-->--4 节点 4 和节点 2 之间有环，所以可以依据 快慢指针 进行入环 节点的 查找
     * 1.快慢指针中 节点的赋值 可以是 都从头结点开始，也可以是 依次循环之后的 节点 赋值开始 ；
     *
     * @param nums
     * @return
     * @see ClassicLinkNodeSlowFastNodeOperation#midOrUpMidNode(CustomSingleNode) 中的说明
     * 这里采用 循环一次之后的 节点值 开始 为 快慢指针赋值，因为这里的 循环结束条件是 slow!=fast
     * 2.快慢指针中 快慢指针的移动
     * slow = slow.next;       <==========> slow = nums[slow]
     * fast = fast.next.next   <==========> fast = nums[nums[fast]]
     */
    public int findDuplicate(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return -1;
        }
        /**
         * 这里快慢指针的赋值 是从循环一次之后的节点为 fast，slow 赋值的，这里的 头结点是 0；
         * 依次循环之后 slow = 1；fast=3；因此这里 初始时 slow = nums[0],fast = nums[1]=nums[nums[0]]
         * 这里的 初始条件 使用 do while 语句 进行优化
         */
        int slow = 0, fast = 0; // 初始时 快慢指针都从 0 这个 节点开始；
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * 使用二分查找 思路进行 搜索
     * 有序数组构建
     * 以数组中的数字和 数组中 小于等于该数字的 总数 构建一个函数 f(num[idx]) = sum(<=nums[idx]) 如示例1所示
     * 数组数字       1   3   2   4   2
     * 符合规则的总数  1   4   3   5   3   因为数组中的数字范围在 1~n 所以 整理后为
     * 数组数字       1   2   3   4
     * 符合规则的总数  1   3   4   5
     * 函数的分布中 在某个区间内 f(nums[idx])<=nums[idx],另一个区间内 f(nums[idx])>nums[idx]，且 f(num[idx]) 随 num[idx] 单调递增；
     * 所以这里就可以使用二分查找
     * 左右两个区域的收缩边界 左边 [1~mid],右边[mid+1,n]
     * 收缩规则
     * * f(nums[idx])<=nums[idx] 即 f(x)<=nums[mid] 则 left=mid+1
     * * f(nums[idx])>nums[idx] 即 f(x)>nums[mid] 则 right = mid
     *
     * @param nums
     * @return
     */
    public int findDuplicate_bin_query(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return -1;
        }
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int currentSum = 0;
            int mid = (right + left) >> 1;
            for (int num : nums) {
                if (num <= mid) {
                    currentSum++;
                }
            }
            if (currentSum <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

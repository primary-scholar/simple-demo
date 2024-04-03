package com.mimu.simple.java.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 这里输出结果是有序的，所以可以先把数组进行排序，然后使用3个指针，idx，left，right来进行查找，
 * idx从数组0，length-1，进行数据的循环，在该循环内 left在idx+1出开始向右移动，right在length-1处向左移动，直到相遇
 * 移动的规则是:
 * array[idx]+array[left]+array[right]>0;则 right--;
 * array[idx]+array[left]+array[right]<0;则 left++
 * 对于array[idx]+array[left]+array[right]=0 的则进行结果的收集 同时进行去重判断，
 * 等idx从头到尾走遍数组则结束循环；
 * <p>
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * <p>
 * **Input:** nums = [-1,0,1,2,-1,-4]
 * **Output:** [[-1,-1,2],[-1,0,1]]
 * **Explanation:**
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */
public class LCTest__15_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);//调用api进行数组排序
        for (int i = 0; i < nums.length - 2; i++) {// 从0，到length-1开始循环
            int a = nums[i];
            if (a > 0) {
                break;
            }
            int left = i + 1;// left 从 i+1出开始 向右移动
            int right = nums.length - 1;// right 从length-1 处开始向左移动
            if (i > 0 && nums[left] == nums[right]) {
                continue;
            }
            while (left < right) {// left和right不相遇 就一直循环
                int target = a + nums[left] + nums[right]; // 根据三数之和进行结果判断
                if (target == 0) {
                    int[] arr = {a, nums[left], nums[right]};
                    List<Integer> list = new ArrayList<>();
                    for (int k = 0; k < arr.length; k++) {
                        list.add(arr[k]);
                    }
                    if (!result.contains(list)) { // 如果结果不重复，则进行数据收集
                        result.add(list);
                    }
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;// left 向右移动
                    right--;// right 向左移动
                } else if (target < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }


    @Test
    public void threeSumResult() {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

}

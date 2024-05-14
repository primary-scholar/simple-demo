package com.mimu.simple.java.leetcode;

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
public class LC__15_ThreeSum {

    public List<List<Integer>> threeSum_Another(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);//调用api进行数组排序
        for (int i = 0; i < nums.length - 2; i++) {// 从0，到length-1开始循环
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) { // 这里是过滤掉重复元素
                continue;
            }
            int left = i + 1;// left 从 i+1出开始 向右移动
            int right = nums.length - 1;// right 从length-1 处开始向左移动
            while (left < right) {// left和right不相遇 就一直循环
                int target = nums[i] + nums[left] + nums[right]; // 根据三数之和进行结果判断
                if (target == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                } else if (target < 0) {
                    while (left < right && nums[left] == nums[++left]) ;
                } else {
                    while (left < right && nums[right] == nums[--right]) ;
                }
            }
        }
        return result;
    }

    /**
     * a+b+c=0;
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum_target(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);//调用api进行数组排序
        for (int i = 0; i < nums.length - 2; i++) {// 从0，到length-2开始循环
            if (nums[i] > target) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {// 这里是过滤掉重复元素
                continue;
            }
            int left = i + 1;// left 从 i+1出开始 向右移动
            int right = nums.length - 1;// right 从length-1 处开始向左移动
            while (left < right) {// left和right不相遇 就一直循环
                int threeSum = nums[i] + nums[left] + nums[right]; // 根据三数之和进行结果判断
                if (threeSum == target) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                } else if (threeSum < target) {
                    while (left < right && nums[left] == nums[++left]) ;
                } else {
                    while (left < right && nums[right] == nums[--right]) ;
                }
            }
        }
        return result;
    }

}

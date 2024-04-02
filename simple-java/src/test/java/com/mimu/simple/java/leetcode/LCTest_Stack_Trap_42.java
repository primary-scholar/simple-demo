package com.mimu.simple.java.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 接雨水问题
 * <p>
 * 使用堆栈寻找 坑(位置和坑大小)的存在，当前元素小于栈顶元素 则把 当前元素的数组索引 入栈 这里说明可能存在坑
 * <p>
 * 使用堆栈 当堆栈为空 或者 当前元素的值 小于 栈顶值 则当前元素的数组索引； 如果当前元素大于栈顶元素且堆栈非空则存在坑，
 * 此时 堆栈非空则 计算 容量； 计算方法
 * <p>
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * Example 1:
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class LCTest_Stack_Trap_42 {

    /**
     * 思路
     * 遍历高度，如果此时栈为空，或者当前高度小于等于栈顶高度，则把当前高度的坐标压入栈，坐标压入栈，是来算水平距离的
     * 当遇到比栈顶高度大的时候，就说明有可能会有坑存在，可以装雨水。此时栈里至少有一个高度，如果只有一个的话，那么不能形成坑，直接跳过；
     * 如果多余一个的话，那么此时把栈顶元素取出来当作坑，新的栈顶元素就是左边界，当前高度是右边界，取二者较小值，减去坑的高度，
     * 长度就是右边界坐标减去左边界坐标再减1，二者相乘既得水量
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        int i = 0, n = height.length, res = 0;
        while (i < n) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) { // 当前堆栈为空，或者当前元素值 小于 栈顶元素
                s.push(i++); // 则 当前元素 数组下标 入栈 ，数组元素后移一位 即 i++;
            } else { // 当前元素 值 大于 栈顶元素  则可能存在 坑
                /**
                 * 下面两步 即判断是否真的存在坑
                 * 先弹出栈顶元素，再判断栈是否为空，
                 * 无坑*
                 * 如果这时堆栈为空 说明堆栈中只有一个元素，那当前元素和堆栈中的元素是无法形成 坑的；所以应直接跳过
                 * 有坑*
                 * 如果这时堆栈非空 说明堆栈中存在多个元素 那当前元素和堆栈中的元素是 存在坑的
                 * 计算容量*
                 * 这时弹出的元素 即为 坑 栈顶元素为左边界，当前元素为右边界
                 * [min(左边界，右边界)-坑高度]*(右边界和左边界的距离)即可
                 */
                int t = s.pop();
                if (s.isEmpty()) continue;
                // [min(左边界，右边界)-坑高度]*(右边界和左边界的距离)
                res += (Math.min(height[s.peek()], height[i]) - height[t]) * (i - s.peek() - 1);
            }
        }
        return res;
    }


    @Test
    public void trapResult() {
        int trap = trap(new int[]{4, 2, 0, 3, 2, 5});
        System.out.println(trap);
    }

}

package com.mimu.simple.java.leetcode;

import org.junit.Test;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * <p>
 * 接雨水问题
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * <p>
 * 使用堆栈寻找 坑(位置和坑大小)的存在，当前元素小于栈顶元素 则把 当前元素的数组索引 入栈 这里说明可能存在坑
 * 使用堆栈 当堆栈为空 或者 当前元素的值 小于 栈顶值 则当前元素的数组索引； 如果当前元素大于栈顶元素且堆栈非空则存在坑，
 * 此时 堆栈非空则 计算 容量； 计算方法
 */
public class LCTest_Stack_42_Trap {

    private LC_Stack_42_Trap trapFunction = new LC_Stack_42_Trap();

    @Test
    public void trapResult() {
        int[] inputs = {4, 2, 0, 3, 2, 5, 1, 2};
        System.out.println(trapFunction.trap(inputs));
        System.out.println(trapFunction.trapAnother(inputs));
    }

}

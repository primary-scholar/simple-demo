package com.mimu.simple.java.leetcode;

import java.util.Stack;

/**
 * 接雨水问题
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Example 1:
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class LC42Test__Trap {

        public int trap(int[] height) {
            Stack<Integer> s = new Stack<>();
            int i = 0, n = height.length, res = 0;
            while (i < n) {
                if (s.isEmpty() || height[i] <= height[s.peek()]) {
                    s.push(i++);
                } else {
                    int t = s.pop();
                    if (s.isEmpty()) continue;
                    res += (Math.min(height[i], height[s.peek()]) - height[t]) * (i - s.peek() - 1);
                }
            }
            return res;
        }


}

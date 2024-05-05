package com.mimu.simple.java.leetcode;

import java.util.Objects;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * Example 1:
 * **Input:** height = [1,8,6,2,5,4,8,3,7]
 * **Output:** 49
 * **Explanation:** The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 * **Input:** height = [1,1]
 * **Output:** 1
 * <p>
 * Constraints:
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 * <p>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器
 */
public class LC__11_MaxArea {

    /**
     * 这里 和下面的 双指针 思路是一致的
     * 只不过对于 Math.min(height[f], height[l]) 这操作做了优化，即并不需要每次都计算出最小值后再移动左右下标；
     * 而是通过判断左右下标的 数值 大小来取 最小值；
     * 不过这里需要注意：
     * 要先计算面积，在开始左右下标的移动 即 (l - f) * height[f++] 这里 (l - f) 要在前面 否则 f++后 对于距离的计算就变动了
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (Objects.isNull(height) || height.length <= 1) {
            return 0;
        }
        int result = Integer.MIN_VALUE, f = 0, l = height.length - 1;
        while (f <= l) {
            result = height[f] < height[l] ? Math.max(result, (l - f) * height[f++])
                    : Math.max(result, (l - f) * height[l--]);
        }
        return result;
    }

    /**
     * 使用双指针，左右向中间逼近，逼近条件是 如果左侧的高度<右侧，则左侧向右，否则右侧向左
     * 这里可以优化
     *
     * @param height
     * @return
     */
    public int maxArea_double_pointer(int[] height) {
        if (Objects.isNull(height) || height.length <= 1) {
            return 0;
        }
        int result = Integer.MIN_VALUE, f = 0, l = height.length - 1;
        while (f <= l) {
            if (height[f] < height[l]) {
                result = Math.max(result, height[f] * (l - f));
                f++;
            } else {
                result = Math.max(result, height[l] * (l - f));
                l--;
            }
        }
        return result;
    }

    /**
     * 穷举法
     *
     * @param height
     * @return
     */
    public int maxArea_force(int[] height) {
        if (Objects.isNull(height) || height.length <= 1) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return result;
    }


}

package com.mimu.simple.java.leetcode;

import java.util.Stack;

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
public class LC_Stack_42_Trap {

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

    /**
     * 我们设置两个指针，left指向数组的0位置，right指针指向数组的n-1位置。再使用两个变量leftMax和rightMax，leftMax的含义是数组0...left位置的最大值，rightMax的含义是数组right...n-1位置的最大值，
     * 这几个变量设置好后就有以下几种情况。
     * leftMax < rightMax，此时可以使用leftMax来结算height[left]位置的储水量。它的右侧可能还会有比rightMax更高的元素，但不会影响left位置的储水量。因为这种情况下left位置左侧的最大值是影响该位置储水量的瓶颈，此时res[left] = leftMax - height[left]。
     * leftMax > rightMax，此时可以使用rightMax来结算right位置的储水量。同样的，它的左侧可能还会有比leftMax更高的元素，但都不影响right位置的储水量。因为这种情况下right位置右侧的最大值是影响该位置储水量的瓶颈。此时res[right] = rightMax - height[right]。
     * leftMax == rightMax，此时既可以结算左侧，也可以结算右侧，或者左右两侧可以同时结算储水量。res[left] = leftMax - height[left]，res[right] = rightMax - height[right]。但是要注意如果结算前left == right，此时只能结算一侧。
     * 不断重复上述流程，哪侧结算就将哪侧的指针相应移动，并在移动的过程中更新leftMax和rightMax，直到两个指针会合，结算完最后一个位置的水量为止;
     *
     * @param height
     * @return
     */
    public int trapAnother(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;  // 左右双指针，无限向中间趋近
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]); // 趋近过程中 记录左侧高度最大值
            rightMax = Math.max(rightMax, height[right]); // 趋近过程中 记录右侧高度最大值
            if (leftMax < rightMax) {
                result += leftMax - height[left]; // 此时可以使用leftMax来结算height[left]位置的储水量,同时 当前位置后移 left++
                left++;
            } else {
                result += rightMax - height[right];  // 此时可以使用rightMax来结算right位置的储水量,同时 当前位置前移 right--
                right--;
            }
        }
        return result;
    }


}

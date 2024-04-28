package com.mimu.simple.java.leetcode;

import org.junit.Test;

import java.util.Arrays;


/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * 最小栈 支持常数级获取 最小元素
 */
public class LCTest {

    private LC_Stack_42_Trap trapFunction = new LC_Stack_42_Trap();
    private LC_Stack_155_MinStack minStack = new LC_Stack_155_MinStack();
    private LC_215_FindKthLargest findKthLargest = new LC_215_FindKthLargest();
    private LC__3_LengthOfLongestSubstring lengthOfLongestSubstring = new LC__3_LengthOfLongestSubstring();

    @Test
    public void minStackResult() {
        minStack.push(3);
        minStack.push(1);
        minStack.push(5);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
    }

    @Test
    public void trapFunctionResult() {
        int[] inputs = {4, 2, 0, 3, 2, 5, 1, 2};
        System.out.println(trapFunction.trap(inputs));
        System.out.println(trapFunction.trapAnother(inputs));
    }

    @Test
    public void findKthLargestResult() {
        int[] element = new int[]{3, 2, 1, 5, 6, 4, 3, 4, 4};
        for (int i = 1; i < element.length; i++) {
            int[] copy = Arrays.copyOf(element, element.length);
            assert findKthLargest.findKthLargestAnother(copy, i) == findKthLargest.findKthLargest(copy, i);
        }
    }

    @Test
    public void lengthOfLongestSubstringResult() {
        assert lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb") == 3;
        assert lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew") == 3;
    }
}

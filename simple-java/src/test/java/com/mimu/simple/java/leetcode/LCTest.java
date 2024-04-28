package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_ListNode;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


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

    private LC_Map_1_AddTwoNumbers addTwoNumbers = new LC_Map_1_AddTwoNumbers();
    private LC__3_LengthOfLongestSubstring lengthOfLongestSubstring = new LC__3_LengthOfLongestSubstring();
    private LC__15_ThreeSum threeSum = new LC__15_ThreeSum();
    private LC_Stack_20_IsValid isValid = new LC_Stack_20_IsValid();
    private LC_Stack_42_Trap trap = new LC_Stack_42_Trap();
    private LC__54_SpiralOrder spiralOrder = new LC__54_SpiralOrder();
    private LC__75_SortColors sortColors = new LC__75_SortColors();
    private LC__136_SingleNumber singleNumber = new LC__136_SingleNumber();
    private LC_Map_146_LRUCache.LRUCache lruCache = new LC_Map_146_LRUCache.LRUCache(2);
    private LC_Stack_155_MinStack minStack = new LC_Stack_155_MinStack();
    private LC__169_MajorityElement majorityElement = new LC__169_MajorityElement();
    private LC_215_FindKthLargest findKthLargest = new LC_215_FindKthLargest();
    private LC_ListNode_234_IsPalindrome isPalindrome = new LC_ListNode_234_IsPalindrome();
    private LC_ListNode_206_ReverseList reverseList = new LC_ListNode_206_ReverseList();


    @Test
    public void addTwoNumbersTest() {
        int[] ints = addTwoNumbers.addTwoNumbers(new int[]{2, 7, 11, 12}, 14);
        int[] ints1 = addTwoNumbers.addTwoNumbers(new int[]{3, 3}, 6);
        assert Arrays.equals(ints, new int[]{0, 3});
        assert Arrays.equals(ints1, new int[]{0, 1});
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        assert lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb") == 3;
        assert lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew") == 3;
    }

    @Test
    public void lruCacheTest() {
        lruCache.put(1, 1); // 缓存是 {1=1}
        lruCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lruCache.get(1));    // 返回 1
        lruCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lruCache.get(2));    // 返回 -1 (未找到)
        lruCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lruCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lruCache.get(3));    // 返回 3
        System.out.println(lruCache.get(4));    // 返回 4
    }

    @Test
    public void minStackTest() {
        minStack.push(3);
        minStack.push(1);
        minStack.push(5);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
    }

    @Test
    public void trapTest() {
        int[] inputs = {4, 2, 0, 3, 2, 5, 1, 2};
        System.out.println(trap.trap(inputs));
        System.out.println(trap.trapAnother(inputs));
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
    public void quotaValid() {
        String quota = "()[]{}";
        System.out.println(isValid.isValid(quota));
        System.out.println(isValid.isValid("(}"));
    }

    @Test
    public void threeSumResult() {
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }


    @Test
    public void spiralOrderResult() {
        List<Integer> integers1 = spiralOrder.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        System.out.println(integers1);
    }

    @Test
    public void sortColorsTest() {
        int[] colors = {0, 1, 0, 2, 0, 1, 2, 0, 2, 0, 1};
        sortColors.sortColors(colors);
        for (int color : colors) {
            System.out.print(color);
        }
    }

    @Test
    public void singleNumberTest() {
        int[] colors = {11, 11, 12, 12, 13};
        System.out.println(singleNumber.singleNumber(colors));
    }

    @Test
    public void majorityElementTest() {
        int[] colors = {0, 1, 0, 2, 0, 1, 2, 0, 2, 0, 1, 2, 2};
        System.out.println(majorityElement.majorityElement(colors));
    }

    @Test
    public void isPalindromeTest() {
        List<Integer> first = Arrays.asList(1, 2, 2, 1);
        List<Integer> second = Arrays.asList(1, 2, 3, 2, 1);
        List<Integer> third = Arrays.asList(1, 2, 3, 2);
        System.out.println(isPalindrome.isPalindrome(isPalindrome.list2LinkNode(first)));
        System.out.println(isPalindrome.isPalindrome(isPalindrome.list2LinkNode(second)));
        System.out.println(isPalindrome.isPalindrome(isPalindrome.list2LinkNode(third)));
    }

    @Test
    public void reverseListTest() {
        List<Integer> first = Arrays.asList(1, 2, 3, 4);
        LC_ListNode.LinkNode linkNode = reverseList.reverseList(reverseList.list2LinkNode(first));
        List<Integer> rlist = reverseList.linkNode2List(linkNode);
        System.out.println(rlist);
    }

}


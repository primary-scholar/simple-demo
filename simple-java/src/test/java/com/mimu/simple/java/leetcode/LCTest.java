package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_ListNode;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
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
    private LC_ListNode_2_AddTwoNumbers listNode_2_addTwoNumbers = new LC_ListNode_2_AddTwoNumbers();
    private LC__3_LengthOfLongestSubstring lengthOfLongestSubstring = new LC__3_LengthOfLongestSubstring();
    private LC__15_ThreeSum threeSum = new LC__15_ThreeSum();
    private LC_ListNode_19_RemoveNthFromEnd removeNthFromEnd = new LC_ListNode_19_RemoveNthFromEnd();
    private LC_Stack_20_IsValid isValid = new LC_Stack_20_IsValid();
    private LC_ListNode_21_MergeTwoLists mergeTwoLists = new LC_ListNode_21_MergeTwoLists();
    private LC_ListNode_23_MergeKLists mergeKLists = new LC_ListNode_23_MergeKLists();
    private LC_Array_31_NextPermutation nextPermutation = new LC_Array_31_NextPermutation();
    private LC_BinQry_33_Search search = new LC_BinQry_33_Search();
    private LC_BinQry_35_SearchInsert searchInsert = new LC_BinQry_35_SearchInsert();
    private LC_Stack_42_Trap trap = new LC_Stack_42_Trap();
    private LC_Array_46_BT_Permute permute = new LC_Array_46_BT_Permute();
    private LC_Array_47_BT_PermuteUnique permuteUnique = new LC_Array_47_BT_PermuteUnique();
    private LC_Array_49_GroupAnagrams groupAnagrams = new LC_Array_49_GroupAnagrams();
    private LC_Array_53_MaxSubArray maxSubArray = new LC_Array_53_MaxSubArray();
    private LC__54_SpiralOrder spiralOrder = new LC__54_SpiralOrder();
    private LC_BinQry_74_SearchMatrix searchMatrix = new LC_BinQry_74_SearchMatrix();
    private LC__75_SortColors sortColors = new LC__75_SortColors();
    private LC_Array_77_BT_Combine combine = new LC_Array_77_BT_Combine();
    private LC_Array_88_Merge merge = new LC_Array_88_Merge();
    private LC_Array_121_MaxProfit maxProfit = new LC_Array_121_MaxProfit();
    private LC_Array_128_LongestConsecutive longestConsecutive = new LC_Array_128_LongestConsecutive();
    private LC__136_SingleNumber singleNumber = new LC__136_SingleNumber();
    private LC_ListNode_141_HasCycle hasCycle = new LC_ListNode_141_HasCycle();
    private LC_ListNode_142_DetectCycle detectCycle = new LC_ListNode_142_DetectCycle();
    private LC_Map_146_LRUCache.LRUCache lruCache = new LC_Map_146_LRUCache.LRUCache(2);
    private LC_ListNode_148_SortList sortList = new LC_ListNode_148_SortList();
    private LC_BinQry_153_FindMin findMin = new LC_BinQry_153_FindMin();
    private LC_Stack_155_MinStack minStack = new LC_Stack_155_MinStack();
    private LC_ListNode_160_GetIntersectionNode getIntersectionNode = new LC_ListNode_160_GetIntersectionNode();
    private LC__169_MajorityElement majorityElement = new LC__169_MajorityElement();
    private LC_ListNode_206_ReverseList reverseList = new LC_ListNode_206_ReverseList();
    private LC_215_FindKthLargest findKthLargest = new LC_215_FindKthLargest();
    private LC_ListNode_234_IsPalindrome isPalindrome = new LC_ListNode_234_IsPalindrome();
    private LC__242_IsAnagram isAnagram = new LC__242_IsAnagram();
    private LC__283_MoveZeroes moveZeroes = new LC__283_MoveZeroes();
    private LC__287_FindDuplicate findDuplicate = new LC__287_FindDuplicate();
    private LC_Array_300_LengthOfLIS lengthOfLIS = new LC_Array_300_LengthOfLIS();
    private LC__347_TopKFrequent topKFrequent = new LC__347_TopKFrequent();
    private LC__438_FindAnagrams findAnagrams = new LC__438_FindAnagrams();
    private LC__560_SubarraySum subarraySum = new LC__560_SubarraySum();

    @Test
    public void addTwoNumbersTest() {
        int[] ints = addTwoNumbers.addTwoNumbers(new int[]{2, 7, 11, 12}, 14);
        int[] ints1 = addTwoNumbers.addTwoNumbers(new int[]{3, 3}, 6);
        assert Arrays.equals(ints, new int[]{0, 3});
        assert Arrays.equals(ints1, new int[]{0, 1});
    }

    @Test
    public void listNode_2_addTwoNumbersTest() {
        LC_ListNode.ListNode aFR = listNode_2_addTwoNumbers.addTwoNumbers(listNode_2_addTwoNumbers.list2Node(Arrays.asList(2, 4, 3)), listNode_2_addTwoNumbers.list2Node(Arrays.asList(5, 6, 4)));
        assert CollectionUtils.isEqualCollection(listNode_2_addTwoNumbers.node2List(aFR), Arrays.asList(7, 0, 8));
        LC_ListNode.ListNode aSR = listNode_2_addTwoNumbers.addTwoNumbers(listNode_2_addTwoNumbers.list2Node(Arrays.asList(9, 9, 9, 9, 9, 9, 9)), listNode_2_addTwoNumbers.list2Node(Arrays.asList(9, 9, 9, 9)));
        assert CollectionUtils.isEqualCollection(listNode_2_addTwoNumbers.node2List(aSR), Arrays.asList(8, 9, 9, 9, 0, 0, 0, 1));
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        assert lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb") == 3;
        assert lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew") == 3;
    }

    @Test
    public void threeSumTest() {
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
        System.out.println(threeSum.threeSum_Another(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum.threeSum_target(new int[]{-1, 0, 1, 2, -1, -4}, 1));
    }

    @Test
    public void removeNthFromEndTest() {
        List<Integer> second = Arrays.asList(9, 2, 4);
        LC_ListNode.ListNode newNode = removeNthFromEnd.removeNthFromEnd(removeNthFromEnd.list2Node(second), 2);
        System.out.println(removeNthFromEnd.node2List(newNode));
    }

    @Test
    public void isValidTest() {
        String quota = "()[]{}";
        System.out.println(isValid.isValid(quota));
        System.out.println(isValid.isValid("(}"));
    }

    @Test
    public void mergeTwoListsTest() {
        List<Integer> first = Arrays.asList(1, 8);
        List<Integer> second = Arrays.asList(9, 2, 4);
        LC_ListNode.ListNode firstNode = sortList.sortList(mergeTwoLists.list2Node(first));
        LC_ListNode.ListNode secondNode = sortList.sortList(mergeTwoLists.list2Node(second));
        LC_ListNode.ListNode merge = mergeTwoLists.mergeTwoLists(firstNode, secondNode);
        System.out.println(mergeTwoLists.node2List(merge));
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
    public void findMinTest() {
        System.out.println(findMin.findMin(new int[]{5, 6, 1, 2, 3, 4}));
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
    public void nextPermutationTest() {
        int[] origin = {1, 1, 5};
        nextPermutation.nextPermutation(origin);
        for (int i : origin) {
            System.out.print(i);
        }
    }

    @Test
    public void searchTest() {
        System.out.println(search.search(new int[]{5, 6, 1, 2, 3, 4}, 1));
    }

    @Test
    public void searchInsertTest() {
        System.out.println(searchInsert.searchInsert(new int[]{1, 2, 3, 4}, 3));
    }

    @Test
    public void trapTest() {
        int[] inputs = {4, 2, 0, 3, 2, 5, 1, 2};
        System.out.println(trap.trap(inputs));
        System.out.println(trap.trapAnother(inputs));
    }

    @Test
    public void permuteTest() {
        System.out.println(permute.permute(new int[]{1, 3, 7}));
    }

    @Test
    public void permuteUniqueTest() {
        System.out.println(permuteUnique.permuteUnique(new int[]{1, 3, 3}));
    }

    @Test
    public void groupAnagramsTest() {
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    @Test
    public void maxSubArrayTest() {
        System.out.println(maxSubArray.maxSubArray(new int[]{1, -3, -3, 7}));
    }

    @Test
    public void searchMatrixTest() {
        int[][] nums = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix.searchMatrix(nums, 16));
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
    public void combineTest() {
        System.out.println(combine.combine(4, 2));
    }

    @Test
    public void mergeTest() {
        int[] target = {1, 2, 3, 0, 0, 0};
        merge.merge(target, 3, new int[]{2, 5, 6}, 3);
        for (int i : target) {
            System.out.print(i);
        }
    }

    @Test
    public void maxProfitTest() {
        assert 5 == maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assert 0 == maxProfit.maxProfit(new int[]{7, 6, 4, 3, 1});
    }

    @Test
    public void longestConsecutiveTest() {
        System.out.println(longestConsecutive.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    @Test
    public void singleNumberTest() {
        int[] colors = {11, 11, 12, 12, 13};
        System.out.println(singleNumber.singleNumber(colors));
    }

    @Test
    public void mergeKListsTest() {
        List<Integer> first = Arrays.asList(1, 8);
        List<Integer> second = Arrays.asList(9, 2, 4);
        List<Integer> third = Arrays.asList(6, 3, 7, 5);
        LC_ListNode.ListNode firstNode = sortList.sortList(mergeKLists.list2Node(first));
        LC_ListNode.ListNode secondNode = sortList.sortList(mergeKLists.list2Node(second));
        LC_ListNode.ListNode thirdNode = sortList.sortList(mergeKLists.list2Node(third));
        LC_ListNode.ListNode merge = mergeKLists.mergeKLists((Arrays.asList(firstNode, secondNode, thirdNode).toArray(new LC_ListNode.ListNode[]{})));
        System.out.println(mergeKLists.node2List(merge));
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
    public void spiralOrderResult() {
        List<Integer> integers1 = spiralOrder.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        System.out.println(integers1);
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
        System.out.println(isPalindrome.isPalindrome(isPalindrome.list2Node(first)));
        System.out.println(isPalindrome.isPalindrome(isPalindrome.list2Node(second)));
        System.out.println(isPalindrome.isPalindrome(isPalindrome.list2Node(third)));
    }

    @Test
    public void reverseListTest() {
        List<Integer> first = Arrays.asList(1, 2, 3, 4);
        LC_ListNode.ListNode linkNode = reverseList.reverseList(reverseList.list2Node(first));
        List<Integer> rlist = reverseList.node2List(linkNode);
        System.out.println(rlist);
    }

    @Test
    public void getIntersectionNodeTest() {
        List<Integer> first = Arrays.asList(4, 1, 8, 4, 5);
        List<Integer> second = Arrays.asList(5, 6, 1, 8, 4, 5);
        LC_ListNode.ListNode node = getIntersectionNode.getIntersectionNode(getIntersectionNode.list2Node(first), getIntersectionNode.list2Node(second));
        System.out.println(node.val);
    }

    @Test
    public void sortListTest() {
        List<Integer> second = Arrays.asList(5, 6, 1, 8, 4, 5);
        LC_ListNode.ListNode listNode = sortList.sortList(sortList.list2Node(second));
        System.out.println(sortList.node2List(listNode));
    }

    @Test
    public void detectCycleTest() {
        List<Integer> second = Arrays.asList(5, 6, 1, 8, 4, 5, 7, 9, 2);
        LC_ListNode.ListNode listNode = detectCycle.detectCycle(detectCycle.list2CycleNode(second));
        System.out.println(listNode.val);
    }

    @Test
    public void hasCycleTest() {
        List<Integer> second = Arrays.asList(5, 6, 1, 8, 4, 5, 7, 9, 2);
        System.out.println(hasCycle.hasCycle(hasCycle.list2Node(second)));
        System.out.println(hasCycle.hasCycle(hasCycle.list2CycleNode(second)));
    }

    @Test
    public void isAnagramTest() {
        System.out.println(isAnagram.isAnagram("eat", "tea"));
    }

    @Test
    public void moveZeroesTest() {
        int[] origin = {1, 3, 5, 0, 3, 0, 5, 0, 0};
        moveZeroes.moveZeroes(origin);
        for (int i : origin) {
            System.out.print(i);
        }
    }

    @Test
    public void findDuplicateTest() {
        System.out.println(findDuplicate.findDuplicate(new int[]{1, 3, 2, 4, 2}));
    }

    @Test
    public void lengthOfLISTest() {
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    @Test
    public void topKFrequentTest() {
        int[] origin = topKFrequent.topKFrequent(new int[]{1, 3, 5, 0, 3, 0, 5, 0, 0}, 3);
        for (int i : origin) {
            System.out.print(i);
        }
    }

    @Test
    public void findAnagramsTest() {
        System.out.println(findAnagrams.findAnagrams_force("baa", "aa"));
    }

    @Test
    public void subarraySumTest() {
        int i = subarraySum.subarraySum_force(new int[]{1, 5, 2, 4, 2, 2, 2}, 6);
        System.out.println(i);
    }

}


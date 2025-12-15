package com.mimu.simple.java.leetcode;

import com.mimu.simple.java.leetcode.base.LC_ListNode;
import com.mimu.simple.java.leetcode.base.LC_TreeNode;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LCTest {

    private LC_Map_1_AddTwoNumbers addTwoNumbers = new LC_Map_1_AddTwoNumbers();
    private LC_ListNode_2_AddTwoNumbers listNode_2_addTwoNumbers = new LC_ListNode_2_AddTwoNumbers();
    private LC__3_LengthOfLongestSubstring lengthOfLongestSubstring = new LC__3_LengthOfLongestSubstring();
    private LC_DP_5_LongestPalindrome longestPalindrome = new LC_DP_5_LongestPalindrome();
    private LC__15_ThreeSum threeSum = new LC__15_ThreeSum();
    private LC_ListNode_19_RemoveNthFromEnd removeNthFromEnd = new LC_ListNode_19_RemoveNthFromEnd();
    private LC_Stack_20_IsValid isValid = new LC_Stack_20_IsValid();
    private LC_ListNode_21_MergeTwoLists mergeTwoLists = new LC_ListNode_21_MergeTwoLists();
    private LC_ListNode_23_MergeKLists mergeKLists = new LC_ListNode_23_MergeKLists();
    private LC_Array_31_NextPermutation nextPermutation = new LC_Array_31_NextPermutation();
    private LC_BinQry_33_Search search = new LC_BinQry_33_Search();
    private LC_BinQry_35_SearchInsert searchInsert = new LC_BinQry_35_SearchInsert();
    private LC_Array_39_BT_CombinationSum combinationSum = new LC_Array_39_BT_CombinationSum();
    private LC_Stack_42_Trap trap = new LC_Stack_42_Trap();
    private LC_Array_46_BT_Permute permute = new LC_Array_46_BT_Permute();
    private LC_Array_47_BT_PermuteUnique permuteUnique = new LC_Array_47_BT_PermuteUnique();
    private LC_Array_49_GroupAnagrams groupAnagrams = new LC_Array_49_GroupAnagrams();
    private LC_Array_53_MaxSubArray maxSubArray = new LC_Array_53_MaxSubArray();
    private LC__54_SpiralOrder spiralOrder = new LC__54_SpiralOrder();
    private LC_Array_56_Merge array56Merge = new LC_Array_56_Merge();
    private LC_DP_62_UniquePaths uniquePaths = new LC_DP_62_UniquePaths();
    private LC_DP_64_MinPathSum minPathSum = new LC_DP_64_MinPathSum();
    private LC_DP_70_ClimbStairs climbStairs = new LC_DP_70_ClimbStairs();
    private LC_BinQry_74_SearchMatrix searchMatrix = new LC_BinQry_74_SearchMatrix();
    private LC__75_SortColors sortColors = new LC__75_SortColors();
    private LC_Array_77_BT_Combine combine = new LC_Array_77_BT_Combine();
    private LC_Array_88_Merge merge = new LC_Array_88_Merge();
    private LC_BinTreeNode_94_InorderTraversal inorderTraversal = new LC_BinTreeNode_94_InorderTraversal();
    private LC_BinTreeNode_98_IsValidBST isValidBST = new LC_BinTreeNode_98_IsValidBST();
    private LC_BinTreeNode_101_IsSymmetric isSymmetric = new LC_BinTreeNode_101_IsSymmetric();
    private LC_BinTreeNode_102_LevelOrder levelOrder = new LC_BinTreeNode_102_LevelOrder();
    private LC_BinTreeNode_103_ZigzagLevelOrder zigzagLevelOrder = new LC_BinTreeNode_103_ZigzagLevelOrder();
    private LC_BinTreeNode_104_MaxDepth maxDepth = new LC_BinTreeNode_104_MaxDepth();
    private LC_BinTreeNode_105_BuildTree buildTree = new LC_BinTreeNode_105_BuildTree();
    private LC_BinTreeNode_108_SortedArrayToBST sortedArrayToBST = new LC_BinTreeNode_108_SortedArrayToBST();
    private LC_BinTreeNode_114_Flatten flatten = new LC_BinTreeNode_114_Flatten();
    private LC_DP_118_Generate generate = new LC_DP_118_Generate();
    private LC_Array_121_MaxProfit maxProfit = new LC_Array_121_MaxProfit();
    private LC_Array_128_LongestConsecutive longestConsecutive = new LC_Array_128_LongestConsecutive();
    private LC_BinTreeNode_129_SumNumbers sumNumbers = new LC_BinTreeNode_129_SumNumbers();
    private LC__136_SingleNumber singleNumber = new LC__136_SingleNumber();
    private LC_ListNode_141_HasCycle hasCycle = new LC_ListNode_141_HasCycle();
    private LC_ListNode_142_DetectCycle detectCycle = new LC_ListNode_142_DetectCycle();
    private LC_Map_146_LRUCache.LRUCache lruCache = new LC_Map_146_LRUCache.LRUCache(2);
    private LC_ListNode_148_SortList sortList = new LC_ListNode_148_SortList();
    private LC_BinQry_153_FindMin findMin = new LC_BinQry_153_FindMin();
    private LC_Stack_155_MinStack minStack = new LC_Stack_155_MinStack();
    private LC_ListNode_160_GetIntersectionNode getIntersectionNode = new LC_ListNode_160_GetIntersectionNode();
    private LC__169_MajorityElement majorityElement = new LC__169_MajorityElement();
    private LC_Array_189_Rotate rotate = new LC_Array_189_Rotate();
    private LC_DP_198_Rob rob = new LC_DP_198_Rob();
    private LC_BinTreeNode_199_RightSideView rightSideView = new LC_BinTreeNode_199_RightSideView();
    private LC_DFS_200_NumIsLands numIsLands = new LC_DFS_200_NumIsLands();
    private LC_ListNode_206_ReverseList reverseList = new LC_ListNode_206_ReverseList();
    private LC_215_FindKthLargest findKthLargest = new LC_215_FindKthLargest();
    private LC_BinTreeNode_230_KthSmallest kthSmallest = new LC_BinTreeNode_230_KthSmallest();
    private LC_Stack_232_MyQueue myQueue = new LC_Stack_232_MyQueue();
    private LC_ListNode_234_IsPalindrome isPalindrome = new LC_ListNode_234_IsPalindrome();
    private LC_BinTreeNode_236_LowestCommonAncestor lowestCommonAncestor =
            new LC_BinTreeNode_236_LowestCommonAncestor();
    private LC_Array_238_ProductExceptSelf productExceptSelf = new LC_Array_238_ProductExceptSelf();
    private LC__242_IsAnagram isAnagram = new LC__242_IsAnagram();
    private LC_BinTreeNode_266_InvertTree invertTree = new LC_BinTreeNode_266_InvertTree();
    private LC_DP_279_NumSquares numSquares = new LC_DP_279_NumSquares();
    private LC__283_MoveZeroes moveZeroes = new LC__283_MoveZeroes();
    private LC__287_FindDuplicate findDuplicate = new LC__287_FindDuplicate();
    private LC_DP_300_LengthOfLIS lengthOfLIS = new LC_DP_300_LengthOfLIS();
    private LC_DP_322_CoinChange coinChange = new LC_DP_322_CoinChange();
    private LC__347_TopKFrequent topKFrequent = new LC__347_TopKFrequent();
    private LC__438_FindAnagrams findAnagrams = new LC__438_FindAnagrams();
    private LC_DP_509_Fib fib = new LC_DP_509_Fib();
    private LC_BinTreeNode_543_DiameterOfBinaryTree diameterOfBinaryTree =
            new LC_BinTreeNode_543_DiameterOfBinaryTree();
    private LC__560_SubarraySum subarraySum = new LC__560_SubarraySum();
    private LC_DP_1143_LongestCommonSubsequence longestCommonSubsequence = new LC_DP_1143_LongestCommonSubsequence();
    private LC_DP__LongestCommonString longestCommonString = new LC_DP__LongestCommonString();

    @Test
    public void addTwoNumbersTest() {
        int[] ints = addTwoNumbers.addTwoNumbers(new int[]{2, 7, 11, 12}, 14);
        int[] ints1 = addTwoNumbers.addTwoNumbers(new int[]{3, 3}, 6);
        assert Arrays.equals(ints, new int[]{0, 3});
        assert Arrays.equals(ints1, new int[]{0, 1});
    }

    @Test
    public void listNode_2_addTwoNumbersTest() {
        LC_ListNode.ListNode aFR =
                listNode_2_addTwoNumbers.addTwoNumbers(listNode_2_addTwoNumbers.list2Node(Arrays.asList(2, 4, 3)),
                        listNode_2_addTwoNumbers.list2Node(Arrays.asList(5, 6, 4)));
        assert CollectionUtils.isEqualCollection(listNode_2_addTwoNumbers.node2List(aFR), Arrays.asList(7, 0, 8));
        LC_ListNode.ListNode aSR =
                listNode_2_addTwoNumbers.addTwoNumbers(listNode_2_addTwoNumbers.list2Node(Arrays.asList(9, 9, 9, 9, 9
                        , 9, 9)), listNode_2_addTwoNumbers.list2Node(Arrays.asList(9, 9, 9, 9)));
        assert CollectionUtils.isEqualCollection(listNode_2_addTwoNumbers.node2List(aSR), Arrays.asList(8, 9, 9, 9, 0
                , 0, 0, 1));
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        assert lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb") == 3;
        assert lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew") == 3;
    }


    @Test
    public void longestPalindromeTest() {
        System.out.println(longestPalindrome.longestPalindrome("babad"));
        System.out.println(longestPalindrome.longestPalindrome_Another("babad"));
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
        System.out.println(search.search(new int[]{5, 6, 7, 1, 2, 3, 4}, 3));
        System.out.println(search.search(new int[]{5, 6, 7, 1, 2, 3, 4}, 5));
        System.out.println(search.search(new int[]{1, 0, 1, 1, 1}, 0));
    }

    @Test
    public void searchInsertTest() {
        System.out.println(searchInsert.searchInsert(new int[]{1, 2, 3, 4}, 3));
    }

    @Test
    public void combinationSumTest() {
        int[] ints = {2, 3, 6, 7};
        System.out.println(combinationSum.combinationSum(ints, 7));
        System.out.println();
        System.out.println(combinationSum.combinationSum_another(ints, 7));
        System.out.println();
        System.out.println(combinationSum.combinationSum_another(new int[]{2, 3, 5}, 8));
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
        System.out.println(maxSubArray.maxSubArray(new int[]{1, -5, -3, 7}));
        System.out.println(maxSubArray.maxSubArray(new int[]{6, -3, -2, 1}));
    }

    @Test
    public void spiralOrderResult() {
        List<Integer> integers1 = spiralOrder.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}});
        System.out.println(integers1);
    }

    @Test
    public void array56MergeTest() {
        int[][] merged = array56Merge.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i][0]);
            System.out.print(merged[i][1]);
        }
    }

    @Test
    public void uniquePathsTest() {
        int i = uniquePaths.uniquePaths(4, 3);
        System.out.println(i);
    }

    @Test
    public void minPathSumTest() {
        int[][] ints = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum.minPathSum(ints));
    }

    @Test
    public void climbStairsTest() {
        System.out.println(climbStairs.climbStairs(5));
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
    public void inorderTraversalTest() {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> queue = inorderTraversal.inorderTraversal(inorderTraversal.list2TreeByLevel(integers));
        for (Integer i : queue) {
            System.out.print(i);
        }
    }

    @Test
    public void isValidBSTTest() {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(5, 1, 4, null, null, 3, 6));
        assert !isValidBST.isValidBST(isValidBST.list2TreeByLevel(integers));
        assert isValidBST.isValidBST(isValidBST.list2TreeByLevel(new LinkedList<>(Arrays.asList(2, 1, 3))));
    }

    @Test
    public void isSymmetricTest() {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 3));
        System.out.println(isSymmetric.isSymmetric(isValidBST.list2TreeByLevel(integers)));
    }

    @Test
    public void levelOrderTest() {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 9, 20, null, null, 15, 7));
        System.out.println(levelOrder.levelOrder(levelOrder.list2TreeByLevel(integers)));
    }

    @Test
    public void zigzagLevelOrderTest() {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 9, 20, null, null, 15, 7));
        System.out.println(zigzagLevelOrder.zigzagLevelOrder(zigzagLevelOrder.list2TreeByLevel(integers)));
    }

    @Test
    public void maxDepthTest() {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 9, 20, null, null, 15, 7));
        System.out.println(maxDepth.maxDepth(maxDepth.list2TreeByLevel(integers)));
    }

    @Test
    public void buildTreeTest() {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        LC_TreeNode.TreeNode tree = buildTree.buildTree(preOrder, inOrder);
        System.out.println(levelOrder.levelOrder(tree));
    }

    @Test
    public void sortedArrayToBSTTest() {
        LC_TreeNode.TreeNode treeNode = sortedArrayToBST.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(levelOrder.levelOrder(treeNode));
    }

    @Test
    public void flattenTest() {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(1, 2, 5, 3, 4, 6));
        LC_TreeNode.TreeNode treeNode = flatten.list2TreeByLevel(integers);
        flatten.flatten(treeNode);
        System.out.println(levelOrder.levelOrder(treeNode));
    }

    @Test
    public void generateTest() {
        List<List<Integer>> generate1 = generate.generate(5);
        System.out.println(generate1);
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
    public void sumNumbersTest() {
        LC_TreeNode.TreeNode treeNode = sumNumbers.list2TreeByLevel(new LinkedList<>(Arrays.asList(1, 2, 3)));
        assert sumNumbers.sumNumbers(treeNode) == 25;
        LC_TreeNode.TreeNode node = sumNumbers.list2TreeByLevel(new LinkedList<>(Arrays.asList(4, 9, 0, 5, 1)));
        assert sumNumbers.sumNumbers(node) == 1026;
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
        LC_ListNode.ListNode merge =
                mergeKLists.mergeKLists((Arrays.asList(firstNode, secondNode, thirdNode).toArray(new LC_ListNode.ListNode[]{})));
        System.out.println(mergeKLists.node2List(merge));
    }

    @Test
    public void rightSideViewTest() {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 9, 20, null, null, 15, 7));
        System.out.println(rightSideView.rightSideView(rightSideView.list2TreeByLevel(integers)));
    }

    @Test
    public void numIsLandsTest() {
        char[][] metrix = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0',
                '0'}, {'0', '0', '0', '1', '1'}};
        int i = numIsLands.numIslands(metrix);
        System.out.println(i);
    }

    @Test
    public void reverseListTest() {
        List<Integer> first = Arrays.asList(1, 2, 3, 4);
        LC_ListNode.ListNode linkNode = reverseList.reverseList(reverseList.list2Node(first));
        List<Integer> rlist = reverseList.node2List(linkNode);
        System.out.println(rlist);
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
    public void kthSmallestTest() {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(5, 1, 4, null, null, 3, 6));
        LC_TreeNode.TreeNode treeNode = kthSmallest.list2TreeByLevel(integers);
        System.out.println(kthSmallest.kthSmallest(treeNode, 3));
    }

    @Test
    public void majorityElementTest() {
        int[] colors = {0, 1, 0, 2, 0, 1, 2, 0, 2, 0, 1, 2, 2};
        System.out.println(majorityElement.majorityElement(colors));
    }

    @Test
    public void rotateTest() {
        int[] origin = {1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(origin, 3);
        for (int i = 0; i < origin.length; i++) {
            System.out.print(i);
        }
    }

    @Test
    public void robTest() {
        System.out.println(rob.rob(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void getIntersectionNodeTest() {
        List<Integer> first = Arrays.asList(4, 1, 8, 4, 5);
        List<Integer> second = Arrays.asList(5, 6, 1, 8, 4, 5);
        LC_ListNode.ListNode node = getIntersectionNode.getIntersectionNode(getIntersectionNode.list2Node(first),
                getIntersectionNode.list2Node(second));
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
    public void myQueueTest() {
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
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
    public void lowestCommonAncestorTest() {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 9, 20, null, null, 15, 7));
        LC_TreeNode.TreeNode treeNode = lowestCommonAncestor.list2TreeByLevel(integers);
        //lowestCommonAncestor.lowestCommonAncestor()
    }

    @Test
    public void productExceptSelfTest() {
        int[] result = productExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }

    @Test
    public void isAnagramTest() {
        System.out.println(isAnagram.isAnagram("eat", "tea"));
    }

    @Test
    public void invertTreeTest() {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 9, 20, null, null, 15, 7));
        LC_TreeNode.TreeNode treeNode = invertTree.invertTree(invertTree.list2TreeByLevel(integers));
        System.out.println(levelOrder.levelOrder(treeNode));
    }

    @Test
    public void numSquaresTest() {
        System.out.println(numSquares.numSquares(19));
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
    public void coinChangeTest() {
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
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
        System.out.println(findAnagrams.findAnagrams_force("baabaaaa", "aa"));
    }

    @Test
    public void fibTest() {
        System.out.println(fib.fib(5));
    }

    @Test
    public void diameterOfBinaryTreeTest() {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 9, 20, null, null, 15, 7));
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(diameterOfBinaryTree.list2TreeByLevel(integers)));
    }

    @Test
    public void subarraySumTest() {
        int i = subarraySum.subarraySum_force(new int[]{1, 5, 2, 4, 2, 2, 2}, 6);
        System.out.println(i);
    }

    @Test
    public void longestCommonSubsequenceTest() {
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
    }

    @Test
    public void longestCommonStringTest() {
        int threshold = 3;
        String title = "1DABF2345CD";
        String query = "12345DAB";
        System.out.println(title.length());
        System.out.println(title.substring(1, title.length()));
        //System.out.println(title);
        //System.out.println(longestCommonString.multiSubLcs(title, query, threshold));
        long begin = System.currentTimeMillis();
        System.out.println(begin);
        System.out.println(longestCommonString.multiLongestCommonString("纸质火车票成为历史 火车票电子发票如何开",
                "今起纸质火车票成为历史", threshold));
        System.out.println(System.currentTimeMillis() - begin);
    }

}


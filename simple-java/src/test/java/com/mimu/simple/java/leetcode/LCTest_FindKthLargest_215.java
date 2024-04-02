package com.mimu.simple.java.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 寻找数组中第 k 大的元素
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
public class LCTest_FindKthLargest_215 {

    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = partition1Idx(nums, left, right);
            if (pos == nums.length - k) return nums[pos];
            if (pos < nums.length - k) left = pos + 1;
            else right = pos - 1;
        }
    }

    /**
     * 使用 堆排序的 有序队列，进行排序 查找
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestAnother(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minQueue.size() < k || num > minQueue.peek()) {
                minQueue.offer(num);
            }
            if (minQueue.size() > k) {
                minQueue.poll();
            }
        }
        return minQueue.peek();
    }

    public Integer partition1Idx(int[] array, Integer left, Integer right) {
        if (left > right) {
            return -1;
        }
        if (left.equals(right)) {
            return left;
        }
        //初始 把数组分成两块 <= 区和>区，<=区为 (array[0],array[left-1]),>区为 (array[left],array[right])两部分 并从 left 开始循环
        int le = left - 1, idx = left;
        // 从 left 到 right 开始循环
        while (idx < right) {
            // 如果当前元素 <= 候选数 则  把当前元素和 <=区的下一个元素进行交换
            if (array[idx] <= array[right]) {
                swap(array, idx, ++le);
            }
            idx++; // 当前 下标 ++
        }
        swap(array, ++le, right); // 把 候选数 和 < 区域的右边界 的下一个 进行交换，
        return le;
    }

    private void swap(int[] array, int i, int j) {
        if (Objects.isNull(array) || array.length <= 1) {
            return;
        }
        Integer tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    @Test
    public void printResult() {
        int[] element = new int[]{3, 2, 1, 5, 6, 4, 3, 4, 4};
        for (int i = 1; i < element.length; i++) {
            int[] copy = Arrays.copyOf(element, element.length);
            assert findKthLargestAnother(copy, i) == findKthLargest(copy, i);
        }
    }
}

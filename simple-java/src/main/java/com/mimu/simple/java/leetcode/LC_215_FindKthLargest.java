package com.mimu.simple.java.leetcode;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * <p>
 * 寻找数组中第 k 大的元素
 */
public class LC_215_FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            // 这里 pos 的值就是 划分两个区域的 左侧区域的右边界，而 nums.length-k 就是 整个数组右边界 向左的第k个元素位置
            int pos = partition1Idx(nums, left, right);
            if (pos == nums.length - k) {
                return nums[pos];
            } else if (pos < nums.length - k) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
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
        swap(array, ++le, right); // 把 候选数 和 <= 区域的右边界 的下一个 进行交换，
        return le;
    }

    private void swap(int[] array, int i, int j) {
        if (Objects.isNull(array) || array.length <= 1) {
            return;
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}

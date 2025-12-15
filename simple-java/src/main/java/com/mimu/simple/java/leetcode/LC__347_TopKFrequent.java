package com.mimu.simple.java.leetcode;


import java.util.*;

/**
 * Given a non-empty array of integers, return the  k  most frequent elements.
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 * You may assume  k  is always valid, 1 ≤  k  ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O( n  log  n ), where  n  is the array's size.
 * <p>
 * 前k个高频元素 要求 <= O(nlogn)
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案
 */
public class LC__347_TopKFrequent {

    /**
     * 使用 map 记录 数组中 数字的频次，然后对 频次进行 逆序排列，取前k个即可
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        // key : 数字; value ：出现到频次
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            numFreq.put(curNum, numFreq.getOrDefault(curNum, 0) + 1);
        }
        // 根据 value 进行逆序排序
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList(numFreq.entrySet());
        /*Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });*/
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    /**
     * 使用 map 记录 数组中 数字的频次，然后对 频次进行 逆序排列，取前k个即可
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent_another(int[] nums, int k) {
        int[] result = new int[k];
        // key : 数字; value ：出现到频次
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            numFreq.put(curNum, numFreq.getOrDefault(curNum, 0) + 1);
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(numFreq::get));
        /*PriorityQueue<Integer> pqNon = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return numFreq.get(o1) - numFreq.get(o2);
            }
        });*/
        for (Integer key : numFreq.keySet()) {
            if (pq.size() < k) { // 如果小根队中的元素个数小于 k 个则 直接添加
                pq.add(key);
            } else if (numFreq.get(key) > numFreq.get(pq.peek())) {
                // 如果小根堆中元素个数 等于 k 个了，就需要比较 当前元素 numFreq.get(key)的频次 和 小根堆中 第一个元素的频次 大小关系了
                // 这里 qp.peek() 就是使用了 小根堆 堆首元素为最小元素 的特性；
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        int idx = 0;
        while (!pq.isEmpty()) {
            result[idx++] = pq.poll();
        }
        return result;
    }
}

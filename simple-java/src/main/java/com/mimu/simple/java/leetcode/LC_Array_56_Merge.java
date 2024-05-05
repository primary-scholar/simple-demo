package com.mimu.simple.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 * <p>
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 */
public class LC_Array_56_Merge {

    /**
     * 1.先按照 区间数组中，每个区间的第一个元素 进行排序
     * 2.对排完序的 区间数组进行合并
     * 2.1 循环遍历区间数组
     * 2.2 如果合并后的数组为空 或者最后一个区间数组的右区间 < 当前区间数组的左区间，则把当前区间添加到合并数组中
     * 2.3 如果合并后的数组最后一个区间数组的右区间 >= 当前区间数组的左区间，则修改合并数组的最后一个区间数组的 右区间；
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 把待合并区间的 数组 按照 左区间 进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) { // 遍历待合并 区间数组
            int l = intervals[i][0], r = intervals[i][1];
            if (result.isEmpty() || result.get(result.size() - 1)[1] < l) { // 如果合并后的数组为空 或者最后一个区间数组的右区间 < 当前区间数组的左区间
                result.add(intervals[i]);
            } else { // 如果合并后的数组为空 或者最后一个区间数组的右区间 > 当前区间数组的左区间, 则修改 合并后的最后一个屈原元素的 右区间值
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], r);
            }
        }
        return result.toArray(new int[][]{});
    }
}

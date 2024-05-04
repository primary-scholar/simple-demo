package com.mimu.simple.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * <p>
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 * <p>
 * Constraints:
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * 数组组合 同样使用回溯 算法进行操作
 * 对于 回溯类型的问题，需要先画出 树形图
 * 如题：n=4,k=2
 * 初始时为 空，
 * * 第一层 可选择的数字 有 4个                1；2；3；4；
 * * 第二层 可选择的数字 依赖于前一个的选择      2，3，4；3，4；4；空；
 * *
 * *                                            []
 * *                            1/            2/        3\       4\
 * *                          [1]           [2]         [3]      [4]
 * *                      2/   3|  4\     3/   4\        4\       无\
 * *                  [1,2] [1,3] [1,4] [2,3]  [2,4]    [3,4]      [4]
 * *符合结果k=2 的返回 [1,2],[1,3],[1,4],[2,3],[2,4],[3,4]
 */
public class LC_Array_77_BT_Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        ArrayList<Integer> path = new ArrayList<>();
        backTrace(n, k, 1, path, res);
        return res;
    }

    /**
     * 这里 与 全排列的 区别在于 树的宽度
     * 每 递归一次 则树 的宽度 就 减少一个，所以这里对于 for 循环 每次都是 从 begin 开始，而不是 从 0 开始
     * 全排列中 之所以需要 一个数组 记录 数据是否被访问过，也是在与 全排列 每次都是 从 0 开始，全排列 需要记录 当前这一步的选择是否在前一步中已经选择过了
     * 组合中 之所以不需要 记录数据是否 被访问过，是因为 组合 每次都是 从 begin 开始，这里没有机会 访问 之前的元素；
     *
     * @param n
     * @param k
     * @param begin
     * @param path
     * @param res
     */
    public void backTrace(int n, int k, int begin, List<Integer> path, List<List<Integer>> res) {
        /**
         * 递归终止条件是：path 的长度等于 k
         * 它决定了 递归的深度
         */
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            path.addLast(i); // 回溯模板 第一步
            // 下一轮递归，初始值只能从当前值的下一个开始 所以要加 1，因为组合数理不允许出现重复的元素
            backTrace(n, k, i + 1, path, res);  // 回溯模板 第二步
            path.removeLast(); // 回溯模板 第三步 回退
        }
    }
}

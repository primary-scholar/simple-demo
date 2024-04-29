package com.mimu.simple.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations ofcandidates where the chosen numbers sum totarget . You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 * Constraints:
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 * <p>
 * 求 组合的总和
 * * 如题：[2,3,6,7] target=7
 * * 初始时 和为0，
 * * 第一层 可选择的数字 有 4个                2；3；6；7；
 * * 第二层 可选择的数字 依赖于前一个的选择      2，3，6，7；3，6，7；6，7；无；
 * * 第三层可选择的数字 依赖于前一个的选择       2，3，6，7；3，6，7；无；无；3，6，7；无；
 * * 等等
 * *
 * *                                                                                              (0)
 * *                                                    2/                                 3/             6\              7\
 * *                                                  (2)                                (3)              (6)             (7)
 * *                          2/                3|        6\  7\                  3/      6|   7\        6/  7\            无
 * *                         (4)               (5)         (8) (9)             (6)        (9)   (10)    (12)  (13)
 * *           2/          3/ 6\  7\       3/  6|  7\      无   无          3/  6|  7\     无     无       无    无
 * *          (6)        (7) (10) (11)    (8) (11) (12)                 (9) (12) (13)
 * *     2/ 3/ 6\ 7\      无   无   无     无   无   无                   无   无   无
 * *   (8) (9) (12) (13)
 * *    无  无   无   无
 * <p>
 * 注意：
 * 这里每次进行选择时，只能 从当前元素的 下一个元素开始选择(包含当前元素)
 */
public class LC_Array_39_BT_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        backTrace(candidates, res, path, 0, target);
        return res;
    }

    /**
     * 这里每次递归都从新计算和
     * 其实这里 可以进行优化
     *
     * @param candidates
     * @param res
     * @param path
     * @param begin
     * @param target
     */
    public void backTrace(int[] candidates, List<List<Integer>> res, List<Integer> path, int begin, int target) {
        /**
         * 递归终止条件是：path 列表中的和 和 target 是否相等
         * 它决定了 递归的深度
         */
        Integer sum = listSum(path);
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);// 回溯模板 第一步
            //这里递归 一定要从当前位置开始，到结束的位置
            backTrace(candidates, res, path, i, target);// 回溯模板 第二步
            path.removeLast();
        }
    }

    /**
     * 这里每次递归 没有计算 path 数组的 和，而是每次把剩余的 target 传到 递归里面
     *
     * @param candidates
     * @param res
     * @param path
     * @param begin
     * @param target
     */
    public void backTraceAnother(int[] candidates, List<List<Integer>> res, List<Integer> path, int begin, int target) {
        /**
         * 递归终止条件是：path 列表中的和 和 target 是否相等
         * 它决定了 递归的深度
         */
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);// 回溯模板 第一步
            //这里递归 一定要从当前位置开始，到结束的位置
            backTraceAnother(candidates, res, path, i, target - candidates[i]);// 回溯模板 第二步
            path.removeLast();
        }
    }

    public Integer listSum(List<Integer> list) {
        if (Objects.isNull(list) || list.isEmpty()) {
            return 0;
        }
        int result = 0;
        for (Integer i : list) {
            result += i;
        }
        return result;
    }
}

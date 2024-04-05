package com.mimu.simple.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组全排列 重复无重复数字 全排列
 * 1.重复无重复数字 全排列 的思想是一致的，只不过对于 对于重复数字的全排列 在 进行递归之前 把数组排下序 后续 对数字进行选择的时候
 * 进行判断即可(根据有序数组，和是否被访问过) 具体可参考 下面的实现
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * <p>
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * <p>
 * 以num=[1，2，3]为例
 * <p>
 * 方法1 回溯法
 * 回溯法的模板是
 * 选择
 * 递归
 * 回溯
 * <p>
 * 所有的回溯法都可以抽象为 一个树形结构
 * <p>
 * 使用深度或广度优先遍历算法 通过以下分析可以看出 递归的结构体的存在
 * 以 1 开头的全排列为 [1,2,3],[1,3,2] 即 1 加上 [2,3] 的全排列
 * 以 2 开头的全排列为 [2,1,3],[2,3,1] 即 2 加上 [1,3] 的全排列
 * 以 3 开头的全排列为 [3,1,2],[3,2,1] 即 3 加上 [1,2] 的全排列
 * 画出一棵全排列 的树形结构 数的宽度 即为 循环的次数，树的深度 即为 递归的深度 对于全排列，树的宽度和深度 是一致的，都是数组的长度；
 * <p>
 * 初始时为 空，第一层 可选择的数字 有 三个 1；2；3；
 * *           第二层 可选择的数字 有 两个 2，3；1，3；1，2；
 * *           第三层 可选择的数字 有 一个 3，2；3，1；2，1；
 * <p>
 * *                                            []
 * *                                 /          |          \
 * *                              [1]          [2]          [3]
 * *                            /   \         /   \        /   \
 * *                       [1,2]   [1,3]   [2,1] [2,3]   [3,1] [3,2]
 * *                         |      |        |     |        |     |
 * *                     [1,2,3]  [1,3,2] [2,1,3] [2,3,1] [3,1,2] [3,2,1]
 * 所以最终的结果 123；132；213；231；312；321；
 */
public class LCTest_Array_46_47_Permute_PermuteUnique {

    /**
     * 回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        backtrack(res, nums, 0, path, used);
        return res;
    }

    /**
     * 深度优先遍历算法
     *
     * @param res
     * @param nums
     * @param depth 递归的深度，也即每次可选地 数字的个数为 num.length - depth;
     * @param path
     * @param used
     */
    private void backtrack(List<List<Integer>> res, int[] nums, int depth,
                           List<Integer> path, boolean[] used) {
        /**
         *这里是递归的深度,当递归到 最底层时 即叶子节点时，就可以收集数据了
         */
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        /**
         * 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
         *这里 就体现了回溯的模板 步骤
         * 1.选择数字
         * 2.递归
         * 3.回溯
         */
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]); // 回溯模板 第1步，选择数字
                used[i] = true; // 回溯模板 第1步，选择数字的同时，需要标记 当前数字已经被使用过，下次递归不可选择
                backtrack(res, nums, depth + 1, path, used); // 回溯模板 第2步，进行递归
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false; // 回溯模板第3步，进行回退，即回溯，撤销标记，在上一层的回溯中可再次选择
                path.remove(depth); // 回溯模板第3步，进行回退，即回溯，删除已经选择的数字，在上一层的回溯中可再次选择
            }
        }
    }


    /**
     * 重复数组全排列
     * <p>
     * 重复数组全排列 整体和 不重复数组全排列 一致
     * 不过 需要 加一个规则，即 保证在填第 idx个数的时候重复数字只会被填入一次
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] vis = new boolean[length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, path, vis);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, int depth, List<Integer> path, boolean[] vis) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            /**
             * 要解决重复问题，我们只要设定一个规则，保证在填第 idx个数的时候重复数字只会被填入一次即可。
             * 而在本题解中，我们选择对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」，
             * 下面的这个判断条件保证了对于重复数的集合，一定是从左往右逐个填入的。
             * 假设我们有 3 个重复数排完序后相邻，那么我们一定保证每次都是拿从左往右第一个未被填过的数字，即整个数组的状态其实是保证了
             * [未填入，未填入，未填入] 到 [填入，未填入，未填入]，再到 [填入，填入，未填入]，最后到 [填入，填入，填入] 的过程的，因此可以达到去重的目标。
             */
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            vis[i] = true;
            backtrack(nums, res, depth + 1, path, vis);
            vis[i] = false;
            path.remove(depth);
        }
    }

}

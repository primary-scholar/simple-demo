package com.mimu.simple.java.leetcode;

import org.junit.Test;

/**
 * 股票最佳收益
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 * <p>
 * Say you have an array for which the  i th element is the price of a given stock on day  i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 */
public class LCTest_Array_121_MaxProfit {

    /**
     * 遍历数组 同时记录访问到的最小值，然后用当前数值 减去 最小值 的到 当前日期的 收益，在当前收益 和结果之间去最大值；
     * 等数组遍历 完毕，则可取的数组中每天收益 中最大的那个
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0, buy = Integer.MAX_VALUE;
        for (int price : prices) {
            buy = Math.min(buy, price);// 遍历数组 取最小值
            res = Math.max(res, price - buy); // 遍历数组 取当前日期和最小值之间的差值，然后去最大的那个
        }
        return res; // 数组遍历完毕后 即为最大值
    }

    @Test
    public void maxProfitResult() {
        assert 5 == maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assert 0== maxProfit(new int[]{7,6,4,3,1});
    }
}

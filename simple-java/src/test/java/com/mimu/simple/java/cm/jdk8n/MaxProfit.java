package com.mimu.simple.java.cm.jdk8n;

import org.junit.Test;

import java.util.Objects;

public class MaxProfit {

    public int getMaxProfit(Integer[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        Integer result = 0, buy = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            buy = Math.min(buy, nums[i]);
            result = Math.max(result, nums[i] - buy);
        }
        return result;
    }

    @Test
    public void maxProfitTest(){
        System.out.println(getMaxProfit(new Integer[]{7, 1, 5, 3, 6, 4}));
        System.out.println(getMaxProfit(new Integer[]{7, 6, 4, 3, 1}));
    }
}

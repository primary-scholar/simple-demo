package com.mimu.simple.java.cm;

import org.junit.Test;

import java.util.Random;

/**
 * @author luyahui
 * @date 2023/8/30
 * @description
 */


public class LoopTest {
    private Integer otLoop = 5, inLoop = 3, currentLoop = 0;

    @Test
    public void currentTest() {
        Integer integer = innerLoop(currentLoop);
        System.out.println(currentLoop);
        System.out.println(integer);
        System.out.println();
        loop(new int[]{1, 2, 3});
    }

    public Integer innerLoop(int currentLoop) {
        for (Integer i = 0; i < inLoop; i++) {
            currentLoop++;
        }
        return currentLoop;
    }

    public void loop(int[] nums) {
        int idx = 0;
        while (idx < nums.length) {
            System.out.println(nums[idx++]);
        }
    }

    @Test
    public void loopTest() {
        int length = 3;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            System.out.println(random.nextInt(length));
        }
        System.out.println();
        length = 0;
        System.out.println(random.nextInt(length));
    }
}

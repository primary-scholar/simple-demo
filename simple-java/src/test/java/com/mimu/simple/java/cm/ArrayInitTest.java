package com.mimu.simple.java.cm;

import org.junit.Test;

public class ArrayInitTest {

    @Test
    public void arrayInitTest() {
        int m = 2, n = 3;
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(nums[i][j]);
            }
        }
    }
}

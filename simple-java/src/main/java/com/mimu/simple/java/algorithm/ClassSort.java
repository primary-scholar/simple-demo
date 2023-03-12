package com.mimu.simple.java.algorithm;

import java.util.Objects;

/**
 * 几种经典算法
 */
public class ClassSort {

    private void swap(Integer[] array, int i, int j) {
        if (Objects.isNull(array) || array.length <= 1) {
            return;
        }
        Integer tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void bubbleSort(Integer[] array) {
        if (Objects.isNull(array) || array.length < 1) {
            return;
        }
        // 0~n-1 次排序
        for (int i = 0; i < array.length; i++) {
            // 外层每循环一次 则就有一个元素排在了合适位置 所以这里需要 -i；-1 是防止内循环数组越界
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //相邻两个元素比较交换
                    swap(array, j, j + 1);
                }
            }
        }
    }
}

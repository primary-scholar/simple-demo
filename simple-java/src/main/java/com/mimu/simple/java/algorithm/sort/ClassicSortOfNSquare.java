package com.mimu.simple.java.algorithm.sort;

import java.util.Objects;

/**
 * 几种经典算法 复杂度为 O(N^2)
 */
public class ClassicSortOfNSquare {

    private void swap(Integer[] array, int i, int j) {
        if (Objects.isNull(array) || array.length <= 1) {
            return;
        }
        Integer tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 冒泡排序 O(N^2) 稳定排序
     * 共 i 次 循环; i in [0,n-1]
     * 每次循环 对相邻两个元素交换(如果有必要)
     *
     * @param array
     */
    public void bubbleSort(Integer[] array) {
        if (Objects.isNull(array) || array.length <= 1) {
            return;
        }
        // 0~n-1 次循环
        for (int i = 0; i < array.length; i++) {
            // 外层每循环一次 则就有一个元素排在了合适位置 所以这里需要 -i；-1 是防止内循环数组越界
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) { // 这里不要用 <= 因为 = 会破坏 元素排序的稳定性
                    //相邻两个元素比较交换
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序 O(N^2)
     * 共 i 次 循环; i in [0,n-1]
     * 每次循环 在 [i,n-1] 个元素中选择一个最小的和 i 位置的元素 交换
     *
     * @param array
     */
    public void selectSort(Integer[] array) {
        if (Objects.isNull(array) || array.length <= 1) {
            return;
        }
        // 0~n-1 次循环
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i; j < array.length; j++) {
                // 寻找 [i,n-1] 中元素最小的位置
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            // 交换 i 位置的元素和 最小位置的元素
            swap(array, i, index);
        }
    }

    /**
     * 插入排序 O(N^2)
     * 共 共 i 次 循环; i in [1,n-1]
     * 把待排序数组分成两个部分 前半部为有序，后半部为无序 每次循环时 取无序部分的第一个元素 然后和有序中的 每个元素进行比较排序直到新添加的这个元素在 愿有序数据中有序
     *
     * @param array
     */
    public void insertSort(Integer[] array) {
        if (Objects.isNull(array) || array.length <= 1) {
            return;
        }
        // 共有 1~n-1 次循环
        for (int i = 1; i < array.length; i++) {
            // 在无序数组中取第一个元素和 有序数组中的每一个元素进行 比较 交换(如果有必要)
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }
}

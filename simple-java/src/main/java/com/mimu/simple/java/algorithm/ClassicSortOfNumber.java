package com.mimu.simple.java.algorithm;

import java.util.Objects;

/**
 * 这里排序的 复杂度 都为 O((N^d)*log(N))
 *
 * @see ClassicRecursion 中的说明
 * <p>
 * 这里的排序有 归并排序、快排序、堆排序；
 */
public class ClassicSortOfNumber {


    /**
     * 归并排序 归并排序整体是一个 递归操作：左边排好序，右边排好序，左右两边 merge 一下让整体有序，
     * 在merge 过程中 使用了 外排序 方法；整体归并排序 可以使用非递归方式 实现
     * 整体思路：
     *
     * @param array
     */
    public void mergeSort(Integer[] array) {
        sort(array, 0, array.length - 1);
    }

    public void mergeSortAnother(Integer[] array) {
        if (Objects.isNull(array)) {
            return;
        }
        int length = array.length, mergeSize = 1;
        while (mergeSize < length) {
            int left = 0;
            while (left < length) {
                int mid = left + mergeSize - 1;
                if (mid >= length) {
                    break;
                }
                int right = Math.min(mid + mergeSize, length - 1);
                merge(array, left, right, mid);
                left = right + 1;
            }
            if (mergeSize > length / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    /**
     * 数组 array[left........right] 变得有序
     * **************  f(0,3)
     * *************  /      \
     * ************  /        \
     * ********** f(0,1)      f(2,3)
     * *********  /  \         /  \
     * ********  /    \       /    \
     * ***** f(0,0) f(1,1)  f(2,2) f(3,3)
     *
     * @param array
     * @param left
     * @param right
     */
    private void sort(Integer[] array, Integer left, Integer right) {
        if (Objects.isNull(array)) {
            return;
        }
        if (left.equals(right)) {
            return;
        }
        Integer mid = left + ((right - left) >> 1);
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, right, mid);
    }

    private void merge(Integer[] array, Integer left, Integer right, Integer mid) {
        Integer[] copy = new Integer[right - left + 1];
        int i = 0, li = left, ri = mid + 1;
        while (li <= mid && ri <= right) {
            copy[i++] = array[li] <= array[ri] ? array[li++] : array[ri++];
        }
        while (li <= mid) {
            copy[i++] = array[li++];
        }
        while (ri <= right) {
            copy[i++] = array[ri++];
        }
        for (int idx = 0; idx < copy.length; idx++) {
            array[left + idx] = copy[idx];
        }
    }
}

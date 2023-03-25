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
     *
     * @param array
     */
    public void mergeSort(Integer[] array) {
        splitAndMerge(array, 0, array.length - 1);
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
     * <p>
     * 这里 split 本身(除了 merge操作外) 仅仅时把大规模的数组 拆分成子规模的数组，直到子规模的数组中只有一个元素，这时这一个元素的数组就自然有序，
     * 此时 通过 merge 方法(有序数组合并) 合并成一个大的有序数组，即所有的排序都是通过 merge 合并操作得来
     *
     * @param array
     * @param left
     * @param right
     */
    private void splitAndMerge(Integer[] array, Integer left, Integer right) {
        if (Objects.isNull(array)) {
            return;
        }
        if (left.equals(right)) { //4.左右子规模数组何时有序，当子规模数组中只有一个元素时 自然有序
            return;
        }
        Integer mid = left + ((right - left) >> 1);
        splitAndMerge(array, left, mid);             // 1.左子规模有序
        splitAndMerge(array, mid + 1, right);                //2.右子规模 有序
        merge(array, left, right, mid);             //3.通过 merge 合并左右两个有序的子规模数组 成为一个大的有序数组即可
    }

    /**
     * 有序数组 合并 初始的 数组 array 在 mid 下标的 分割下 很自然的就分成了 array[left...mid],和 array[mid+1,right] 两个部分
     * <p>
     * 合并时 若果左右两部分都非空 则 取左右侧最小的值 放到 copy 数组中；
     * 否则 把多余的 部分直接 拷贝到 copy 数组中
     *
     * @param array
     * @param left
     * @param right
     * @param mid
     */
    private void merge(Integer[] array, Integer left, Integer right, Integer mid) {
        Integer[] copy = new Integer[right - left + 1];
        int i = 0, li = left, ri = mid + 1;
        while (li <= mid && ri <= right) {          // 左右两部分都有数组 则取左右两侧最小的值 放到 copy中
            copy[i++] = array[li] <= array[ri] ? array[li++] : array[ri++];
        }
        while (li <= mid) {         // 把左右两部分中 多出来的那部分(左部分) 直接拷贝到 copy中
            copy[i++] = array[li++];
        }
        while (ri <= right) {           // 把左右两部分中 多出来的那部分(右部分) 直接拷贝到 copy中
            copy[i++] = array[ri++];
        }
        System.arraycopy(copy, 0, array, left, copy.length);            // 把copy数组整体 copy 到 原 array 数组中
    }


    /**
     * 归并排序 非递归算法
     * 整体思路：使用一个归并排序的步长字段 mergeSize 来判断数组循环的次数
     * 归并步长 mergeSize 是 合并左右子有序数组的 数组长度的 变量 初始为 1 表示 1，2；3，4；5，6；...... 为左右长度为1的子有序数据 并对子有序数据进行 merge 合并操作
     * 每次循环结束后 归并步长 左移以为 mergeSize <<=1 继续进行 长度为 2 的 左右有序数组的归并，1 2，3 4；5 6，7 8； 进行 merge 归并操作
     * 直到 mergeSize >= array.length 是结束排序；
     *
     * @param array
     */
    public void mergeSortAnother(Integer[] array) {
        if (Objects.isNull(array)) {
            return;
        }
        int length = array.length, mergeSize = 1;  // 初始 mergeSize =1 即归并的左右子数据长度 为 1 ，
        while (mergeSize < length) {  // mergeSize < length 是开始循环
            int left = 0;
            while (left < length) {  // 每次都行数据 的 最左侧 array[0] 位置 开始 进行 分组 归并
                int mid = left + mergeSize - 1;  // 初始化  mid 值 把 数据分成 array [left,mid],[mid+1,right] 两组进行归并
                if (mid >= length) {
                    break;
                }
                int right = Math.min(mid + mergeSize, length - 1); // 初始化 right 值
                merge(array, left, right, mid); //  进行归并
                left = right + 1;       // 从左到右 依次进行归并 排序
            }
            if (mergeSize > length / 2) {
                break;
            }
            mergeSize <<= 1; // 归并步长 左移 进行下一轮的归并
        }
    }
}

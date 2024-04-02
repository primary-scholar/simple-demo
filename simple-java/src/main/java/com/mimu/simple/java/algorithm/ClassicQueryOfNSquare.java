package com.mimu.simple.java.algorithm;

import com.mimu.simple.java.algorithm.sort.ClassicSortOfNSquare;

import java.util.Objects;

/**
 * 二分查找
 * 1.在一个有序数组中，查找某个元素是否存在
 * 2.在一个有序数组中，查找>=某个元素的最左侧的位置
 * 3.在一个有序数组中，查找<=某个元素的最右侧的位置
 * 4.查找局部最小值问题 ex 一个数组 不等且无序
 * <p>
 * 二分查找的思想 在于每次做决策时都可以明确的 抛弃全量数据中的 某一半的数据量 在剩余的数据中查询
 * 所以二分查找 适用于 有序数组，但 同时又不仅仅 仅适用于 有序数组
 */
public class ClassicQueryOfNSquare extends ClassicSortOfNSquare {

    /**
     * 二分查找 O(logN)
     *
     * @param array
     * @param searchIng
     * @return
     */
    public Integer binaryQuery(Integer[] array, Integer searchIng) {
        if (Objects.isNull(array) || array.length < 1) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            //如果当前索引的数组值 = 待要查询的 数字 则返回 该index
            if (array[mid].equals(searchIng)) {
                return mid;
            }
            // 如果 当前索引的数组值 < 待查询的值 则 可舍弃 < 当前索引值的 数组的那部分
            // 即 left = mid+1;
            if (array[mid] < searchIng) {
                left = mid + 1;
            }
            // 如果 当前索引的数组值 > 待查询的值 则 可舍弃 > 当前索引值的 数组的那部分
            // 即 right = mid-1;
            if (array[mid] > searchIng) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * >= 某个元素最左侧的位置 O(logN)
     *
     * @param array
     * @param searchIng
     * @return
     */
    public Integer bigThanOneMostLeftQuery(Integer[] array, Integer searchIng) {
        if (Objects.isNull(array) || array.length < 1) {
            return -1;
        }
        int left = 0, right = array.length - 1, index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            // 如果 当前索引的数组值 >= 待查询的值 则 可舍弃 > 当前索引值的 数组的那部分，在<的那部分无限逼近
            // 即 right=mid-1;
            if (array[mid] >= searchIng) {
                index = mid;
                right = mid - 1;
            }
            // 如果 当前索引的数组值 < 待查询的值 则 可舍弃 < 当前索引值的 数组的那部分 在>的那部分无限逼近
            // 即 left = mid+1;
            if (array[mid] < searchIng) {
                left = mid + 1;
            }
        }
        return index;
    }

    /**
     * <= 某个元素最右侧的位置 O(logN)
     *
     * @param array
     * @param searchIng
     * @return
     */
    public Integer smallThanOneMostRightQuery(Integer[] array, Integer searchIng) {
        if (Objects.isNull(array) || array.length < 1) {
            return -1;
        }
        int left = 0, right = array.length - 1, index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            // 如果 当前索引的数组值 <= 待查询的值 则 可舍弃 < 当前索引值的 数组的那部分，在> 的那部分无限逼近
            // 即 left = mid+1;
            if (array[mid] <= searchIng) {
                index = mid;
                left = mid + 1;
            }
            // 如果 当前索引的数组值 > 待查询的值 则 可舍弃 > 当前索引值的 数组的那部分，在< 的那部分无限逼近
            // 即 right = mid-1;
            if (array[mid] > searchIng) {
                right = mid - 1;
            }
        }
        return index;
    }

    /**
     * 局部最小
     * <p>
     * 思路 寻找 局部最小 可能存在的区域，
     * 如果当前位置的 数字 比它左边的数字大 则局部最小 的数字 应该出现在 该位置左侧
     * 如果当前位置的 数字 比它右边的数字大 则局部最小 的数字 应该出现在 该位置右侧
     *
     * @param array
     * @return
     */
    public Integer leastQuery(Integer[] array) {
        if (Objects.isNull(array) || array.length < 1) {
            return -1;
        }
        if (array.length == 1 || array[0].equals(array[1])) {
            return 0;
        }
        if (array[array.length - 1] < array[array.length - 2]) {
            return array.length - 1;
        }
        int left = 1, right = array.length - 2;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (array[mid] > array[mid - 1]) { // 当前 mid 位置的数字 比左边的数字大 则说明 局部最小值 在该位置 左侧
                right = mid - 1;
            } else if (array[mid] > array[mid + 1]) { // 当前 mid 位置的数字 比右边的数字大 则说明 局部最小值 在该位置 右侧
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    /**
     * 局部最大
     * <p>
     * 思路 寻找局部最大 可能存在的区域
     * 如果当前位置的 数字 比它左边的数字小 则局部最大 的数字 应该出现在 该位置左侧
     * 如果当前位置的 数字 比它右边的数字小 则局部最大 的数字 应该出现在 该位置右侧
     *
     * @param array
     * @return
     */
    public Integer maxQuery(Integer[] array) {
        if (Objects.isNull(array) || array.length < 1) {
            return -1;
        }
        if (array.length == 1 || array[0].equals(array[1])) {
            return 0;
        }
        if (array[array.length - 1] < array[array.length - 2]) {
            return array.length - 2;
        }
        int left = 1, right = array.length - 2;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (array[mid] < array[mid - 1]) { // 当前 mid 位置的数字 比左边的数字小 则说明 局部最大值 在该位置 左侧
                right = mid - 1;
            } else if (array[mid] < array[mid + 1]) { // 当前 mid 位置的数字 比右边的数字小 则说明 局部最大值 在该位置 右侧
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}

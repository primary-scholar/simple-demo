package com.mimu.simple.java.algorithm;

import java.util.Objects;

/**
 * 二分查找
 * 1.在一个有序数组中，查找某个元素是否存在
 * 2.在一个有序数组中，查找>=某个元素的最左侧的位置
 * 3.在一个有序数组中，查找<=某个元素的最右侧的位置
 * 4.查找局部最小值问题
 * <p>
 * 二分查找的思想 在于每次做决策时都可以明确的 抛弃全量数据中的 某一半的数据量 在剩余的数据中查询
 * 所以二分查找 适用于 有序数组，但 同时又不仅仅 仅适用于 有序数组
 */
public class ClassicQuery extends ClassicSort {

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
}

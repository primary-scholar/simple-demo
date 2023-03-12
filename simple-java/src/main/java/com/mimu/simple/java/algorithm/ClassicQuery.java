package com.mimu.simple.java.algorithm;

import java.util.Objects;

/**
 * 二分查找
 *
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
}

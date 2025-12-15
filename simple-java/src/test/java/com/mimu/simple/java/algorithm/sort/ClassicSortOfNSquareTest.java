package com.mimu.simple.java.algorithm.sort;

import com.alibaba.fastjson2.JSONObject;
import com.mimu.simple.java.algorithm.BaseTest;
import com.mimu.simple.java.algorithm.sort.ClassicSortOfNSquare;
import org.junit.Test;

import java.util.Arrays;


public class ClassicSortOfNSquareTest extends BaseTest {


    public ClassicSortOfNSquare sort = new ClassicSortOfNSquare();

    @Test
    public void bubbleSortTest() {
        for (int l = 0; l < loop; l++) {
            Integer[] array = initArray();
            Integer[] copy = copyArray(array);
            sort.bubbleSort(array);
            Arrays.sort(copy);
            if (!Arrays.equals(array, copy)) {
                System.out.println(JSONObject.toJSONString(array));
                System.out.println(JSONObject.toJSONString(copy));
            }
        }
    }

    @Test
    public void selectSortTest() {
        for (int l = 0; l < loop; l++) {
            Integer[] array = initArray();
            Integer[] copy = copyArray(array);
            sort.selectSort(array);
            Arrays.sort(copy);
            if (!Arrays.equals(array, copy)) {
                System.out.println(JSONObject.toJSONString(array));
                System.out.println(JSONObject.toJSONString(copy));
            }
        }
    }

    @Test
    public void insertSortTest() {
        for (int l = 0; l < loop; l++) {
            Integer[] array = initArray();
            Integer[] copy = copyArray(array);
            sort.insertSort(array);
            Arrays.sort(copy);
            if (!Arrays.equals(array, copy)) {
                System.out.println(JSONObject.toJSONString(array));
                System.out.println(JSONObject.toJSONString(copy));
            }
        }
    }
}
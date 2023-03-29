package com.mimu.simple.java.algorithm;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Arrays;


public class ClassicSortOfNSquareTest {
    public int loop = (int) (Math.random() * 999999) + 1;

    public ClassicSortOfNSquare sort = new ClassicSortOfNSquare();

    public Integer getRandom() {
        return (int) (Math.random() * 100) - (int) (Math.random() * 100);
    }

    public Integer getPRandom() {
        Integer random = getRandom();
        return random < 0 ? -random : random;
    }

    public Integer[] initArray() {
        int arrayLength = (int) (Math.random() * 19) + 1;
        Integer[] array = new Integer[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = getRandom();
        }
        return array;
    }

    public Integer[] copyArray(Integer array[]) {
        return Arrays.copyOf(array, array.length);
    }

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
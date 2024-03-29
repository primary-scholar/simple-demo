package com.mimu.simple.java.algorithm.sort;

import com.alibaba.fastjson.JSONObject;
import com.mimu.simple.java.algorithm.BaseTest;
import com.mimu.simple.java.algorithm.sort.ClassicSortOfAnotherNum;
import org.junit.Test;

import java.util.Arrays;

public class ClassicSortOfAnotherNumTest extends BaseTest {

    ClassicSortOfAnotherNum sort = new ClassicSortOfAnotherNum();

    @Test
    public void partition1Idx() {
        Integer[] array = initArray();
        System.out.println(JSONObject.toJSONString(array));
        Integer integer = sort.partition1Idx(array, 0, array.length - 1);
        System.out.println(JSONObject.toJSONString(array));
        System.out.println(integer);
    }

    @Test
    public void partition2Idx() {
        Integer[] array = initArray();
        System.out.println(JSONObject.toJSONString(array));
        Integer[] integer = sort.partition2Idx(array, 0, array.length - 1);
        System.out.println(JSONObject.toJSONString(array));
        System.out.println(JSONObject.toJSONString(integer));
    }

    @Test
    public void quickSort() {
        for (int i = 0; i < loop; i++) {
            Integer[] array = initArray();
            Integer[] copy = copyArray(array);
            sort.quickSort(array);
            Arrays.sort(copy);
            assert Arrays.equals(array, copy);
        }
    }

}
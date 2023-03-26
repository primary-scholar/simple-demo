package com.mimu.simple.java.algorithm;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

public class ClassicSortOfNumberTest extends ClassicSortOfNSquareTest {

    ClassicSortOfNumber sortOfNumber = new ClassicSortOfNumber();

    @Test
    public void mergeSort() {
        for (int i = 0; i < loop; i++) {
            Integer[] array = initArray();
            Integer[] copy = copyArray(array);
            sortOfNumber.mergeSort(array);
            Arrays.sort(copy);
            assert Arrays.equals(array, copy);
        }
    }

    @Test
    public void mergeSortAgain() {
        for (int i = 0; i < loop; i++) {
            Integer[] array = initArray();
            Integer[] copy = copyArray(array);
            sortOfNumber.mergeSortAnother(array);
            Arrays.sort(copy);
            assert Arrays.equals(array, copy);
        }
    }

    @Test
    public void smallMergeTest() {
        for (int i = 0; i < loop; i++) {
            Integer[] array = initArray();
            Integer[] copy = copyArray(array);
            Integer sumAnother = smallSumAnother(array);
            Integer smallSum = sortOfNumber.smallSum(copy);
            if (!sumAnother.equals(smallSum)) {
                System.out.println(JSONObject.toJSONString(array));
                System.out.println(sumAnother);
                System.out.println(smallSum);
                return;
            }
        }

    }

    private Integer smallSumAnother(Integer[] array) {
        if (Objects.isNull(array) || array.length <= 1) {
            return 0;
        }
        Integer smallSum = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) smallSum += array[j];
            }
        }
        return smallSum;
    }
}
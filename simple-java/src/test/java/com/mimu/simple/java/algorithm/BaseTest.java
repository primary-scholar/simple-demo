package com.mimu.simple.java.algorithm;

import java.util.Arrays;

public class BaseTest {

    public int loop = (int) (Math.random() * 999999) + 1;
    public Integer capacity = (int) (Math.random() * 10) + 1;

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
}

package com.mimu.simple.java.algorithm;

import org.junit.Test;

import java.util.*;

public class RandomFunction {

    public Integer[] getLittleNums(Integer num) {
        if (Objects.isNull(num) || num <= 0) {
            return new Integer[]{};
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            integers.add(i);
        }
        Collections.shuffle(integers);
        return integers.toArray(new Integer[]{});
    }

    public int[] getLittleNumsAnother(Integer num) {
        if (Objects.isNull(num) || num <= 0) {
            return new int[]{};
        }
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            numbers[i] = i + 1;
        }
        int[] result = new int[num];
        for (int i = 0; i < result.length; i++) {
            int r = (int) (Math.random() * num);
            result[i] = numbers[r];
            numbers[r] = numbers[num - 1];
            num--;
        }
        return result;
    }


    @Test
    public void getLittleNumTest() {
        for (int i : getLittleNums(3)) {
            System.out.println(i);
        }
        System.out.println();
        for (int i : getLittleNumsAnother(5)) {
            System.out.println(i);
        }
    }
}

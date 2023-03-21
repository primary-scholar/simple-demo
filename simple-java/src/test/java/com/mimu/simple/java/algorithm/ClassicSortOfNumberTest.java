package com.mimu.simple.java.algorithm;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

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
    public void mergeSortAgain(){
        for (int i = 0; i < loop; i++) {
            Integer[] array = initArray();
            Integer[] copy = copyArray(array);
            sortOfNumber.mergeSortAnother(array);
            Arrays.sort(copy);
            assert Arrays.equals(array, copy);
        }
    }
}
package com.mimu.simple.java.algorithm;

import org.junit.Test;


import java.util.Arrays;


public class ClassicHeapOperationTest extends BaseTest {

    ClassicHeapOperation heapOperation = new ClassicHeapOperation();

    @Test
    public void heapSort() {
        for (int i = 0; i < loop; i++) {
            Integer[] array = initArray();
            Integer[] copy = copyArray(array);
            heapOperation.heapSort(array);
            Arrays.sort(copy);
            assert Arrays.equals(array, copy);
        }
    }
}
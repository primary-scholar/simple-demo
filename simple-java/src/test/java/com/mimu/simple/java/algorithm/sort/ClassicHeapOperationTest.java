package com.mimu.simple.java.algorithm.sort;

import com.mimu.simple.java.algorithm.BaseTest;
import com.mimu.simple.java.algorithm.sort.ClassicHeapOperation;
import org.junit.Test;


import java.util.Arrays;


public class ClassicHeapOperationTest extends BaseTest {

    ClassicHeapOperation heapOperation = new ClassicHeapOperation();

    @Test
    public void heapOperation() {
        ClassicHeapOperation.CustomHeap customHeap = new ClassicHeapOperation.CustomHeap(5);
        customHeap.push(5);
        customHeap.push(7);
        customHeap.push(9);
        customHeap.push(2);
        customHeap.push(4);
        Integer[] heap = customHeap.getHeap();
        for (Integer i : heap) {
            System.out.print(i);
        }
    }

    @Test
    public void heapSortResult() {
        for (int i = 0; i < loop; i++) {
            Integer[] array = initArray();
            Integer[] copy = copyArray(array);
            heapOperation.heapSort(array);
            Arrays.sort(copy);
            assert Arrays.equals(array, copy);
        }
    }
}
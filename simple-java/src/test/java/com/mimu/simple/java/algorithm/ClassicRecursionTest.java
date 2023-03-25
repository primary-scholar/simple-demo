package com.mimu.simple.java.algorithm;

import org.junit.Test;

import java.util.Arrays;


public class ClassicRecursionTest extends ClassicSortOfNSquareTest {

    ClassicRecursion recursion = new ClassicRecursion();


    @Test
    public void processTest() {
        for (int i = 0; i < loop; i++) {
            Integer[] array = initArray();
            Integer process = recursion.process(array, 0, array.length - 1);
            Integer[] copy = copyArray(array);
            Arrays.sort(copy);
            assert process.equals(copy[copy.length - 1]);
            Integer processAgain = recursion.processAnother(array, 0, array.length - 1);
            assert processAgain.equals(process);
        }
    }

}
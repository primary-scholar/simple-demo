package com.mimu.simple.java.algorithm.linkorqueue;

import com.alibaba.fastjson.JSONObject;
import com.mimu.simple.java.algorithm.linkorqueue.ClassicQueryOfNSquare;
import com.mimu.simple.java.algorithm.sort.ClassicSortOfNSquareTest;
import org.junit.Test;

import java.util.Arrays;

public class BinaryQueryTest extends ClassicSortOfNSquareTest {

    public ClassicQueryOfNSquare query = new ClassicQueryOfNSquare();


    @Test
    public void binaryQueryTest() {
        for (int l = 0; l < loop; l++) {
            Integer[] array = initArray();
            Arrays.sort(array);
            Integer index = getPRandom() % array.length;
            Integer searchIng = array[index];
            Integer queryIndex = query.binaryQuery(array, searchIng);
            if (!searchIng.equals(array[queryIndex])) {
                String info = "searching=%s,queryIndex=%s,index=%s";
                System.out.println(JSONObject.toJSONString(array));
                System.out.println(String.format(info, searchIng, queryIndex, index));
                return;
            }
        }
    }

    @Test
    public void bigThanOneMostLeftQueryTest() {
        for (int l = 0; l < loop; l++) {
            Integer[] array = initArray();
            Arrays.sort(array);
            Integer index = getPRandom() % array.length;
            Integer searchIng = array[index];
            Integer queryIndex = query.bigThanOneMostLeftQuery(array, searchIng);
            if (queryIndex != -1 && array[queryIndex] < searchIng) {
                String info = "searching=%s,queryIndex=%s,index=%s";
                System.out.println(JSONObject.toJSONString(array));
                System.out.println(String.format(info, searchIng, queryIndex, index));
                return;
            }
        }
    }

    @Test
    public void smallThanOneMostRightQueryTest() {
        for (int l = 0; l < loop; l++) {
            Integer[] array = initArray();
            Arrays.sort(array);
            Integer index = getPRandom() % array.length;
            Integer searchIng = array[index];
            Integer queryIndex = query.smallThanOneMostRightQuery(array, searchIng);
            if (queryIndex != -1 && array[queryIndex] > searchIng) {
                String info = "searching=%s,queryIndex=%s,index=%s";
                System.out.println(JSONObject.toJSONString(array));
                System.out.println(String.format(info, searchIng, queryIndex, index));
                return;
            }
        }
    }


}
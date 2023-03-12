package com.mimu.simple.java.algorithm;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Arrays;

public class BinaryQueryTest extends ClassicSortTest {

    public ClassicQuery query = new ClassicQuery();


    @Test
    public void binaryQueryTest() {
        int loop = (int) (Math.random() * 499) + 1;
        for (int l = 0; l < loop; l++) {
            Integer[] array = initArray();
            Arrays.sort(array);
            Integer index = ((int) (Math.random() * 100)) % array.length;
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


}
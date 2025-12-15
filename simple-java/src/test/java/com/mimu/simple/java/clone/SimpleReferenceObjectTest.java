package com.mimu.simple.java.clone;

import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SimpleReferenceObjectTest {

    @Test
    public void originCopyTest() throws CloneNotSupportedException {
        SimpleReferenceObject origin = new SimpleReferenceObject();
        origin.setId(1);
        origin.setName("1-name");
        HashSet<Integer> originSet = new HashSet<>();
        originSet.add(1);
        origin.setScoreSet(originSet);
        ArrayList<String> originList = new ArrayList<>();
        originList.add("1");
        origin.setMajorList(originList);
        SimpleReferenceObject.InnerReferenceObject referenceObject = new SimpleReferenceObject.InnerReferenceObject();
        referenceObject.setId(11);
        referenceObject.setName("11-name");
        origin.setInnerReference(referenceObject);
        System.out.println(JSONObject.toJSONString(origin));
        SimpleReferenceObject copy = origin.clone();
        Set<Integer> scoreSet = copy.getScoreSet();
        scoreSet.add(2);
        List<String> majorList = copy.getMajorList();
        majorList.add("2");
        SimpleReferenceObject.InnerReferenceObject innerReference = copy.getInnerReference();
        innerReference.setName("11-name-copy");
        System.out.println();
        System.out.println(JSONObject.toJSONString(origin));
        System.out.println();
        System.out.println(JSONObject.toJSONString(copy));
    }

    @Test
    public void utilCopyTest() throws CloneNotSupportedException, InvocationTargetException, IllegalAccessException,
            InstantiationException, NoSuchMethodException {
        SimpleReferenceObject origin = new SimpleReferenceObject();
        origin.setId(1);
        origin.setName("1-name");
        HashSet<Integer> originSet = new HashSet<>();
        originSet.add(1);
        origin.setScoreSet(originSet);
        ArrayList<String> originList = new ArrayList<>();
        originList.add("1");
        origin.setMajorList(originList);
        SimpleReferenceObject.InnerReferenceObject referenceObject = new SimpleReferenceObject.InnerReferenceObject();
        referenceObject.setId(11);
        referenceObject.setName("11-name");
        origin.setInnerReference(referenceObject);
        System.out.println(JSONObject.toJSONString(origin));
        SimpleReferenceObject copy = (SimpleReferenceObject) BeanUtils.cloneBean(origin);
        copy.getInnerReference().setName("111-name-copy");
        System.out.println(JSONObject.toJSONString(copy));
    }

}
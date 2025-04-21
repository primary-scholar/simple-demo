package com.mimu.simple.java.seriali;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mimu.simple.java.seriali.model.FastJsonFeaturePeople;
import com.mimu.simple.java.seriali.model.ModelIntegerString;
import com.mimu.simple.java.seriali.model.Student;
import com.mimu.simple.java.seriali.model.TempModel;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * author: mimu
 * date: 2019/10/5
 */

/**
 * FastJson 序列化过程 JSONObject.toJSONString(people)
 * 1. 根据object 获取其对应Class
 * 2。根据class信息构造SerializeBeanInfo 信息
 * 2。1 反射获取class 所有 getXXX() 或 isXXX() 方法(解析使用@JSONField的情形) 以获取序列化对应的 key
 * 2。2 根据 2。1返回的 key 信息 利用反射获取到对象的值 以获取序列化对应的 value
 * 3。根据 key 和 value 拼成 string 字符串
 * <p>
 * <p>
 * FastJson 反序列化过程
 * 1。String peos = "{\"aName\":\"anamela\",\"age\":11}"
 * 1。1 JSONObject jsonObject = JSONObject.parseObject(peos)
 * 2。People people1 = JSONObject.toJavaObject(jsonObject, People.class);
 * <p>
 * 1。1 首先把字符串 转换成 Map<String,Object>类型 组成 key：value 对儿
 * 2。1 根据 class 信息构造 ObjectDeserializer 信息
 * 2。2 反射获取class 所有 setXXX() 方法(解析使用@JSONField的情形) 以获取 反序列化后 field 接受 value 对应的 key
 * 2。3 根据 class 信息，反射生成 object 对象
 * 根据 1。1中的 Map<String,Object>的数据和 2。2 中的key进行匹配，若有对应的key 则反射method.invoke() 给field付值
 */
public class FastJsonSerializedTest {

    @Test
    public void info() {
        FastJsonFeaturePeople people = new FastJsonFeaturePeople();
        people.setName("name");
        people.setAge(10);
        System.out.println(JSONObject.toJSONString(people));
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(people));
        FastJsonFeaturePeople javaObject = JSONObject.toJavaObject(jsonObject, FastJsonFeaturePeople.class);
        System.out.println(javaObject);
    }

    @Test
    public void info1() {
        FastJsonFeaturePeople people = new FastJsonFeaturePeople();
        people.setName("nameA");
        people.setAge(11);
        System.out.println(JSONObject.toJSONString(people));

        String peos = "{\"aName\":\"anamela\",\"age\":11}";
        FastJsonFeaturePeople javaObject = JSONObject.toJavaObject(JSONObject.parseObject(peos), FastJsonFeaturePeople.class);
        System.out.println(javaObject);

        String peos1 = "{\"bName\":\"bnamela\",\"age\":12}";
        FastJsonFeaturePeople object = JSONObject.toJavaObject(JSONObject.parseObject(peos1), FastJsonFeaturePeople.class);
        System.out.println(object);
    }

    @Test
    public void studentTest() {
        Integer length = 3;
        ArrayList<Student> studentList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            Student student = new Student();
            student.setName("name" + i);
            if (i % 2 == 0) {
                student.setAge(i);
            }
            studentList.add(student);
        }
        List<Integer> collect = studentList.stream().map(Student::getAge).filter(Objects::nonNull).toList();
        collect.forEach(System.out::println);
    }

    @Test
    public void tempModelTest() {
        TempModel model = new TempModel();
        model.setFlag(Boolean.TRUE);
        model.setQuery("abc");
        model.setUIdList(Collections.singletonList("uid"));
        System.out.println(JSONObject.toJSONString(model));
    }

    @Test
    public void tempModel2Test() {
        String url = "http://test.s.ad.sohuno.com/as?itemspaceid=%d&videoInterest=%s&articleInterest=%s";

        ArrayList<ModelIntegerString> video = new ArrayList<>();
        video.add(new ModelIntegerString("48", new BigDecimal("-0.000082916795538539")));
        video.add(new ModelIntegerString("232", new BigDecimal("-0.000082916795538539")));
        video.add(new ModelIntegerString("500", new BigDecimal("-0.000082916795538539")));
        video.add(new ModelIntegerString("238", new BigDecimal("-0.000082916795538539")));
        video.add(new ModelIntegerString("83", new BigDecimal("-0.000082916795538539")));

        ArrayList<ModelIntegerString> article = new ArrayList<>();
        article.add(new ModelIntegerString("18", new BigDecimal("-0.000074916795538539")));
        article.add(new ModelIntegerString("562", new BigDecimal("-0.000072786795538539")));
        article.add(new ModelIntegerString("80", new BigDecimal("-0.000082913795338539")));
        article.add(new ModelIntegerString("838", new BigDecimal("-0.000082456785538539")));
        System.out.println(String.format(url, 843528, JSONObject.toJSONString(video, SerializerFeature.WriteBigDecimalAsPlain),
                JSONObject.toJSONString(article, SerializerFeature.WriteBigDecimalAsPlain)));
    }

}

package com.mimu.simple.java.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.mimu.simple.java.stream.StreamRelevantTest;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import sun.jvm.hotspot.runtime.PerfDataPrologue;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mimu
 * date: 2019/7/23
 */
public class FastJsonTest {
    private static final double EARTH_RADIUS = 6371000;

    public static void main(String[] args) {
        double distanceDouble = FastJsonTest.getDistanceDouble(30.28584600054597, 120.07649909322168, 69.17289, 46.383771);
        System.out.println(distanceDouble);
    }

    public static double getDistanceDouble(Double lat1, Double lng1, Double lat2, Double lng2) {
        //经纬度（角度）转弧度。弧度用作参数，以调用Math.cos和Math.sin
        double radiansAX = Math.toRadians(lng1);//A经弧度
        double radiansAY = Math.toRadians(lat1);//A纬弧度
        double radiansBX = Math.toRadians(lng2);//B经弧度
        double radiansBY = Math.toRadians(lat2);//B纬弧度
        //公式中“cosβ1cosβ2cos（α1-α2）+sinβ1sinβ2”的部分，得到∠AOB的cos值
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX) + Math.sin(radiansAY) * Math.sin(radiansBY);
        double acos = Math.acos(cos);//反余弦值
        return EARTH_RADIUS * acos;//最终结果
    }

    @Test
    public void info() {
        People people = new People();
        people.setId(10);
        String peopleStr = JSONObject.toJSONString(people);
        System.out.println(peopleStr);
        People x = JSONObject.parseObject(peopleStr, People.class);
        System.out.println(x.getId());
        System.out.println(x.getName());

        /*String peos = "{\"aName\":\"anamela\",\"id\":11}";
        People people1 = JSONObject.toJavaObject(JSONObject.parseObject(peos), People.class);
        System.out.println(JSONObject.toJSONString(people1));*/

        /*String peos1 = "{\"name\":\"bnamela\",\"id\":12,\"role\":\"worker\"}";
        People people2 = JSONObject.toJavaObject(JSONObject.parseObject(peos1), People.class);
        System.out.println(JSONObject.toJSONString(people2));*/

        /*String peos12 = "{\"name\":\"bnamela\",\"id\":12,\"role\":\"worker\"}";
        People people121 = JSONObject.toJavaObject(JSONObject.parseObject(peos12), Worker.class);
        System.out.println(JSONObject.toJSONString(people121));*/

    }

    @Test
    public void listInfo() {
        ArrayList<People> list = new ArrayList<>();
        People p1 = new People();
        p1.setId(1);
        p1.setName("name1");
        People p2 = new People();
        p2.setId(2);
        p2.setName("name2");
        list.add(p1);
        list.add(p2);
        Grade grade = new Grade();
        grade.setGrade(1);
        grade.setPeopleList(list);

        Template<Grade> template = new Template<>();
        template.setCode(200);
        template.setMsg("success");
        template.setData(grade);

        System.out.println(JSONObject.toJSONString(template));
    }

    @Setter
    @Getter
    static class Template<T> {
        private Integer code;
        private String msg;
        private T data;
    }

    @Setter
    @Getter
    static class Grade {
        private Integer grade;
        private List<People> peopleList;
    }

    static class People {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Worker extends People {
        private String role;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}

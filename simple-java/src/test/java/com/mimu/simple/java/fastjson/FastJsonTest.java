package com.mimu.simple.java.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

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
        Student student = new Student();
        student.setStId(1L);
        Grade grade = new Grade();
        grade.setDegree(1);
        grade.setDegreeDesc("so");
        student.setGrade(grade);
        System.out.println(JSONObject.toJSONString(student));
    }

    @Test
    public void test(){
        System.out.println(String.format("%03d",1));
        OperatingSystemMXBean systemMXBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println(systemMXBean.getName());
    }
}

package com.mimu.simple.java.seriali;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mimu.simple.java.abase.Grade;
import com.mimu.simple.java.abase.Student;
import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

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

    @Test
    public void test1(){
        JSONObject json = new JSONObject();
        json.put("id",1);
        JSONArray list = new JSONArray();
        json.put("list",list);
        System.out.println(json.toJSONString());

        json.getJSONArray("list").add(1,1);


    }

    @Test
    public void test2() throws InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("current "+Thread.currentThread().getName());
            }
        });
        CompletableFuture<Void> future =CompletableFuture.completedFuture(null);

        CompletableFuture.allOf(voidCompletableFuture,future).join();

        String cids = "7323092223519042666,7230678383846706986,6868743954981389900, 7208188122226961210, " +
                "6569242706932314121, 6486201201087393904";

        String[] split = cids.split(",");
        ArrayList<Long> cidList = new ArrayList<>();
        for (String s : split) {
            cidList.add(Long.parseLong(s.trim()));
        }

        for (Long l : cidList) {
            System.out.println(l%32);
        }

    }
}

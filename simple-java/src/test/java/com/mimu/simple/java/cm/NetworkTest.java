package com.mimu.simple.java.cm;


import com.mimu.simple.java.fastjson.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * author: mimu
 * date: 2019/7/12
 */
public class NetworkTest {

    @Before
    public void init() {
        Properties properties = new Properties();
        properties.put("a", "a");
        properties.put("b", "b");
        System.setProperties(properties);
    }

    @Test
    public void info() {
        System.out.println(System.getProperty("a"));
        System.out.println(System.getProperty("b"));
    }

    @Test
    public void info1() {
        List<Student> objects = Collections.emptyList();
        Map<Long, List<Student>> collect = objects.stream().collect(Collectors.groupingBy(new Function<Student, Long>() {
            @Override
            public Long apply(Student student) {
                return student.getStId();
            }
        }));
        System.out.println(collect);
    }

    @Test
    public void equalTest() {
        String first = "{\"code\":200,\"data\":{\"merchantProductSpecList\":[{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":7,\"merchantMark\":\"qxk\",\"merchantName\":\"青行客-骑胜\",\"picUrl\":\"https://static-c.qingxingke.com/didi/merchant/operation/2023-10-24//554d0c4f881141d5121bced193138d90.png\",\"productSpecList\":[{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":13,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\",\"停车摄像头\",\"智能头盔锁\"],\"specDesc\":\"vc5.0摄像头、头盔部件\",\"specName\":\"摄像头+头盔+车架+中控+车码\"},{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":18,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"常规车\",\"specName\":\"车架+中控+车码\"},{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":15,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"常规车\",\"specName\":\"车架+中控+车码\"}]},{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":8,\"merchantMark\":\"qxk\",\"merchantName\":\"青行客-骑胜\",\"picUrl\":\"https://static-c.qingxingke.com/didi/merchant/operation/2023-10-24//62ef3bc98638e558dc5d75c6aaf88a40.png\",\"productSpecList\":[{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":14,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\",\"停车摄像头\",\"智能头盔锁\"],\"specDesc\":\"vm6.0\",\"specName\":\"摄像头+头盔+车架+中控+车码.....................................\"},{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":19,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"常规用车\",\"specName\":\"车架+中控+车码vm6.0\"}]},{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":13,\"merchantMark\":\"qxkj\",\"merchantName\":\"青行科技\",\"picUrl\":\"\",\"productSpecList\":[{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":15,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"常规车\",\"specName\":\"车架+中控+车码\"},{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":13,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\",\"停车摄像头\",\"智能头盔锁\"],\"specDesc\":\"vc5.0摄像头、头盔部件\",\"specName\":\"摄像头+头盔+车架+中控+车码\"}]},{\"assetModel\":\"VM2.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":9,\"merchantMark\":\"qxkj\",\"merchantName\":\"青行科技\",\"picUrl\":\"https://static-c.qingxingke.com/didi/merchant/operation/2023-10-25//265f5838159065becbdb13825e7ae59c.png\",\"productSpecList\":[{\"assetModel\":\"VM2.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":21,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"车架+中控+车码vm2.0\",\"specName\":\"车架+中控+车码vm2.0\"},{\"assetModel\":\"VM2.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":22,\"productPartDescList\":[\"车架\",\"中控\"],\"specDesc\":\"常规车配件\",\"specName\":\"车架+中控+车码vm2.0\"}]},{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":14,\"merchantMark\":\"qxkj\",\"merchantName\":\"青行科技\",\"picUrl\":\"\",\"productSpecList\":[{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":19,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"常规用车\",\"specName\":\"车架+中控+车码vm6.0\"},{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":14,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\",\"停车摄像头\",\"智能头盔锁\"],\"specDesc\":\"vm6.0\",\"specName\":\"摄像头+头盔+车架+中控+车码.....................................\"},{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":23,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\",\"控制器编码\",\"停车摄像头\"],\"specDesc\":\"带摄像头的VM6\",\"specName\":\"吕辉测试\"},{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":24,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"测试\",\"specName\":\"王珂测试\"}]}],\"total\":5},\"msg\":\"处理成功\",\"success\":true}\n";

        String second = "{\"code\":200,\"data\":{\"merchantProductSpecList\":[{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":7,\"merchantMark\":\"qxk\",\"merchantName\":\"青行客-骑胜\",\"picUrl\":\"https://static-c.qingxingke.com/didi/merchant/operation/2023-10-24//554d0c4f881141d5121bced193138d90.png\",\"productSpecList\":[{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":13,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\",\"停车摄像头\",\"智能头盔锁\"],\"specDesc\":\"vc5.0摄像头、头盔部件\",\"specName\":\"摄像头+头盔+车架+中控+车码\"},{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":18,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"常规车\",\"specName\":\"车架+中控+车码\"},{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":15,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"常规车\",\"specName\":\"车架+中控+车码\"}]},{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":8,\"merchantMark\":\"qxk\",\"merchantName\":\"青行客-骑胜\",\"picUrl\":\"https://static-c.qingxingke.com/didi/merchant/operation/2023-10-24//62ef3bc98638e558dc5d75c6aaf88a40.png\",\"productSpecList\":[{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":14,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\",\"停车摄像头\",\"智能头盔锁\"],\"specDesc\":\"vm6.0\",\"specName\":\"摄像头+头盔+车架+中控+车码.....................................\"},{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":19,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"常规用车\",\"specName\":\"车架+中控+车码vm6.0\"}]},{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":13,\"merchantMark\":\"qxkj\",\"merchantName\":\"青行科技\",\"picUrl\":\"\",\"productSpecList\":[{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":15,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"常规车\",\"specName\":\"车架+中控+车码\"},{\"assetModel\":\"VC5.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":13,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\",\"停车摄像头\",\"智能头盔锁\"],\"specDesc\":\"vc5.0摄像头、头盔部件\",\"specName\":\"摄像头+头盔+车架+中控+车码\"}]},{\"assetModel\":\"VM2.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":9,\"merchantMark\":\"qxkj\",\"merchantName\":\"青行科技\",\"picUrl\":\"https://static-c.qingxingke.com/didi/merchant/operation/2023-10-25//265f5838159065becbdb13825e7ae59c.png\",\"productSpecList\":[{\"assetModel\":\"VM2.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":21,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"车架+中控+车码vm2.0\",\"specName\":\"车架+中控+车码vm2.0\"},{\"assetModel\":\"VM2.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":22,\"productPartDescList\":[\"车架\",\"中控\"],\"specDesc\":\"常规车配件\",\"specName\":\"车架+中控+车码vm2.0\"}]},{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":14,\"merchantMark\":\"qxkj\",\"merchantName\":\"青行科技\",\"picUrl\":\"\",\"productSpecList\":[{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":19,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"常规用车\",\"specName\":\"车架+中控+车码vm6.0\"},{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":14,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\",\"停车摄像头\",\"智能头盔锁\"],\"specDesc\":\"vm6.0\",\"specName\":\"摄像头+头盔+车架+中控+车码.....................................\"},{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":23,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\",\"控制器编码\",\"停车摄像头\"],\"specDesc\":\"带摄像头的VM6\",\"specName\":\"吕辉测试\"},{\"assetModel\":\"VM6.0\",\"assetType\":1,\"assetTypeDesc\":\"电单车\",\"id\":24,\"productPartDescList\":[\"车辆id\",\"车架\",\"中控\"],\"specDesc\":\"测试\",\"specName\":\"王珂测试\"}]}],\"total\":5},\"msg\":\"处理成功\",\"success\":true}\n";

        System.out.println(first.equals(second));


    }
}

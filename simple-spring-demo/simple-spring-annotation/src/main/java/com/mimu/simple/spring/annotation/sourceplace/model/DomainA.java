package com.mimu.simple.spring.annotation.sourceplace.model;

import com.alibaba.fastjson2.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * author: mimu
 * date: 2019/12/16
 */

@Setter
@Getter
@Component
public class DomainA {
    @Value("${source.field}")
    private String domain;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

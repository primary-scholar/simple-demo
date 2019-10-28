package com.mimu.simple.spring.mybatis.service;

import com.mimu.simple.spring.mybatis.CommonService;
import com.mimu.simple.spring.mybatis.config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * author: mimu
 * date: 2019/10/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class CommonServiceTest {

    @Autowired
    private CommonService commonService;

    @Test
    public void finUserById() {
        System.out.println(commonService.finUserById(1));
    }
}
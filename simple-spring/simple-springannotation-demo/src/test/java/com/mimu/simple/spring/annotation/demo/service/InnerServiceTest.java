package com.mimu.simple.spring.annotation.demo.service;

import com.mimu.simple.spring.annotation.demo.config.ApplicationConfig;
import com.mimu.simple.spring.annotation.demo.model.PersonData;
import com.mimu.simple.spring.annotation.demo.model.TermData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class InnerServiceTest {

    protected CommonService commonService;

    @Autowired
    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    @Test
    public void saveInfo() {
        PersonData personData = new PersonData();
        personData.setPid(2);
        personData.setNickName("nickname2");
        TermData termData = new TermData();
        termData.setPid(2);
        termData.setTid(2);
        Assert.assertTrue(commonService.saveInfo(personData, termData));
    }


    @Test
    public void updateInfo() {
        PersonData personData = new PersonData();
        personData.setPid(20);
        personData.setNickName("nickname1");
        TermData termData = new TermData();
        termData.setPid(2);
        termData.setTid(1);
        commonService.updateInfo(personData, termData);
        //Assert.assertTrue(commonService.updateInfo(personData, termData));
    }

    @Test
    public void info() {
        while (true) {
            PersonData personData = commonService.getPeople(1);
            System.out.println(personData);
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void logger() {
        System.out.println(commonService.getPeople(1));
    }


}
package com.mimu.simple.spring.annotation.service;

import com.mimu.simple.spring.annotation.config.ApplicationConfig;
import com.mimu.simple.spring.annotation.model.TermData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AsyncTransactionEventTest {

    @Autowired
    private CommonService commonService;

    @Test
    public void info(){
        TermData termData = new TermData();
        termData.setPid(1);
        termData.setTid(2);
        commonService.asyncTransactionExecute(termData);
    }
}

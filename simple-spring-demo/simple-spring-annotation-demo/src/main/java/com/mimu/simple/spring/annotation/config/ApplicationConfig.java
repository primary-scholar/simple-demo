package com.mimu.simple.spring.annotation.config;

import com.mimu.simple.spring.annotation.controller.CommonController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * author: mimu
 * date: 2018/12/4
 */
@Configuration
@EnableAsync
//@EnableScheduling
@ComponentScan(basePackageClasses = CommonController.class)
@Import(value = {AspectConfig.class, DataSourceConfig.class, RedisConfig.class})
public class ApplicationConfig {
}

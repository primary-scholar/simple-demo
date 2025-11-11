package com.mimu.simple.spring.dubbo.provider.config;

import com.mimu.simple.spring.dubbo.provider.ApplicationServer;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = {"classpath:provider.xml"})
@ComponentScan(basePackageClasses = ApplicationServer.class)
@EnableDubbo
public class ApplicationConfig {
}
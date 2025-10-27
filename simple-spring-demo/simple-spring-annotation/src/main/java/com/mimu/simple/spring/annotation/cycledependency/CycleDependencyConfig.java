package com.mimu.simple.spring.annotation.cycledependency;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CycleDependencyConfig.class)
public class CycleDependencyConfig {
}

package com.mimu.simple.spring.multimodel.servera.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ApplicationA {


    public String getHello() {
        return "hello";
    }
}

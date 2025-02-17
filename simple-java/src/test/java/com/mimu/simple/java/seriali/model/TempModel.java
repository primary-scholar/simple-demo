package com.mimu.simple.java.seriali.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class TempModel implements Serializable {
    private Boolean flag;
    private String query;
    private List<String> uIdList;
}

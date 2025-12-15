package com.mimu.simple.java.seriali.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
public class ModelIntegerString implements Serializable {
    @Serial
    private static final long serialVersionUID = 8425835370575545205L;
    private String id;
    private BigDecimal weight;

}

package com.mimu.simple.java.seriali;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
public class ApiResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -4294848960241812599L;

    private Integer code;

    private String message;

    private T data;

}

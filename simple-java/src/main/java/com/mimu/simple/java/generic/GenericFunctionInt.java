package com.mimu.simple.java.generic;

import com.mimu.simple.java.generic.req.CustomReq;

public interface GenericFunctionInt {


    /**
     * @param req
     * @param <T>
     * @return
     */
    public <T,V> V apply(T req);
}

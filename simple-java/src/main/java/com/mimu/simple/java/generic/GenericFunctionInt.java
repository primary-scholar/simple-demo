package com.mimu.simple.java.generic;

public interface GenericFunctionInt {


    /**
     * @param req
     * @param <T>
     * @return
     */
    public <T,V> V apply(T req);
}

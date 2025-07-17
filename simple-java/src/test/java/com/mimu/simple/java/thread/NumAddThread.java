package com.mimu.simple.java.thread;

public class NumAddThread implements Runnable{
    private Integer size;
    public NumAddThread(Integer size){
        this.size = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < size; i++) {

        }
    }
}

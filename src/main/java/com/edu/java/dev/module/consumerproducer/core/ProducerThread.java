package com.edu.java.dev.module.consumerproducer.core;

/**
 * 生产线程
 * Created by garychen on 2018/3/28.
 */
public class ProducerThread extends Thread{

    /**
     * 生产者,生产资源
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long)(1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

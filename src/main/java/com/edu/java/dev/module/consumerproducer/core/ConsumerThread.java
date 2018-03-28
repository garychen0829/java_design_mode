package com.edu.java.dev.module.consumerproducer.core;

/**
 * 消费者
 * Created by garychen on 2018/3/28.
 */
public class ConsumerThread extends Thread {
    /**
     * 消耗资源
     */
    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

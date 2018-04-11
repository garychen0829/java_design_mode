package com.edu.java.dev.module.consumerproducer.core;

/**
 * Created by garychen on 2018/4/11.
 */
public abstract class AbstractProducer implements Producer,Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

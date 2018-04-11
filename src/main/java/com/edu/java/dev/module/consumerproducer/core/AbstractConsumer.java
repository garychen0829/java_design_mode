package com.edu.java.dev.module.consumerproducer.core;

/**
 * Created by garychen on 2018/4/11.
 */
public abstract class AbstractConsumer implements Consumer,Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

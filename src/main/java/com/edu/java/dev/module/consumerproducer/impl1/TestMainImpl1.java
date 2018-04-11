package com.edu.java.dev.module.consumerproducer.impl1;

import com.edu.java.dev.module.consumerproducer.core.Model;

/**
 * Created by garychen on 2018/4/11.
 */
public class TestMainImpl1 {

    public static void main(String[] args) {
        int cap = 10;
        Model model = new BlockingQueueModule(cap);
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}

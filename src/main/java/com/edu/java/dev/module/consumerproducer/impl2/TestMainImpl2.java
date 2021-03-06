package com.edu.java.dev.module.consumerproducer.impl2;

import com.edu.java.dev.module.consumerproducer.core.Model;

/**
 * Created by garychen on 2018/4/11.
 */
public class TestMainImpl2 {

    public static void main(String[] args) {
        int cap = 3;
        Model model = new WaitNotifyModel(cap);
        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}

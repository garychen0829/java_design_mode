package com.edu.java.dev.module.consumerproducer.impl4.test;

import com.edu.java.dev.module.consumerproducer.core.Model;
import com.edu.java.dev.module.consumerproducer.impl4.demo.LockConditionModel2;

/**
 * Created by garychen on 2018/4/11.
 */
public class TestMainImpl4 {

    public static void main(String[] args) {

        Model model = new LockConditionModel2(3);
        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}

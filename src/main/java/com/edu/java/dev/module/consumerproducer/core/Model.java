package com.edu.java.dev.module.consumerproducer.core;

/**
 * Created by garychen on 2018/4/11.
 */
public interface Model {

    Runnable newRunnableConsumer();

    Runnable newRunnableProducer();

}

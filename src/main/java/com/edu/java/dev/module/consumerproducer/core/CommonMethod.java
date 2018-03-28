package com.edu.java.dev.module.consumerproducer.core;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by garychen on 2018/3/28.
 */
public class CommonMethod {

    private int num = 0;//当前资源属性
    private int size = 10;//最大资源数量

    private Lock lock;//自定义锁
    private Condition producerCondition;
    private Condition consumerCondition;




}

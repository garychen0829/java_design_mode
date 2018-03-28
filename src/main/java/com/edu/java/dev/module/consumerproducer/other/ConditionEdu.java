package com.edu.java.dev.module.consumerproducer.other;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 补充学习 java.util.concurrent.locks.Condition
 * Created by garychen on 2018/3/28.
 */
public class ConditionEdu {

    public static void main(String[] args) {
        ConditionEdu edu = new ConditionEdu();
        edu.test();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test(){
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();

        Thread thread = new Thread(() -> {
            try {
                reentrantLock.lock();
                System.out.println("我要等一个新信号" + this);
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我拿到一个信号了!" + this);
            reentrantLock.unlock();
        }, "waitThread1");
        //启动线程
        thread.start();

        Thread thread1 = new Thread(() -> {
            reentrantLock.lock();
            System.out.println("我拿到锁了");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            System.out.println("我发出一个信号");
            reentrantLock.unlock();

        },"signalThread");
        //启动线程
        thread1.start();
    }

}

package com.edu.java.dev.module.consumerproducer.impl2;

import com.edu.java.dev.module.consumerproducer.core.AbstractConsumer;
import com.edu.java.dev.module.consumerproducer.core.Consumer;
import com.edu.java.dev.module.consumerproducer.core.Model;
import com.edu.java.dev.module.consumerproducer.core.Task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by garychen on 2018/4/11.
 */
public class WaitNotifyModel implements Model {

    private final Object BUFFER_LOCK = new Object();
    private final Queue<Task> buffer = new LinkedList<>();
    private int cap = 0;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public WaitNotifyModel(int cap){
        this.cap = cap;
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }

    private class ConsumerImpl extends AbstractConsumer implements Consumer,Runnable{

        @Override
        public void consume() throws InterruptedException {
            synchronized (BUFFER_LOCK) {
                while (buffer.size()==0) {
                    BUFFER_LOCK.wait();
                }
                Task task = buffer.poll();
                assert task != null;
                // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                Thread.sleep(500 + (long) (Math.random() * 500));

                System.out.println("消费: " + task.no);
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    private class ProducerImpl extends AbstractConsumer implements Consumer,Runnable{

        @Override
        public void consume() throws InterruptedException {
            synchronized (BUFFER_LOCK) {
                while (buffer.size() == cap) {
                    BUFFER_LOCK.wait();
                }
                Task task = new Task(increTaskNo.getAndIncrement());
                buffer.offer(task);
                System.out.println("生产: " + task.no);
                BUFFER_LOCK.notifyAll();
            }
        }
    }


}

package com.edu.java.dev.module.consumerproducer.impl1;

import com.edu.java.dev.module.consumerproducer.core.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by garychen on 2018/4/11.
 */
public class BlockingQueueModule implements Model{
    private final BlockingQueue<Task> queue;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public BlockingQueueModule(int cap) {
        //LinkedBlockingQueue 的队列是 lazy-init 的，但 ArrayBlockingQueue 在创建时就已经 init
        this.queue = new LinkedBlockingDeque<>(cap);
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl() ;
    }

    public class ConsumerImpl extends AbstractConsumer implements Consumer,Runnable{

        @Override
        public void consume() throws InterruptedException {
            Task task = queue.take();
            // 固定时间范围的消费，模拟相对稳定的服务器处理过程
            Thread.sleep(500 + (long) (Math.random() * 500));
            System.out.println("消费 : " + task.no);
        }
    }


    public class ProducerImpl extends AbstractProducer {

        @Override
        public void producer() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            Task task = new Task(increTaskNo.getAndIncrement());
            queue.put(task);
            System.out.println("生产 : " + task.no);
        }
    }
}

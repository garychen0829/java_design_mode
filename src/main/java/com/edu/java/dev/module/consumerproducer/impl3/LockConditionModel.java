package com.edu.java.dev.module.consumerproducer.impl3;

import com.edu.java.dev.module.consumerproducer.core.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by garychen on 2018/4/11.
 */
public class LockConditionModel implements Model{
    private final Lock BUFFER_LOCK = new ReentrantLock();
    private final Condition BUFFER_COND = BUFFER_LOCK.newCondition();
    private final Queue<Task> buffer = new LinkedList<>();
    private int cap = 0;
    private final AtomicInteger increTaskNo = new AtomicInteger();

    public LockConditionModel(int cap) {
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

    public class ConsumerImpl extends AbstractConsumer implements Consumer,Runnable{
        @Override
        public void consume() throws InterruptedException {
            BUFFER_LOCK.lockInterruptibly();
            try {
                while (buffer.size()==0){
                    BUFFER_COND.await();
                }
                Task task = buffer.poll();
                // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                Thread.sleep(500 + (long) (Math.random() * 500));
                assert task != null;
                System.out.println("消费: " + task.no);
                BUFFER_COND.signalAll();
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                BUFFER_LOCK.unlock();
            }

        }
    }

    public class ProducerImpl extends AbstractProducer implements Producer,Runnable{
        @Override
        public void producer() throws InterruptedException {
            try {
                BUFFER_LOCK.lockInterruptibly();
                while (buffer.size() == cap){
                    BUFFER_COND.await();
                }
                Task task = new Task(increTaskNo.getAndIncrement());
                buffer.offer(task);
                System.out.println("生产: " + task.no);
                BUFFER_COND.signalAll();
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                BUFFER_LOCK.unlock();
            }
        }
    }
}

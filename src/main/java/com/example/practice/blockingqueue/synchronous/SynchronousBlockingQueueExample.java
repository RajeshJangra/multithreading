package com.example.practice.blockingqueue.synchronous;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class SynchronousBlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new SynchronousQueue<>();
        SynchronousProducer synchronousProducer = new SynchronousProducer(queue);
        new Thread(synchronousProducer).start();
        try {
            Thread.sleep(10 * 100); // so that all messages are published first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SynchronousConsumer synchronousConsumer = new SynchronousConsumer(queue);
        new Thread(synchronousConsumer).start();
        System.out.println("SynchronousProducer and SynchronousConsumer started");
    }
}

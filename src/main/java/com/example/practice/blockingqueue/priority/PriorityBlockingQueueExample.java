package com.example.practice.blockingqueue.priority;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class PriorityBlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new PriorityBlockingQueue<>(10);
        PriorityProducer priorityProducer = new PriorityProducer(queue);
        new Thread(priorityProducer).start();
        try {
            Thread.sleep(10 * 100); // so that all messages are published first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PriorityConsumer priorityConsumer = new PriorityConsumer(queue);
        new Thread(priorityConsumer).start();
        System.out.println("SynchronousProducer and SynchronousConsumer started");
    }
}

package com.example.practice.DelayedQueueExample;

import com.example.practice.blockingqueue.Consumer;
import com.example.practice.blockingqueue.Message;
import com.example.practice.blockingqueue.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class DelayedBlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
        System.out.println("DelayedProducer and DelayedConsumer started");
    }
}

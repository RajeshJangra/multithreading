package com.example.practice.blockingqueue.synchronous;

import java.util.concurrent.BlockingQueue;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class SynchronousConsumer implements Runnable {

    private BlockingQueue<Message> queue;

    public SynchronousConsumer(final BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;
        try {
            Message message;
            while ((message = queue.take()).getMessage() != "Z Completed") {
                Thread.sleep(counter++ * 100);
                System.out.println("Consumed: " + message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All messages consumed");
    }
}

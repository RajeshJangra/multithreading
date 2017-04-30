package com.example.practice.DelayedQueueExample;

import java.util.concurrent.BlockingQueue;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class DelayedConsumer implements Runnable {

    private BlockingQueue<Message> queue;

    public DelayedConsumer(final BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;
        try {
            Message message;
            while ((message = queue.take()).getMessage() != "Completed") {
                Thread.sleep(counter++ * 1000);
                System.out.println("Consumed: " + message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

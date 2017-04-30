package com.example.practice.blockingqueue.delayed;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class DelayedProducer implements Runnable {

    private BlockingQueue<Message> queue;

    public DelayedProducer(final BlockingQueue<Message> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        for (int counter = 0; counter < 20; counter++) {
            try {
                //Thread.sleep(counter * 100);
                queue.put(new Message("Message: " + counter, new Date().getTime() + 1 * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Added Message: " + counter);
        }
        try {
            queue.put(new Message("Completed", new Date().getTime() + 1 * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

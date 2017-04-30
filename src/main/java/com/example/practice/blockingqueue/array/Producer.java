package com.example.practice.blockingqueue.array;

import java.util.concurrent.BlockingQueue;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    public Producer(final BlockingQueue<Message> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        for (int counter = 0; counter < 20; counter++) {
            try {
                //Thread.sleep(counter * 100);
                queue.put(new Message("Message: " + counter));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Added Message: " + counter);
        }
        try {
            queue.put(new Message("Completed"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

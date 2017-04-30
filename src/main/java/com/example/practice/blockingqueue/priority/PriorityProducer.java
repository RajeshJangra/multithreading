package com.example.practice.blockingqueue.priority;

import java.util.concurrent.BlockingQueue;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class PriorityProducer implements Runnable {

    private BlockingQueue<Message> queue;

    public PriorityProducer(final BlockingQueue<Message> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        for (int counter = 20; counter > 0; counter--) {
            try {
                //Thread.sleep(counter * 100);
                queue.put(new Message(((char)(counter + 65)) + " Message"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Added " + ((char)(counter + 65)) + " Message: ");
        }
        try {
            queue.put(new Message("Z Completed"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All messages produced");
    }
}

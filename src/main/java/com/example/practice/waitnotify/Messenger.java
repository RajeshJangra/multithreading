package com.example.practice.waitnotify;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class Messenger implements Runnable {

    private Message message;

    public Messenger(final Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        synchronized (message) {
            try {
                System.out.println(threadName + " waiting to be notified " + System.currentTimeMillis());
                message.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " Got notified " + System.currentTimeMillis());
            System.out.println(threadName + " processed: " + message.getMessage());
        }
    }
}

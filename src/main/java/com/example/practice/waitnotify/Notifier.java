package com.example.practice.waitnotify;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class Notifier implements Runnable {
    private Message message;

    public Notifier(final Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(final Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " Started");

        try {
            Thread.sleep(100);
            synchronized (message){
                message.setMessage(threadName + " Notifiers work done");
                message.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

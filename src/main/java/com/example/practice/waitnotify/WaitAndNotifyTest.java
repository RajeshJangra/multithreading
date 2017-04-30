package com.example.practice.waitnotify;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class WaitAndNotifyTest {
    public static void main(String[] args) throws InterruptedException {
        Message message = new Message("Encrypted message");
        Messenger messenger = new Messenger(message);
        final Thread t1 = new Thread(messenger, "Thread 1");
        t1.start();

        Messenger messenger1 = new Messenger(message);
        final Thread t2 = new Thread(messenger1, "Thread 2");
        t2.start();

        Thread.sleep(200);
        synchronized (message) {
            System.out.println("About to notify 1");
            message.notify();
            Thread.sleep(200);
            System.out.println("About to notify 2");
            message.notify();
        }
        System.out.println("All the threads are started");

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

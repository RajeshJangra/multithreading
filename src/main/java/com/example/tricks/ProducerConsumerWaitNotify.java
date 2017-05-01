package com.example.tricks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rajeshkumar on 01/05/17.
 */
public class ProducerConsumerWaitNotify {

    // Producer Consumer with wait notify

    public static void main(String[] args) {
        Queue<String> stringQueue = new LinkedList();

        //Producer
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                while (stringQueue.size() >= 2) {
                    try {
                        synchronized (stringQueue) {
                            System.out.println("Producer waiting");
                            Thread.currentThread().wait();
                            System.out.println("Producer notified");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String e = "" + i;
                synchronized (stringQueue) {
                    stringQueue.add(e);
                    stringQueue.notify();
                }
                System.out.println("Produced: " + e);
            }
        }).start();

        //Consumer
        new Thread(() -> {
            while (true) {
                while (stringQueue.size() <= 0) {
                    try {
                        synchronized (stringQueue) {
                            System.out.println("Consumer waiting");
                            stringQueue.wait();
                            System.out.println("Consumer notified");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (stringQueue) {
                    System.out.println("Consumed: " + stringQueue.remove());
                    stringQueue.notify();
                }
            }
        }).start();
    }
}
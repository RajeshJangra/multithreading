package com.example.practice;

import java.util.concurrent.Exchanger;

/**
 * Created by rajeshkumar on 01/05/17.
 */
public class ExchangerTest {

    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<String>();

        Thread t1 = new Thread(() -> new Runnable() {
            Exchanger<String> ex = exchanger;
            String message = "I like Coffee";

            public void run() {
                try {
                    System.out.println(" Previous message: " + message);
                    message = ex.exchange(message);
                    System.out.println(" Current message: " + message);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new MyThread(exchanger, "I like tea");
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {

    Exchanger<String> exchanger;
    String message;

    MyThread(Exchanger<String> exchanger, String message) {
        this.exchanger = exchanger;
        this.message = message;
    }

    public void run() {
        try {
            System.out.println(this.getName() + " Previous message: " + message);
            message = exchanger.exchange(message);
            System.out.println(this.getName() + " Current message: " + message);
        } catch (Exception e) {
        }
    }
}

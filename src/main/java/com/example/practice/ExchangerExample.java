package com.example.practice;

import java.util.concurrent.Exchanger;

/**
 * Created by rajeshkumar on 01/05/17.
 */
public class ExchangerExample {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();

        Runnable runnable1 = new Runnable() {
            Exchanger ex = exchanger;
            Object message = "Hello";

            @Override
            public void run() {
                try {
                    Object previous = message;
                    this.message = ex.exchange(this.message);
                    System.out.println(previous + " is changed to " + message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            Exchanger ex = exchanger;
            Object message = "World";

            @Override
            public void run() {
                try {
                    Object previous = message;
                    this.message = ex.exchange(this.message);
                    System.out.println(previous + " is changed to " + message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}

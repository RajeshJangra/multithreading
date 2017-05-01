package com.example.practice;

import java.util.concurrent.Exchanger;

/**
 * Created by rajeshkumar on 01/05/17.
 */
public class ExchangerExample {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger();

        new Thread(() -> {
            try {
                String message = "Hello";
                Object previous = message;
                message = exchanger.exchange(message);
                System.out.println(previous + " is changed to " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                String message = "World";
                Object previous = message;
                message = exchanger.exchange(message);
                System.out.println(previous + " is changed to " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

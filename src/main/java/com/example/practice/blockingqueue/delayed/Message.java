package com.example.practice.blockingqueue.delayed;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class Message implements Delayed {

    private String message;

    private long expiryTime;

    public Message(final String message, final long expiryTime) {
        this.message = message;
        this.expiryTime = expiryTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        long diff = expiryTime - System.currentTimeMillis();
        return timeUnit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        int val = (expiryTime < ((Message) o).expiryTime) ? -1 : expiryTime > ((Message) o).expiryTime ? 1 : 0;
        return val;
    }

    @Override
    public String toString() {
        return message + ": " + expiryTime;
    }
}

package com.example.practice.blockingqueue.array;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class Message {

    private String message;

    public Message(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

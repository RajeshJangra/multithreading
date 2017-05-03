package com.example.tricks;

import java.util.stream.IntStream;

/**
 * Created by rajeshkumar on 02/05/17.
 */
public class Hello {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("Hello")).start();

        IntStream.range(0, 10).forEach( i -> System.out.println(i));
        final boolean b = Thread.currentThread().holdsLock(String.class);
    }


}


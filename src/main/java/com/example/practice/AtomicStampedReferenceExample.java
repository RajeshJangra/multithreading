package com.example.practice;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by rajeshkumar on 02/05/17.
 */
public class AtomicStampedReferenceExample {
    public static void main(String[] args) {
        String initialRef = "text";
        int initialStamp = 0;

        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(initialRef, initialStamp);

        int[] stampHolders = new int[3];
        Object ref = atomicStampedReference.get(stampHolders);

        System.out.println("ref = " + ref);
        for (int stampHolder: stampHolders) {
            System.out.println("stamp = " + stampHolder);
        }

        atomicStampedReference.compareAndSet("text", "New Text", 0, 1);
        ref = atomicStampedReference.get(stampHolders);
        System.out.println("ref = " + ref);
        for (int stampHolder: stampHolders) {
            System.out.println("stamp = " + stampHolder);
        }

        atomicStampedReference.compareAndSet("New Text", "Newer Text", 1, 2);
        ref = atomicStampedReference.get(stampHolders);
        System.out.println("ref = " + ref);
        for (int stampHolder: stampHolders) {
            System.out.println("stamp = " + stampHolder);
        }
    }
}

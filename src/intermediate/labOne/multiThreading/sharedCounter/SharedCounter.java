package intermediate.labOne.multiThreading.sharedCounter;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounter {
    private static AtomicInteger count = new AtomicInteger();

    // Method to increment the counter


    // Synchronized block to ensure thread safety
    public static synchronized void increment() {
        count.incrementAndGet();
        System.out.println("Thread ID: " + Thread.currentThread().threadId());
        System.out.println("Count after increment: " + count);

    }

    // Getter for the count value
    public static int getCount() {
        return count.get();
    }
}

package intermediate.labOne.multiThreading.sharedCounter;

public class Program {
    public static void main(String[] args) {


        // Create multiple threads to increment the counter
        Thread t1 = new Thread(() -> {
            SharedCounter  counter =new SharedCounter();
            for (int i = 0; i < 100; i++) {
                SharedCounter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            SharedCounter  counter =new SharedCounter();
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        });

        // Start the threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Threads interrupted.");
        }

        System.out.println("Final count: " + SharedCounter.getCount());
    }
}

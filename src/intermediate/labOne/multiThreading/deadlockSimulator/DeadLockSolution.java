package intermediate.labOne.multiThreading.deadlockSimulator;

public class DeadLockSolution {
    private static final Object Resource1 = new Object();
    private static final Object Resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (Resource1) {
                System.out.println("Thread 1: Locked Resource 1");

                try {
                    // Simulating processing time
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                synchronized (Resource2) {
                    System.out.println("Thread 1: Locked Resource 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (Resource1) {
                System.out.println("Thread 2: Locked Resource 1");

                try {
                    // Simulating processing time
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                synchronized (Resource2) {
                    System.out.println("Thread 2: Locked Resource 2");
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}

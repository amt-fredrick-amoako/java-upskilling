package intermediate.labOne.multiThreading.imageProcessor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Program {
    public static void main(String[] args) {
        // Number of threads in the pool
        int numberOfThreads = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        // List of image names to process
        String[] imageNames = {"image1.png", "image2.png", "image3.png", "image4.png", "image5.png"};

        // Submitting tasks to the executor service
        for (String imageName : imageNames) {
            ImageProcessor processor = new ImageProcessor(imageName);
            executorService.submit(processor);
        }

        // Initiating shutdown and waiting for the completion of all tasks
        executorService.shutdown();

        while (!executorService.isTerminated()) {
            // Wait for all tasks to finish

        }
        System.out.println("All images have been processed.");
    }
}

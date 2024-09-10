package intermediate.labOne.multiThreading.imageProcessor;

public class ImageProcessor implements Runnable {
    private String imageName;

    public ImageProcessor(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void run() {
        System.out.println("Processing image: " + imageName);
        // Simulate image processing time
        try {
            Thread.sleep(1000); // Simulate processing delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Image processing was interrupted for: " + imageName);
        }
        System.out.println("Completed processing image: " + imageName);
    }
}

package intermediate.labTwo.designPatterns.creational.singleton;

public class Program {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Starting application...");

        // Perform other operations
        logger.log("Performing an operation...");

        logger.log("Ending application.");
    }
}

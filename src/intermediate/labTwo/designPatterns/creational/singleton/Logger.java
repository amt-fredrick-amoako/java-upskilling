package intermediate.labTwo.designPatterns.creational.singleton;

public class Logger {
    // The static variable that holds the one and only instance of the Logger
    private static Logger instance;

    private static int numOfInstances = 0;

    // Making the constructor private to prevent instantiation from other classes
    private Logger() {
    }

    // Public method to provide global access to the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
            numOfInstances++;
        }


        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println(System.currentTimeMillis() + ": " + message);
        System.out.println("The number of instances: " + numOfInstances);
    }
}


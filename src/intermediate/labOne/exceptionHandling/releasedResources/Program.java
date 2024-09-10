package intermediate.labOne.exceptionHandling.releasedResources;

public class Program {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.readFile("example.txt");
    }
}

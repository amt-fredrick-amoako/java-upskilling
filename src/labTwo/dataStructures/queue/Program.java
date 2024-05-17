package labTwo.dataStructures.queue;

public class Program {
    public static void main(String... args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTask("Devops upskilling labs");
        scheduler.addTask("Java upskilling labs");
        scheduler.addTask("Welfare app groupings");

        System.out.println("Tasks in queue:");
        scheduler.displayTasks();

        System.out.println("Completed: " + scheduler.completeTask());

        System.out.println("Tasks in queue:");
        scheduler.displayTasks();

    }
}

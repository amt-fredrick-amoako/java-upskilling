package labTwo.dataStructures.queue;

public class Program {
    public static void main(String... args) {
//        String [] orders = {"green curry","pad thai","gyoza","cucumber salad","pad see ew", "brown rice","red curry","salad rolls"};
//
//        RestaurantOrders foodOrders = new RestaurantOrders();
//
//        foodOrders.assign(orders);

        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks to the queue
        scheduler.addTask("Task 1");
        scheduler.addTask("Task 2");
        scheduler.addTask("Task 3");

        // Display tasks
        System.out.println("Tasks in queue:");
        scheduler.displayTasks();

        // Complete a task
        System.out.println("Completed: " + scheduler.completeTask());

        // Display tasks
        System.out.println("Tasks in queue:");
        scheduler.displayTasks();

    }
}

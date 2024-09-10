package intermediate.labOne.dataStructures.heap;

public class Task {
    int priority;
    String description;

    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "priority=" + priority +
                ", description='" + description + '\'' +
                '}';
    }
}

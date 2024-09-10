package foundation.labTwo.dataStructures.queue;

import foundation.labTwo.dataStructures.linkedList.Node;

public class TaskScheduler {
    private Queue queue;

    public TaskScheduler() {
        this.queue = new Queue();
    }

    public void addTask(String task) {
        this.queue.enqueue(task);
    }

    public String completeTask() {
        return this.queue.dequeue();
    }

    public void displayTasks() {
        Node current = this.queue.queue.head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNextNode();
        }
    }
}

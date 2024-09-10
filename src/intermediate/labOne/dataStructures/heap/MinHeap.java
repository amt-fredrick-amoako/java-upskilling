package intermediate.labOne.dataStructures.heap;

import java.util.ArrayList;

public class MinHeap {
    public ArrayList<Task> heap;
    public int size;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(null); // Adding a dummy element at index 0
        this.size = 0;
    }

    public void add(Task task) {
        this.heap.add(task);
        this.size++;
        this.bubbleUp();
    }

    public Task popMin() {
        if (this.size == 0) {
            throw new Error("Heap is empty!");
        }
        this.swap(1, this.size);
        Task min = this.heap.remove(this.size);
        this.size--;
        this.heapify();
        return min;
    }

    private void bubbleUp() {
        int current = this.size;
        while (current > 1 && this.heap.get(current).getPriority() < this.heap.get(this.getParent(current)).getPriority()) {
            this.swap(current, this.getParent(current));
            current = this.getParent(current);
        }
    }

    private void heapify() {
        int current = 1;
        int leftChild = this.getLeft(current);
        int rightChild = this.getRight(current);
        while (this.canSwap(current, leftChild, rightChild)) {
            if (this.exists(leftChild) && this.exists(rightChild)) {
                if (this.heap.get(leftChild).getPriority() < this.heap.get(rightChild).getPriority()) {
                    this.swap(current, leftChild);
                    current = leftChild;
                } else {
                    this.swap(current, rightChild);
                    current = rightChild;
                }
            } else {
                this.swap(current, leftChild);
                current = leftChild;
            }
            leftChild = this.getLeft(current);
            rightChild = this.getRight(current);
        }
    }

    private void swap(int a, int b) {
        Task temp = this.heap.get(b);
        this.heap.set(b, this.heap.get(a));
        this.heap.set(a, temp);
    }

    private boolean exists(int index) {
        return index <= this.size;
    }

    private boolean canSwap(int current, int leftChild, int rightChild) {
        return (this.exists(leftChild) && (this.heap.get(current).getPriority() > this.heap.get(leftChild).getPriority()))
                || (this.exists(rightChild) && (this.heap.get(current).getPriority() > this.heap.get(rightChild).getPriority()));
    }

    public int getParent(int current) {
        return current / 2;
    }

    public int getLeft(int current) {
        return current * 2;
    }

    public int getRight(int current) {
        return (current * 2) + 1;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        // Add tasks with different priorities
        minHeap.add(new Task(5, "Task 1"));
        minHeap.add(new Task(3, "Task 2"));
        minHeap.add(new Task(8, "Task 3"));
        minHeap.add(new Task(1, "Task 4"));
        minHeap.add(new Task(6, "Task 5"));

        // Simulate task scheduling
        System.out.println("Scheduled tasks based on priority:");
        while (minHeap.size > 0) {
            System.out.println(minHeap.popMin());
        }
    }
}
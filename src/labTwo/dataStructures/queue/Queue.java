package labTwo.dataStructures.queue;

import labTwo.dataStructures.linkedList.LinkedList;

/**
 * Queue class represents a first-in-first-out (FIFO) queue of objects.
 * The usual enqueue and dequeue operations are provided, as well as a method to peek at the head item on the queue,
 * a method to test for whether the queue is empty.
 * When a queue is first created, it contains no items.
 */
public class Queue {

    // LinkedList instance to hold the queue elements
    public LinkedList queue;

    // Current size of the queue
    public int size;

    // Default maximum size of the queue
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;

    // Maximum size of the queue
    public int maxSize;

    public Queue(){
        this(DEFAULT_MAX_SIZE);
    }

    /**
     * Creates a new queue that is initially empty.
     * @param maxSize Maximum size of the queue
     */
    public Queue(int maxSize){
        this.queue = new LinkedList();
        this.size = 0;
        this.maxSize = maxSize;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
     * @param data the item to be added into this queue.
     * @throws Error if the queue is full
     */
    public void enqueue(String data) {
        if(hasSpace()){
            this.queue.addToTail(data);
            this.size++;
        }else{
            throw new Error("Queue is full!");
        }
    }

    /**
     * Retrieves and removes the head of this queue.
     * @return The head of this queue
     * @throws Error if the queue is empty
     */
    public String dequeue() {
        if (!this.isEmpty()) {
            String data = this.queue.removeHead();
            this.size--;
            return data;
        } else {
            throw new Error("Queue is empty!");
        }
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * @return the head of this queue, or null if this queue is empty
     */
    public String peek(){
        return !isEmpty() ? this.queue.head.getData() : null;
    }

    /**
     * Checks if the queue has space for more elements.
     * @return true if the queue has space, false otherwise
     */
    public boolean hasSpace(){
        return this.size < this.maxSize;
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return this.size <= 0;
    }
}

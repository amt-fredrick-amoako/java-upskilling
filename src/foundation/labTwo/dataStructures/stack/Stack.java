package foundation.labTwo.dataStructures.stack;

import foundation.labTwo.dataStructures.linkedList.LinkedList;

/**
 * Stack class represents a last-in-first-out (LIFO) stack of objects.
 * The usual push and pop operations are provided, as well as a method to peek at the top item on the stack,
 * a method to test for whether the stack is empty.
 * When a stack is first created, it contains no items.
 */
public class Stack {

    // LinkedList instance to hold the stack elements
    public LinkedList stack;

    // Current size of the stack
    public int size;

    // Default maximum size of the stack
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;

    // Maximum size of the stack
    public int maxSize;

    public Stack() {
        this(DEFAULT_MAX_SIZE);
    }

    /**
     * Creates a new stack that is initially empty.
     * @param maxSize Maximum size of the stack
     */
    public Stack(int maxSize) {
        this.stack = new LinkedList();
        this.size = 0;
        this.maxSize = maxSize;
    }

    /**
     * Checks if the stack has space for more elements.
     * @return true if the stack has space, false otherwise
     */
    public boolean hasSpace() {
        return this.size < this.maxSize;
    }

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Pushes an item onto the top of this stack.
     * @param data the item to be pushed onto this stack.
     * @throws Error if the stack is full
     */
    public void push(String data) {
        if(hasSpace()){
            this.stack.addToHead(data);
            this.size++;
        }else{
            throw new Error("Stack is full!");
        }
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     * @return The object at the top of this stack
     * @throws Error if the stack is empty
     */
    public String pop() {
        if(!isEmpty()){
            String data = this.stack.removeHead();
            this.size--;
            return data;
        }else{
            throw new Error("Stack is empty!");
        }
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * @return the object at the top of this stack or null if the stack is empty.
     */
    public String peek() {
        return !isEmpty() ? this.stack.head.getData() : null;
    }
}


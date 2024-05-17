package labTwo.dataStructures.stack;

import labTwo.dataStructures.linkedList.LinkedList;

public class Stack {

    public LinkedList stack;
    public int size;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    public int maxSize;

    public Stack() {
        this(DEFAULT_MAX_SIZE);
    }

    public Stack(int maxSize) {
        this.stack = new LinkedList();
        this.size = 0;
        this.maxSize = maxSize;
    }

    public boolean hasSpace() {
        return this.size < this.maxSize;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(String data) {
        if(hasSpace()){
            this.stack.addToHead(data);
            this.size++;
            System.out.println("Added " + data + "! Stack size is now " + this.size);
        }else{
            throw new Error("Stack is full!");
        }
    }

    public String pop() {
        if(!isEmpty()){
            String data = this.stack.removeHead();
            this.size--;
            System.out.println("Removed " + data + "! Stack size is now " + this.size);
            return data;
        }else{
            throw new Error("Stack is empty!");
        }
    }

    public String peek() {
        return !isEmpty() ? this.stack.head.getData() : null;
    }
}

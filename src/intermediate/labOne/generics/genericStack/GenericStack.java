package intermediate.labOne.generics.genericStack;

public class GenericStack<T> {

    private Node<T> top;
    private int size;

    public GenericStack() {
        this.top = null;
        this.size = 0;
    }

    // Push an element onto the stack
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack.");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    // Peek the top element of the stack
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the size of the stack
    public int size() {
        return size;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public static void main(String... args) {

        //Strings Stack Data Structure
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("Top element: " + stringStack.peek());  // Outputs "World"
        System.out.println("Stack size: " + stringStack.size());   // Outputs 2
        System.out.println("Popped element: " + stringStack.pop()); // Outputs "World"
        System.out.println("New top element: " + stringStack.peek());// Outputs "Hello"

        //Integer Stack DataStructure
        GenericStack<Integer> integerStack = new GenericStack<>();
        integerStack.push(45);
        integerStack.push(89);
        integerStack.push(0);
        System.out.println("Top element: " + integerStack.peek());  // Outputs "0"
        System.out.println("Stack size: " + integerStack.size());   // Outputs 3
        System.out.println("Popped element: " + integerStack.pop()); // Outputs "0"
        System.out.println("New top element: " + integerStack.peek());// Outputs "89"
    }
}

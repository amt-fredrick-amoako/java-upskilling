package labTwo.dataStructures.linkedList;

public class Node {
    private Node next;
    private String data;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return this.data;
    }

    public void setNextNode(Node next) {
        this.next = next;
    }

    public Node getNextNode() {
        return this.next;
    }
}
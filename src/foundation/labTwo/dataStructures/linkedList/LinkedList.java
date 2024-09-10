package foundation.labTwo.dataStructures.linkedList;

public class LinkedList {
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    /**
     * Adds data to the head of a list.
     * @param data to be added to the list.
     */
    public void addToHead(String data) {
        Node newHead = new Node(data);
        Node currentHead = this.head;
        this.head = newHead;
        if(currentHead != null){
            this.head.setNextNode(currentHead);
        }
    }

    /**
     * Adds data to the tail of the list in an iterative fashion.
     * @param data to be added to the end of the list.
     */
    public void addToTail(String data) {
        Node tail = this.head;

        if(tail == null){
            this.head = new Node(data);
        }else{
            while(tail.getNextNode() != null){
                tail = tail.getNextNode();
            }

            tail.setNextNode(new Node(data));
        }
    }

    /**
     * Removes the head in the list
     * @return the head in the list.
     */
    public String removeHead(){
        Node removedHead = this.head;

        if(removedHead == null){
            return null;
        }

        this.head = this.head.getNextNode();
        return removedHead.getData();
    }

    /**
     * Iterate through the list and print all the items in the list.
     */
    public void printList(){
        StringBuilder output = new StringBuilder("<head> ");
        Node currentNode = this.head;
        while(currentNode != null){
            output.append(currentNode.getData()).append(", ");
            currentNode = currentNode.getNextNode();
        }
        output.append("<tail>");
        System.out.println(output);
    }

    /**
     * Finds and deletes specified data from the list.
     * Does nothing when there's no matching data.
     * @param data to be removed
     */
    public void delete(String data) {
        if (this.head == null) {
            return;
        }

        if (this.head.getData().equals(data)) {
            this.head = this.head.getNextNode();
            return;
        }

        Node currentNode = this.head;
        while (currentNode.getNextNode() != null) {
            if (currentNode.getNextNode().getData().equals(data)) {
                currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                return;
            }
            currentNode = currentNode.getNextNode();
        }
    }

    /**
     * Searches for a node with the given data in the list.
     * @param data The data of the node to be searched.
     * @return The data if found, null otherwise.
     */
    public String search(String data) {
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData().equals(data)) {
                return currentNode.getData();
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }
}
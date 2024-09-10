package intermediate.labOne.dataStructures.avl;

public class Node<T extends Comparable<T>> {

    private T data;
    private int height = 1;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", height=" + height +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}

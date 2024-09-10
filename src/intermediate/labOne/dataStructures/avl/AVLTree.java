package intermediate.labOne.dataStructures.avl;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    Node<T> root = null;

    @Override
    public Tree<T> insert(T data) {
        root = insert(data, root);
        return this;
    }

    private Node<T> insert(T data, Node<T> node) {
       if(node == null) {
           return new Node<>(data);
       }
       if(data.compareTo(node.getData()) < 0) {
           node.setLeftChild(insert(data, node.getLeftChild()));
       }else if(data.compareTo(node.getData()) > 0) {
           node.setRightChild(insert(data, node.getRightChild()));
       }else{
           return node;
       }

       updateHeight(node);
       return applyRotation(node);
    }

    @Override
    public void delete(T data) {
        root = delete(data, root);
    }

    private Node<T> delete(T data, Node<T> node) {
       if(node == null) {
           return null;
       }
       if(data.compareTo(node.getData()) < 0) {
           node.setLeftChild(delete(data, node.getLeftChild()));
       }else if(data.compareTo(node.getData()) > 0) {
           node.setRightChild(delete(data, node.getRightChild()));
       }else{
           if(node.getLeftChild() == null){
               return node.getRightChild();
           }else if(node.getRightChild() == null){
               return node.getLeftChild();
           }

           node.setData(getMax(node.getLeftChild()));
           node.setLeftChild(delete(node.getData(), node.getLeftChild()));
       }

        updateHeight(node);
        return applyRotation(node);
    }

    private Node<T> applyRotation(Node<T> node) {
       int balance = balance(node);
       if(balance > 1){ // left heavy
           if(balance(node.getLeftChild()) < 0){ // if balance of the node's left child is negative
               node.setLeftChild(rotateLeft(node.getLeftChild()));
           }
           return rotateRight(node);
       }
       if(balance < -1){ // right heavy
           if(balance(node.getRightChild()) > 0){ // if balance of the node's right child is positive
               node.setRightChild(rotateRight(node.getRightChild()));
           }
           return rotateLeft(node);
       }

       return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftChild = node.getLeftChild();
        Node<T> centerNode = leftChild.getRightChild();
        leftChild.setRightChild(node);
        node.setLeftChild(centerNode);
        return leftChild;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightNode = node.getRightChild();
        Node<T> centerNode = rightNode.getLeftChild();
        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);
        return rightNode;
    }

    private int balance(Node<T> node) {
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    private void updateHeight(Node<T> node) {
        int maxHeight = Math.max(
                height(node.getLeftChild()),
                height(node.getRightChild())
        );

        node.setHeight(maxHeight + 1);
    }

    private int height(Node<T> node) {
       return node != null ? node.getHeight() : 0;
    }

    private T getMax(Node<T> node) {
       if(node.getRightChild() != null){
           return getMax(node.getRightChild());
       }

       return node.getData();
    }

    @Override
    public void traverse() {
        traverseOrder(root);
    }

    private void traverseOrder(Node<T> node) {
       if(node != null){
           traverseInOrder(node.getLeftChild());
           System.out.println(node);
           traverseInOrder(node.getRightChild());
       }
    }

    private void traverseInOrder(Node<T> node) {
        if(node != null){
            traverseInOrder(node.getLeftChild());
            System.out.println(node);
            traverseInOrder(node.getRightChild());
        }
    }

    @Override
    public T getMax() {
        if(isEmpty()){
            return null;
        }
        return getMax(root);
    }

    @Override
    public T getMin() {
        if(isEmpty()){
            return null;
        }
        return getMin(root);
    }

    private T getMin(Node<T> node) {
       if(node.getLeftChild() != null){
           return getMin(node.getLeftChild());
       }
       return node.getData();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}

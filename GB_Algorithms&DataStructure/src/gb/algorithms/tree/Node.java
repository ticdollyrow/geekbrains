package gb.algorithms.tree;


public class Node<T extends Comparable<? super T>> {
    private final T value;
    private boolean isRepeat;
    protected int repeat;
    private boolean isRed;

    private Node<T> leftChild;
    private Node<T> rightChild;



    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLeftChild(T value) {
        return getValue().compareTo(value) > 0;
    }

    public boolean isList() {
        return leftChild == null && rightChild == null;
    }

    public boolean hasOnlyOneChild() {
//        return (leftChild != null && rightChild == null) || (leftChild == null && rightChild != null);
        return leftChild != null ^ rightChild != null;
    }
}


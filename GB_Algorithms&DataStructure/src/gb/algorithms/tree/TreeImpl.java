package gb.algorithms.tree;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    public Node<E> getRoot() {
        return root;
    }

    private Node<E> root;
    private int size;

    private class NodeAndParent {
        private Node<E> current;
        private Node<E> parent;
        private int level;

        public NodeAndParent(Node<E> current, Node<E> parent, int level) {
            this.current = current;
            this.parent = parent;
            this.level = level;
        }
    }

    @Override
    public boolean contains(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        return nodeAndParent.current != null;
    }

    private NodeAndParent doFind(E value) {
        Node<E> current = root;
        Node<E> parent = null;
        int level = 1;

        while (current != null) {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, parent, level);
            }
            level++;
            parent = current;
            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return new NodeAndParent(null, parent, level);
    }

    @Override
    public boolean add(E value) {
        NodeAndParent nodeAndParent = doFind(value);

        if (nodeAndParent.current != null) {
//            nodeAndParent.current.repeat++;
            return true;
        }
        if( nodeAndParent.level > 4){
            return false;
        }

        Node<E> node = new Node<>(value);

        Node<E> parent = nodeAndParent.parent;

        if (parent == null) {
            root = node;
        } else if (parent.isLeftChild(value)) {
            parent.setLeftChild(node);
        } else {
            parent.setRightChild(node);
        }
        size++;

        return true;
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> removed = nodeAndParent.current;
        Node<E> parent = nodeAndParent.parent;

        if (removed == null) {
            return false;
        }

        if (removed.isList()) {
            removeNodeWithoutChild(removed, parent);
        } else if (removed.hasOnlyOneChild()) {
            removeNodeWithOneChild(removed, parent);
        } else {
            removeNodeWithAllChildren(removed, parent);
        }
        size--;
        return true;
    }

    private void removeNodeWithoutChild(Node<E> removed, Node<E> parent) {
        if (removed == root) {
            root = null;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
    }

    private void removeNodeWithOneChild(Node<E> removed, Node<E> parent) {
        Node<E> child = removed.getLeftChild() != null ? removed.getLeftChild() : removed.getRightChild();

        if (removed == root) {
            root = child;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(child);
        } else {
            parent.setRightChild(child);
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private void removeNodeWithAllChildren(Node<E> removed, Node<E> parent) {
        Node<E> successor = getSuccessor(removed);

        if (removed == root) {
            root = successor;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(successor);
        } else {
            parent.setLeftChild(successor);
        }

    }

    private Node<E> getSuccessor(Node<E> removed) {
        Node<E> successor = removed;
        Node<E> successorParent = null;
        Node<E> current = removed.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removed.getRightChild() && successorParent != null) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removed.getRightChild());
            successor.setLeftChild(removed.getLeftChild());
        }
        return successor;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public void traverse(TraversMode mode) {
//        switch (mode) {
//            case PRE_ORDER -> preOrder(root); //прямой обход
//            case IN_ORDER -> inOrder(root); //центрированный обход
//            case POST_ORDER -> postOrder(root); //обратный порядок
//            default -> throw new RuntimeException("Unknown travers mode: " + mode);
//        }
//        System.out.println();
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.print(current.getValue() + " ");
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        System.out.print(current.getValue() + " ");
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.print(current.getValue() + " ");
        inOrder(current.getRightChild());
    }
}

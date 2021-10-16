package gb.algorithms.collections.list;

import gb.algorithms.collections.queue.Queue;

public class LinkedQueue<E> implements Queue<E> {
    private final TwoSideLinkedList<E> data;

    public LinkedQueue() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedQueue{" + "data=" + data + '}';
    }
}

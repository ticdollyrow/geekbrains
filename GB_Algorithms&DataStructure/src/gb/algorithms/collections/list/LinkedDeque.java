package gb.algorithms.collections.list;

import gb.algorithms.collections.deque.Deque;

public class LinkedDeque<E> implements Deque<E> {
    private final TwoSideLinkedList<E> data;

    public LinkedDeque(){
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insertLeft(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        return data.removeLast();

    }

    @Override
    public boolean insert(Object value) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    public boolean remove(E value) {
        return data.remove(value);
    }

    @Override
    public Object peekFront() {
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
    public String toString(){
        return "LinkedDeque{" + "data=" + data + '}';
    }
}

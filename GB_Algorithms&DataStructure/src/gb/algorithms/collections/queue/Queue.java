package gb.algorithms.collections.queue;

public interface Queue<E>{
    boolean insert(E value);

    E remove();

    E peekFront();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();
}

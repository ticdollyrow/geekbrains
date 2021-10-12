package gb.algorithms.collections.deque;

import gb.algorithms.collections.queue.Queue;

public interface Deque<E> extends Queue {
    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();
}

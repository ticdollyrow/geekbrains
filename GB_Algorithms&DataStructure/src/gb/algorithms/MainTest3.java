package gb.algorithms;

import gb.algorithms.collections.deque.Deque;
import gb.algorithms.collections.deque.DequeImpl;
import gb.algorithms.collections.queue.Queue;
import gb.algorithms.collections.queue.QueueImpl;

public class MainTest3 {
    public static void main(String[] args) {
//        testQueue();
        testDeue();
    }

    private static void testQueue() {

        Queue<Integer> queue = new QueueImpl<>(5);
        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));
        System.out.println("add element: " + queue.insert(14));
        System.out.println("add element: " + queue.insert(17));

        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();

    }

    private static void testDeue() {
        Deque<Integer> deque = new DequeImpl<>(5);
        System.out.println("add element: " + deque.insertRight(2));
        System.out.println("add element: " + deque.insertLeft(34));
        System.out.println("add element: " + deque.insertRight(1));
        System.out.println("add element: " + deque.insertLeft(25));
        System.out.println("add element: " + deque.insertLeft(3));
        System.out.println("add element: " + deque.insertLeft(77));

        deque.display();
        System.out.println("remove: " + deque.removeRight());
        deque.display();
        System.out.println("remove: " + deque.removeLeft());
        deque.display();

    }


}

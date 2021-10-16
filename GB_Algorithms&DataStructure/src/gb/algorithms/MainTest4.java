package gb.algorithms;

import gb.algorithms.collections.list.LinkedDeque;
import gb.algorithms.collections.list.LinkedList;
import gb.algorithms.collections.list.SimpleLinkedListImpl;
import gb.algorithms.collections.list.TwoSideLinkedListImpl;

public class MainTest4 {

    public static void main(String[] args) {

//        testLinkedList();
        testLinkedDeque();
    }


    private  static void testLinkedDeque(){
        LinkedDeque<Integer> linkedDeque = new LinkedDeque<>();
        linkedDeque.insertLeft(2);
        linkedDeque.insertLeft(5);
        linkedDeque.insertRight(12);
        linkedDeque.insertLeft(8);

        linkedDeque.display();
//        linkedDeque.removeLeft();
//        linkedDeque.display();
//        linkedDeque.removeRight();
//        linkedDeque.display();
        linkedDeque.remove(5);
        linkedDeque.display();

    }


    private static void testLinkedList() {
        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
//        var linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);


        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        linkedList.removeFirst();
        linkedList.remove(4);

        linkedList.display();


        //ДОЛЖНО РАБОТАТЬ! Iterable - LinkedListIterator impl Iterator

       for (Integer value : linkedList) {
            System.out.println("value: " + value);
        }

    }

}

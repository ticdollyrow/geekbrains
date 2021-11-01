package gb.algorithms;

import gb.algorithms.hashtable.Product;
import gb.algorithms.hashtable.homework.HashTableImpl;

public class MainTest8 {
    public static void main(String[] args) {
        var hashTable = new HashTableImpl<>(5);

        hashTable.put(new Product(1, "Orange"), 150);
        hashTable.put(new Product(77, "Banana"), 100);
        hashTable.put(new Product(60, "Lemon"), 250);
        hashTable.put(new Product(1, "Orange"), 20);
        hashTable.put(new Product(61, "Cookie"), 120);

        System.out.println("Size is " + hashTable.size());
        hashTable.display();


        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));
        System.out.println("Cost orange is " + hashTable.get(new Product(1, "Orange")));

        System.out.println(hashTable.remove(new Product(1, "Orange")));

        System.out.println("Size is " + hashTable.size());
        hashTable.display();
    }
}

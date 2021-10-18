package gb.algorithms;

import gb.algorithms.recursion.Backpack;
import gb.algorithms.recursion.Exponentiation;
import gb.algorithms.recursion.Item;

import java.util.LinkedList;
import java.util.List;

public class MainTest5 {
    public static void main(String[] args) {
//        System.out.println(Exponentiation.pow(5.0, -1));


        List<Item> pack = new LinkedList<>();
        pack.add(new Item("notebook", 4000,2));
        pack.add(new Item("phone", 2000, 1));
        pack.add(new Item("book", 500, 3));
        pack.add(new Item("watch", 1500, 3));

        Backpack backpack = new Backpack(4);
        backpack.getBestSet(pack);
    }
}

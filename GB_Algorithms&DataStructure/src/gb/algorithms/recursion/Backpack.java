package gb.algorithms.recursion;

import java.util.LinkedList;
import java.util.List;

public class Backpack {
//    максимальная масса рюкзака
    private int maxWeight;
    private int bestPrice;
    private List<Item> result;

    public Backpack(int weight){
        maxWeight = weight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

//    вес предметов
    private int sumWeight(List<Item> items){
        int weight = 0;
        for (Item item: items) {
            weight += item.getWeight();
        }
        return  weight;
    }

//    соимость предметов
    private int sumPrice(List<Item> items){
        int price = 0;
        for (Item item: items) {
            price += item.getPrice();
        }
        return price;
    }

    private void check(List<Item> items){
        if (result == null)
        {
            if (sumWeight(items) <= maxWeight)
            {
                result = items;
                bestPrice = sumPrice(items);
            }
        }
        else
        {
            if(sumWeight(items) <= maxWeight && sumPrice(items) > bestPrice)
            {
                result = items;
                bestPrice = sumPrice(items);
            }
        }
    }

    private void find(List<Item> items){
        if(items.size() > 0){
            check(items);

            for(int i = 0; i < items.size(); i++ ){
                List<Item> newItem  = new LinkedList<>(items);
                newItem.remove(i);
                find(newItem);
            }
        }
    }

    public void getBestSet(List<Item> items){
        find(items);

        for (Item item: result) {
            item.print();
        }
    }
}

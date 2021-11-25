package fruit;

import com.google.common.math.DoubleMath;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box>{
    @Getter
    private List<T> fruits;


    public Box(){
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public double getWeight(){
        double weight = 0.0;

        for (T fruit : fruits) {
            weight+= fruit.getWeight();
        }
        return weight;
    }

    public void empty(Box<T> box){
        this.fruits.addAll(box.getFruits());
        box.clear();
    }

    private void clear() {
        this.fruits.clear();
    }


    @Override
    public int compareTo(Box box) {
        double epsilon = 0.000001d;
        return  DoubleMath.fuzzyCompare(this.getWeight(), box.getWeight(), epsilon);
    }
}

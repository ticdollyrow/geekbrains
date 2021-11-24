package fruit;

import lombok.Getter;

import java.lang.annotation.AnnotationFormatError;
import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box>{
    @Getter
    private List<T> fruits;


    public Box(){
        fruits = new ArrayList<>();
    }

    public static void main(String[] args) {
        Box<Apple> boxOfApple = new Box<>();
        Box<Apple> boxOfApple2 = new Box<>();
        Box<Orange> boxOfOrange = new Box<>();
        Apple apple1 = new Apple(1.0f);
        Apple apple2 = new Apple(1.3f);
        Orange orange1 = new Orange(2.5f);


        boxOfApple.addFruit(apple1);
        boxOfApple.addFruit(apple2);
        boxOfApple2.addFruit(apple1);
        boxOfOrange.addFruit(orange1);


        System.out.println(boxOfApple.getWeight());
        System.out.println(boxOfApple.compare(boxOfOrange));
        boxOfApple2.empty(boxOfApple);


        System.out.println(boxOfApple.getWeight());
        System.out.println(boxOfApple2.getWeight());
        System.out.println(boxOfApple2.compareTo(boxOfOrange));

    }

    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public Float getWeight(){
        Float weight = 0.0f;

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

    public boolean compare(Box box){
         return this.getWeight().equals(box.getWeight());
    }


    @Override
    public int compareTo(Box box) {

        return this.getWeight().compareTo(box.getWeight());
    }
}

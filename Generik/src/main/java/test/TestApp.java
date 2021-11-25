package test;

import fruit.Apple;
import fruit.Box;
import fruit.Orange;

public class TestApp {
    public static void main(String[] args) {
        Box<Apple> boxOfApple = new Box<>();
        Box<Apple> boxOfApple2 = new Box<>();
        Box<Orange> boxOfOrange = new Box<>();
        Apple apple1 = new Apple(1.0f);
        Apple apple2 = new Apple(1.3f);
        Orange orange1 = new Orange(3.5f);


        boxOfApple.addFruit(apple1);
        boxOfApple.addFruit(apple2);
        boxOfApple2.addFruit(apple1);
        boxOfOrange.addFruit(orange1);


        System.out.println(boxOfApple.getWeight());
        System.out.println(boxOfApple.compareTo(boxOfOrange));
        boxOfApple2.empty(boxOfApple);


        System.out.println(boxOfApple.getWeight());
        System.out.println(boxOfApple2.getWeight());
        System.out.println(boxOfApple2.compareTo(boxOfOrange));
    }
}

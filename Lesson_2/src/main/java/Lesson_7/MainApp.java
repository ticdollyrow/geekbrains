package Lesson_7;

import java.util.Scanner;

public class MainApp {
    private final static int SIZE = 3;

    public static void main(String[] args) {
        int food = 14;
        int appetite;
        String name;
        Cat[] cats = new Cat[SIZE];
        Plate plate = new Plate(food);

        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < cats.length; i++) {
            System.out.println("Введите имя кота");
            name = scan.next();
            System.out.println("Аппетит");
            appetite = scan.nextInt();
            cats[i] = new Cat(name, appetite);
        }

        for (Cat cat: cats) {
            cat.eat(plate);
            cat.info();
        }
    }
}

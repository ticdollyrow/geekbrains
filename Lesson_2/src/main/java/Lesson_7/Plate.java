package Lesson_7;

import java.util.Scanner;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public void setFood(int food){
        if( food > 0) {
            this.food = food;
        }
    }

    public void decreaseFood(int amount) {
        if ( food >= amount) {
            food -= amount;
            return;
        }
        System.out.println("Необходимо добавить еду в тарелку");
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.printf("Plate [ Food: %d ]\n", food);
    }

    public void addFood(int amount){
        Scanner scan = new Scanner(System.in);
        int food;
        do {
            System.out.println("Введите количество еды - ");
            food = scan.nextInt();
        }while (food <= 0);
        scan.close();
        setFood(food);
    }
}

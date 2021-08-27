package Lesson_7;

import java.util.Random;

public class Cat {
    private static int FOOD = 10;
    private String name;
    private int appetite;
    private boolean hungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    public int getAppetite() {
        return appetite;
    }

    public void info() {
        System.out.println(name + " голоден " + hungry + " appetite " + appetite);
    }

    public void eat(Plate plate) {
        if(!plate.decreaseFood(appetite)) {
            hungry = true;
            return;
        }
//        plate.decreaseFood(appetite);
        hungry = false;
        appetite = 0;
        System.out.println(name + " поел из тарелки!");
    }

    public void play(){
        if(!hungry){
            Random random = new Random();
            appetite = random.nextInt(FOOD) + 1;
            hungry = true;
            return;
        }
        System.out.println(name + "голоден");
    }
}

package Lesson_7;

public class Cat {
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
        System.out.println(name + " " + hungry);
    }

    public void eat(Plate plate) {
        if(plate.getFood() < appetite && appetite != 0) {
            hungry = true;
            return;
        }
        plate.decreaseFood(appetite);
        hungry = false;
        System.out.println(name + " поел из тарелки!");
    }
}

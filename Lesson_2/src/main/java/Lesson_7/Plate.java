package Lesson_7;


public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public void setFood(int food){
        if(food > 0) {
            this.food = food;
        }
    }

    public boolean decreaseFood(int amount) {
        if (food >= amount && amount !=0) {
            food -= amount;
            return true;
        } else if(food < amount || food == 0) {
            System.out.println("Необходимо добавить еду в тарелку");
        }
        return  false;
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.printf("Plate [ Food: %d ]\n", food);
    }

    public void addFood(int food){
        if(food > 0){
            this.food += food;
        }
        info();
    }
}

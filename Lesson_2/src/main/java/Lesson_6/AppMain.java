package Lesson_6;

public class AppMain {
    public static void main(String[] args) {
        Dog bobik = new Dog("Bobik");
        bobik.run(600);
        bobik.swim(7);

        Dog elli = new Dog("Elli");
        elli.run(100);

        Cat poppy = new Cat("Poppy");
        poppy.swim(3);
        poppy.run(10);

        Animal.printCount();
        Dog.printCount();
        Cat.printCount();
    }
}

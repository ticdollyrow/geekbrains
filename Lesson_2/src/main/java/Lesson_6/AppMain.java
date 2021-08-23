package Lesson_6;

import java.util.Scanner;

public class AppMain {
    private static final int SIZE = 3;

    public static void main(String[] args) {
        Dog bobik = new Dog("Bobik");
        bobik.run(600);
        bobik.swim(7);

        Dog elli = new Dog("Elli");
        elli.run(100);

        Cat poppy = new Cat("Poppy");
        poppy.swim(3);
        poppy.run(10);

        Scanner scan = new Scanner(System.in);
        Animal[] arr = new Animal[SIZE];

        for(int i = 0; i < SIZE; i++) {
            System.out.println("Enter 1 - Dog  2 - Cat and Name");
            int num = scan.nextInt();
            String name = scan.nextLine();
            switch (num) {
                case 1:
                    arr[i] = new Dog(name);
                    break;
                case 2:
                    arr[i] = new Cat(name);
                    break;
            }
        }
        scan.close();
        Animal.printCount();
        Dog.printCount();
        Cat.printCount();

    }
}

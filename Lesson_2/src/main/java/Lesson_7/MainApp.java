package Lesson_7;

import java.util.Scanner;

public class MainApp {
    private final static int SIZE = 3;
    private final static char QUIT = 'q';

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


        Cat Barry = new Cat("Barry", 4);
        Barry.info();
        System.out.println("Вы можете покормить кота - 1, поиграть с котом - 2, наполнить тарелку - 3. Выход - q");
        char answer;
        do {
            answer = scan.next().charAt(0);
            switch (answer) {
                case '1':
                    Barry.eat(plate);
                    Barry.info();
                    plate.info();
                    break;
                case '2':
                    Barry.play();
                    Barry.info();
                    break;
                case '3':
                    plate.addFood(food);
                    break;
            }
        }while (answer != QUIT );

        scan.close();
    }
}

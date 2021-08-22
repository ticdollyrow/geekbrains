package Lesson_6;

public class Cat extends Animal{
    private static int CatCount = 0;
    public Cat(String name){
        super(name, 200, 0);
        CatCount +=1;
    }

    public void swim( int length ){
        System.out.println("Коты не умеют плавать");
    }

    public static void printCount(){
        System.out.println("Количество кошек - " + CatCount );
    }
}

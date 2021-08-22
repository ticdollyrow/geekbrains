package Lesson_6;

public class Dog extends Animal{
    private static int DogCount = 0;
    public Dog(String name){
        super(name, 500, 10);
        DogCount += 1;
    }

    public void swim( int length ){
        if( length > super.getSwimLength() ){
            System.out.println("ограничение для собак " + super.getSwimLength() + "м");
            return;
        }
        System.out.println( super.getName() + " проплыл " + length + "м");
    }

    public static void printCount(){
        System.out.println("Количество собак - " + DogCount);
    }
}

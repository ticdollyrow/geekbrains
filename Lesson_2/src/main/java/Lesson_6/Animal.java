package Lesson_6;

public abstract class Animal {
    private String name;
    private final int RunLength;
    private final int SwimLength;
    private static int CountAnimal = 0;


    public Animal(String name, int RunLength, int SwimLength){
        this.name = name;
        this.RunLength = RunLength;
        this.SwimLength = SwimLength;
        CountAnimal += 1;
    }

    public abstract void swim( int length );
    public void run( int length ){
        if( length > RunLength ){
            System.out.println("ограничение " + RunLength + "м");
            return;
        }
        System.out.println( name + " пробежал " + length + "м" );
    };

    public String getName(){
        return name;
    }

    public int getSwimLength(){
        return SwimLength;
    }

    public static void printCount(){
        System.out.println("Количество животных - " + CountAnimal);
    }
}

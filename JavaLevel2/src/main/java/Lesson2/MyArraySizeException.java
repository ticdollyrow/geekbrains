package Lesson2;

public class MyArraySizeException extends Exception{
   private static final String MESSAGE = "Некорректный размер массива";
    public MyArraySizeException(){
        System.out.println(MESSAGE);
    }
}

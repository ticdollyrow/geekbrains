package Lesson2;

public class MyArrayDataException extends Exception{
    private static final String MESSAGE = "некорректные данные в ячейке [%d][%d]";
    public MyArrayDataException(int i, int j){
        System.out.printf(MESSAGE, i, j);
    }
}

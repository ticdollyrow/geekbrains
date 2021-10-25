package Lesson2;

import java.util.Random;

public class AppMain {
    private static final String testValue = "1243tyhv65tsvyn";
    private static final int SIZE = 4;
    public static void main(String[] args) {
        String[][] arr = new String[SIZE][SIZE];
        fillArray(arr);
        print(arr);
        try{
            System.out.println(calc(arr));
        }catch (MyArraySizeException | MyArrayDataException e){
            e.getMessage();
        }



    }

    private static boolean isNumeric(String str){
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private static int calc(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        int sum = 0;
        if(arr.length != SIZE){
            throw new MyArraySizeException();
        }

        try {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != SIZE) {
                    throw new MyArraySizeException();
                }
                for (int j = 0; j < arr[i].length; j++) {
                    if (!isNumeric(arr[i][j])) {
                        throw new MyArrayDataException(i, j);
                    } else {
                        sum += Integer.parseInt(arr[i][j]);
                    }
                }
            }
        }finally {

            return sum;
        }

    }

    private static void fillArray(String[][] arr){
        int value;
        Random random = new Random();
        for(int i = 0; i < arr.length; i++ ){
            for(int j = 0; j < arr[i].length; j++  ){
                value = random.nextInt(testValue.length());
                arr[i][j] = String.valueOf(testValue.charAt(value));
            }
        }
    }

    private static void print(String[][] arr){
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

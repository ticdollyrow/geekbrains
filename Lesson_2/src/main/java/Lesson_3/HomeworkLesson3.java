package Lesson_3;

import  java.util.Arrays;
import  java.util.Scanner;

public class HomeworkLesson3 {
    public static void main(String[] args) {
//Task 1,2,3
        fillArrays();
//Task 4
        drawDiagonal();

        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int[] arr = new int[n];
        for(int i =0; i< arr.length; i++){
           arr[i] = (int) ( Math.random() * 10 );
        }
//Task5
        System.out.println("Task5");
        int[] mas = fillArray(n, 76);
        System.out.println(Arrays.toString(mas));

        System.out.println(Arrays.toString(arr));
//Task6
        findMinMax(arr);
//Task 7
        int[] test = {8,2,2,2,1,4,1};
        System.out.println("Task7");
        System.out.println(checkBalance(arr));
//Task 8
        System.out.println("Task8");
        offsetArrElem(arr, -2);

    }

    public static  void fillArrays(){
        int[] arr = { 1, 0, 1, 0, 0, 1 };
//        заменить 0 на 1, 1 на 0
        System.out.println("Task1");
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i <arr.length; i++){
            if( arr[i] == 1 ){
                arr[i] = 0;
            } else{
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));

        int[] hunderd = new int[100];
        for(int i =0; i< hunderd.length; i++){
            hunderd[i] = i+1;
        }
        System.out.println("Task2");
        System.out.println(Arrays.toString(hunderd));

        int[] mas = {1,5,3,2,11,4,5,2,4,8,9,1};
//        числа меньшие 6 умножить на 2
        for( int i =0; i< mas.length; i++){
            if(mas[i] < 6){
                mas[i] *= 2;
            }
        }
        System.out.println("Task3");
        System.out.println(Arrays.toString(mas));
    }

    public static void drawDiagonal(){
        int n = 5;
//        квадратный двумерный целочисленный массив
        int[][] arr = new int[n][n];
        int l = arr.length - 1;
//        заполнить диагональные элементы единицами
        for(int i = 0; i<arr.length; i++){
            arr[i][i] = 1;
            arr[l][i] = 1;
            l--;
        }
        System.out.println("Task4");
        for(int i = 0; i< arr.length; i++){
                System.out.println(Arrays.toString(arr[i]));
        }
    }

    public  static  int[] fillArray(int len, int initialValue){
      int[] arr = new int[len];
//      for(int i =0; i <arr.length; i++){
//          arr[i] = initialValue;
//      }
        Arrays.fill(arr,initialValue);
      return arr;
    }

    public  static  void findMinMax(int[] arr){
        int min, max;
        min = max = arr[0];
        for(int i =1; i< arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
            if( max < arr[i]){
                max = arr[i];
            }
        }

        System.out.println("Минимум" + min + " Максимум" + max);
    }

    public  static  boolean checkBalance(int[] arr){
        int left = 0, right = 0;
        int i = 0, n = arr.length - 1;

//        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны
       while(i<=n){
         if( left >= right){
             right += arr[n];
             n--;
         } else{
           left += arr[i];
           i++;
         }
       }
       if ( left == right ){
           return  true;
        }
           return  false;
    }

    public static  void offsetArrElem(int[] arr, int offset){
        int set, tmp, idx = 0, TmpNew;
        int i = 0;
        int idxFirst =0;
        if( Math.abs(offset) >= arr.length){
            set = offset % arr.length;
        }else{
            set = offset;
        }

        tmp = arr[idx];
        while(i<arr.length){

          idx += set;
          if( idx >= arr.length){
              idx -= arr.length;
          }else if (idx < 0){
              idx += arr.length;
          }

          TmpNew = arr[idx];
          arr[idx] = tmp;
          tmp = TmpNew;

          i++;
          if (idx == idxFirst){
              idxFirst += 1;
              idx = idxFirst;
              tmp = arr[idx];
          }
        }

        System.out.println(Arrays.toString(arr));
    }
}

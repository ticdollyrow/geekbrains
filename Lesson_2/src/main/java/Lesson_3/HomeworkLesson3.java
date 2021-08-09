package Lesson_3;

import  java.util.Arrays;
import  java.util.Scanner;

public class HomeworkLesson3 {
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int arr[] = new int[n];
        for(int i =0; i< arr.length; i++){
           arr[i] = (int) ( Math.random() * 10 );
        }
        System.out.println(Arrays.toString(arr));

        drawDiagonal();

        int test[] = {1,1,1,3,5,1,4,1,1,2,2,1};
        System.out.println(checkBalance(test));
        offsetArrElem(arr, -7);

    }

    public static void drawDiagonal(){
        int n = 3;
//        квадратный двумерный целочисленный массив
        int arr[][] = new int[n][n];
        int l = arr.length - 1;
//        заполнить диагональные элементы единицами
        for(int i = 0; i<arr.length; i++){
            arr[i][i] = 1;
            arr[l][i] = 1;
            l--;
        }

        for(int i = 0; i< arr.length; i++){
                System.out.println(Arrays.toString(arr[i]));

        }
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
        if( Math.abs(offset) >= arr.length){
            set = offset % arr.length;
        }else{
            set = offset;
        }

        tmp = arr[idx];
        for (int i= 0; i<arr.length; i++){

          idx += set;
          if( idx >= arr.length){
              idx -= arr.length;
          }else if (idx < 0){
              idx += arr.length;
          }

          TmpNew = arr[idx];
          arr[idx] = tmp;
          tmp = TmpNew;
        }

        System.out.println(Arrays.toString(arr));
    }
}

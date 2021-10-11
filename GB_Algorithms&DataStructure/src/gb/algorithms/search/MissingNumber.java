package gb.algorithms.search;

import java.util.Arrays;

public class MissingNumber {

//    Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
//    Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.

    public static int search(int arr[], int step){
        int middle, value;

        if( arr.length == 0 ) return step;
        int low = 0;
        int high = arr.length;

        while (low<high) {
            middle = (low + high) / 2;
            value = ( middle + 1 ) * step;

            if (arr[middle] == value) low = middle + 1;
            else high = middle;
        }
        return arr[high] - step;
    }
}

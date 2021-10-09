package gb.algorithms.sort;

public class InsertionSort {
    public static  void sort(int[] arr){
        int value, j;
        for(int i = 0; i < arr.length - 1; i++){
            value = arr[i + 1];
            for( j = i + 1; j > 0 && arr[j-1] > value; j--){
                    arr[j] = arr[j-1];
            }
            arr[j] = value;
        }
    }
}

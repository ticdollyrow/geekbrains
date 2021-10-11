package gb.algorithms.search;

public class BinarySearch {
    public static int search(int[] arr, int value){
        int low, high, middle;
        low = 0;
        high = arr.length -1;

        while(low <= high){
            middle = ( low + high ) / 2;
            if(arr[middle] == value) return middle;
            if(arr[middle] < value) low = middle + 1;
            if(arr[middle] > value) high = middle - 1;
        }
        return -1;
    }
}

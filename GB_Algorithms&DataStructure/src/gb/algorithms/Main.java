package gb.algorithms;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = {1,3,5,6,9,12,14,17,19,23,34};
        int value = 12;
        int item = binarySearch(arr,value);
        System.out.println(item);
    }

    public static int binarySearch(int[] arr, int value){
        int low, high, mid;
        low = 0;
        high = arr.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] == value) return mid;
            else{
                if(arr[mid] > value)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
    return -1;
    }
}
